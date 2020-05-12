package com.losolved.emplacamento.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//
@Entity
@Table(name = "emplacamento_avulso")
@SequenceGenerator(name = "EMPLCAA_SEQ", sequenceName = "EMPLACAMENTA_SEQ", initialValue = 1, allocationSize = 1)

public class EmplacamentoAvulso extends BaseEntity<Integer>{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLCAA_SEQ")
	private Integer id; 

		
	@OneToOne
	@JoinColumn(name = "id")
	@MapsId
	private Emplacamento emplacamento;
	
	
	private String  codigo_cliente;
	private String nome;
	private String  tipo;
	private String cpf_cnpj;
	private String cgf_rg;
	private String endereco;
	private String numero;
	private String complemento;
	private String cep ;
	private String bairro;
	private String cidade;
	private String uf;
	private String fone1;
	private String fone2;
	private String fone3;
	private String data_aniversario;
	private String email ;
	private String  inscricao_municipal;

		
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
		int result = super.hashCode();
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cgf_rg == null) ? 0 : cgf_rg.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((classificacao == null) ? 0 : classificacao.hashCode());
		result = prime * result + ((codigo_cliente == null) ? 0 : codigo_cliente.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((cpf_cnpj == null) ? 0 : cpf_cnpj.hashCode());
		result = prime * result + ((data_aniversario == null) ? 0 : data_aniversario.hashCode());
		result = prime * result + ((data_emplacamento == null) ? 0 : data_emplacamento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emplacamento == null) ? 0 : emplacamento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + ((fone1 == null) ? 0 : fone1.hashCode());
		result = prime * result + ((fone2 == null) ? 0 : fone2.hashCode());
		result = prime * result + ((fone3 == null) ? 0 : fone3.hashCode());
		result = prime * result + ((inscricao_municipal == null) ? 0 : inscricao_municipal.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((potencia == null) ? 0 : potencia.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
		result = prime * result + ((vlVeiculo == null) ? 0 : vlVeiculo.hashCode());
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
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cgf_rg == null) {
			if (other.cgf_rg != null)
				return false;
		} else if (!cgf_rg.equals(other.cgf_rg))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (classificacao == null) {
			if (other.classificacao != null)
				return false;
		} else if (!classificacao.equals(other.classificacao))
			return false;
		if (codigo_cliente == null) {
			if (other.codigo_cliente != null)
				return false;
		} else if (!codigo_cliente.equals(other.codigo_cliente))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (cpf_cnpj == null) {
			if (other.cpf_cnpj != null)
				return false;
		} else if (!cpf_cnpj.equals(other.cpf_cnpj))
			return false;
		if (data_aniversario == null) {
			if (other.data_aniversario != null)
				return false;
		} else if (!data_aniversario.equals(other.data_aniversario))
			return false;
		if (data_emplacamento == null) {
			if (other.data_emplacamento != null)
				return false;
		} else if (!data_emplacamento.equals(other.data_emplacamento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emplacamento == null) {
			if (other.emplacamento != null)
				return false;
		} else if (!emplacamento.equals(other.emplacamento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estoque == null) {
			if (other.estoque != null)
				return false;
		} else if (!estoque.equals(other.estoque))
			return false;
		if (fone1 == null) {
			if (other.fone1 != null)
				return false;
		} else if (!fone1.equals(other.fone1))
			return false;
		if (fone2 == null) {
			if (other.fone2 != null)
				return false;
		} else if (!fone2.equals(other.fone2))
			return false;
		if (fone3 == null) {
			if (other.fone3 != null)
				return false;
		} else if (!fone3.equals(other.fone3))
			return false;
		if (inscricao_municipal == null) {
			if (other.inscricao_municipal != null)
				return false;
		} else if (!inscricao_municipal.equals(other.inscricao_municipal))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (potencia == null) {
			if (other.potencia != null)
				return false;
		} else if (!potencia.equals(other.potencia))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
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
		return "EmplacamentoAvulso [emplacamento=" + emplacamento + ", codigo_cliente=" + codigo_cliente + ", nome="
				+ nome + ", tipo=" + tipo + ", cpf_cnpj=" + cpf_cnpj + ", cgf_rg=" + cgf_rg + ", endereco=" + endereco
				+ ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", uf=" + uf + ", fone1=" + fone1 + ", fone2=" + fone2 + ", fone3=" + fone3
				+ ", data_aniversario=" + data_aniversario + ", email=" + email + ", inscricao_municipal="
				+ inscricao_municipal + ", veiculo=" + veiculo + ", vlVeiculo=" + vlVeiculo + ", estoque=" + estoque
				+ ", data_emplacamento=" + data_emplacamento + ", potencia=" + potencia + ", classificacao="
				+ classificacao + "]";
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getCgf_rg() {
		return cgf_rg;
	}

	public void setCgf_rg(String cgf_rg) {
		this.cgf_rg = cgf_rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public String getFone3() {
		return fone3;
	}

	public void setFone3(String fone3) {
		this.fone3 = fone3;
	}

	public String getData_aniversario() {
		return data_aniversario;
	}

	public void setData_aniversario(String data_aniversario) {
		this.data_aniversario = data_aniversario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInscricao_municipal() {
		return inscricao_municipal;
	}

	public void setInscricao_municipal(String inscricao_municipal) {
		this.inscricao_municipal = inscricao_municipal;
	} 
	
	
	
	
	
	
	

}
