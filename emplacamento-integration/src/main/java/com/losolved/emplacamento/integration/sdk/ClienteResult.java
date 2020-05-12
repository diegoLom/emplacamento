package com.losolved.emplacamento.integration.sdk;

import java.sql.ResultSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteResult extends BaseResult {

	private String codigo_cliente;
	private String nome;
	private String tipo;
	private String cpf_cnpj;
	private String cgf_rg;
	private String endereco;
	private String numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	private String fone1;
	private String fone2;
	private String fone3;
	private String data_aniversario;
	private String email;
	private String inscricao_municipal;
	

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
	
	public ClienteResult(ResultSet result) {
		populate(result);
	}
	@Override
	public String toString() {
		return "ClienteResult [codigo_cliente=" + codigo_cliente + ", nome=" + nome + ", tipo=" + tipo + ", cpf_cnpj="
				+ cpf_cnpj + ", cgf_rg=" + cgf_rg + ", endereco=" + endereco + ", numero=" + numero + ", complemento="
				+ complemento + ", cep=" + cep + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", fone1="
				+ fone1 + ", fone2=" + fone2 + ", fone3=" + fone3 + ", data_aniversario=" + data_aniversario
				+ ", email=" + email + ", inscricao_municipal=" + inscricao_municipal + "]";
	}
	
	


}
