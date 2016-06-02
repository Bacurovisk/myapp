package br.com.myapp.mod.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.myapp.mod.val.Entregas;

@SuppressWarnings("unchecked")

public class EntregasCRUD {
	private EntityManager entityManager;

	public EntregasCRUD(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void cadastrar(Entregas entregas){
		entityManager.persist(entregas);
	}
	
	
	public void alterar(Entregas entregas){
		entityManager.merge(entregas);
	}
	
	public void excluir(Entregas entregas){
		entityManager.remove(entityManager.merge(entregas));
	}
	
	public Entregas consultar(Long id){
		return entityManager.getReference(Entregas.class, id);
	}

	
	public List<Entregas> listar(){
		
		//String jpql = "from Entregas e, Pedido p"; // 	Quando faz o n=inner join ele não mostra os campos
		String jpql = "Select e from Entregas e order by e.nome";
		//String jpql = "select e from Entregas e inner join e.localentrega order by e.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	
}
