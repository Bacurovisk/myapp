package br.com.myapp.mod.mb;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Usuario;
import br.com.myapp.mod.dao.UsuarioDAO;
import br.com.myapp.mod.util.JPAUtil;

@ManagedBean

@ViewScoped

public class UsuarioMB {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> listaUsuario = new ArrayList<Usuario>();

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	@PostConstruct 

	public void carregarUsuario() {
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		listaUsuario = dao.listar();
		listaUsuario = dao.listar2();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		em.getTransaction().begin();
		dao.excluir(usuario);
		em.getTransaction().commit();
		em.close();
		carregarUsuario();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		em.getTransaction().begin();
		if (usuario.getId() != null) {
			dao.alterar(usuario);
		} else {
			dao.cadastrar(usuario);
		}
		em.getTransaction().commit();
		em.close();
		usuario = new Usuario();
		carregarUsuario();
	}

}
