package com.springboot.rest.webservice.restfulwebservice.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	//override the Spring-security Filter Chain
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
//		1)All request should be authenticated -- that is why a login page will come up 
//code is correct -error is due to old JDK version
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
//		2)If a request is not authenticated a webpage/login page will come up -- it means if a request/API EndPoint is not authenticated then it will redirect to the login page
		http.httpBasic(withDefaults());
		
//		3)CSRF -> POST , PUT -- CSRF effects the POST and PUT request and due to which POST/PUT request is not accessible and it gives 403 forbidden error
//		(disable CSRF)
		http.csrf().disable();
		return http.build();
	}

}
