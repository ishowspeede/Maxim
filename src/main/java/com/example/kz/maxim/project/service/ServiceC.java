package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.repository.RepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceC {
    public ServiceB serviceB;
    private RepoInterface repoInterface;

    @Value("example3.property")
    private String value3;

    @Autowired
    public ServiceC(
            ServiceB serviceB, @Qualifier("repoC") RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
        this.serviceB = serviceB;
    }

    public static String getMessageFromDbClassC() {
        return "This message selected from database ClassC";
    }

    public void methodC() {
        System.out.println("class {ServiceC} method called");
        serviceB.methodB();
    }
}
