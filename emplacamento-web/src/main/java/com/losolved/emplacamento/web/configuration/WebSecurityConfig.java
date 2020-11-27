package com.losolved.emplacamento.web.configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.inject.Qualifier;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private DataSource dataSource;
	


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.cors().configurationSource(new CorsConfigurationSource() {

    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        return config;
    }
}).and().csrf().disable().authorizeRequests()
		
			.antMatchers(new String[]{"/home","/auth/token","/auth/reset","/auth/check"}).
		permitAll().antMatchers(HttpMethod.OPTIONS).permitAll()
		.antMatchers(HttpMethod.POST, "/login").
			permitAll().anyRequest().authenticated().and()
		
		
		
		// filtra requisições de login
		.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)
		
//		// filtra outras requisições para verificar a presença do JWT no header
		.addFilterBefore(new JWTAuthenticationFilter(),
		   UsernamePasswordAuthenticationFilter.class);
	}

	
	

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	} 
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("select username,password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, authority from authorities where username=?");
			;
		
	}	
   	

    
}
