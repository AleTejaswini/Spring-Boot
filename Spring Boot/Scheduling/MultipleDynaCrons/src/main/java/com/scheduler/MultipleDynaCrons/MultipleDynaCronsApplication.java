package com.scheduler.MultipleDynaCrons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class MultipleDynaCronsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDynaCronsApplication.class, args);
	}

}
