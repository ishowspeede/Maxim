package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.RepoInterface;
import com.example.kz.maxim.project.repository.RepoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceC {
    public ServiceB serviceB;
    public RepoC repoC;
    private RepoInterface repoInterface;

    @Value("example3.property")
    private boolean value3;

    @Autowired
    public ServiceC(@Qualifier("repoC")
            ServiceB serviceB, RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
    }

    public void methodC() {
        System.out.println("class {ServiceC} method called");
        serviceB.methodB();
        repoC.functionC();
    }
}
