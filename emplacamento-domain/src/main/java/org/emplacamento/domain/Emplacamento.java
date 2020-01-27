package org.emplacamento.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Emplacamento implements BaseEntity<Long> {
	
	@Column
	private String cod;

	public String getCod() {
		return cod;
	}

	public void setNumPedido(String ve_nr) {
		this.numPedido = numPedido;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long o) {
		// TODO Auto-generated method stub

	}
	
	
	
		cod
		ve_nr
		uf_cd
		municipio_nm
		nf_nota
		emp_cd
		tpVec
		vl_receb
		forma_pagto
		dt_cad


}
