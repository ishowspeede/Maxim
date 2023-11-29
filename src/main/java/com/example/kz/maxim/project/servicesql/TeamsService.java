package com.example.kz.maxim.project.servicesql;

import com.example.kz.maxim.project.model.Teams;
import com.example.kz.maxim.project.repos.TeamsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class TeamsService {
    private TeamsRepo teamsRepository;

    @Autowired
    public TeamsService(TeamsRepo teamRepository) {
        this.teamsRepository = teamRepository;
    }

    public List<Teams> getTeams() {
        try {
            return teamsRepository.findAll();
        } catch (SQLException e) {
            log.error("Error getting teams: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public void addTeams(Teams teams) {
        try {
            teamsRepository.insert(teams);
        } catch (Exception e) {
            log.error("Error adding teams: {}", e.getMessage(), e);
        }
    }

    public void deleteTeams(Long id) {
        try {
            teamsRepository.delete(id);
        } catch (Exception e) {
            log.error("Error deleting teams: {}", e.getMessage(), e);
        }
    }

    public Teams findTeamsById(Long id) {
        try {
            return teamsRepository.findById(id);
        } catch (Exception e) {
            log.error("Error finding teams: {}", e.getMessage(), e);
            return new Teams();
        }
    }

    public List<Teams> findTeamsByName(String name) {
        try {
            return teamsRepository.findByAttrName(name);
        } catch (Exception e) {
            log.error("Error finding teams: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Teams> findTeamsByCountry(String country) {
        try {
            return teamsRepository.findByAttrCountry(country);
        } catch (Exception e) {
            log.error("Error finding teams: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<Teams> findTeamsByNumberOfPlayers(Integer numberOfPlayers) {
        try {
            return teamsRepository.findByAttrNumbers(numberOfPlayers);
        } catch (Exception e) {
            log.error("Error finding teams: {}", e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
