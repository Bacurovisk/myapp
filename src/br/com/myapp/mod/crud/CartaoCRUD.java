package br.com.myapp.mod.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.val.Cartao;
@SuppressWarnings("unchecked")
public class CartaoCRUD {
	private EntityManager entityManager;

	public CartaoCRUD(EntityManager entityManager) {
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
		String jpql = "Select c from Cartao c order by c.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	public List<Cartao> listar2(){
		String jpql = "Select c.nome from Cartao c order by c.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
