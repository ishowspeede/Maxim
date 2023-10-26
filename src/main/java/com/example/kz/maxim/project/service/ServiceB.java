package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.repository.RepoInterface;
import com.example.kz.maxim.project.repository.RepoB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceB {
    public ServiceA serviceA;
    public RepoB repoB;
    private RepoInterface repoInterface;

    @Value("example2.property")
    private String value2;

    @Autowired
    public ServiceB(@Qualifier("repoB")
            ServiceA serviceA, RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
    }

    public void methodB() {
        System.out.println("class {ServiceB} method called");
        serviceA.methodA();
        repoB.functionB();
    }
}
