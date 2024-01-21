package com.pranav.roche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class RocheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocheApplication.class, args);
	}
	
}
