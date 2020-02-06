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
	
	@OneToMany
	@JoinColumn
	private List<Incidente> incidentes;
	
	@OneToMany
	@JoinColumn
	private List<FormaPagamento> pagamentos;
	
	@Column
	private String observacao;

	@Override
	public String toString() {
		return "Emplacamento [veiculo=" + veiculo + ", incidentes=" + incidentes + ", pagamentos=" + pagamentos
				+ ", observacao=" + observacao + "]";
	}
	
	
	


}
