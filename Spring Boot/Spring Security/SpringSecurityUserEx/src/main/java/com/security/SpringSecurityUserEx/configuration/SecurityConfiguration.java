package com.security.SpringSecurityUserEx.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	

	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception{

		return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
				request -> request.requestMatchers("/public", "/register").permitAll().anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).build();

	}

	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
}
