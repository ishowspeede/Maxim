package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.classes.Game;
import com.example.kz.maxim.project.classes.Player;
import com.example.kz.maxim.project.repo.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepo gameRepo;
    public List<Game> list() {
        return gameRepo.findAll();
    }
    public Game findByNameContainingIgnoreCase(String name) {
        return gameRepo.findByNameContainingIgnoreCase(name);
    }
    public Game retrieveByName(String name) {
        return gameRepo.retrieveByName(name);
    }
    public List<Game> findAllGameNative() {
        return gameRepo.findAllGameNative();
    }
    public List<Game> listSort() {
        return gameRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
