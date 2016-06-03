package br.com.myapp.mod.crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.val.Local;

@SuppressWarnings("unchecked")

public class LocalCRUD {
	private EntityManager entityManager;

	public LocalCRUD(EntityManager entityManager) {
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
		String jpql = "Select l from Local l order by l.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	public List<Local> listar2(){
		String jpql = "Select l.nome from Local l order by l.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
