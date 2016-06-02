package br.com.myapp.mod.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.val.Mobile;

public class MobileCRUD {
	private EntityManager entityManager;

	public MobileCRUD(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Mobile mobile) {
		entityManager.persist(mobile);
	}

	public void alterar(Mobile mobile) {
		entityManager.merge(mobile);
	}

	public void excluir(Mobile mobile) {
		entityManager.remove(entityManager.merge(mobile));
	}

	public Mobile consultar(Long id) {
		return entityManager.getReference(Mobile.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Mobile> listar() {
		String jpql = "Select m from Mobile m order by m.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
