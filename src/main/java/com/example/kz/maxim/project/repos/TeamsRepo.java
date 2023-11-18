package com.example.kz.maxim.project.repos;

import com.example.kz.maxim.project.model.Games;
import com.example.kz.maxim.project.model.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TeamsRepo {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Teams findUserById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", this.mapRow(), id);
    }
}
