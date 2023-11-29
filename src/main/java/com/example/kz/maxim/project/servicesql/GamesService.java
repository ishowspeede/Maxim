package com.example.kz.maxim.project.servicesql;

import com.example.kz.maxim.project.model.Games;
import com.example.kz.maxim.project.model.Teams;
import com.example.kz.maxim.project.repos.GamesRepo;
import com.example.kz.maxim.project.repos.TeamsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class GamesService {
    private GamesRepo gamesRepo;

    @Autowired
    public GamesService(GamesRepo gamesRepo) {
        this.gamesRepo = gamesRepo;
    }

    public List<Games> getGames() {
        try {
            return gamesRepo.findAll();
        } catch (SQLException e) {
            log.error("Error getting games: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public void addGames(Games games) {
        try {
            gamesRepo.insert(games);
        } catch (Exception e) {
            log.error("Error adding games: {}", e.getMessage(), e);
        }
    }

    public void deleteGames(Long id) {
        try {
            gamesRepo.delete(id);
        } catch (Exception e) {
            log.error("Error deleting games: {}", e.getMessage(), e);
        }
    }

    public Games findGamesById(Long id) {
        try {
            return gamesRepo.findById(id);
        } catch (Exception e) {
            log.error("Error finding games: {}", e.getMessage(), e);
            return new Games();
        }
    }

    public List<Games> findGamesByName(String name) {
        try {
            return gamesRepo.findByAttrName(name);
        } catch (Exception e) {
            log.error("Error finding games: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Games> findGamesByTypeOfGames(String typeOfGames) {
        try {
            return gamesRepo.findByAttrType(typeOfGames);
        } catch (Exception e) {
            log.error("Error finding games: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List <Games> findGamesByPickOnline(Integer pickOnline) {
        try {
            return gamesRepo.findByAttrPick(pickOnline);
        } catch (Exception e) {
            log.error("Error finding games: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
