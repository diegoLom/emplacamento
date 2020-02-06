package com.losolved.emplacamento.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emplacamento")
public class Emplacamento extends BaseEntity<Integer> {
	
	
	@OneToOne
	@JoinColumn(name ="veiculoid")
	private Veiculo veiculo;
	
	
	@ManyToOne
	@JoinColumn(name ="municipioId")
	private Municipio municipio;
	
	

	@OneToMany(targetEntity = com.losolved.emplacamento.domain.Incidente.class, mappedBy = "emplacamento")
	private List<Incidente> incidentes;
	
	
	@OneToMany(targetEntity = com.losolved.emplacamento.domain.FormaPagamento.class, mappedBy = "emplacamento")
	private List<FormaPagamento> pagamentos;
	
	@Column
	private String observacao;

	@Override
	public String toString() {
		return "Emplacamento [veiculo=" + veiculo + ", incidentes=" + incidentes + ", pagamentos=" + pagamentos
				+ ", observacao=" + observacao + "]";
	}
	
	
	 


}
