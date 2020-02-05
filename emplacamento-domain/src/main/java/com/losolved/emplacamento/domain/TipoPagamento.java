package com.losolved.emplacamento.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamento extends BaseEntity<Byte> {
	
	
	@Column(unique = true, nullable = false)
	private String nome;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
	
	
	

}
