package com.scheduler.threadpool_scheduler;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolDemo {

    @Scheduled(fixedRate = 3000)
    public void taskA() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Task A started" +LocalTime.now());
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " Task A finished" +LocalTime.now());
    }

    @Scheduled(fixedRate = 3000)
    public void taskB() {
        System.out.println(Thread.currentThread().getName() + " Task B running" +LocalTime.now());
    }
}



