package com.losolved.emplacamento.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//
@Entity
@Table(name = "emplacamento_avulso")
@SequenceGenerator(name = "default_seq", sequenceName = "EMPLACAMENTA_SEQ", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class EmplacamentoAvulso extends BaseEntity<Integer>{

	@OneToOne
	@JoinColumn(name = "id")
	@MapsId
	private Emplacamento emplacamento;
	
	private String codigo_cliente;
	
	private String nome;
	
	private BigDecimal vlVec;
	
	private String estoque;
	
	@Column
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date data;
	
	private String observacoes;
	
	private String codigo;
	
	private String descritivo;
	
	private String placa;
	
	private String estadoUF;
	
	private String chassi;
	
	private String motor;
	
	private String renavam;
	
	private String comb;
	
	private String potencia;
	
	private String cor;
	
	private String classificacao;
	
	private String status;
	
	private String vendedor;

	public Emplacamento getEmplacamento() {
		return emplacamento;
	}

	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}

	public String getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(String codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getVlVec() {
		return vlVec;
	}

	public void setVlVec(BigDecimal vlVec) {
		this.vlVec = vlVec;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescritivo() {
		return descritivo;
	}

	public void setDescritivo(String descritivo) {
		this.descritivo = descritivo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getEstadoUF() {
		return estadoUF;
	}

	public void setEstadoUF(String estadoUF) {
		this.estadoUF = estadoUF;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getComb() {
		return comb;
	}

	public void setComb(String comb) {
		this.comb = comb;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public String toString() {
		return "EmplacamentoAvulso [emplacamento=" + emplacamento + ", codigo_cliente=" + codigo_cliente + ", nome="
				+ nome + ", vlVec=" + vlVec + ", estoque=" + estoque + ", data=" + data + ", observacoes=" + observacoes
				+ ", codigo=" + codigo + ", descritivo=" + descritivo + ", placa=" + placa + ", estadoUF=" + estadoUF
				+ ", chassi=" + chassi + ", motor=" + motor + ", renavam=" + renavam + ", comb=" + comb + ", potencia="
				+ potencia + ", cor=" + cor + ", classificacao=" + classificacao + ", status=" + status + ", vendedor="
				+ vendedor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((codigo_cliente == null) ? 0 : codigo_cliente.hashCode());
		result = prime * result + ((comb == null) ? 0 : comb.hashCode());
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descritivo == null) ? 0 : descritivo.hashCode());
		result = prime * result + ((emplacamento == null) ? 0 : emplacamento.hashCode());
		result = prime * result + ((estadoUF == null) ? 0 : estadoUF.hashCode());
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + ((motor == null) ? 0 : motor.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((potencia == null) ? 0 : potencia.hashCode());
		result = prime * result + ((renavam == null) ? 0 : renavam.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
		result = prime * result + ((vlVec == null) ? 0 : vlVec.hashCode());
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
		EmplacamentoAvulso other = (EmplacamentoAvulso) obj;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (classificacao == null) {
			if (other.classificacao != null)
				return false;
		} else if (!classificacao.equals(other.classificacao))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigo_cliente == null) {
			if (other.codigo_cliente != null)
				return false;
		} else if (!codigo_cliente.equals(other.codigo_cliente))
			return false;
		if (comb == null) {
			if (other.comb != null)
				return false;
		} else if (!comb.equals(other.comb))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descritivo == null) {
			if (other.descritivo != null)
				return false;
		} else if (!descritivo.equals(other.descritivo))
			return false;
		if (emplacamento == null) {
			if (other.emplacamento != null)
				return false;
		} else if (!emplacamento.equals(other.emplacamento))
			return false;
		if (estadoUF == null) {
			if (other.estadoUF != null)
				return false;
		} else if (!estadoUF.equals(other.estadoUF))
			return false;
		if (estoque == null) {
			if (other.estoque != null)
				return false;
		} else if (!estoque.equals(other.estoque))
			return false;
		if (motor == null) {
			if (other.motor != null)
				return false;
		} else if (!motor.equals(other.motor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (potencia == null) {
			if (other.potencia != null)
				return false;
		} else if (!potencia.equals(other.potencia))
			return false;
		if (renavam == null) {
			if (other.renavam != null)
				return false;
		} else if (!renavam.equals(other.renavam))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		if (vlVec == null) {
			if (other.vlVec != null)
				return false;
		} else if (!vlVec.equals(other.vlVec))
			return false;
		return true;
	}
	


	
	
	
	
	
	

}
