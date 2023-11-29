package com.example.kz.maxim.project.repos;

import com.example.kz.maxim.project.model.Games;
import com.example.kz.maxim.project.model.Players;
import com.example.kz.maxim.project.model.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeamsRepo {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TeamsRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper <Teams> mapRow() {
        return (rs, rowNum) -> {
            Teams teams = new Teams();
            teams.setId(rs.getLong("id"));
            teams.setName(rs.getString("name"));
            teams.setCountry(rs.getString("country"));
            teams.setNumberOfPlayers(rs.getInt("number_of_players"));
            return teams;
        };
    }

    public List<Teams> findAll() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM teams", this.mapRow());
    }

    public void insert(Teams teams) {
        jdbcTemplate.update("INSERT INTO teams (name, number_of_players, country) VALUES (?, ?, ?)", teams.getName(), teams.getNumberOfPlayers(), teams.getCountry());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM games WHERE id = ?", id);
    }

    public Teams findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM teams WHERE id = ?", this.mapRow(), id);
    }

    public List <Teams> findByAttrName(String name) {
        return jdbcTemplate.query("SELECT * FROM teams WHERE name = ?", this.mapRow(), name);
    }

    public List <Teams> findByAttrCountry(String country) {
        return jdbcTemplate.query("SELECT * FROM teams WHERE country = ?", this.mapRow(), country);
    }

    public List <Teams> findByAttrNumbers(Integer numberOfPlayers) {
        return jdbcTemplate.query("SELECT * FROM teams WHERE number_of_players = ?", this.mapRow(), numberOfPlayers);
    }
}
