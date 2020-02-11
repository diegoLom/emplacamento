package com.losolved.emplacamento.web.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(value = "com.losolved.emplacamento.domain")
@EnableJpaRepositories({ "com.losolved.emplacamento.integration" })
@ComponentScan({ "com.losolved.emplacamento.services", "com.losolved.emplacamento.web" })

public class AppConfig {
	
	
	


}
