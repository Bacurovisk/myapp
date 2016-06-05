package br.com.myapp.mod.mb;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.val.Categoria;
import br.com.myapp.mod.crud.CategoriaCRUD;
import br.com.myapp.mod.pers.JPAUtil;

@ViewScoped
@ManagedBean
public class CategoriaMB {
private Categoria categoria = new Categoria();
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> listaCategoria = new ArrayList<Categoria>();
	
	public List<Categoria> getListaCategoria(){
		return listaCategoria;
	}
	
	public List<Categoria> listaCategoria2 = new ArrayList<Categoria>();
	
	public List<Categoria> getListaCategoria2(){
		return listaCategoria2;
	}
	
	@PostConstruct
	public void carregarCategoria(){
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaCRUD crud = new CategoriaCRUD(em);
		listaCategoria = crud.listar();
		listaCategoria2 = crud.listar2();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaCRUD crud = new CategoriaCRUD(em);
		em.getTransaction().begin();
		crud.excluir(categoria);
		em.getTransaction().commit();
		em.close();
		carregarCategoria();
	}

	public void salvar(){
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaCRUD crud = new CategoriaCRUD(em);
		em.getTransaction().begin();
		if(categoria.getId()!=null){
			crud.alterar(categoria);
		}else{
			crud.cadastrar(categoria);
		}
		em.getTransaction().commit();
		em.close();
		categoria  = new Categoria();
		carregarCategoria();
	}

}
