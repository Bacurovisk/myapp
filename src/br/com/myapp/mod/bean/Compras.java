package br.com.myapp.mod.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMPRAS")
public class Compras {
	@Id 
	@GeneratedValue 
	@Column(name="compra_id")
	private Long compraId;

	@ManyToOne
	@JoinColumn(name="fornecedor_id", 
				insertable=true, updatable=true, 
				nullable=true)
	private Fornecedor fornecedor = new Fornecedor();
	
	@Column(name="compras_desc_compra")
	private String descCompra;
	
	@Column(name="compra_qtd")
	private int qtdCompra;
	
	@Column(name="compra_total")
	private Double totalCompra;
	
public Compras() {
		
	}
	
	public Compras(String descCompra, int qtdCompra, Double totalCompra ) {
		this.descCompra = descCompra;
		this.qtdCompra = qtdCompra;
		this.totalCompra = totalCompra;
	}
	
	

	public Long getCompraId() {
		return compraId;
	}

	public void setCompraId(Long compraId) {
		this.compraId = compraId;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDescCompra() {
		return descCompra;
	}

	public void setDescCompra(String descCompra) {
		this.descCompra = descCompra;
	}
	
	public int getQtdCompra() {
		return qtdCompra;
	}

	public void setQtdCompra(int qtdCompra) {
		this.qtdCompra = qtdCompra;
	}
	
	public Double getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(Double totalCompra) {
		this.totalCompra = totalCompra;
	}
}
