package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.repository.RepoA;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceA {
    public RepoA repoA;

    @Value("example1.property")
    private String value1;

    public ServiceA(RepoA repoA) {
    }

    public void methodA() {
        System.out.println("class {ServiceA} method called");
        repoA.functionA();
    }
}
