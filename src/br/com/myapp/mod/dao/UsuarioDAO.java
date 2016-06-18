package br.com.myapp.mod.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.myapp.mod.bean.Usuario;

public class UsuarioDAO {

	private EntityManager entityManager;

	public UsuarioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void cadastrar(Usuario usuario) {
		entityManager.persist(usuario);
	}

	public void alterar(Usuario usuario) {
		entityManager.merge(usuario);
	}

	public void excluir(Usuario usuario) {
		entityManager.remove(entityManager.merge(usuario));
	}

	public Usuario consultar(Long id) {
		return entityManager.getReference(Usuario.class, id);
	}

	public List<Usuario> listar() {
		String jpql = "Select u from Usuario u order by u.nome";
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

}