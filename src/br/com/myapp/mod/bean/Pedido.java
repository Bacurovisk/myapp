package br.com.myapp.mod.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PEDIDO")
public class Pedido {
	
	@Id
	@GeneratedValue
	@Column(name="pedido_id")
	private Long pedidoId;
	
	@Column(name="pedido_nome_prato")
	private String nomePrato;
	
	@Column(name="pedido_quantidade")
	private float qtdPedido;
	
	@Column(name="pedido_total_valor")
	private double totalValor;
	
	@ManyToOne
	@JoinColumn(name="cartao_id", 
				insertable=true, updatable=true, 
				nullable=true)
	private Cartao cartao = new Cartao();
	
	@ManyToOne
	@JoinColumn(name="local_id", 
				insertable=true, updatable=true, 
				nullable=true)
	private Local local = new Local();
	
	public Pedido() {
		
	}
	
	public Pedido(String nomePrato, Float qtdPedido, Double totalValor) {
		this.nomePrato = nomePrato;
		this.qtdPedido = qtdPedido;
		this.totalValor = totalValor;
	}
	
	
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	public String getNomePrato() {
		return nomePrato;
	}
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	public float getQtdPedido() {
		return qtdPedido;
	}
	public void setQtdPedido(float qtdPedido) {
		this.qtdPedido = qtdPedido;
	}
	public double getTotalValor() {
		return totalValor;
	}
	public void setTotalValor(double totalValor) {
		this.totalValor = totalValor;
	}
		
	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	

}
