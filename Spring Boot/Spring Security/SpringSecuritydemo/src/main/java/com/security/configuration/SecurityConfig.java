package com.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception{
		return http
		.csrf(customizer ->customizer.disable())
		.authorizeHttpRequests(request->request.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.build();
				
	}
	
	@Bean
	public UserDetailsService userservicedetail() {
		UserDetails user1 =User.withUsername("teja")
				.password("teja6666")
				.roles("USER")
				.build();
		UserDetails user2 =User.withDefaultPasswordEncoder()
				.username("tejaswini")
				.password("teja")
				.roles("admin")
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}

}
