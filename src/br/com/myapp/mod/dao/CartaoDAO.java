package br.com.myapp.mod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Cartao;

public class CartaoDAO {
	private EntityManager entityManager;

	public CartaoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Cartao cartao){
		entityManager.persist(cartao);
	}
	public void alterar(Cartao cartao){
		entityManager.merge(cartao);
	}
	public void excluir(Cartao cartao){
		entityManager.remove(entityManager.merge(cartao));
	}
	
	public Cartao consultar(Long id){
		return entityManager.getReference(Cartao.class, id);
	}
	
	public List<Cartao> listar(){
		String jpql = "Select c from Cartao c order by c.cartaoId";
		TypedQuery<Cartao> query = entityManager.createQuery(jpql, Cartao.class);
		return query.getResultList();
	}
}
