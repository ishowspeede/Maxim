package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.repository.RepoB;
import lombok.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceB {
    public ServiceA serviceA;
    public RepoB repoB;

    @Value("example2.property")
    private int value2;

    public ServiceB(ServiceA serviceA, RepoB repoB) {
    }

    public void methodB() {
        System.out.println("class {ServiceB} method called");
        serviceA.methodA();
        repoB.functionB();
    }
}
