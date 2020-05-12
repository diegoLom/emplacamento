package com.losolved.emplacamento.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "comissao")
@SequenceGenerator(name = "COM_SEQ", sequenceName = "COMISSAO_SEQ", initialValue = 1, allocationSize = 1)
public class Comissao extends BaseEntity<Integer> {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COM_SEQ")
	private Integer id; 

	
	@Column
    private Integer comissao_cd;
	
	@Column
    private String emp_cd;
    
	@Column
    private String uf_cd;
	
	@Column
    private String municipio_cd;
    
	@Column
    private String comissao_periodo_vu;
	
	@Column
    private String comissao_tipo_vu;
	
	@Column
    private BigDecimal comissao_valor_vu;
	
	@Column
    private BigDecimal comissao_custo_vu;
    
	@Column
    private String comissao_periodo;
	
	@Column
    private String comissao_tipo;
	
	@Column
    private BigDecimal comissao_valor_vn;
	
	@Column
    private BigDecimal comissao_custo_vn;
    
	@Column
    private String comissao_periodo_vd;
	
	@Column
    private String comissao_tipo_vd;
	
	@Column
	private BigDecimal comissao_valor_vd;
	
	@Column
    private BigDecimal comissao_custo_vd;
    
	@Column
    private String comissao_abateCusto;
    

	@Column
    private String comissao_inclui_programacao;
    
	@Column
    private String comissao_calcAutomatico;

	public Integer getComissao_cd() {
		return comissao_cd;
	}

	public void setComissao_cd(Integer comissao_cd) {
		this.comissao_cd = comissao_cd;
	}

	public String getEmp_cd() {
		return emp_cd;
	}

	public void setEmp_cd(String emp_cd) {
		this.emp_cd = emp_cd;
	}

	public String getUf_cd() {
		return uf_cd;
	}

	public void setUf_cd(String uf_cd) {
		this.uf_cd = uf_cd;
	}

	public String getMunicipio_cd() {
		return municipio_cd;
	}

	public void setMunicipio_cd(String municipio_cd) {
		this.municipio_cd = municipio_cd;
	}

	public String getComissao_periodo_vu() {
		return comissao_periodo_vu;
	}

	public void setComissao_periodo_vu(String comissao_periodo_vu) {
		this.comissao_periodo_vu = comissao_periodo_vu;
	}

	public String getComissao_tipo_vu() {
		return comissao_tipo_vu;
	}

	public void setComissao_tipo_vu(String comissao_tipo_vu) {
		this.comissao_tipo_vu = comissao_tipo_vu;
	}

	public BigDecimal getComissao_valor_vu() {
		return comissao_valor_vu;
	}

	public void setComissao_valor_vu(BigDecimal comissao_valor_vu) {
		this.comissao_valor_vu = comissao_valor_vu;
	}

	public BigDecimal getComissao_custo_vu() {
		return comissao_custo_vu;
	}

	public void setComissao_custo_vu(BigDecimal comissao_custo_vu) {
		this.comissao_custo_vu = comissao_custo_vu;
	}

	public String getComissao_periodo() {
		return comissao_periodo;
	}

	public void setComissao_periodo(String comissao_periodo) {
		this.comissao_periodo = comissao_periodo;
	}

	public String getComissao_tipo() {
		return comissao_tipo;
	}

	public void setComissao_tipo(String comissao_tipo) {
		this.comissao_tipo = comissao_tipo;
	}

	public BigDecimal getComissao_valor_vn() {
		return comissao_valor_vn;
	}

	public void setComissao_valor_vn(BigDecimal comissao_valor_vn) {
		this.comissao_valor_vn = comissao_valor_vn;
	}

	public BigDecimal getComissao_custo_vn() {
		return comissao_custo_vn;
	}

	public void setComissao_custo_vn(BigDecimal comissao_custo_vn) {
		this.comissao_custo_vn = comissao_custo_vn;
	}

	public String getComissao_periodo_vd() {
		return comissao_periodo_vd;
	}

	public void setComissao_periodo_vd(String comissao_periodo_vd) {
		this.comissao_periodo_vd = comissao_periodo_vd;
	}

