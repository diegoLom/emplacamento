package com.losolved.emplacamento.web.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@Profile("dev")
public class DatabaseConfiguration {
	
	
	
	 @Value("${datasource.dev.url}")
	  private String dbUrl;
	 
	 
	 @Value("${datasource.dev.username}")
	  private String dbUsername;
	 
	 
	 @Value("${datasource.dev.password}")
	  private String dbPassword;

	  @Bean
	  public DataSource dataSource() {
		  
	      HikariConfig config = new HikariConfig();
	      
	      config.setJdbcUrl(dbUrl);
	      config.setUsername(dbUsername);
	      config.setPassword(dbPassword);
	 
	      return new HikariDataSource(config);
	  }

}
