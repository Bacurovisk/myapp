package br.com.myapp.mod.bean;
import javax.persistence.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name="CARDAPIO")
public class Cardapio {
	@Id
	@GeneratedValue
	@Column(name="CARDAPIO_ID")
	private Long cardapioId;
	@Column(name="CARDAPIO_TITULO")
	private String cardapioTitulo;
	@Column(name="CARDAPIO_PERIODO")
	private Date cardapioPeriodo;
	@Column(name="CARDAPIO_INF")
	private String cardapioExtra;
	@ManyToOne
	@JoinColumn(name="categoria_id", 
				insertable=false, updatable=false, 
				nullable=false)
	private Categoria categoria;
	
	@Column(name="CARDAPIO_DESC")
	private String descSimples;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="cardapio_id")
	@IndexColumn(name="idx")
	private List<Item> item;
	
    public Cardapio() {
		
	}
	
	public Cardapio(String cardapioTitulo, String cardapioExtra) {
		this.cardapioTitulo = cardapioTitulo;
		this.cardapioPeriodo = new Date(System.currentTimeMillis());
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
	public Date getCardapioPeriodo() {
		return cardapioPeriodo;
	}
	public void setCardapioPeriodo(Date cardapioPeriodo) {
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
}
