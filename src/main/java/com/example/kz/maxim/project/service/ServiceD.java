package com.example.kz.maxim.project.service;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceD {
    public ServiceC serviceC;

    @Value("example4.property")
    private long value4;

    public ServiceD(ServiceC serviceC) {
    }

    public void methodD() {
        System.out.println("class {ServiceC} method called");
        serviceC.methodC();
    }
}
