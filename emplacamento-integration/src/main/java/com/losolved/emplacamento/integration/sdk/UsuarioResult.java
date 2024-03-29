package com.losolved.emplacamento.integration.sdk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioResult {
	
	
	private String codigo_funcionario;
	private String nome;
	private String login_funcionario;
	
	private String senha;
	private String tipo;
	private String supervisor;
	public String getCodigo_funcionario() {
		return codigo_funcionario;
	}
	public void setCodigo_funcionario(String codigo_funcionario) {
		this.codigo_funcionario = codigo_funcionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin_funcionario() {
		return login_funcionario;
	}
	public void setLogin_funcionario(String login_funcionario) {
		this.login_funcionario = login_funcionario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	@Override
	public String toString() {
		return "UsuarioResult [codigo_funcionario:" + codigo_funcionario + ", nome:" + nome + ", login_funcionario:"
				+ login_funcionario + ", tipo:" + tipo + ", supervisor:" + supervisor + "]";
	}
	
	
	
	
	
	

}
