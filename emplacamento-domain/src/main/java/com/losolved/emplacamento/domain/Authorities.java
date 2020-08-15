package com.losolved.emplacamento.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "authorities")
@SequenceGenerator(name = "default_seq", sequenceName = "AUTHORITIES_SEQ", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id",  scope = Authorities.class)
public class Authorities extends BaseEntity<Integer> {
	
	
	
	private String username;
	
	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authorities other = (Authorities) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Authorities [username=" + username + ", authority=" + authority + "]";
	}
	
	

	


	
	

}
