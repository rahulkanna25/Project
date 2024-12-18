package com.sprint.Project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.controller,com.servicce")
@EntityScan("com.model")
@EnableJpaRepositories("com.DAO")
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

}
