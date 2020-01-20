package org.emplacamento.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Emplacamento implements BaseEntity<Long> {
	
	@Column
	private String numPedido;

	public String getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(String numPedido) {
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

}
