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
		this.cod = cod;
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
