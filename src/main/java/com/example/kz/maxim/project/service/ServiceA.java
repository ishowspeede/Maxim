package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.repository.RepoInterface;
import com.example.kz.maxim.project.repository.RepoA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class ServiceA {
    private RepoInterface repoInterface;

    @Value("example1.property")
    private String value1;

    @Autowired
    public ServiceA(RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
    }

    public void methodA() {
        System.out.println("class {ServiceA} method called");
        repoInterface.repoMethod();
    }

    @PostConstruct
    public void init() {
        System.out.println("ServiceA init method called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("ServiceA destroy method called");
    }
}
