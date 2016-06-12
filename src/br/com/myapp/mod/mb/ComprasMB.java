package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Compras;
import br.com.myapp.mod.dao.ComprasDAO;
import br.com.myapp.mod.util.JPAUtil;

@ManagedBean

@ViewScoped 

public class ComprasMB {

	private Compras compras = new Compras();

	public Compras getCompras() {
		return compras;
	}

	public void setCompras(Compras compras) {
		this.compras = compras;
	}

	public List<Compras> listaCompras = new ArrayList<Compras>();

	public List<Compras> getListaCompras() {
		return listaCompras;
	}

	@PostConstruct 
	
	public void carregarCompras() {
		EntityManager em = JPAUtil.getEntityManager();
		ComprasDAO dao = new ComprasDAO(em);
		listaCompras = dao.listar();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		ComprasDAO dao = new ComprasDAO(em);
		em.getTransaction().begin();
		dao.excluir(compras);
		em.getTransaction().commit();
		em.close();
		carregarCompras();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		ComprasDAO dao = new ComprasDAO(em);
		em.getTransaction().begin();
		if (compras.getCompraId() != null) {
			dao.alterar(compras);
		} else {
			dao.cadastrar(compras);
		}
		em.getTransaction().commit();
		em.close();
		compras = new Compras();
		carregarCompras();
	}
}
