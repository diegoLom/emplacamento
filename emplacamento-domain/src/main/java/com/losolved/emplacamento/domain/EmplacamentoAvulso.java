package com.losolved.emplacamento.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "emplacamento_avulso")
public class EmplacamentoAvulso extends BaseEntity<Integer>{
		
	@OneToOne @MapsId
	private Emplacamento emplacamento;

		
	@Column
	private String veiculo;
	
	@Column
	private BigDecimal vlVeiculo;
	
	@Column
	private String estoque;
	
	@Column
	@Temporal(value = TemporalType.TIMESTAMP)
	private java.util.Date data_emplacamento;
	
	
	@Column
	private String potencia;
	
	@Column
	private String classificacao;
	
	
	public Emplacamento getEmplacamento() {
		return emplacamento;
	}

	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result + ((data_emplacamento == null) ? 0 : data_emplacamento.hashCode());
		result = prime * result + ((emplacamento == null) ? 0 : emplacamento.hashCode());
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + ((potencia == null) ? 0 : potencia.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
		result = prime * result + ((vlVeiculo == null) ? 0 : vlVeiculo.hashCode());
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
		EmplacamentoAvulso other = (EmplacamentoAvulso) obj;
		if (classificacao == null) {
			if (other.classificacao != null)
				return false;
		} else if (!classificacao.equals(other.classificacao))
			return false;
		if (data_emplacamento == null) {
			if (other.data_emplacamento != null)
				return false;
		} else if (!data_emplacamento.equals(other.data_emplacamento))
			return false;
		if (emplacamento == null) {
			if (other.emplacamento != null)
				return false;
		} else if (!emplacamento.equals(other.emplacamento))
			return false;
		if (estoque == null) {
			if (other.estoque != null)
				return false;
		} else if (!estoque.equals(other.estoque))
			return false;
		if (potencia == null) {
			if (other.potencia != null)
				return false;
		} else if (!potencia.equals(other.potencia))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		if (vlVeiculo == null) {
			if (other.vlVeiculo != null)
				return false;
		} else if (!vlVeiculo.equals(other.vlVeiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmplacamentoAvulso [emplacamento=" + emplacamento + "]";
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public BigDecimal getVlVeiculo() {
		return vlVeiculo;
	}

	public void setVlVeiculo(BigDecimal vlVeiculo) {
		this.vlVeiculo = vlVeiculo;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

	public java.util.Date getData_emplacamento() {
		return data_emplacamento;
	}

	public void setData_emplacamento(java.util.Date data_emplacamento) {
		this.data_emplacamento = data_emplacamento;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	} 
	
	
	
	
	
	
	

}
