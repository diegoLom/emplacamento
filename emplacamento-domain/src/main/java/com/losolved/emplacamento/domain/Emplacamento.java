package com.losolved.emplacamento.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "emplacamento")
@SequenceGenerator(name = "default_seq", sequenceName = "EMPLACA_SEQ", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class Emplacamento extends BaseEntity<Integer> {
	
	

	
//	@OneToOne(mappedBy = "emplacamento")
//	private EmplacamentoAvulso emplacamentoA;

	
	private String	numero_proposta;
	private String numero_pedido;
	private BigDecimal valor_proposta;
	private BigDecimal valor_nf;
	private BigDecimal valor_financiado;
	private String nome_cliente;
	private String codigo_veiculo;
	private String modelo_veiculo;
	private String placa;
	private String uf_placa;
	private String chassi;
	private String numero_motor;
	private String renavam;
	private String combustivel;
	private String cor_externa;
	private String classificacao;
	private String estqoue;
	private String vendedor_proposta;
	
	private String propdata;
	private String cidadeplaca;
	
	
	
//	@OneToMany(targetEntity = com.losolved.emplacamento.domain.FormaPagamento.class, mappedBy = "emplacamento" , fetch = FetchType.LAZY)
	@Transient
	private Set<FormaPagamento> pagamentos;

	
	@Column
	private String observacao;
	

//  @OneToMany(targetEntity = com.losolved.emplacamento.domain.EmplacamentoTaxa.class, mappedBy = "taxa", fetch = FetchType.LAZY)
	@Transient
  	private Set<EmplacamentoTaxa> taxas;
	  
	

	public Set<EmplacamentoTaxa> getTaxas() {
		return taxas;
	}

	public void setTaxas(Set<EmplacamentoTaxa> taxas) {
		
		for (EmplacamentoTaxa empl_taxa : taxas) {
			if(empl_taxa != null && empl_taxa.getTaxa() != null)
				valorEmplacamento = valorEmplacamento.add(empl_taxa.getTaxa().getVl_final());
		}
	
		this.taxas = taxas;
	}

	public String getNumero_proposta() {
		return numero_proposta;
	}

	public void setNumero_proposta(String numero_proposta) {
		this.numero_proposta = numero_proposta;
	}

	public String getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(String numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public BigDecimal getValor_proposta() {
		return valor_proposta;
	}

	public void setValor_proposta(BigDecimal valor_proposta) {
		this.valor_proposta = valor_proposta;
	}

	public BigDecimal getValor_nf() {
		return valor_nf;
	}

	public void setValor_nf(BigDecimal valor_nf) {
		this.valor_nf = valor_nf;
	}

	public BigDecimal getValor_financiado() {
		return valor_financiado;
	}

	public void setValor_financiado(BigDecimal valor_financiado) {
		this.valor_financiado = valor_financiado;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getCodigo_veiculo() {
		return codigo_veiculo;
	}

	public void setCodigo_veiculo(String codigo_veiculo) {
		this.codigo_veiculo = codigo_veiculo;
	}

	public String getModelo_veiculo() {
		return modelo_veiculo;
	}

	public void setModelo_veiculo(String modelo_veiculo) {
		this.modelo_veiculo = modelo_veiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getUf_placa() {
		return uf_placa;
	}

	public void setUf_placa(String uf_placa) {
		this.uf_placa = uf_placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getNumero_motor() {
		return numero_motor;
	}

	public void setNumero_motor(String numero_motor) {
		this.numero_motor = numero_motor;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCor_externa() {
		return cor_externa;
	}

	public void setCor_externa(String cor_externa) {
		this.cor_externa = cor_externa;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getEstqoue() {
		return estqoue;
	}

	public void setEstqoue(String estqoue) {
		this.estqoue = estqoue;
	}

	public String getVendedor_proposta() {
		return vendedor_proposta;
	}

	public void setVendedor_proposta(String vendedor_proposta) {
		this.vendedor_proposta = vendedor_proposta;
	}

	
	@Transient
	private BigDecimal valorEmplacamento = new BigDecimal(0);
	
	
	
	public void setValorEmplacamento(BigDecimal valorEmplacamento) {
		this.valorEmplacamento = valorEmplacamento;
	}

	public BigDecimal getValorEmplacamento() {
		return valorEmplacamento;
		
	}

//	public Veiculo getVeiculo() {
//		return veiculo;
//	}
//
//	public void setVeiculo(Veiculo veiculo) {
//		this.veiculo = veiculo;
//	}
//
//	public Municipio getMunicipio() {
//		return municipio;
//	}
//
//	public void setMunicipio(Municipio municipio) {
//		this.municipio = municipio;
//	}

	


	public Set<FormaPagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(Set<FormaPagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	
	public void setPagamentos(FormaPagamento pagamento, Boolean t) {
		if(pagamentos == null)
			pagamentos = new HashSet<FormaPagamento>();
			
		 pagamentos.add(pagamento);
			
		this.pagamentos = pagamentos;
	}


	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((cidadeplaca == null) ? 0 : cidadeplaca.hashCode());
		result = prime * result + ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result + ((codigo_veiculo == null) ? 0 : codigo_veiculo.hashCode());
		result = prime * result + ((combustivel == null) ? 0 : combustivel.hashCode());
		result = prime * result + ((cor_externa == null) ? 0 : cor_externa.hashCode());
		result = prime * result + ((estqoue == null) ? 0 : estqoue.hashCode());
		result = prime * result + ((modelo_veiculo == null) ? 0 : modelo_veiculo.hashCode());
		result = prime * result + ((nome_cliente == null) ? 0 : nome_cliente.hashCode());
		result = prime * result + ((numero_motor == null) ? 0 : numero_motor.hashCode());
		result = prime * result + ((numero_pedido == null) ? 0 : numero_pedido.hashCode());
		result = prime * result + ((numero_proposta == null) ? 0 : numero_proposta.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((pagamentos == null) ? 0 : pagamentos.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((propdata == null) ? 0 : propdata.hashCode());
		result = prime * result + ((renavam == null) ? 0 : renavam.hashCode());
		result = prime * result + ((taxas == null) ? 0 : taxas.hashCode());
		result = prime * result + ((uf_placa == null) ? 0 : uf_placa.hashCode());
		result = prime * result + ((valorEmplacamento == null) ? 0 : valorEmplacamento.hashCode());
		result = prime * result + ((valor_financiado == null) ? 0 : valor_financiado.hashCode());
		result = prime * result + ((valor_nf == null) ? 0 : valor_nf.hashCode());
		result = prime * result + ((valor_proposta == null) ? 0 : valor_proposta.hashCode());
		result = prime * result + ((vendedor_proposta == null) ? 0 : vendedor_proposta.hashCode());
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
		Emplacamento other = (Emplacamento) obj;
		if (chassi == null) {
			if (other.chassi != null)
				return false;
		} else if (!chassi.equals(other.chassi))
			return false;
		if (cidadeplaca == null) {
			if (other.cidadeplaca != null)
				return false;
		} else if (!cidadeplaca.equals(other.cidadeplaca))
			return false;
		if (classificacao == null) {
			if (other.classificacao != null)
				return false;
		} else if (!classificacao.equals(other.classificacao))
			return false;
		if (codigo_veiculo == null) {
			if (other.codigo_veiculo != null)
				return false;
		} else if (!codigo_veiculo.equals(other.codigo_veiculo))
			return false;
		if (combustivel == null) {
			if (other.combustivel != null)
				return false;
		} else if (!combustivel.equals(other.combustivel))
			return false;
		if (cor_externa == null) {
			if (other.cor_externa != null)
				return false;
		} else if (!cor_externa.equals(other.cor_externa))
			return false;
		if (estqoue == null) {
			if (other.estqoue != null)
				return false;
		} else if (!estqoue.equals(other.estqoue))
			return false;
		if (modelo_veiculo == null) {
			if (other.modelo_veiculo != null)
				return false;
		} else if (!modelo_veiculo.equals(other.modelo_veiculo))
			return false;
		if (nome_cliente == null) {
			if (other.nome_cliente != null)
				return false;
		} else if (!nome_cliente.equals(other.nome_cliente))
			return false;
		if (numero_motor == null) {
			if (other.numero_motor != null)
				return false;
		} else if (!numero_motor.equals(other.numero_motor))
			return false;
		if (numero_pedido == null) {
			if (other.numero_pedido != null)
				return false;
		} else if (!numero_pedido.equals(other.numero_pedido))
			return false;
		if (numero_proposta == null) {
			if (other.numero_proposta != null)
				return false;
		} else if (!numero_proposta.equals(other.numero_proposta))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (pagamentos == null) {
			if (other.pagamentos != null)
				return false;
		} else if (!pagamentos.equals(other.pagamentos))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (propdata == null) {
			if (other.propdata != null)
				return false;
		} else if (!propdata.equals(other.propdata))
			return false;
		if (renavam == null) {
			if (other.renavam != null)
				return false;
		} else if (!renavam.equals(other.renavam))
			return false;
		if (taxas == null) {
			if (other.taxas != null)
				return false;
		} else if (!taxas.equals(other.taxas))
			return false;
		if (uf_placa == null) {
			if (other.uf_placa != null)
				return false;
		} else if (!uf_placa.equals(other.uf_placa))
			return false;
		if (valorEmplacamento == null) {
			if (other.valorEmplacamento != null)
				return false;
		} else if (!valorEmplacamento.equals(other.valorEmplacamento))
			return false;
		if (valor_financiado == null) {
			if (other.valor_financiado != null)
				return false;
		} else if (!valor_financiado.equals(other.valor_financiado))
			return false;
		if (valor_nf == null) {
			if (other.valor_nf != null)
				return false;
		} else if (!valor_nf.equals(other.valor_nf))
			return false;
		if (valor_proposta == null) {
			if (other.valor_proposta != null)
				return false;
		} else if (!valor_proposta.equals(other.valor_proposta))
			return false;
		if (vendedor_proposta == null) {
			if (other.vendedor_proposta != null)
				return false;
		} else if (!vendedor_proposta.equals(other.vendedor_proposta))
			return false;
		return true;
	}
	
	

	public String getPropdata() {
		return propdata;
	}

	public void setPropdata(String propdata) {
		this.propdata = propdata;
	}

	public String getCidadeplaca() {
		return cidadeplaca;
	}

	public void setCidadeplaca(String cidadeplaca) {
		this.cidadeplaca = cidadeplaca;
	}

	@Override
	public String toString() {
		return "Emplacamento [numero_proposta=" + numero_proposta + ", numero_pedido=" + numero_pedido
				+ ", valor_proposta=" + valor_proposta + ", valor_nf=" + valor_nf + ", valor_financiado="
				+ valor_financiado + ", nome_cliente=" + nome_cliente + ", codigo_veiculo=" + codigo_veiculo
				+ ", modelo_veiculo=" + modelo_veiculo + ", placa=" + placa + ", uf_placa=" + uf_placa + ", chassi="
				+ chassi + ", numero_motor=" + numero_motor + ", renavam=" + renavam + ", combustivel=" + combustivel
				+ ", cor_externa=" + cor_externa + ", classificacao=" + classificacao + ", estqoue=" + estqoue
				+ ", vendedor_proposta=" + vendedor_proposta + ", propdata=" + propdata + ", cidadeplaca=" + cidadeplaca
				+ ", pagamentos=" + pagamentos + ", observacao=" + observacao + ", taxas=" + taxas
				+ ", valorEmplacamento=" + valorEmplacamento + "]";
	}

	





}
