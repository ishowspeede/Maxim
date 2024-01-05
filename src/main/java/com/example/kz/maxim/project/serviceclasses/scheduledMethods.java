package com.example.kz.maxim.project.serviceclasses;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class scheduledMethods {

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        log.info("");
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        log.info("");
    }

    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() {
        log.info("");
    }

    @Scheduled(cron = "0 15 10 ? * 6L 2002-2005")
    public void scheduleCronTask() {
        log.info("");
    }
}
