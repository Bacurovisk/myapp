package br.com.myapp.mod.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.bean.Fornecedor;

@SuppressWarnings("unchecked")

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
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	public List<Fornecedor> listar2(){
		String jpql = "Select f.fornecedorNome from Fornecedor f order by f.fornecedorId";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
