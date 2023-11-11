package com.example.kz.maxim.project.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.zip.DataFormatException;

@Repository
@Primary
public class RepoC implements RepoInterface {
    public void functionC() {
        System.out.println("class (RepoC) method called");
    }

    @Override
    public void repoMethod() {
        System.out.println("class (RepoC) method");
    }
}
