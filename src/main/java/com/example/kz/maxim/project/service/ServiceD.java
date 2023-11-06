package com.example.kz.maxim.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
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
