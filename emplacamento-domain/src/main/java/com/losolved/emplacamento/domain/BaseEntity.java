package com.losolved.emplacamento.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public class BaseEntity<T> implements Serializable {
	
	
	@Id
	private T id; 
	
	public T getId() {
		return id; 
	}
	public void setId(T o) {
		this.id = o;
	}
	
	
	

}
