package com.losolved.emplacamento.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emplacamento_avulso")
public class EmplacamentoAvulso extends BaseEntity<Integer>{
	
	
	@OneToOne @MapsId
	private Emplacamento emplacamento;

	public Emplacamento getEmplacamento() {
		return emplacamento;
	}

	public void setEmplacamento(Emplacamento emplacamento) {
		this.emplacamento = emplacamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emplacamento == null) ? 0 : emplacamento.hashCode());
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
		EmplacamentoAvulso other = (EmplacamentoAvulso) obj;
		if (emplacamento == null) {
			if (other.emplacamento != null)
				return false;
		} else if (!emplacamento.equals(other.emplacamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmplacamentoAvulso [emplacamento=" + emplacamento + "]";
	} 
	
	
	
	
	
	
	

}
