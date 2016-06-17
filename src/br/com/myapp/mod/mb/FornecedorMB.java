package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Fornecedor;
import br.com.myapp.mod.dao.FornecedorDAO;
import br.com.myapp.mod.util.JPAUtil;

@ViewScoped
@ManagedBean
public class FornecedorMB {

	private Fornecedor fornecedor = new Fornecedor();

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();

	public List<Fornecedor> getListaFornecedor() {
		return listaFornecedor;
	}

	public List<Fornecedor> listaFornecedor2 = new ArrayList<Fornecedor>();

	public List<Fornecedor> getListaFornecedor2() {
		return listaFornecedor2;
	}

	@PostConstruct
	public void carregarFornecedor() {
		EntityManager em = JPAUtil.getEntityManager();
		FornecedorDAO dao = new FornecedorDAO(em);
		listaFornecedor = dao.listar();
		listaFornecedor2 = dao.listar2();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		FornecedorDAO dao = new FornecedorDAO(em);
		em.getTransaction().begin();
		dao.excluir(fornecedor);
		em.getTransaction().commit();
		em.close();
		carregarFornecedor();
	}

	public void salvar() {
		EntityManager em = JPAUtil.getEntityManager();
		FornecedorDAO dao = new FornecedorDAO(em);
		em.getTransaction().begin();
		if (fornecedor.getFornecedorId() != null) {
			dao.alterar(fornecedor);
		} else {
			dao.cadastrar(fornecedor);
		}
		em.getTransaction().commit();
		em.close();
		fornecedor = new Fornecedor();
		carregarFornecedor();
	}
}
