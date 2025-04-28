package com.app.nanny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NannyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NannyApplication.class, args);
	}

}
