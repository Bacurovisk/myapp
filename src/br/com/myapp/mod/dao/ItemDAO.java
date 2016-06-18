package br.com.myapp.mod.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Item;

public class ItemDAO {
	
	private EntityManager entityManager;

	public ItemDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Item item){
		entityManager.persist(item);
	}
	public void alterar(Item item){
		entityManager.merge(item);
	}
	public void excluir(Item item){
		entityManager.remove(entityManager.merge(item));
	}
	
	public Item consultar(Long id){
		return entityManager.getReference(Item.class, id);
	}
	
	public List<Item> listar(){
		String jpql = "Select c from Item c order by c.itemId";
		TypedQuery<Item> query = entityManager.createQuery(jpql, Item.class);
		return query.getResultList();
	}
}
