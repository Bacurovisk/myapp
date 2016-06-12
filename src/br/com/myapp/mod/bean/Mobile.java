package br.com.myapp.mod.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mobile {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String tel;
	private double totalgasto;
	private float avaliacao;
	private String endereco;
	private String sugestao;
	
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public double getTotalgasto() {
		return totalgasto;
	}
	public void setTotalgasto(double totalgasto) {
		this.totalgasto = totalgasto;
	}
	public float getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(float avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSugestao() {
		return sugestao;
	}
	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}
}
