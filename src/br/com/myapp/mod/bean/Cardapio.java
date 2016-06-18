package br.com.myapp.mod.bean;

import javax.persistence.Entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARDAPIO")
public class Cardapio {
	@Id
	@GeneratedValue
	@Column(name = "CARDAPIO_ID")
	private Long cardapioId;

	@Column(name = "CARDAPIO_TITULO")
	private String cardapioTitulo;

	@Column(name = "CARDAPIO_PERIODO")
	private String cardapioPeriodo;

	@Column(name = "CARDAPIO_INF")
	private String cardapioExtra;

	@ManyToOne
	@JoinColumn(name = "categoria_id", insertable = true, updatable = true, nullable = true)
	private Categoria categoria = new Categoria();

	@Column(name = "CARDAPIO_DESC")
	private String descSimples;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "cardapio_id")
	private List<Item> item;

	public Cardapio() {

	}

	public Cardapio(String cardapioTitulo, String cardapioExtra, String cardapioPeriodo) {
		this.cardapioTitulo = cardapioTitulo;
		this.cardapioPeriodo = cardapioPeriodo;
		this.cardapioExtra = cardapioExtra;
	}

	public Long getCardapioId() {
		return cardapioId;
	}

	public void setCardapioId(Long cardapioId) {
		this.cardapioId = cardapioId;
	}

	public String getCardapioTitulo() {
		return cardapioTitulo;
	}

	public void setCardapioTitulo(String cardapioTitulo) {
		this.cardapioTitulo = cardapioTitulo;
	}

	public String getCardapioPeriodo() {
		return cardapioPeriodo;
	}

	public void setCardapioPeriodo(String cardapioPeriodo) {
		this.cardapioPeriodo = cardapioPeriodo;
	}

	public String getCardapioExtra() {
		return cardapioExtra;
	}

	public void setCardapioExtra(String cardapioExtra) {
		this.cardapioExtra = cardapioExtra;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescSimples() {
		return descSimples;
	}

	public void setDescSimples(String descSimples) {
		this.descSimples = descSimples;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public String toString() {
		return cardapioTitulo;
	}
}
