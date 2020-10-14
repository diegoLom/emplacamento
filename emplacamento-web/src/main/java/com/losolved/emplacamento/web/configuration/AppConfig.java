package com.losolved.emplacamento.web.configuration;

import java.util.Properties;
import java.util.TimeZone;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EntityScan(value = "com.losolved.emplacamento.domain")
@EnableJpaRepositories({ "com.losolved.emplacamento.integration" })
@ComponentScan({ "com.losolved.emplacamento.services", "com.losolved.emplacamento.web" })

public class AppConfig {
	
	 @Primary
	    @Bean
	    public ObjectMapper objectMapper() {
	        // serializar via field ao inves de getters/setters (JSON)
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
	        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	           mapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
	        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	        
	     
//	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//	        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
//	        mapper.setTimeZone(TimeZone.getTimeZone(""));
	      //  mapper.registerModule(new Jackson2HalModule());
	        return mapper;
	    }

	 @Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder) {
			return builder.build();
		}
	 
	 
	 @Bean
	 public JavaMailSender getJavaMailSender() {
	     JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	   
	     mailSender.setUsername("losolvedcorp@yahoo.com");
	     mailSender.setPassword("rjytwuogojhbfbpz");
	     
	     Properties props = mailSender.getJavaMailProperties();
	     props.put("mail.transport.protocol", "smtp");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.smtp.starttls.enable", "true");
	     props.put("mail.debug", "true");
	     
	     
         props.put("mail.smtp.host", "smtp.mail.yahoo.com");
         props.put("mail.smtp.socketFactory.port", "465");
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.port", "25");

	     
	     return mailSender;
	 }


}
