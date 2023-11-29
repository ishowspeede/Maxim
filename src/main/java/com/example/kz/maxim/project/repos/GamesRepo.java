package com.example.kz.maxim.project.repos;

import com.example.kz.maxim.project.model.Games;
import com.example.kz.maxim.project.model.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GamesRepo {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GamesRepo (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper <Games> mapRow() {
        return (rs, rowNum) -> {
            Games games = new Games();
            games.setId(rs.getLong("id"));
            games.setName(rs.getString("name"));
            games.setTypeOfGame(rs.getString("type_of_game"));
            games.setPickOnline(rs.getInt("pick_online"));
            return games;
        };
    }

    public List<Games> findAll() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM games", this.mapRow());
    }

    public void insert(Games games) {
        jdbcTemplate.update("INSERT INTO games (name, pick_online, type_of_game VALUES (?, ?, ?)", games.getName(), games.getPickOnline(), games.getTypeOfGame());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM games WHERE id = ?", id);
    }

    public Games findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM games WHERE id = ?", this.mapRow(), id);
    }

    public List <Games> findByAttrName(String name) {
        return jdbcTemplate.query("SELECT * FROM games WHERE name = ?", this.mapRow(), name);
    }

    public List <Games> findByAttrType(String typeOfGame) {
        return jdbcTemplate.query("SELECT * FROM games WHERE type_of_game = ?", this.mapRow(), typeOfGame);
    }

    public List<Games> findByAttrPick(Integer pickOnline) {
        return jdbcTemplate.query("SELECT * FROM games WHERE pick_online= ?", this.mapRow(), pickOnline);
    }
}
