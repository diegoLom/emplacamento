package com.losolved.emplacamento.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "parametro")
@JsonIgnoreProperties(ignoreUnknown = true)
@SequenceGenerator(name = "default_seq", sequenceName = "PARAMETRO_SEQ", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class Parametro extends BaseEntity<Integer> {
	
	@Column
	private String emp_cd;
	
	@Column
	private String emp_ds;
	
	
	@ManyToOne
	@JoinColumn(name ="ufid")
	private Uf uf;
	
	@Column
	@Temporal(value = TemporalType.DATE)
	private java.util.Date data_per;
	
	
	
	@Transient
	private String ufnome;
	
	public String getUfnome() {
		return ufnome;
	}

	public void setUfnome(String ufnome) {
			this.ufnome = ufnome;
	}

	@Transient
	private Set<Taxa> taxas = new HashSet<Taxa>();

	

	public String getEmp_cd() {
		return emp_cd;
	}

	public void setEmp_cd(String emp_cd) {
		this.emp_cd = emp_cd;
	}


	public java.util.Date getData_per() {
		return data_per;
	}

	public void setData_per(java.util.Date data_per) {
		this.data_per = data_per;
	}

	public Set<Taxa> getTaxas() {
		return taxas;
	}

	public void setTaxas(Set<Taxa> taxas) {
		this.taxas = taxas;
	}

	public String getEmp_ds() {
		return emp_ds;
	}

	public void setEmp_ds(String emp_ds) {
		this.emp_ds = emp_ds;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		
		if(uf != null )
			ufnome = uf.getNome();
		
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data_per == null) ? 0 : data_per.hashCode());
		result = prime * result + ((emp_cd == null) ? 0 : emp_cd.hashCode());
		result = prime * result + ((emp_ds == null) ? 0 : emp_ds.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime * result + ((ufnome == null) ? 0 : ufnome.hashCode());
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
		Parametro other = (Parametro) obj;
		if (data_per == null) {
			if (other.data_per != null)
				return false;
		} else if (!data_per.equals(other.data_per))
			return false;
		if (emp_cd == null) {
			if (other.emp_cd != null)
				return false;
		} else if (!emp_cd.equals(other.emp_cd))
			return false;
		if (emp_ds == null) {
			if (other.emp_ds != null)
				return false;
		} else if (!emp_ds.equals(other.emp_ds))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		if (ufnome == null) {
			if (other.ufnome != null)
				return false;
		} else if (!ufnome.equals(other.ufnome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Parametro [emp_cd=" + emp_cd + ", emp_ds=" + emp_ds + ", uf=" + uf + ", data_per=" + data_per
				+ ", ufnome=" + ufnome + "]";
	}

	

	
	
	

}
