package br.com.myapp.mod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.bean.Mobile;
@SuppressWarnings("unchecked")
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
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
