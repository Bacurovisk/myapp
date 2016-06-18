package br.com.myapp.mod.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Pedido;

public class PedidoDAO {
	private EntityManager entityManager;

	public PedidoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Pedido pedido) {
		entityManager.persist(pedido);
	}

	public void alterar(Pedido pedido) {
		entityManager.merge(pedido);
	}

	public void excluir(Pedido pedido) {
		entityManager.remove(entityManager.merge(pedido));
	}

	public Pedido consultar(Long id) {
		return entityManager.getReference(Pedido.class, id);
	}

	
	public List<Pedido> listar() {
		String jpql = "Select p from Pedido p order by p.pedidoId";
		TypedQuery<Pedido> query = entityManager.createQuery(jpql, Pedido.class);
		return query.getResultList();
	}
}
