package com.losolved.emplacamento.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.losolved.emplacamento.web.configuration.AppConfig;

@SpringBootApplication(scanBasePackages = "com.losolved.emplacamento.*")
@Import(AppConfig.class)
public class LoSolvedEmplacamentoApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(LoSolvedEmplacamentoApplication.class, args)	;
	}

}
