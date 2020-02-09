package com.losolved.emplacamento.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private Set<Incidente> incidentes;
	
	
	@OneToMany(targetEntity = com.losolved.emplacamento.domain.FormaPagamento.class, mappedBy = "emplacamento")
	private Set<FormaPagamento> pagamentos;

	
	@Column
	private String observacao;

	@Override
	public String toString() {
		return "Emplacamento [veiculo=" + veiculo + ", incidentes=" + incidentes + ", pagamentos=" + pagamentos
				+ ", observacao=" + observacao + "]";
	}
	
	public BigDecimal getValorEmplacamento() {
		BigDecimal valorEmplacamento = new BigDecimal(0); 
		  
		if(incidentes != null)
			for (Incidente incidente : incidentes) {
				valorEmplacamento = valorEmplacamento.add(incidente.getValor());
			}
			
		return valorEmplacamento;
		
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Set<Incidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(Set<Incidente> incidentes) {
		this.incidentes = incidentes;
	}
	
	
	public void setIncidentes(Incidente incidente) {
		if(incidentes == null)
			incidentes = new HashSet<Incidente>();
			
			
		this.incidentes = incidentes;
	}


	public Set<FormaPagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Set<FormaPagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	public void setPagamentos(FormaPagamento pagamento) {
		if(pagamentos == null)
			pagamentos = new HashSet<FormaPagamento>();
			
			
		this.pagamentos = pagamentos;
	}


	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	 


}
