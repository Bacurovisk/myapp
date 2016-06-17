package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Pedido;
import br.com.myapp.mod.dao.PedidoDAO;
import br.com.myapp.mod.util.JPAUtil;

@ManagedBean

@ViewScoped

public class PedidoMB {

	private Pedido pedido = new Pedido();

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> listaPedido = new ArrayList<Pedido>();

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	@PostConstruct
	
	public void carregarPedido() {
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDAO dao = new PedidoDAO(em);
		listaPedido = dao.listar();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		PedidoDAO dao = new PedidoDAO(em);
		em.getTransaction().begin();
		dao.excluir(pedido);
		em.getTransaction().commit();
		em.close();
		carregarPedido();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		PedidoDAO dao = new PedidoDAO(em);
		em.getTransaction().begin();
		if (pedido.getPedidoId() != null) {
			dao.alterar(pedido);
		} else {
			dao.cadastrar(pedido);
		}
		em.getTransaction().commit();
		em.close();
		pedido = new Pedido();
		carregarPedido();
	}
}