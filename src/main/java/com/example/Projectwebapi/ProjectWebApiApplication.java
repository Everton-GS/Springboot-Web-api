package com.example.Projectwebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjectWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWebApiApplication.class, args);
	}

	@Bean
	public PasswordEncoder gPasswordEncoder(){
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			return encoder;
			
		}

}
