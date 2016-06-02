package br.com.myapp.mod.val;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pedido {
	@Id
	@GeneratedValue
	private Long id;
	private String nomeprato;
	private float quantidade;
	private double totalvalor;
	private String formapagamento;
	private String localentrega;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeprato() {
		return nomeprato;
	}
	public void setNomeprato(String nomeprato) {
		this.nomeprato = nomeprato;
	}
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public double getTotalvalor() {
		return totalvalor;
	}
	public void setTotalvalor(double totalvalor) {
		this.totalvalor = totalvalor;
	}
	public String getFormapagamento() {
		return formapagamento;
	}
	public void setFormapagamento(String formapagamento) {
		this.formapagamento = formapagamento;
	}
	public String getLocalentrega() {
		return localentrega;
	}
	public void setLocalentrega(String localentrega) {
		this.localentrega = localentrega;
	}
	
	
	
}
