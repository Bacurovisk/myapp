package br.com.myapp.mod.bean;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="FORNECEDOR")
public class Fornecedor {
	@Id
	@GeneratedValue
	@Column(name="FORNECEDOR_ID")
	private Long fornecedorId;
	
	@Column(name="FORNECEDOR_NOME")
	private String fornecedorNome;
	
	@Column(name="FORNECEDOR_PRODUTO")
	private String fornecedorProduto;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="fornecedor_id")
	@IndexColumn(name="idx")
	private List<Compras> compras;
	
	public Long getFornecedorId() {
		return fornecedorId;
	}
	public void setFornecedorId(Long fornecedorId) {
		this.fornecedorId = fornecedorId;
	}
	public String getFornecedorNome() {
		return fornecedorNome;
	}
	public void setFornecedorNome(String fornecedorNome) {
		this.fornecedorNome = fornecedorNome;
	}
	public String getFornecedorProduto() {
		return fornecedorProduto;
	}
	public void setFornecedorProduto(String fornecedorProduto) {
		this.fornecedorProduto = fornecedorProduto;
	}
	public List<Compras> getCompras() {
		return compras;
	}
	public void setCompras(List<Compras> compras) {
		this.compras = compras;
	}
}
