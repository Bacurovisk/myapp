package br.com.myapp.mod.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.myapp.mod.val.Pedido;
import br.com.myapp.mod.pers.JPAUtil;
import br.com.myapp.mod.crud.PedidoCRUD;

@ManagedBean

@ViewScoped

public class PedidoMB {

	private Pedido pedido = new Pedido();

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> listaPedido = new ArrayList<Pedido>();

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	@PostConstruct // � importante colocar suas inicializa��es no post construct
					// e n�o no construtor da classe, isso porque se voc�
					// estiver realizando inje��o de depend�ncia (no Spring, por
					// exemplo) todas as depend�ncias podem n�o estar carregadas
					// na constru��o da sua classe, ent�o no post construct voc�
					// garante que tudo j� foi carregado e agora voc� pode
					// us�-los.
	
	public void carregarPedido() {
		EntityManager em = JPAUtil.getEntityManager();
		PedidoCRUD crud = new PedidoCRUD(em);
		listaPedido = crud.listar();
		em.close();
	}

	public void excluir() {
		EntityManager em = JPAUtil.getEntityManager();
		PedidoCRUD crud = new PedidoCRUD(em);
		em.getTransaction().begin();
		crud.excluir(pedido);
		em.getTransaction().commit();
		em.close();
		carregarPedido();
	}

	public void salvar() {

		EntityManager em = JPAUtil.getEntityManager();
		PedidoCRUD crud = new PedidoCRUD(em);
		em.getTransaction().begin();
		if (pedido.getId() != null) {
			crud.alterar(pedido);
		} else {
			crud.cadastrar(pedido);
		}
		em.getTransaction().commit();
		em.close();
		pedido = new Pedido();
		carregarPedido();
	}
}