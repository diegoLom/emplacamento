package com.losolved.emplacamento.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "emplacamento_taxas")

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="taxaKey", scope = EmplacamentoTaxa.class)
public class EmplacamentoTaxa {

	@EmbeddedId
	private	EmplacamentoTaxaKey taxaKey;

	@ManyToOne(fetch= FetchType.EAGER)
	@MapsId("taxas_id")
	@JoinColumn(name = "taxas_id")
	private Taxa taxa;

	@MapsId("emplacamentos_id")
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "emplacamentos_id")
	private Emplacamento emplacamento;
	
	@Transient
	@JsonInclude()
	private	Integer taxa_Id;
	
	

	@Column
	private BigDecimal valor_final; 
	
	@Transient
	private String vl_final_formatado = "";

	
	

	public String getVl_final_formatado() {
		return vl_final_formatado;
	}

	public void setVl_final_formatado(String vl_final_formatado) {
		this.vl_final_formatado = vl_final_formatado;
	}

	public BigDecimal getValor_final() {
		return valor_final;
	}

	public void setValor_final(BigDecimal valor_final) {
		
		
		if(valor_final != null)
			setVl_final_formatado(new java.text.DecimalFormat("R$ #,##0.00").format(valor_final));
	
		this.valor_final = valor_final;
	}

	public EmplacamentoTaxa(Taxa taxa, Emplacamento emplacamento) {
		super();
		this.taxa = taxa;
		this.emplacamento = emplacamento;
	}

	public EmplacamentoTaxa() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTaxa_Id() {
		return taxa_Id;
	}

	public void setTaxa_Id(Integer taxa_Id) {
		this.taxa_Id = taxa_Id;
	}

	public Taxa getTaxa() {
		return taxa;
	}

	public void setTaxa(Taxa taxa) {
		this.taxa = taxa;
	}

	public Emplacamento getEmplacamento() {
		return emplacamento;
	}

	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}

	public EmplacamentoTaxaKey getTaxaKey() {
		return taxaKey;
	}

	public void setTaxaKey(EmplacamentoTaxaKey taxaKey) {
		this.taxaKey = taxaKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emplacamento == null) ? 0 : emplacamento.hashCode());
		result = prime * result + ((taxa == null) ? 0 : taxa.hashCode());
		result = prime * result + ((taxaKey == null) ? 0 : taxaKey.hashCode());
		result = prime * result + ((taxa_Id == null) ? 0 : taxa_Id.hashCode());
		result = prime * result + ((valor_final == null) ? 0 : valor_final.hashCode());
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
		EmplacamentoTaxa other = (EmplacamentoTaxa) obj;
		if (emplacamento == null) {
			if (other.emplacamento != null)
				return false;
		} else if (!emplacamento.equals(other.emplacamento))
			return false;
		if (taxa == null) {
			if (other.taxa != null)
				return false;
		} else if (!taxa.equals(other.taxa))
			return false;
		if (taxaKey == null) {
			if (other.taxaKey != null)
				return false;
		} else if (!taxaKey.equals(other.taxaKey))
			return false;
		if (taxa_Id == null) {
			if (other.taxa_Id != null)
				return false;
		} else if (!taxa_Id.equals(other.taxa_Id))
			return false;
		if (valor_final == null) {
			if (other.valor_final != null)
				return false;
		} else if (!valor_final.equals(other.valor_final))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmplacamentoTaxa "
				;
	}


	
	
}
