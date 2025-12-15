package com.scheduling.Scheduling.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class demo {
	
//	@Scheduled(fixedDelay  = 7000)
//	public void fixedDelay() {
//		System.out.println(LocalTime.now()+"fixed Delay");
//	}
//	@Scheduled(initialDelay=4000, fixedRate = 3000)
//	public void initialfixed() {
//		System.out.println(LocalTime.now() +"initialDelay and fixedDelay");
//	}
	
//	@Scheduled(fixedRate = 3000)
//	public void fixedRate() {
//		System.out.println(LocalTime.now()+"fixedRate ");
//	}
//	
//	@Scheduled(initialDelay = 8000)
//	public void initialDelay() {
//		System.out.println(LocalTime.now()+"initialDelay");
//	}
//	@Scheduled(initialDelay = 6000,fixedDelay = 3000)
//	public void initialfixed() {
//		System.out.println(LocalTime.now()+"initialDelay ,fixedelay ");
//	}
//	
	
//	@Scheduled(cron = "0 * * * * *",zone ="Asia/Kolkata")
//	public void cron() {
//		System.out.println(LocalTime.now()+"hello");
//	}
	
	@Scheduled(cron = "*/5 * 16 * * *", zone = "Asia/Kolkata")
	public void cron() {
	    System.out.println(LocalTime.now() + " hello");
	}
	
	
}
