package com.losolved.emplacamento.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "municipio")
public class Municipio extends BaseEntity<Integer> {

	
	@Column
	private String nome;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(updatable = false)
	private Uf uf;
}
