package br.com.myapp.mod.crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.myapp.mod.val.Pedido;

@SuppressWarnings("unchecked")
public class PedidoCRUD {
	private EntityManager entityManager;

	public PedidoCRUD(EntityManager entityManager) {
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
		String jpql = "Select p from Pedido p order by p.nomeprato";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
