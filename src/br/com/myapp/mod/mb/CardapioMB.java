package br.com.myapp.mod.mb;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Cardapio;
import br.com.myapp.mod.dao.CardapioDAO;
import br.com.myapp.mod.util.JPAUtil;

@ViewScoped
@ManagedBean
public class CardapioMB {
private Cardapio cardapio = new Cardapio();
	
	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public List<Cardapio> listaCardapio = new ArrayList<Cardapio>();
	
	public List<Cardapio> getListaCardapio(){
		return listaCardapio;
	}
	
	@PostConstruct
	public void carregarCardapio(){
		EntityManager em = JPAUtil.getEntityManager();
		CardapioDAO dao = new CardapioDAO(em);
		listaCardapio = dao.listar();
		em.close();
	}
	
	public void excluir(){
		
		EntityManager em = JPAUtil.getEntityManager();
		CardapioDAO dao = new CardapioDAO(em);
		em.getTransaction().begin();
		dao.excluir(cardapio);
		em.getTransaction().commit();
		em.close();
		carregarCardapio();
	}

	public void salvar(){
		
		EntityManager em = JPAUtil.getEntityManager();
		CardapioDAO dao = new CardapioDAO(em);
		em.getTransaction().begin();
		if(cardapio.getCardapioId()!=null){
			dao.alterar(cardapio);
		}else{
			dao.cadastrar(cardapio);
		}
		em.getTransaction().commit();
		em.close();
		cardapio  = new Cardapio();
		carregarCardapio();
	}

}
