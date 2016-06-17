package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.bean.Local;
import br.com.myapp.mod.dao.LocalDAO;
import br.com.myapp.mod.util.JPAUtil;

@ViewScoped
@ManagedBean
public class LocalMB {
	
		private Local local = new Local();
		
		public Local getLocal() {
			return local;
		}
		
		public void setLocal(Local local) {
			this.local = local;
		}
		
		public List<Local> listaLocal = new ArrayList<Local>();
		
		public List<Local> getListaLocal() {
			return listaLocal;
		}	
		public List<Local> listaLocal2 = new ArrayList<Local>();
		
		public List<Local> getListaLocal2() {
			return listaLocal2;
		}

		@PostConstruct
		public void carregarLocal(){
			EntityManager em = JPAUtil.getEntityManager();
			LocalDAO dao = new LocalDAO(em);
			listaLocal = dao.listar();
			listaLocal2 = dao.listar2();
			em.close();
		}
		
		public void excluir(){
			EntityManager em = JPAUtil.getEntityManager();
			LocalDAO dao = new LocalDAO(em);
			em.getTransaction().begin();
			dao.excluir(local);
			em.getTransaction().commit();
			em.close();
			carregarLocal();
		}

		public void salvar(){
			EntityManager em = JPAUtil.getEntityManager();
			LocalDAO dao = new LocalDAO(em);
			em.getTransaction().begin();
			if(local.getLocalId()!=null){
				dao.alterar(local);
			}else{
				dao.cadastrar(local);
			}
			em.getTransaction().commit();
			em.close();
			local  = new Local();
			carregarLocal();
		}
}
