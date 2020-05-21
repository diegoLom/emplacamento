package com.losolved.emplacamento.domain;

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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "parametro")
@SequenceGenerator(name = "default_seq", sequenceName = "PARAMETRO_SEQ", initialValue = 1, allocationSize = 1)
public class Parametro extends BaseEntity<Integer> {
	

	
	
	@Column
	private String emp_cd;
	
	@ManyToOne
	@JoinColumn(name ="municipioId")
	private Municipio municipio;
	
	@Column
	@Temporal(value = TemporalType.DATE)
	private java.util.Date data_per;
	
	
	
	@Transient
//	@OneToMany(targetEntity = com.losolved.emplacamento.domain.Taxa.class, mappedBy = "parametro", fetch = FetchType.LAZY)
//	@Fetch(value=FetchMode.SELECT)
	private Set<Taxa> taxas;

	

	public String getEmp_cd() {
		return emp_cd;
	}

	public void setEmp_cd(String emp_cd) {
		this.emp_cd = emp_cd;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_per == null) ? 0 : data_per.hashCode());
		result = prime * result + ((emp_cd == null) ? 0 : emp_cd.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		//result = prime * result + ((taxas == null) ? 0 : taxas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
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
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (taxas == null) {
			if (other.taxas != null)
				return false;
		} else if (!taxas.equals(other.taxas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Parametro [emp_cd=" + emp_cd + ", municipio=" + municipio + ", data_per=" + data_per + ", taxas="
				+ taxas + "]";
	}

	
	
	

}
