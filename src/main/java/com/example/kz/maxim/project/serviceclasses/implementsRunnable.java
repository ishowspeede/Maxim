package com.example.kz.maxim.project.serviceclasses;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

@Slf4j
public class implementsRunnable implements Runnable {
    @Override
    public void run() {
        log.info("start runnable");
        Stream.iterate(0, n->n+1)
                .limit(20)
                .forEach(x-> {
                    log.info("operation with id: " + x);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
        log.info("end runnable");
    }
}
