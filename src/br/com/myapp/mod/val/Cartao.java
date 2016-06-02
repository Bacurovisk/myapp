package br.com.myapp.mod.val;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cartao {
	@Id //A anotação "@Id" marca um campo como um campo de chave primária.
	@GeneratedValue //A anotação @GeneratedValue especifica que a chave primária é automaticamente atribuído pelo DB.
	private Long id;

	private String nome;

	private Double parcela;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getParcela() {
		return parcela;
	}

	public void setParcela(Double parcela) {
		this.parcela = parcela;
	}
}
