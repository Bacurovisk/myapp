package br.com.myapp.mod.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.val.Item;

@SuppressWarnings("unchecked")
public class ItemCRUD {
	
	private EntityManager entityManager;

	public ItemCRUD(EntityManager entityManager) {
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
		String jpql = "Select c from Item c order by c.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
