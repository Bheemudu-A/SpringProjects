package com.src.SpringSecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;

import com.src.SpringSecurity.service.MyUserDetailsService;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class StudentConfig {
	
	@Autowired
	public UserDetailsService userDetailService;
	
	
	@Bean
	public AuthenticationProvider authProvider() {
	
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // this is used to Authonticate plain password text, if passowrd is bycrpted it cannot authenticate
	//	provider.setPasswordEncoder(new BCryptPasswordEncoder(12));  // this is used to Authonticate Bcrypted password text, if password is plain text it cannot authenticate
		
		return provider;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		
		security.csrf(customizer -> customizer.disable());
		security.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		security.httpBasic(Customizer.withDefaults());
		security.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
//		Customizer<SessionManagementConfigurer<HttpSecurity>> sessionManagementCustomizer = new Customizer<SessionManagementConfigurer<HttpSecurity>>() {			
//			@Override
//			public void customize(SessionManagementConfigurer<HttpSecurity> t) {
//				
//				t.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//			}
//		};
		return security.build();
	}
	
	
	//to create user & password, by create this the username, password provided in annotation file won't be picked
	// it's static username and password
	
/*	@Bean
	public UserDetailsService userDetailService() {
		
		UserDetails user=User
				.withDefaultPasswordEncoder()
				.username("navin")
				.password("n@123")
				.roles("USER")
				.build();
		
		UserDetails  admin=User
				.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin@789")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}*/
	
	
	

}
