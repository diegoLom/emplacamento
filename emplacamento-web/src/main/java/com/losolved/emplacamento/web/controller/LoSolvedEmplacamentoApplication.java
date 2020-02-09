package com.losolved.emplacamento.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(value = "com.losolved.emplacamento.domain")
@ComponentScan({ "com.losolved.emplacamento" })
public class LoSolvedEmplacamentoApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(LoSolvedEmplacamentoApplication.class, args)	;
	}

}
