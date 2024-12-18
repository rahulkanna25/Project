package com.sprint.Project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
<<<<<<< HEAD

@SpringBootApplication(scanBasePackages="com.controller,com.servicce")
@EntityScan("com.model")
@EnableJpaRepositories("com.DAO")
=======
@SpringBootApplication(scanBasePackages="com.controller,com.service")
@EnableJpaRepositories(basePackages = "com.dao")
@EntityScan(basePackages = "com.model")
>>>>>>> 7963fc8248d2d8d9bdd5f444b0a65e6ef418c212
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

}
