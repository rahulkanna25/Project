package com.security.Security1;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.DAO.*;
import com.filter.JwtFilter;
import com.service.CustomUserDetailsService;

@SpringBootApplication(scanBasePackages={"com.controller","com.service","com.filter,com.initializer,com.exception"})
@EntityScan("com.model")
@EnableJpaRepositories("com.dao")
@EnableWebSecurity
public class Security1Application {

	public static void main(String[] args) {
		SpringApplication.run(Security1Application.class, args);
		
	}
	 
	
	@Bean
	@DependsOn("userDetailsService")
	public DaoAuthenticationProvider daoAuthenticationProvider() {
	    CustomUserDetailsService service=userDetailsService();

	  
	    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	    
	    provider.setUserDetailsService(service);
	    provider.setPasswordEncoder(passwordEncoder());
	    return provider;
	}

	@Bean
	public CustomUserDetailsService userDetailsService() {
		
	 
	    return new CustomUserDetailsService(); // Implement your own user details service
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(); // Use a password encoder of your choice
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    System.out.println("invoked");
		http
	        .csrf().disable() 
	        
	        .authorizeRequests()
	            .requestMatchers("/api/auth").permitAll()
	            
	                .requestMatchers(HttpMethod.PUT,"/api/manager/register/*").hasRole("ADMIN")
	                .requestMatchers("/api/user/register").permitAll() 
	                .requestMatchers(HttpMethod.GET,"/api/restaurants").hasAnyRole("USER","MANAGER")
	                .requestMatchers(HttpMethod.GET,"/api/restaurants/{restaurantId").hasAnyRole("MANAGER","USER")
	                .requestMatchers(HttpMethod.POST,"/api/restaurants").hasAnyRole("ADMIN","MANAGER")
		            .requestMatchers(HttpMethod.GET,"/api/restaurants/{restaurantId}/menu").hasAnyRole("MANAGER,USER")
		            .requestMatchers(HttpMethod.GET,"/api/restaurants/{restaurantId}/reviews").hasAnyRole("ADMIN,USER")
		            .requestMatchers(HttpMethod.GET,"/api/restaurants/{restaurantId}/delivery-areas").hasAnyRole("MANAGER,ADMIN")
		            .requestMatchers(HttpMethod.GET,"/api/restaurants").hasAnyRole("ADMIN,USER")
		            .requestMatchers(HttpMethod.PUT,"/api/restaurants/{restaurantId}").hasAnyRole("ADMIN","MANAGER")
		            .requestMatchers(HttpMethod.GET,"/api/customers/{customerId}").hasAnyRole("MANAGER,ADMIN")
		            .requestMatchers(HttpMethod.GET,"/api/customers").hasRole("MANAGER")
		            .requestMatchers(HttpMethod.PUT,"/api/customers/{customerId}").hasRole("MANAGER")
		            .requestMatchers(HttpMethod.GET,"/api/customers/{customerId}/orders").hasAnyRole("MANAGER,USER")
		            .requestMatchers(HttpMethod.GET,"/api/restaurants").hasRole("USER")
		            .requestMatchers(HttpMethod.GET,"/api/restaurants/{restaurantId}/menu").hasAnyRole("USER,MANAGER")
		            .requestMatchers(HttpMethod.POST,"/api/restaurants/{restaurantId}/menu").hasRole("ADMIN")
		            .requestMatchers(HttpMethod.PUT,"/api/restaurants/{restaurantId}/menu/{itemId}").hasRole("MANAGER")
		            .requestMatchers(HttpMethod.DELETE,"/api/restaurants/{restaurantId}/menu/{itemId}").hasRole("ADMIN")
		            .requestMatchers(HttpMethod.POST,"/api/orders").hasRole("USER")
		            .requestMatchers(HttpMethod.GET,"/api/orders/{orderId}").hasAnyRole("MANAGER,USER")
		            .requestMatchers(HttpMethod.PUT,"/api/orders/{orderId}/status").hasAnyRole("ADMIN,USER")
		            .requestMatchers(HttpMethod.DELETE,"/api/orders/{orderId}").hasRole("USER")
		            .requestMatchers(HttpMethod.GET, "/api/drivers").hasRole("ADMIN")
		            .requestMatchers(HttpMethod.GET, "/api/drivers/{driverId}").hasAnyRole("USER,MANAGER")
		            .requestMatchers(HttpMethod.PUT,"/api/orders/{orderId}/assignDriver/{driverId}").hasRole("MANAGER")
		            .requestMatchers(HttpMethod.PUT,"/api/drivers/{driverId}/location").hasAnyRole("MANAGER","ADMIN")
		            .requestMatchers(HttpMethod.GET,"/api/drivers/{driverId}/orders").hasAnyRole("ADMIN,MANAGER")
		           
		           
	             

	            .anyRequest().authenticated()
	            .and()
	             .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
	           
	        .sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and()
	            .sessionManagement().disable()
	            	
	            
	                
	        .authenticationManager(new ProviderManager(daoAuthenticationProvider()));
	        
	
	        
	    return http.build();
	}
}