package br.com.myapp.mod.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.bean.Pedido;

@SuppressWarnings("unchecked")
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
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
