package com.example.kz.maxim.project.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tournaments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long tournamentId;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public int moneyWin;

    @Column(nullable = false)
    public String inWhichGame;
}