	public String getComissao_tipo_vd() {
		return comissao_tipo_vd;
	}

	public void setComissao_tipo_vd(String comissao_tipo_vd) {
		this.comissao_tipo_vd = comissao_tipo_vd;
	}

	public BigDecimal getComissao_valor_vd() {
		return comissao_valor_vd;
	}

	public void setComissao_valor_vd(BigDecimal comissao_valor_vd) {
		this.comissao_valor_vd = comissao_valor_vd;
	}

	public BigDecimal getComissao_custo_vd() {
		return comissao_custo_vd;
	}

	public void setComissao_custo_vd(BigDecimal comissao_custo_vd) {
		this.comissao_custo_vd = comissao_custo_vd;
	}

	public String getComissao_abateCusto() {
		return comissao_abateCusto;
	}

	public void setComissao_abateCusto(String comissao_abateCusto) {
		this.comissao_abateCusto = comissao_abateCusto;
	}

	public String getComissao_inclui_programacao() {
		return comissao_inclui_programacao;
	}

	public void setComissao_inclui_programacao(String comissao_inclui_programacao) {
		this.comissao_inclui_programacao = comissao_inclui_programacao;
	}

	public String getComissao_calcAutomatico() {
		return comissao_calcAutomatico;
	}

	public void setComissao_calcAutomatico(String comissao_calcAutomatico) {
		this.comissao_calcAutomatico = comissao_calcAutomatico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comissao_abateCusto == null) ? 0 : comissao_abateCusto.hashCode());
		result = prime * result + ((comissao_calcAutomatico == null) ? 0 : comissao_calcAutomatico.hashCode());
		result = prime * result + ((comissao_cd == null) ? 0 : comissao_cd.hashCode());
		result = prime * result + ((comissao_custo_vd == null) ? 0 : comissao_custo_vd.hashCode());
		result = prime * result + ((comissao_custo_vn == null) ? 0 : comissao_custo_vn.hashCode());
		result = prime * result + ((comissao_custo_vu == null) ? 0 : comissao_custo_vu.hashCode());
		result = prime * result + ((comissao_inclui_programacao == null) ? 0 : comissao_inclui_programacao.hashCode());
		result = prime * result + ((comissao_periodo == null) ? 0 : comissao_periodo.hashCode());
		result = prime * result + ((comissao_periodo_vd == null) ? 0 : comissao_periodo_vd.hashCode());
		result = prime * result + ((comissao_periodo_vu == null) ? 0 : comissao_periodo_vu.hashCode());
		result = prime * result + ((comissao_tipo == null) ? 0 : comissao_tipo.hashCode());
		result = prime * result + ((comissao_tipo_vd == null) ? 0 : comissao_tipo_vd.hashCode());
		result = prime * result + ((comissao_tipo_vu == null) ? 0 : comissao_tipo_vu.hashCode());
		result = prime * result + ((comissao_valor_vd == null) ? 0 : comissao_valor_vd.hashCode());
		result = prime * result + ((comissao_valor_vn == null) ? 0 : comissao_valor_vn.hashCode());
		result = prime * result + ((comissao_valor_vu == null) ? 0 : comissao_valor_vu.hashCode());
		result = prime * result + ((emp_cd == null) ? 0 : emp_cd.hashCode());
		result = prime * result + ((municipio_cd == null) ? 0 : municipio_cd.hashCode());
		result = prime * result + ((uf_cd == null) ? 0 : uf_cd.hashCode());
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
		Comissao other = (Comissao) obj;
		if (comissao_abateCusto == null) {
			if (other.comissao_abateCusto != null)
				return false;
		} else if (!comissao_abateCusto.equals(other.comissao_abateCusto))
			return false;
		if (comissao_calcAutomatico == null) {
			if (other.comissao_calcAutomatico != null)
				return false;
		} else if (!comissao_calcAutomatico.equals(other.comissao_calcAutomatico))
			return false;
		if (comissao_cd == null) {
			if (other.comissao_cd != null)
				return false;
		} else if (!comissao_cd.equals(other.comissao_cd))
			return false;
		if (comissao_custo_vd == null) {
			if (other.comissao_custo_vd != null)
				return false;
		} else if (!comissao_custo_vd.equals(other.comissao_custo_vd))
			return false;
		if (comissao_custo_vn == null) {
			if (other.comissao_custo_vn != null)
				return false;
		} else if (!comissao_custo_vn.equals(other.comissao_custo_vn))
			return false;
		if (comissao_custo_vu == null) {
			if (other.comissao_custo_vu != null)
				return false;
		} else if (!comissao_custo_vu.equals(other.comissao_custo_vu))
			return false;
		if (comissao_inclui_programacao == null) {
			if (other.comissao_inclui_programacao != null)
				return false;
		} else if (!comissao_inclui_programacao.equals(other.comissao_inclui_programacao))
			return false;
		if (comissao_periodo == null) {
			if (other.comissao_periodo != null)
				return false;
		} else if (!comissao_periodo.equals(other.comissao_periodo))
			return false;
		if (comissao_periodo_vd == null) {
			if (other.comissao_periodo_vd != null)
				return false;
		} else if (!comissao_periodo_vd.equals(other.comissao_periodo_vd))
			return false;
		if (comissao_periodo_vu == null) {
			if (other.comissao_periodo_vu != null)
				return false;
		} else if (!comissao_periodo_vu.equals(other.comissao_periodo_vu))
			return false;
		if (comissao_tipo == null) {
			if (other.comissao_tipo != null)
				return false;
		} else if (!comissao_tipo.equals(other.comissao_tipo))
			return false;
		if (comissao_tipo_vd == null) {
			if (other.comissao_tipo_vd != null)
				return false;
		} else if (!comissao_tipo_vd.equals(other.comissao_tipo_vd))
			return false;
		if (comissao_tipo_vu == null) {
			if (other.comissao_tipo_vu != null)
				return false;
		} else if (!comissao_tipo_vu.equals(other.comissao_tipo_vu))
			return false;
		if (comissao_valor_vd == null) {
			if (other.comissao_valor_vd != null)
				return false;
		} else if (!comissao_valor_vd.equals(other.comissao_valor_vd))
			return false;
		if (comissao_valor_vn == null) {
			if (other.comissao_valor_vn != null)
				return false;
		} else if (!comissao_valor_vn.equals(other.comissao_valor_vn))
			return false;
		if (comissao_valor_vu == null) {
			if (other.comissao_valor_vu != null)
				return false;
		} else if (!comissao_valor_vu.equals(other.comissao_valor_vu))
			return false;
		if (emp_cd == null) {
			if (other.emp_cd != null)
				return false;
		} else if (!emp_cd.equals(other.emp_cd))
			return false;
		if (municipio_cd == null) {
			if (other.municipio_cd != null)
				return false;
		} else if (!municipio_cd.equals(other.municipio_cd))
			return false;
		if (uf_cd == null) {
			if (other.uf_cd != null)
				return false;
		} else if (!uf_cd.equals(other.uf_cd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comissao [comissao_cd=" + comissao_cd + ", emp_cd=" + emp_cd + ", uf_cd=" + uf_cd + ", municipio_cd="
				+ municipio_cd + ", comissao_periodo_vu=" + comissao_periodo_vu + ", comissao_tipo_vu="
				+ comissao_tipo_vu + ", comissao_valor_vu=" + comissao_valor_vu + ", comissao_custo_vu="
				+ comissao_custo_vu + ", comissao_periodo=" + comissao_periodo + ", comissao_tipo=" + comissao_tipo
				+ ", comissao_valor_vn=" + comissao_valor_vn + ", comissao_custo_vn=" + comissao_custo_vn
				+ ", comissao_periodo_vd=" + comissao_periodo_vd + ", comissao_tipo_vd=" + comissao_tipo_vd
				+ ", comissao_valor_vd=" + comissao_valor_vd + ", comissao_custo_vd=" + comissao_custo_vd
				+ ", comissao_abateCusto=" + comissao_abateCusto + ", comissao_inclui_programacao="
				+ comissao_inclui_programacao + ", comissao_calcAutomatico=" + comissao_calcAutomatico + "]";
	}
	
	
	
	
	
    
    
   
   
    
}
