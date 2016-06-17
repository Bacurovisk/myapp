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




@Entity
@Table(name="LOCAL")
public class Local {
	
	@Id
	@GeneratedValue
	@Column(name="LOCAL_ID")
	private Long localId;
	@Column(name="LOCAL_NOME")
	private String localNome;
	@Column(name="LOCAL_TAXA")
	private Double localTaxa;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="local_id")
	private List<Pedido> pedido;
	
	public Long getLocalId() {
		return localId;
	}
	public void setLocalId(Long localId) {
		this.localId = localId;
	}
	public String getLocalNome() {
		return localNome;
	}
	public void setLocalNome(String localNome) {
		this.localNome = localNome;
	}
	public Double getLocalTaxa() {
		return localTaxa;
	}
	public void setLocalTaxa(Double localTaxa) {
		this.localTaxa = localTaxa;
	}
	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	
}
