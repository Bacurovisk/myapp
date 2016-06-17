package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Item;
import br.com.myapp.mod.dao.ItemDAO;
import br.com.myapp.mod.util.JPAUtil;

@ViewScoped
@ManagedBean
public class ItemMB {

private Item item = new Item();
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> listaItem = new ArrayList<Item>();
	
	public List<Item> getListaItem(){
		return listaItem;
	}
	public List<Item> listaItem2 = new ArrayList<Item>();
	
	public List<Item> getListaItem2(){
		return listaItem2;
	}
	
	
	@PostConstruct
	public void carregarItem(){
		EntityManager em = JPAUtil.getEntityManager();
		ItemDAO dao = new ItemDAO(em);
		listaItem = dao.listar();
		listaItem2 = dao.listar2();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		ItemDAO dao = new ItemDAO(em);
		em.getTransaction().begin();
		dao.excluir(item);
		em.getTransaction().commit();
		em.close();
		carregarItem();
	}

	public void salvar(){
		
		EntityManager em = JPAUtil.getEntityManager();
		ItemDAO dao = new ItemDAO(em);
		em.getTransaction().begin();
		if(item.getItemId()!=null){
			dao.alterar(item);
		}else{
			dao.cadastrar(item);
		}
		em.getTransaction().commit();
		em.close();
		item  = new Item();
		carregarItem();
	}
	
}
