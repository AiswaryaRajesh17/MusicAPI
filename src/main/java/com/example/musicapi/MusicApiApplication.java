package com.example.musicapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.musicapi.repository")
public class MusicApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicApiApplication.class, args);
	}

}
