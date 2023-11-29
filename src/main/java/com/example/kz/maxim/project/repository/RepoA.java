package com.example.kz.maxim.project.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class RepoA implements RepoInterface {
    public void functionA() {
        System.out.println("class (RepoA) method called");
    }

    @Override
    public void repoMethod() {
        System.out.println("class (RepoA) method");
    }
}
