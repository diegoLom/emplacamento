package com.losolved.emplacamento.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "incidente")
public class Incidente extends BaseEntity<Integer>{
	
	
	@Column
	private BigDecimal valor; 
	
	@Column
	private String obs; 
	
	@Column
	private java.util.Date dtPagamento;
	
	
	@Column
	private java.util.Date dtEntrega;
	
	@Column
	private java.util.Date dtRecebimento;
	
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Emplacamento emplacamento; 
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private TipoIncidente tipoIncidente;

	

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public java.util.Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(java.util.Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public java.util.Date getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(java.util.Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public java.util.Date getDtRecebimento() {
		return dtRecebimento;
	}

	public void setDtRecebimento(java.util.Date dtRecebimento) {
		this.dtRecebimento = dtRecebimento;
	}

	public Emplacamento getEmplacamento() {
		return emplacamento;
	}

	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}

	public TipoIncidente getTipoIncidente() {
		return tipoIncidente;
	}

	public void setTipoIncidente(TipoIncidente tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtEntrega == null) ? 0 : dtEntrega.hashCode());
		result = prime * result + ((dtPagamento == null) ? 0 : dtPagamento.hashCode());
		result = prime * result + ((dtRecebimento == null) ? 0 : dtRecebimento.hashCode());
		result = prime * result + ((emplacamento == null) ? 0 : emplacamento.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((tipoIncidente == null) ? 0 : tipoIncidente.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidente other = (Incidente) obj;
		if (dtEntrega == null) {
			if (other.dtEntrega != null)
				return false;
		} else if (!dtEntrega.equals(other.dtEntrega))
			return false;
		if (dtPagamento == null) {
			if (other.dtPagamento != null)
				return false;
		} else if (!dtPagamento.equals(other.dtPagamento))
			return false;
		if (dtRecebimento == null) {
			if (other.dtRecebimento != null)
				return false;
		} else if (!dtRecebimento.equals(other.dtRecebimento))
			return false;
		if (emplacamento == null) {
			if (other.emplacamento != null)
				return false;
		} else if (!emplacamento.equals(other.emplacamento))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (tipoIncidente == null) {
			if (other.tipoIncidente != null)
				return false;
		} else if (!tipoIncidente.equals(other.tipoIncidente))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	
	
	
	


}
