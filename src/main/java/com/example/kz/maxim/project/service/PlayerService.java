package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.classes.Player;
import com.example.kz.maxim.project.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;
    public List<Player> list() {
        return playerRepo.findAll();
    }
    public Player findByNameContainingIgnoreCase(String name) {
        return playerRepo.findByNameContainingIgnoreCase(name);
    }
    public Player retrieveByName(String name) {
        return playerRepo.retrieveByName(name);
    }
    public List<Player> findAllPlayersNative() {
        return playerRepo.findAllBooksNative();
    }
    public List<Player> listSort() {
        return playerRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
