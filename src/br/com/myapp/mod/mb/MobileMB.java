package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Mobile;
import br.com.myapp.mod.dao.MobileDAO;
import br.com.myapp.mod.util.JPAUtil;

@ManagedBean

@ViewScoped

public class MobileMB {
	
	private Mobile mobile = new Mobile();

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public List<Mobile> listaMobile = new ArrayList<Mobile>();

	public List<Mobile> getListaMobile() {
		return listaMobile;
	}

	@PostConstruct 
	
	public void carregarMobile() {
		EntityManager em = JPAUtil.getEntityManager();
		MobileDAO dao = new MobileDAO(em);
		listaMobile = dao.listar();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		MobileDAO dao = new MobileDAO(em);
		em.getTransaction().begin();
		dao.excluir(mobile);
		em.getTransaction().commit();
		em.close();
		carregarMobile();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		MobileDAO dao = new MobileDAO(em);
		em.getTransaction().begin();
		if (mobile.getId() != null) {
			dao.alterar(mobile);
		} else {
			dao.cadastrar(mobile);
		}
		em.getTransaction().commit();
		em.close();
		mobile = new Mobile();
		carregarMobile();
	}

}
