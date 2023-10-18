package com.example.kz.maxim.project;

import com.example.kz.maxim.project.repository.RepoA;
import com.example.kz.maxim.project.repository.RepoB;
import com.example.kz.maxim.project.repository.RepoC;
import com.example.kz.maxim.project.service.ServiceA;
import com.example.kz.maxim.project.service.ServiceB;
import com.example.kz.maxim.project.service.ServiceC;
import com.example.kz.maxim.project.service.ServiceD;
import org.springframework.context.annotation.Bean;

import java.security.Provider;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public ServiceA serviceA(RepoA repoA){
        return new ServiceA(repoA);
    }

    @Bean
    public ServiceB serviceB(ServiceA serviceA, RepoB repoB) {
        return new ServiceB(serviceA,repoB);
    }

    @Bean
    public ServiceC serviceC(ServiceB serviceB, RepoC repoC) {
        return new ServiceC(serviceB, repoC);
    }

    @Bean
    public ServiceD serviceD(ServiceC serviceC) {
        return new ServiceD(serviceC);
    }
}
