package br.com.myapp.mod.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.bean.Categoria;

@SuppressWarnings("unchecked")
public class CategoriaDAO {
	private EntityManager entityManager;

	public CategoriaDAO(EntityManager entityManager) {
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
		String jpql = "Select c from Categoria c order by c.categoriaId";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	public List<Categoria> listar2(){
		String jpql = "Select c.categoriaNome from Categoria c order by c.categoriaNome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}


}
