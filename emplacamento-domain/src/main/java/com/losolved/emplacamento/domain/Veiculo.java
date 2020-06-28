package com.losolved.emplacamento.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lo_veiculo")
@SequenceGenerator(name = "default_seq", sequenceName = "VEICULO_SEQ", initialValue = 1, allocationSize = 1)
public class Veiculo extends BaseEntity<Integer> {
	

	

}
