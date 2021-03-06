package br.com.myapp.mod.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Categoria;


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
		TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);
		return query.getResultList();
	}

}
