package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;


import br.com.myapp.mod.val.Mobile;
import br.com.myapp.mod.crud.MobileCRUD;
import br.com.myapp.mod.pers.JPAUtil;

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
		MobileCRUD crud = new MobileCRUD(em);
		listaMobile = crud.listar();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		MobileCRUD crud = new MobileCRUD(em);
		em.getTransaction().begin();
		crud.excluir(mobile);
		em.getTransaction().commit();
		em.close();
		carregarMobile();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		MobileCRUD crud = new MobileCRUD(em);
		em.getTransaction().begin();
		if (mobile.getId() != null) {
			crud.alterar(mobile);
		} else {
			crud.cadastrar(mobile);
		}
		em.getTransaction().commit();
		em.close();
		mobile = new Mobile();
		carregarMobile();
	}

}
