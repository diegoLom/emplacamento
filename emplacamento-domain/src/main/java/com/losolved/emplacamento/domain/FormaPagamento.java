package com.losolved.emplacamento.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ibm.icu.math.BigDecimal;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento extends BaseEntity<Integer> {
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "emplacaid")
	private Emplacamento emplacamento;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "tpPagamentoId")
	private TipoPagamento tipoPagamento;
	
	
	@Column
	private BigDecimal valor;


	public Emplacamento getEmplacamento() {
		return emplacamento;
	}


	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}


	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}


	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emplacamento == null) ? 0 : emplacamento.hashCode());
		result = prime * result + ((tipoPagamento == null) ? 0 : tipoPagamento.hashCode());
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
		FormaPagamento other = (FormaPagamento) obj;
		if (emplacamento == null) {
			if (other.emplacamento != null)
				return false;
		} else if (!emplacamento.equals(other.emplacamento))
			return false;
		if (tipoPagamento == null) {
			if (other.tipoPagamento != null)
				return false;
		} else if (!tipoPagamento.equals(other.tipoPagamento))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	} 
	
	
	

}
