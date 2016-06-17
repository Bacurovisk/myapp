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
@Table(name="CATEGORIA")
public class Categoria {
	
	@Id
	@GeneratedValue
	@Column(name="CATEGORIA_ID")
	private Long categoriaId;
	
	@Column(name="CATEGORIA_NOME")
	private String categoriaNome;
	
	@Column(name="CATEGORIA_ITEM")
	private String categoriaItem;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="categoria_id")
	private List<Cardapio> cardapio;
	
	
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	public String getCategoriaNome() {
		return categoriaNome;
	}
	public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
	}
	public String getCategoriaItem() {
		return categoriaItem;
	}
	public void setCategoriaItem(String categoriaItem) {
		this.categoriaItem = categoriaItem;
	}
	public List<Cardapio> getCardapio() {
		return cardapio;
	}
	public void setCardapio(List<Cardapio> cardapio) {
		this.cardapio = cardapio;
	}
	public String toString(){
		return categoriaNome;
	}
}
