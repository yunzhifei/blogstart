package com.bj.hai.yang.blog.start.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sychorinzed {

    @Scheduled(cron = "* * * * * ?")
    public void task() {
        Thread thread = Thread.currentThread();
        System.out.println("true = " + thread.getId());
    }

    @Scheduled(cron = "* * * * * ?")
    public void task1() {
        Thread thread = Thread.currentThread();
        System.out.println("false = " + thread.getId());
    }
}
