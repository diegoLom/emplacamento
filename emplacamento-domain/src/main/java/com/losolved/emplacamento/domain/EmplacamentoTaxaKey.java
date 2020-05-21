package com.losolved.emplacamento.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmplacamentoTaxaKey implements Serializable{
	

    @Column(name = "emplacamentos_id")
	private Integer emplcamentoId;
 
    @Column(name = "taxas_id")
   private Integer taxaId;

	public Integer getEmplcamentoId() {
		return emplcamentoId;
	}

	public void setEmplcamentoId(Integer emplcamentoId) {
		this.emplcamentoId = emplcamentoId;
	}

	public Integer getTaxaId() {
		return taxaId;
	}

	public void setTaxaId(Integer taxaId) {
		this.taxaId = taxaId;
	}

	@Override
	public String toString() {
		return "EmplacamentoTaxaKey [emplcamentoId=" + emplcamentoId + ", taxaId=" + taxaId + ", getEmplcamentoId()="
				+ getEmplcamentoId() + ", getTaxaId()=" + getTaxaId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emplcamentoId == null) ? 0 : emplcamentoId.hashCode());
		result = prime * result + ((taxaId == null) ? 0 : taxaId.hashCode());
		return result;
	}

	public EmplacamentoTaxaKey(Integer emplcamentoId, Integer taxaId) {
		super();
		this.emplcamentoId = emplcamentoId;
		this.taxaId = taxaId;
	}
	
	public EmplacamentoTaxaKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmplacamentoTaxaKey other = (EmplacamentoTaxaKey) obj;
		if (emplcamentoId == null) {
			if (other.emplcamentoId != null)
				return false;
		} else if (!emplcamentoId.equals(other.emplcamentoId))
			return false;
		if (taxaId == null) {
			if (other.taxaId != null)
				return false;
		} else if (!taxaId.equals(other.taxaId))
			return false;
		return true;
	}
    
	
}

