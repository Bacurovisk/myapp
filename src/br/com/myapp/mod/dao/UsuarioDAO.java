package br.com.myapp.mod.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.myapp.mod.bean.Usuario;

@SuppressWarnings("unchecked")
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
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	public List<Usuario> listar2() {
		String jpql = "Select u.nome from Usuario u order by u.nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}