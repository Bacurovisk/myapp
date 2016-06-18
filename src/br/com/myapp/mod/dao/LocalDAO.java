package br.com.myapp.mod.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Local;

public class LocalDAO {
	private EntityManager entityManager;

	public LocalDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Local local){
		entityManager.persist(local);
	}
	public void alterar(Local local){
		entityManager.merge(local);
	}
	public void excluir(Local local){
		entityManager.remove(entityManager.merge(local));
	}
	
	public Local consultar(Long id){
		return entityManager.getReference(Local.class, id);
	}
	
	public List<Local> listar(){
		String jpql = "Select l from Local l order by l.localId";
		TypedQuery<Local> query = entityManager.createQuery(jpql, Local.class);
		return query.getResultList();
	}
}
