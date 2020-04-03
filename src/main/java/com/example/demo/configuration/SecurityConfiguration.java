package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("akil").password(passwordEncoder().encode("welcome")).roles("ADMIN").and().withUser("john").password(passwordEncoder().encode("welcome")).roles("USER");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//TODO Auto-generated method stub
//http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	//http.authorizeRequests().antMatchers("/index1").hasRole("ADMIN").antMatchers("/index2").hasAnyRole("ADMIN","USER").and().httpBasic();
		http.authorizeRequests()
		.antMatchers("/index1").access("hasRole('ADMIN')")
		.antMatchers("/index2").access("hasRole('ADMIN') or hasRole('USER')")
		.and().httpBasic();
	
	
	}
	
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
		
	}

}
