package br.com.myapp.mod.mb;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Categoria;
import br.com.myapp.mod.dao.CategoriaDAO;
import br.com.myapp.mod.util.JPAUtil;

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
	
	
	@PostConstruct
	public void carregarCategoria(){
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDAO dao = new CategoriaDAO(em);
		listaCategoria = dao.listar();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDAO dao = new CategoriaDAO(em);
		em.getTransaction().begin();
		dao.excluir(categoria);
		em.getTransaction().commit();
		em.close();
		carregarCategoria();
	}

	public void salvar(){
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDAO dao = new CategoriaDAO(em);
		em.getTransaction().begin();
		if(categoria.getCategoriaId()!=null){
			dao.alterar(categoria);
		}else{
			dao.cadastrar(categoria);
		}
		em.getTransaction().commit();
		em.close();
		categoria  = new Categoria();
		carregarCategoria();
	}

}
