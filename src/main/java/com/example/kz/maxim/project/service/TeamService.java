package com.example.kz.maxim.project.service;

import com.example.kz.maxim.project.classes.Player;
import com.example.kz.maxim.project.classes.Team;
import com.example.kz.maxim.project.repo.PlayerRepo;
import com.example.kz.maxim.project.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamService {
    @Autowired
    private TeamRepo teamRepo;
    public List<Team> list() {
        return teamRepo.findAll();
    }
    public Team findByNameContainingIgnoreCase(String name) {
        return teamRepo.findByNameContainingIgnoreCase(name);
    }
    public Team retrieveByName(String name) {
        return teamRepo.retrieveByName(name);
    }
    public List<Team> findAllTeamNative() {
        return teamRepo.findAllTeamNative();
    }
    public List <Team> listSort() {
        return teamRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
