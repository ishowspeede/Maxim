package com.example.kz.maxim.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tournaments")
public class Tournaments {
    @Id
    private long id;
    private String name;
    private int moneyWin;
    private String inWhichGame;
}
