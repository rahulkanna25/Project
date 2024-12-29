package com.sprint.Project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.DAO.*;
import com.filter.JwtFilter;
import com.service.CustomUserDetailsService;

@SpringBootApplication(scanBasePackages={"com.controller","com.service","com.filter","com.initializer","com.exception"})
@EntityScan("com.model")
@EnableJpaRepositories("com.dao")
@EnableWebSecurity
public class Project1Application {

    public static void main(String[] args) {
        SpringApplication.run(Project1Application.class, args);
    }
    
    
    @Bean
    @DependsOn("userDetailsService")
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        CustomUserDetailsService service = userDetailsService();
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public CustomUserDetailsService userDetailsService() {
        return new CustomUserDetailsService(); 
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); 
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("Security Filter Chain Invoked");
        http
            .csrf().disable()
            .authorizeRequests()
                // Public Endpoints
                .requestMatchers("/api/auth").permitAll()
                .requestMatchers("/api/user/register").permitAll()
                
                // Restaurants Endpoints
                .requestMatchers(HttpMethod.GET, "/api/restaurants").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/restaurants/{restaurantId}").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/restaurants").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/restaurants/{restaurantId}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/restaurants/{restaurantId}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/restaurants/{restaurantId}/menu").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/restaurants/{restaurantId}/menu").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/restaurants/{restaurantId}/menu/{itemId}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/restaurants/{restaurantId}/menu/{itemId}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/restaurants/{restaurantId}/reviews").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/restaurants/{restaurantId}/delivery-areas").hasAnyRole("USER", "ADMIN")
                
                // Orders Endpoints
                .requestMatchers(HttpMethod.POST, "/api/orders").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/orders/{orderId}").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/orders/{orderId}/status").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/orders/{orderId}").hasRole("USER")
                .requestMatchers(HttpMethod.PUT, "/api/orders/{orderId}/assignDriver/{driverId}").hasRole("ADMIN")
                
                // Drivers Endpoints
                .requestMatchers(HttpMethod.GET, "/api/drivers").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/drivers/{driverId}").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/drivers/{driverId}/location").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/drivers/{driverId}/orders").hasRole("ADMIN")
                
                // Customers Endpoints
                .requestMatchers(HttpMethod.GET, "/api/customers").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/customers/{customerId}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/customers/{customerId}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/customers/{customerId}").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/customers/{customerId}/orders").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/customers/{customerId}/reviews").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/customers/{customerId}/favorites").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/customers/{customerId}/favorites/{restaurantId}").hasRole("ADMIN")

           
            .anyRequest().authenticated()
            .and()
           
            .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
            // Stateless session management
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .sessionManagement().disable()
            .authenticationManager(new ProviderManager(daoAuthenticationProvider()));

        return http.build();
    }

}
