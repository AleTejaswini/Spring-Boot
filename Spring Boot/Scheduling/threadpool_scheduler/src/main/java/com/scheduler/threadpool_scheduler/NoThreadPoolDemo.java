package com.scheduler.threadpool_scheduler;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NoThreadPoolDemo {

    @Scheduled(fixedRate = 3000)
    public void taskA() throws InterruptedException {
        System.out.println("Task A started" +LocalTime.now());
        Thread.sleep(5000); // takes 5 seconds
        System.out.println("Task A finished" +LocalTime.now());
    }

    @Scheduled(fixedRate = 3000)
    public void taskB() {
        System.out.println("Task B running" +LocalTime.now());
    }
}
