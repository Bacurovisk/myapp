package br.com.myapp.mod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Mobile;

public class MobileDAO {
	private EntityManager entityManager;

	public MobileDAO(EntityManager entityManager) {
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

	
	public List<Mobile> listar() {
		String jpql = "Select m from Mobile m order by m.id";
		TypedQuery<Mobile> query = entityManager.createQuery(jpql, Mobile.class);
		return query.getResultList();
	}
}
