package com.example.kz.maxim.project;

import com.example.kz.maxim.project.logaspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		MyAspect myAspect = new MyAspect();
		System.out.println(myAspect);
	}
}
