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
	
	
	 @Value("${datasource.prod.username}")
	  private String dbUsername;
	
	 @Value("${datasource.prod.password}")
	  private String dbPassword;
	
	
	 @Value("${datasource.prod.url}")
	  private String dbUrl;
	 
	 
	  @Bean
	  public DataSource dataSource() {
		  
	      HikariConfig config = new HikariConfig();
	      
	      config.setJdbcUrl(dbUrl);
	      config.setUsername(dbUsername);
	      config.setPassword(dbPassword);
	      
	      return new HikariDataSource(config);
	  }

}
