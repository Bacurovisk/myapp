package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Entregas;
import br.com.myapp.mod.dao.EntregasDAO;
import br.com.myapp.mod.util.JPAUtil;

@ManagedBean 
@ViewScoped 
public class EntregasMB {
	private Entregas entregas = new Entregas();

	public Entregas getEntregas() {
		return entregas;
	}

	public void setEntregas(Entregas entregas) {
		this.entregas = entregas;
	}

	public List<Entregas> listaEntregas = new ArrayList<Entregas>();

	public List<Entregas> getListaEntregas() {
		return listaEntregas;
	}
	public List<Entregas> listaEntregas2 = new ArrayList<Entregas>();

	public List<Entregas> getListaEntregas2() {
		return listaEntregas2;
	}

	@PostConstruct
	public void carregarEntregas() {
		EntityManager em = JPAUtil.getEntityManager();
		EntregasDAO dao = new EntregasDAO(em);
		listaEntregas = dao.listar();
		listaEntregas2 = dao.listar2();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		EntregasDAO dao = new EntregasDAO(em);
		em.getTransaction().begin();
		dao.excluir(entregas);
		em.getTransaction().commit();
		em.close();
		carregarEntregas();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		EntregasDAO dao = new EntregasDAO(em);
		em.getTransaction().begin();
		
		if (entregas.getId() != null) {
			dao.alterar(entregas);
		} else {
			dao.cadastrar(entregas);
		}
		em.getTransaction().commit();
		em.close();
		entregas = new Entregas();
		carregarEntregas();
	}
	
}
