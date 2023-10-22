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
    public RepoA repoA;
    private RepoInterface repoInterface;

    @Value("example1.property")
    private String value1;

    @Autowired
    public ServiceA(@Qualifier("repoA") RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
    }

    public void methodA() {
        System.out.println("class {ServiceA} method called");
        repoA.functionA();
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
