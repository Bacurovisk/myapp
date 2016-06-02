package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.val.Compras;
import br.com.myapp.mod.crud.ComprasCRUD;
import br.com.myapp.mod.pers.JPAUtil;

@ManagedBean // Anotação que reflete o nome que usaremos para chamar essa classe
				// através da nossa View.

@ViewScoped // Este é o escopo da classe, que diz respeito até quando nosso
			// objeto continuará persistente em memória. Como utilizamos o
			// ViewScoped ele permanecerá até o fechamento da View, ou da
			// página, se assim preferir.

public class ComprasMB {

	private Compras compras = new Compras();

	public Compras getCompras() {
		return compras;
	}

	public void setCompras(Compras compras) {
		this.compras = compras;
	}

	public List<Compras> listaCompras = new ArrayList<Compras>();

	public List<Compras> getListaCompras() {
		return listaCompras;
	}

	@PostConstruct // É importante colocar suas inicializações no post construct
					// e não no construtor da classe, isso porque se você
					// estiver realizando injeção de dependência (no Spring, por
					// exemplo) todas as dependências podem não estar carregadas
					// na construção da sua classe, então no post construct você
					// garante que tudo já foi carregado e agora você pode
					// usá-los.
	
	public void carregarCompras() {
		EntityManager em = JPAUtil.getEntityManager();
		ComprasCRUD crud = new ComprasCRUD(em);
		listaCompras = crud.listar();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		ComprasCRUD crud = new ComprasCRUD(em);
		em.getTransaction().begin();
		crud.excluir(compras);
		em.getTransaction().commit();
		em.close();
		carregarCompras();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		ComprasCRUD crud = new ComprasCRUD(em);
		em.getTransaction().begin();
		if (compras.getId() != null) {
			crud.alterar(compras);
		} else {
			crud.cadastrar(compras);
		}
		em.getTransaction().commit();
		em.close();
		compras = new Compras();
		carregarCompras();
	}
}
