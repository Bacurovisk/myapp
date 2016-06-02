package br.com.myapp.mod.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.val.Compras;
@SuppressWarnings("unchecked")
public class ComprasCRUD {
	private EntityManager entityManager;

	public ComprasCRUD(EntityManager entityManager) {
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
		String jpql = "Select cp from Compras cp order by cp.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
