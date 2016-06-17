package br.com.myapp.mod.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.bean.Cardapio;

@SuppressWarnings("unchecked")
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
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	public List<Cardapio> listar2(){
		String jpql = "Select c.cardapioTitulo from Cardapio c order by c.cardapioTitulo";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}

