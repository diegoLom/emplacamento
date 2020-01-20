package org.emplacamento.domain;

import java.io.Serializable;

public interface BaseEntity<T> extends Serializable {
	
	
	public T getId();
	public void setId(T o);

}
