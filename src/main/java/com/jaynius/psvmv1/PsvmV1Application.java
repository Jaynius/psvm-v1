package com.jaynius.psvmv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PsvmV1Application {

	public static void main(String[] args) {
		SpringApplication.run(PsvmV1Application.class, args);
	}

}
