package com.losolved.emplacamento.domain;

import java.math.BigDecimal;
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
@Table(name = "taxa_vec")
@JsonIgnoreProperties(ignoreUnknown = true)
@SequenceGenerator(name = "default_seq", sequenceName = "TAXAVEC_SEQ", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id" ,  scope = TaxaVec.class)
public class TaxaVec extends BaseEntity<Integer> {
	
	@Column
	private String tp_vec;
	
	@Column
	private BigDecimal vl_final;
	
	@Column(name = "obrigatorio", columnDefinition="BIT")
	private Boolean obrigatorio;
	
	@Column
	private String tp_valor;
	
	@ManyToOne
	@JoinColumn(name = "taxaid", nullable = false)
	private Taxa taxa;

	public BigDecimal getVl_final() {
		return vl_final;
	}

	public void setVl_final(BigDecimal vl_final) {
		this.vl_final = vl_final;
	}



	public String getTp_valor() {
		return tp_valor;
	}

	public void setTp_valor(String tp_valor) {
		this.tp_valor = tp_valor;
	}

	public Taxa getTaxa() {
		return taxa;
	}

	public void setTaxa(Taxa taxa) {
		this.taxa = taxa;
	}
	
	
	
	

	public String getTp_vec() {
		return tp_vec;
	}

	public void setTp_vec(String tp_vec) {
		this.tp_vec = tp_vec;
	}

	public Boolean getObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(Boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((obrigatorio == null) ? 0 : obrigatorio.hashCode());
		result = prime * result + ((taxa == null) ? 0 : taxa.hashCode());
		result = prime * result + ((tp_valor == null) ? 0 : tp_valor.hashCode());
		result = prime * result + ((tp_vec == null) ? 0 : tp_vec.hashCode());
		result = prime * result + ((vl_final == null) ? 0 : vl_final.hashCode());
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
		TaxaVec other = (TaxaVec) obj;
		if (obrigatorio == null) {
			if (other.obrigatorio != null)
				return false;
		} else if (!obrigatorio.equals(other.obrigatorio))
			return false;
		if (taxa == null) {
			if (other.taxa != null)
				return false;
		} else if (!taxa.equals(other.taxa))
			return false;
		if (tp_valor == null) {
			if (other.tp_valor != null)
				return false;
		} else if (!tp_valor.equals(other.tp_valor))
			return false;
		if (tp_vec == null) {
			if (other.tp_vec != null)
				return false;
		} else if (!tp_vec.equals(other.tp_vec))
			return false;
		if (vl_final == null) {
			if (other.vl_final != null)
				return false;
		} else if (!vl_final.equals(other.vl_final))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaxaVec [tp_vec=" + tp_vec + ", vl_final=" + vl_final + ", obrigatorio=" + obrigatorio + ", tp_valor="
				+ tp_valor + ", taxa=" + taxa + "]";
	}



	
	
	
	
	
	

}
