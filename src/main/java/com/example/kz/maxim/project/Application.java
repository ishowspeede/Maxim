package com.example.kz.maxim.project;

import com.example.kz.maxim.project.logaspect.MyAspect;
import com.example.kz.maxim.project.service.ServiceD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		ServiceD serviceDFromConfigurationClass = ctx.getBean("serviceD", ServiceD.class);
		serviceDFromConfigurationClass.methodD();
		serviceDFromConfigurationClass.printMessage();
	}
}
