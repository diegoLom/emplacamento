package com.losolved.emplacamento.web.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@Profile("prod")
public class DatabaseConfigurationP {
	
	
	
	 @Value("${datasource.prod.url}")
	  private String dbUrl;
	 
	 

	  @Bean
	  public DataSource dataSource() {
		  
	      HikariConfig config = new HikariConfig();
	      
	      config.setJdbcUrl(dbUrl);
	      
	      return new HikariDataSource(config);
	  }

}
