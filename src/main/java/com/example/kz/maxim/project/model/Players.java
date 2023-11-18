package com.example.kz.maxim.project.model;

import javax.persistence.*;

@Entity
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long playerId;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public int age;

    @Column(nullable = false)
    public String role;

}
