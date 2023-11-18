package com.example.kz.maxim.project.model;

import javax.persistence.*;

@Entity
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long gameId;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public int pickOnline;

    @Column(nullable = false)
    public String typeOfGame;
}
