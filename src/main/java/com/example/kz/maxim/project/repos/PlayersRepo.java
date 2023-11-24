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
public class PlayersRepo {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PlayersRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Players> mapRow() {
        return (rs, rowNum) -> {
            Players players = new Players();
            players.setId(rs.getLong("id"));
            players.setName(rs.getString("name"));
            players.setRole(rs.getString("role"));
            players.setAge(rs.getInt("age"));
            return players;
        };
    }

    public List <Players> findAll() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM players", this.mapRow());
    }

    public void insert(Players player) {
        jdbcTemplate.update("INSERT INTO players (name, age, role) VALUES (?, ?, ?)", player.getName(), player.getAge(), player.getRole());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM players WHERE id = ?", id);
    }

    public Players findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM players WHERE id = ?", this.mapRow(), id);
    }

    public List <Players> findByAttrName(String name) {
        return jdbcTemplate.query("SELECT * FROM players WHERE name = ?", this.mapRow(), name);
    }

    public List <Players> findByAttrRole(String role) {
        return jdbcTemplate.query("SELECT * FROM players WHERE role = ?", this.mapRow(), role);
    }

    public List<Players> findByAttrAge(Integer age) {
        return jdbcTemplate.query("SELECT * FROM players WHERE age= ?", this.mapRow(), age);
    }
}
