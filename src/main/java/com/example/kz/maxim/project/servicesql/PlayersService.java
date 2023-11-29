package com.example.kz.maxim.project.servicesql;

import com.example.kz.maxim.project.model.Players;
import com.example.kz.maxim.project.repos.PlayersRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class PlayersService {
    private final PlayersRepo playersRepo;
    @Autowired
    public PlayersService(PlayersRepo playersRepository) {
        this.playersRepo = playersRepository;
    }

    public List <Players> getPlayers() {
        try {
            return playersRepo.findAll();
        } catch (SQLException e) {
            log.error("Error getting players: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public void addPlayers(Players players) {
        try {
            playersRepo.insert(players);
        } catch (Exception e) {
            log.error("Error adding players: {}", e.getMessage(), e);
        }
    }

    public void deletePlayers(Long id) {
        try {
            playersRepo.delete(id);
        } catch (Exception e) {
            log.error("Error deleting players: {}", e.getMessage(), e);
        }
    }

    public Players findPlayersById(Long id) {
        try {
            return playersRepo.findById(id);
        } catch (Exception e) {
            log.error("Error finding players: {}", e.getMessage(), e);
            return new Players();
        }
    }

    public List <Players> findPlayersByName(String name) {
        try {
            return playersRepo.findByAttrName(name);
        } catch (Exception e) {
            log.error("Error finding players: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Players> findPlayersByAge(Integer age) {
        try {
            return playersRepo.findByAttrAge(age);
        } catch (Exception e) {
            log.error("Error finding players: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Players> findPlayersByRole(String role) {
        try {
            return playersRepo.findByAttrRole(role);
        } catch (Exception e) {
            log.error("Error finding players: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
