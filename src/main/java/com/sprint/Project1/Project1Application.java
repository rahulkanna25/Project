package com.sprint.Project1;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;

import com.filter.JwtFilter;
import com.service.CustomUserDetailsService;


@SpringBootApplication(scanBasePackages="com.controller,com.service")
@EnableJpaRepositories(basePackages = "com.dao")
@EntityScan(basePackages = "com.model")

public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
		
		
		 
		
	}
}