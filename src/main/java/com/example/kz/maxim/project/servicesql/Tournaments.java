package com.example.kz.maxim.project.servicesql;

import com.example.kz.maxim.project.model.Games;
import com.example.kz.maxim.project.repos.GamesRepo;
import com.example.kz.maxim.project.repos.TournamentsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class Tournaments {
    private TournamentsRepo tournamentsRepo;

    @Autowired
    public Tournaments(TournamentsRepo tournamentsRepo) {
        this.tournamentsRepo = tournamentsRepo;
    }

    public List <Tournaments> getTournaments() {
        try {
            return tournamentsRepo.findAll();
        } catch (SQLException e) {
            log.error("Error getting tournaments: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public void addTournaments(Tournaments tournaments) {
        try {
            tournamentsRepo.insert(tournaments);
        } catch (Exception e) {
            log.error("Error adding tournaments: {}", e.getMessage(), e);
        }
    }

    public void deleteTournaments(Long id) {
        try {
            tournamentsRepo.delete(id);
        } catch (Exception e) {
            log.error("Error deleting tournaments: {}", e.getMessage(), e);
        }
    }

    public Games findTournamentsById(Long id) {
        try {
            return tournamentsRepo.findById(id);
        } catch (Exception e) {
            log.error("Error finding tournaments: {}", e.getMessage(), e);
            return new Games();
        }
    }

    public List <Tournaments> findTournamentsByName(String name) {
        try {
            return tournamentsRepo.findByAttrName(name);
        } catch (Exception e) {
            log.error("Error finding tournaments: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List <Tournaments> findTournamentsByInWhichGame(String whichGame) {
        try {
            return tournamentsRepo.findByAttrGame(whichGame);
        } catch (Exception e) {
            log.error("Error finding tournaments: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List <Tournaments> findTournamentsByMoneyWin(Integer moneyWin) {
        try {
            return tournamentsRepo.findByAttrMoney(moneyWin);
        } catch (Exception e) {
            log.error("Error finding tournaments: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
