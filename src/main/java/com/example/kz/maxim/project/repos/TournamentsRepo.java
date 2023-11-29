package com.example.kz.maxim.project.repos;

import com.example.kz.maxim.project.model.Games;
import com.example.kz.maxim.project.model.Players;
import com.example.kz.maxim.project.model.Tournaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TournamentsRepo {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TournamentsRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper <Tournaments> mapRow() {
        return (rs, rowNum) -> {
            Tournaments tournaments = new Tournaments();
            tournaments.setId(rs.getLong("id"));
            tournaments.setName(rs.getString("name"));
            tournaments.setInWhichGame(rs.getString("in_which_game"));
            tournaments.setMoneyWin(rs.getInt("money_win"));
            return tournaments;
        };
    }

    public List<Tournaments> findAll() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM tournaments", this.mapRow());
    }

    public void insert(Tournaments tournaments) {
        jdbcTemplate.update("INSERT INTO tournaments (name, money_win, in_which_game) " +
                "VALUES (?, ?, ?)", tournaments.getName(), tournaments.getMoneyWin(), tournaments.getInWhichGame());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM tournaments WHERE id = ?", id);
    }

    public Tournaments findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tournaments WHERE id = ?", this.mapRow(), id);
    }

    public List <Tournaments> findByAttrName(String name) {
        return jdbcTemplate.query("SELECT * FROM tournaments WHERE name = ?", this.mapRow(), name);
    }

    public List <Tournaments> findByAttrGame(String inWhichGame) {
        return jdbcTemplate.query("SELECT * FROM tournaments WHERE in_which_game = ?", this.mapRow(), inWhichGame);
    }

    public List<Tournaments> findByAttrMoney(Integer moneyWin) {
        return jdbcTemplate.query("SELECT * FROM tournaments WHERE money_win= ?", this.mapRow(), moneyWin);
    }
}
