package br.com.myapp.mod.crud;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.val.Categoria;

@SuppressWarnings("unchecked")
public class CategoriaCRUD {
	private EntityManager entityManager;

	public CategoriaCRUD(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Categoria categoria){
		entityManager.persist(categoria);
	}
	public void alterar(Categoria categoria){
		entityManager.merge(categoria);
	}
	public void excluir(Categoria categoria){
		entityManager.remove(entityManager.merge(categoria));
	}
	
	public Categoria consultar(Long id){
		return entityManager.getReference(Categoria.class, id);
	}
	
	public List<Categoria> listar(){
		String jpql = "Select c from Categoria c order by c.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	public List<Categoria> listar2(){
		String jpql = "Select c.nome from Categoria c order by c.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
