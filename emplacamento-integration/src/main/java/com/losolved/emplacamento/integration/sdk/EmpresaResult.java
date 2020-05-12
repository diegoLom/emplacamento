package com.losolved.emplacamento.integration.sdk;

import java.sql.ResultSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpresaResult extends BaseResult {
	
	
	private String emp_cd; 
	
	private String emp_ds; 
	
	private String emp_banco;
	
		public String getEmp_cd() {
		return emp_cd;
	}

	public void setEmp_cd(String emp_cd) {
		this.emp_cd = emp_cd;
	}

	public String getEmp_ds() {
		return emp_ds;
	}
		
	public void setEmp_ds(String emp_ds) {
		this.emp_ds = emp_ds;
	}

	public String getEmp_banco() {
		return emp_banco;
	}

	public void setEmp_banco(String emp_banco) {
		this.emp_banco = emp_banco;
	}

	public EmpresaResult (ResultSet res) {
		populate(res);
	}

	@Override
	public String toString() {
		return "EmpresaResult [emp_cd=" + emp_cd + ", emp_ds=" + emp_ds + ", emp_banco=" + emp_banco + "]";
	}
	



	
}
