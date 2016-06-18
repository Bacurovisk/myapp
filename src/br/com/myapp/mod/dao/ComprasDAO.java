package br.com.myapp.mod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Compras;

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
		TypedQuery<Compras> query = entityManager.createQuery(jpql, Compras.class);
		return query.getResultList();
	}
}
