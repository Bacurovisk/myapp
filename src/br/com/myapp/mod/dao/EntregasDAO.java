package br.com.myapp.mod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Entregas;


public class EntregasDAO {
	private EntityManager entityManager;

	public EntregasDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Entregas entregas){
		entityManager.persist(entregas);
	}
	
	
	public void alterar(Entregas entregas){
		entityManager.merge(entregas);
	}
	
	public void excluir(Entregas entregas){
		entityManager.remove(entityManager.merge(entregas));
	}
	
	public Entregas consultar(Long id){
		return entityManager.getReference(Entregas.class, id);
	}

	
	public List<Entregas> listar(){
		String jpql = "Select e from Entregas e order by e.id";
		TypedQuery<Entregas> query = entityManager.createQuery(jpql, Entregas.class);
		return query.getResultList();
	}	
}
