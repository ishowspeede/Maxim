package com.example.kz.maxim.project.repo;

import com.example.kz.maxim.project.classes.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepo extends JpaRepository<Player, Long> {
    Player findByNameContainingIgnoreCase(String name);
    @Query("SELECT p FROM Player p WHERE LOWER(p.name) = LOWER(:name)")
    Player retrieveByName(@Param("name") String name);
    @Query(value = "SELECT * FROM Player p",
            nativeQuery = true)
    List<Player> findAllBooksNative();
}