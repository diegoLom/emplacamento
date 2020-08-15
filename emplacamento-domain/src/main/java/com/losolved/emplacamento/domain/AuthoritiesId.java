package com.losolved.emplacamento.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AuthoritiesId implements Serializable {
	
	 public String username;
	 public String authority;

}
