package com.example.kz.maxim.project.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class RepoB implements RepoInterface {
    public void functionB() {
        System.out.println("class (RepoB) method called");
    }

    @Override
    public void repoMethod() {
        System.out.println("class (RepoB) method");
    }
}
