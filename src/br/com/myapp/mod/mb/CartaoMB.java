package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Cartao;
import br.com.myapp.mod.dao.CartaoDAO;
import br.com.myapp.mod.util.JPAUtil;

@ManagedBean 

@ViewScoped 

public class CartaoMB {

	private Cartao cartao = new Cartao();

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public List<Cartao> listaCartao = new ArrayList<Cartao>();

	public List<Cartao> getListaCartao() {
		return listaCartao;
	}
	public List<Cartao> listaCartao2 = new ArrayList<Cartao>();

	public List<Cartao> getListaCartao2() {
		return listaCartao2;
	}

	@PostConstruct
	
	public void carregarCartao() {
		EntityManager em = JPAUtil.getEntityManager();
		CartaoDAO dao = new CartaoDAO(em);
		listaCartao = dao.listar();
		listaCartao = dao.listar2();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		CartaoDAO dao = new CartaoDAO(em);
		em.getTransaction().begin();
		dao.excluir(cartao);
		em.getTransaction().commit();
		em.close();
		carregarCartao();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		CartaoDAO dao = new CartaoDAO(em);
		em.getTransaction().begin();
		if (cartao.getCartaoId() != null) {
			dao.alterar(cartao);
		} else {
			dao.cadastrar(cartao);
		}
		em.getTransaction().commit();
		em.close();
		cartao = new Cartao();
		carregarCartao();
	}
}
