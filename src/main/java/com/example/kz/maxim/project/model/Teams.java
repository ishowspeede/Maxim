package com.example.kz.maxim.project.model;

import javax.persistence.*;

@Entity
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long teamId;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public int numberOfPlayers;

    @Column(nullable = false)
    public String country;
}
