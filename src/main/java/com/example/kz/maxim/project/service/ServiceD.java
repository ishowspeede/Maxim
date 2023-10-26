package com.example.kz.maxim.project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceD {
    public ServiceC serviceC;

    @Value("example4.property")
    private String value4;

    public ServiceD(ServiceC serviceC) {
    }

    public void methodD() {
        System.out.println("class {ServiceC} method called");
        serviceC.methodC();
    }
}
