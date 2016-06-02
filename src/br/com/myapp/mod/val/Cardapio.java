package br.com.myapp.mod.val;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cardapio {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String periodo;
	private String extra;
	private String categoria;
	private String descsimples;
	
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
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescsimples() {
		return descsimples;
	}
	public void setDescsimples(String descsimples) {
		this.descsimples = descsimples;
	}
}
