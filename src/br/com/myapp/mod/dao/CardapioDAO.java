package br.com.myapp.mod.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Cardapio;

public class CardapioDAO {
	private EntityManager entityManager;

	public CardapioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Cardapio cardapio){
		entityManager.persist(cardapio);
	}
	public void alterar(Cardapio cardapio){
		entityManager.merge(cardapio);
	}
	public void excluir(Cardapio cardapio){
		entityManager.remove(entityManager.merge(cardapio));
	}
	
	public Cardapio consultar(Long id){
		return entityManager.getReference(Cardapio.class, id);
	}
	
	public List<Cardapio> listar(){
		String jpql = "Select c from Cardapio c order by c.cardapioId";
		TypedQuery<Cardapio> query = entityManager.createQuery(jpql, Cardapio.class);
		return query.getResultList();
	}
	
}

