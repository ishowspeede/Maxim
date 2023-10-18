package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.repository.RepoC;
import lombok.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceC {
    public ServiceB serviceB;
    public RepoC repoC;

    @Value("example3.property")
    private boolean value3;

    public ServiceC(ServiceB serviceB, RepoC repoC) {
    }

    public void methodC() {
        System.out.println("class {ServiceC} method called");
        serviceB.methodB();
        repoC.functionC();
    }
}
