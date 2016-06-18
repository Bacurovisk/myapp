package br.com.myapp.mod.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Fornecedor;

public class FornecedorDAO {
	private EntityManager entityManager;

	public FornecedorDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Fornecedor fornecedor){
		entityManager.persist(fornecedor);
	}
	public void alterar(Fornecedor fornecedor){
		entityManager.merge(fornecedor);
	}
	public void excluir(Fornecedor fornecedor){
		entityManager.remove(entityManager.merge(fornecedor));
	}
	
	public Fornecedor consultar(Long id){
		return entityManager.getReference(Fornecedor.class, id);
	}
	
	public List<Fornecedor> listar(){
		String jpql = "Select f from Fornecedor f order by f.fornecedorId";
		TypedQuery<Fornecedor> query = entityManager.createQuery(jpql, Fornecedor.class);
		return query.getResultList();
	}
}
