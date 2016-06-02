package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.val.Cartao;
import br.com.myapp.mod.crud.CartaoCRUD;
import br.com.myapp.mod.pers.JPAUtil;

@ManagedBean // Anotação que reflete o nome que usaremos para chamar essa classe
				// através da nossa View.

@ViewScoped // Este é o escopo da classe, que diz respeito até quando nosso
			// objeto continuará persistente em memória. Como utilizamos o
			// ViewScoped ele permanecerá até o fechamento da View, ou da
			// página, se assim preferir.

public class CartaoMB {

	private Cartao cartao = new Cartao();

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public List<Cartao> listaCartao = new ArrayList<Cartao>();

	public List<Cartao> getListaCartao() {
		return listaCartao;
	}

	@PostConstruct // É importante colocar suas inicializações no post construct
					// e não no construtor da classe, isso porque se você
					// estiver realizando injeção de dependência (no Spring, por
					// exemplo) todas as dependências podem não estar carregadas
					// na construção da sua classe, então no post construct você
					// garante que tudo já foi carregado e agora você pode
					// usá-los.
	
	public void carregarCartao() {
		EntityManager em = JPAUtil.getEntityManager();
		CartaoCRUD crud = new CartaoCRUD(em);
		listaCartao = crud.listar();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		CartaoCRUD crud = new CartaoCRUD(em);
		em.getTransaction().begin();
		crud.excluir(cartao);
		em.getTransaction().commit();
		em.close();
		carregarCartao();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		CartaoCRUD crud = new CartaoCRUD(em);
		em.getTransaction().begin();
		if (cartao.getId() != null) {
			crud.alterar(cartao);
		} else {
			crud.cadastrar(cartao);
		}
		em.getTransaction().commit();
		em.close();
		cartao = new Cartao();
		carregarCartao();
	}
}
