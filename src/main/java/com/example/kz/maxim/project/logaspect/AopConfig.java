package com.example.kz.maxim.project.logaspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@Slf4j
public class AopConfig {
    @Bean
    public MyAspect myAspect() {
        return new MyAspect();
    }
}
