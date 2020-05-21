package com.losolved.emplacamento.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;

@Entity
@Table(name = "forma_pagamento")
@SequenceGenerator(name = "default_seq", sequenceName = "PAGAMENTO_SEQ", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class FormaPagamento extends BaseEntity<Integer> {
	
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "emplacaid", nullable=false)
	private Emplacamento emplacamento;
	
		
	@Column
	private BigDecimal valor;

	@JsonIgnore
	public Emplacamento getEmplacamento() {
		return emplacamento;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "tpPagamentoId", nullable=false)
	private TipoPagamento tipoPagamento;
	
	
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}


	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	

	
	
	@JsonInclude()
	@Transient
	private String tipoPagamentoId;

	public String getTipoPagamentoId() {
		return tipoPagamentoId;
	}

	public void setTipoPagamentoId(String tipoPagamentoId) {
		
		TipoPagamento tpPagamento = new TipoPagamento();
		tpPagamento.setId(Integer.parseInt(tipoPagamentoId));
		
		setTipoPagamento(tpPagamento);
		
		this.tipoPagamentoId = tipoPagamentoId;
	}


	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}





	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	@Override
	public String toString() {
		return "FormaPagamento [emplacamento=" + emplacamento + ", valor=" + valor + ", tipoPagamento=" + tipoPagamento
				+ ", tipoPagamentoId=" + tipoPagamentoId + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((emplacamento == null) ? 0 : emplacamento.hashCode());
		result = prime * result + ((tipoPagamento == null) ? 0 : tipoPagamento.hashCode());
		result = prime * result + ((tipoPagamentoId == null) ? 0 : tipoPagamentoId.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
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
		if (tipoPagamentoId == null) {
			if (other.tipoPagamentoId != null)
				return false;
		} else if (!tipoPagamentoId.equals(other.tipoPagamentoId))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	} 
	
	
	

}
