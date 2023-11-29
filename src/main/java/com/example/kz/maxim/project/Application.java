package com.example.kz.maxim.project;

import com.example.kz.maxim.project.logaspect.MyAspect;
import com.example.kz.maxim.project.service.ServiceD;
import com.example.kz.maxim.project.servicesql.GamesService;
import com.example.kz.maxim.project.servicesql.PlayersService;
import com.example.kz.maxim.project.servicesql.TeamsService;
import com.example.kz.maxim.project.servicesql.TournamentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		PlayersService playersService = ctx.getBean("playersService", PlayersService.class);
		TeamsService teamsService = ctx.getBean("teamsService", TeamsService.class);
		GamesService gamesService = ctx.getBean("gamesService", GamesService.class);
		TournamentsService tournamentsService = ctx.getBean("tournamentsService", TournamentsService.class);
		log.info("Teams in database: {}", teamsService.getTeams());
		log.info("findTeamById in database: {}", teamsService.findTeamsById(2L));
		log.info("find Teams by country in database: {}", teamsService.findTeamsByCountry("Kaz"));
		log.info("Players in database: {}", playersService.getPlayers());
		log.info("find PlayersById in database: {}", playersService.findPlayersById(1L));
		log.info("find Players by name: {}", playersService.findPlayersByName("s1mple"));
		log.info("Games in database: {}", gamesService.getGames());
		log.info("findGameById in database: {}", gamesService.findGamesById(3L));
		log.info("find Games by country in database: {}", gamesService.findGamesByPickOnline(100000));
		log.info("find Tournaments in database: {} ", tournamentsService.getTournaments());
		log.info("find TournamentsById in database: {}", tournamentsService.findTournamentsById(1L));
		log.info("find Tournaments by money win: {}", tournamentsService.findTournamentsByMoneyWin(1000000));
	}
}
