package com.batchScheduling.CompanyDetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class CompanyDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyDetailApplication.class, args);
	}

}
