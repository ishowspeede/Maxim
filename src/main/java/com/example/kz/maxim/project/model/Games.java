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
@Table (name = "games")
public class Games {
    @Id
    private long id;
    private String name;
    private int pickOnline;
    private String typeOfGame;
}
