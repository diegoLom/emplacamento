package com.losolved.emplacamento.web.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EntityScan(value = "com.losolved.emplacamento.domain")
@EnableJpaRepositories({ "com.losolved.emplacamento.integration" })
@ComponentScan({ "com.losolved.emplacamento.services", "com.losolved.emplacamento.web" })

public class AppConfig {
	
	@Value("${spring.datasource.url}")
	private String dbUrl; 
	
	
	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig(); 
		config.setJdbcUrl(dbUrl);
		
		return new HikariDataSource(config);
	}


}
