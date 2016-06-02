package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import br.com.myapp.mod.crud.EntregasCRUD;
import br.com.myapp.mod.pers.JPAUtil;
import br.com.myapp.mod.val.Entregas;

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

	@PostConstruct
	public void carregarEntregas() {
		EntityManager em = JPAUtil.getEntityManager();
		EntregasCRUD crud = new EntregasCRUD(em);
		listaEntregas = crud.listar();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		EntregasCRUD crud = new EntregasCRUD(em);
		em.getTransaction().begin();
		crud.excluir(entregas);
		em.getTransaction().commit();
		em.close();
		carregarEntregas();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		EntregasCRUD crud = new EntregasCRUD(em);
		em.getTransaction().begin();
		
		if (entregas.getId() != null) {
			crud.alterar(entregas);
		} else {
			crud.cadastrar(entregas);
		}
		em.getTransaction().commit();
		em.close();
		entregas = new Entregas();
		carregarEntregas();
	}
	
}
