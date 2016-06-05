package br.com.myapp.mod.val;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String descricaoSimples;
	private String descricaoCompleta;
	private float preco;
	
	// comencando get e set
	
	public String getNome() {
		return nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

}
