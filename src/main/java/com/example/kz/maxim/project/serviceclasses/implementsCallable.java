package com.example.kz.maxim.project.serviceclasses;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

@Slf4j
public class implementsCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        Integer sum = Stream.iterate(0, n->n+1)
                .limit(20)
                .reduce(0, (x,y) -> {
                    log.info("operation with " + x + "and " + y);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return x + y;
                });
        return sum;
    }
}
