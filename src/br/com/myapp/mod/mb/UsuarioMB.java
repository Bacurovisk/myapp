package br.com.myapp.mod.mb;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.crud.UsuarioCRUD;
import br.com.myapp.mod.pers.JPAUtil;
import br.com.myapp.mod.val.Usuario;

@ManagedBean // Anotação que reflete o nome que usaremos para chamar essa classe
// através da nossa View.

@ViewScoped // Este é o escopo da classe, que diz respeito até quando nosso
// objeto continuará persistente em memória. Como utilizamos o
// ViewScoped ele permanecerá até o fechamento da View, ou da
// página, se assim preferir.

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

	@PostConstruct // É importante colocar suas inicializações no post construct
					// e não no construtor da classe, isso porque se você
					// estiver realizando injeção de dependência (no Spring, por
					// exemplo) todas as dependências podem não estar carregadas
					// na construção da sua classe, então no post construct você
					// garante que tudo já foi carregado e agora você pode
					// usá-los.

	public void carregarUsuario() {
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioCRUD crud = new UsuarioCRUD(em);
		listaUsuario = crud.listar();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioCRUD crud = new UsuarioCRUD(em);
		em.getTransaction().begin();
		crud.excluir(usuario);
		em.getTransaction().commit();
		em.close();
		carregarUsuario();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		UsuarioCRUD crud = new UsuarioCRUD(em);
		em.getTransaction().begin();
		if (usuario.getId() != null) {
			crud.alterar(usuario);
		} else {
			crud.cadastrar(usuario);
		}
		em.getTransaction().commit();
		em.close();
		usuario = new Usuario();
		carregarUsuario();
	}

}
