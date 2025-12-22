package com.scheduler.threadpool_scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ThreadpoolSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreadpoolSchedulerApplication.class, args);
	}

}
