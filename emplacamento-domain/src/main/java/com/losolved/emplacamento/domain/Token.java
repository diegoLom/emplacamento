package com.losolved.emplacamento.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "token")
@SequenceGenerator(name = "default_seq", sequenceName = "TOKEN_SEQ", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "token", scope = Token.class)
public class Token {
	
	@Id
	private String token; 
	
	private String userName; 
	
	
	@Column
	@Temporal(value = TemporalType.TIMESTAMP)
	private java.util.Date dtExpiracao;


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public java.util.Date getDtExpiracao() {
		return dtExpiracao;
	}


	public void setDtExpiracao(java.util.Date dtExpiracao) {
		this.dtExpiracao = dtExpiracao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtExpiracao == null) ? 0 : dtExpiracao.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Token other = (Token) obj;
		if (dtExpiracao == null) {
			if (other.dtExpiracao != null)
				return false;
		} else if (!dtExpiracao.equals(other.dtExpiracao))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Token [token=" + token + ", userName=" + userName + ", dtExpiracao=" + dtExpiracao + "]";
	}
	
	
	
	

}
