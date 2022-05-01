package com.example.backFlightApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BackFlightAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackFlightAppApplication.class, args);
	}

}
