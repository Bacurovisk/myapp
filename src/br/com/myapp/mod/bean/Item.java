package br.com.myapp.mod.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Long itemId;
	@Column(name="item_nome")
	private String itemNome;
	@Column(name="item_descS")
	private String descricaoSimples;
	@Column(name="item_descC")
	private String descricaoCompleta;
	@Column(name="item_preco")
	private float itemPreco;
	@ManyToOne
	@JoinColumn(name="cardapio_id", 
				insertable=false, updatable=false, 
				nullable=false)
	private Cardapio cardapio;
	
public Item() {
		
	}
	
	public Item(String itemNome, String descricaoSimples, String descricaoCompleta, Float itemPreco ) {
		this.itemNome = itemNome;
		this.descricaoSimples = descricaoSimples;
		this.descricaoCompleta = descricaoCompleta;
		this.itemPreco = itemPreco;
	}
	
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemNome() {
		return itemNome;
	}
	public void setItemNome(String itemNome) {
		this.itemNome = itemNome;
	}
	public String getDescricaoSimples() {
		return descricaoSimples;
	}
	public void setDescricaoSimples(String descricaoSimples) {
		this.descricaoSimples = descricaoSimples;
	}
	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}
	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}
	public float getItemPreco() {
		return itemPreco;
	}
	public void setItemPreco(float itemPreco) {
		this.itemPreco = itemPreco;
	}
	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

}
