package com.example.kz.maxim.project.config;

import com.example.kz.maxim.project.repository.RepoA;
import com.example.kz.maxim.project.repository.RepoB;
import com.example.kz.maxim.project.repository.RepoC;
import com.example.kz.maxim.project.service.ServiceA;
import com.example.kz.maxim.project.service.ServiceB;
import com.example.kz.maxim.project.service.ServiceC;
import com.example.kz.maxim.project.service.ServiceD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.security.Provider;

@org.springframework.context.annotation.Configuration
@PropertySource("classpath:myapp.properties")
@Import(ServiceA.class)
public class Configuration {
}
