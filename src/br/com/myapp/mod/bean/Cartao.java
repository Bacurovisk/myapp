package br.com.myapp.mod.bean;

import javax.persistence.Entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CARTAO")
public class Cartao {
	@Id 
	@GeneratedValue
	@Column(name="CARTAO_ID")
	private Long cartaoId;

	@Column(name="CARTAO_NOME")
	private String cartaoNome;
	
	@Column(name="CARTAO_PARCELA")
	private Double cartaoParcela;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="cartao_id")
	private List<Pedido> pedido;

	public Long getCartaoId() {
		return cartaoId;
	}

	public void setCartaoId(Long cartaoId) {
		this.cartaoId = cartaoId;
	}

	public String getCartaoNome() {
		return cartaoNome;
	}

	public void setCartaoNome(String cartaoNome) {
		this.cartaoNome = cartaoNome;
	}

	public Double getCartaoParcela() {
		return cartaoParcela;
	}

	public void setCartaoParcela(Double cartaoParcela) {
		this.cartaoParcela = cartaoParcela;
	}
	
	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
}
