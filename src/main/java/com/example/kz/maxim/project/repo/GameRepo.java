package com.example.kz.maxim.project.repo;

import com.example.kz.maxim.project.classes.Game;
import com.example.kz.maxim.project.classes.Player;
import com.example.kz.maxim.project.classes.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepo extends JpaRepository<Game, Long> {
    Game findByNameContainingIgnoreCase(String name);
    @Query("SELECT g FROM Game g WHERE LOWER(g.name) = LOWER(:name)")
    Game retrieveByName(@Param("name") String name);
    @Query(value = "SELECT * FROM Game g",
            nativeQuery = true)
    List<Game> findAllGameNative();
}
