package com.losolved.emplacamento.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "taxa")
@SequenceGenerator(name = "TX_SEQ", sequenceName = "TAXA_SEQ", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class Taxa  extends BaseEntity<Integer>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TX_SEQ")
	private Integer id; 

	
	
	@Column
	private String descr;

	@Column
	private String per_taxa;
	
	@Column
	private String tp_veic;
	
	
	@Column
	private String tp_valor;
	
	@Column
	private BigDecimal vl_custo;
	
	@Column
	private BigDecimal vl_final;
	
	@Column
	private BigDecimal vl_iof;
	
	@Column
	private BigDecimal vl_bilhete;
	
	@ManyToOne
	@JoinColumn(name = "parametroid", nullable=false)
	@JsonBackReference
	private Parametro parametro;
	
	
	@ManyToMany
	 @JoinTable (name = "emplacamento_taxa",
	      joinColumns=@JoinColumn(name="taxa_id"),
	         inverseJoinColumns=@JoinColumn(name="emplacamento_id"))
	 private Set<Emplacamento> emplacamentos;
	 
	 
	 
	
	 

	public Set<Emplacamento> getEmplacamentos() {
		return emplacamentos;
	}


	public void setEmplacamentos(Set<Emplacamento> emplacamentos) {
		this.emplacamentos = emplacamentos;
	}


	public String getPer_taxa() {
		return per_taxa;
	}


	public void setPer_taxa(String per_taxa) {
		this.per_taxa = per_taxa;
	}


	public String getTp_veic() {
		return tp_veic;
	}


	public void setTp_veic(String tp_veic) {
		this.tp_veic = tp_veic;
	}


	public String getTp_valor() {
		return tp_valor;
	}


	public void setTp_valor(String tp_valor) {
		this.tp_valor = tp_valor;
	}


	public BigDecimal getVl_custo() {
		return vl_custo;
	}


	public void setVl_custo(BigDecimal vl_custo) {
		this.vl_custo = vl_custo;
	}


	public BigDecimal getVl_final() {
		return vl_final;
	}


	public void setVl_final(BigDecimal vl_final) {
		this.vl_final = vl_final;
	}


	public BigDecimal getVl_iof() {
		return vl_iof;
	}


	public void setVl_iof(BigDecimal vl_iof) {
		this.vl_iof = vl_iof;
	}


	public BigDecimal getVl_bilhete() {
		return vl_bilhete;
	}


	public void setVl_bilhete(BigDecimal vl_bilhete) {
		this.vl_bilhete = vl_bilhete;
	}


	public Parametro getParametro() {
		return parametro;
	}


	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((emplacamentos == null) ? 0 : emplacamentos.hashCode());
		result = prime * result + ((parametro == null) ? 0 : parametro.hashCode());
		result = prime * result + ((per_taxa == null) ? 0 : per_taxa.hashCode());
		result = prime * result + ((tp_valor == null) ? 0 : tp_valor.hashCode());
		result = prime * result + ((tp_veic == null) ? 0 : tp_veic.hashCode());
		result = prime * result + ((vl_bilhete == null) ? 0 : vl_bilhete.hashCode());
		result = prime * result + ((vl_custo == null) ? 0 : vl_custo.hashCode());
		result = prime * result + ((vl_final == null) ? 0 : vl_final.hashCode());
		result = prime * result + ((vl_iof == null) ? 0 : vl_iof.hashCode());
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
		Taxa other = (Taxa) obj;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (emplacamentos == null) {
			if (other.emplacamentos != null)
				return false;
		} else if (!emplacamentos.equals(other.emplacamentos))
			return false;
		if (parametro == null) {
			if (other.parametro != null)
				return false;
		} else if (!parametro.equals(other.parametro))
			return false;
		if (per_taxa == null) {
			if (other.per_taxa != null)
				return false;
		} else if (!per_taxa.equals(other.per_taxa))
			return false;
		if (tp_valor == null) {
			if (other.tp_valor != null)
				return false;
		} else if (!tp_valor.equals(other.tp_valor))
			return false;
		if (tp_veic == null) {
			if (other.tp_veic != null)
				return false;
		} else if (!tp_veic.equals(other.tp_veic))
			return false;
		if (vl_bilhete == null) {
			if (other.vl_bilhete != null)
				return false;
		} else if (!vl_bilhete.equals(other.vl_bilhete))
			return false;
		if (vl_custo == null) {
			if (other.vl_custo != null)
				return false;
		} else if (!vl_custo.equals(other.vl_custo))
			return false;
		if (vl_final == null) {
			if (other.vl_final != null)
				return false;
		} else if (!vl_final.equals(other.vl_final))
			return false;
		if (vl_iof == null) {
			if (other.vl_iof != null)
				return false;
		} else if (!vl_iof.equals(other.vl_iof))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Taxa [descr=" + descr + ", per_taxa=" + per_taxa + ", tp_veic=" + tp_veic + ", tp_valor=" + tp_valor
				+ ", vl_custo=" + vl_custo + ", vl_final=" + vl_final + ", vl_iof=" + vl_iof + ", vl_bilhete="
				+ vl_bilhete + ", parametro=" + parametro + ", emplacamentos=" + emplacamentos + "]";
	}




	
	
	
	


	
	
    
	

}
