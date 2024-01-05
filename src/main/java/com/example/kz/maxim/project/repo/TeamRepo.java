package com.example.kz.maxim.project.repo;

import com.example.kz.maxim.project.classes.Player;
import com.example.kz.maxim.project.classes.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepo extends JpaRepository<Team, Long> {
    Team findByNameContainingIgnoreCase(String name);
    @Query("SELECT t FROM Team t WHERE LOWER(t.name) = LOWER(:name)")
    Team retrieveByName(@Param("name") String name);
    @Query(value = "SELECT * FROM Team t",
            nativeQuery = true)
    List<Team> findAllTeamNative();
}