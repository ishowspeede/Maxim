package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.repository.RepoInterface;
import com.example.kz.maxim.project.repository.RepoB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.zip.DataFormatException;

@Component
public class ServiceB {
    public ServiceA serviceA;
    private RepoInterface repoInterface;

    @Value("example2.property")
    private String value2;

    @Autowired
    public ServiceB(ServiceA serviceA, @Qualifier("repoB") RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
        this.serviceA = serviceA;
    }

    public void methodB() {
        System.out.println("class {ServiceB} method called");
        serviceA.methodA();
    }
}
