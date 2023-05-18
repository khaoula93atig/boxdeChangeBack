package com.tta.boxchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BoxChangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoxChangeApplication.class, args);
	}

}
