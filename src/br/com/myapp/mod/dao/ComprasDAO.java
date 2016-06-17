package br.com.myapp.mod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.bean.Compras;
@SuppressWarnings("unchecked")
public class ComprasDAO {
	private EntityManager entityManager;

	public ComprasDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Compras compras){
		entityManager.persist(compras);
	}
	public void alterar(Compras compras){
		entityManager.merge(compras);
	}
	public void excluir(Compras compras){
		entityManager.remove(entityManager.merge(compras));
	}
	
	public Compras consultar(Long id){
		return entityManager.getReference(Compras.class, id);
	}
	
	public List<Compras> listar(){
		String jpql = "Select cp from Compras cp order by cp.compraId";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	public List<Compras> listar2(){
		String jpql = "Select cp.compraId from Compras cp order by cp.compraId";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
