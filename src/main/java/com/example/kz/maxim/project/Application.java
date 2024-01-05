package com.example.kz.maxim.project;


import com.example.kz.maxim.project.service.GameService;
import com.example.kz.maxim.project.service.PlayerService;
import com.example.kz.maxim.project.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories("com.example.kz.maxim.project.repo")
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		PlayerService playersService = ctx.getBean("playerService", PlayerService.class);
		TeamService teamsService = ctx.getBean("teamService", TeamService.class);
		GameService gamesService = ctx.getBean("gameService", GameService.class);
		log.info("Players in a list: {}", playersService.list());
		log.info("Players findByNameContainingIgnoreCase: {}", playersService.findByNameContainingIgnoreCase("Zhangir"));
		log.info("Players in retrieveByName: {}", playersService.retrieveByName("Max"));
		log.info("Players in findAllPlayersNative: {}", playersService.findAllPlayersNative());
		log.info("Players in listSort: {}", playersService.listSort());

		log.info("Teams in a list: {}", teamsService.list());
		log.info("Teams findByNameContainingIgnoreCase: {}", teamsService.findByNameContainingIgnoreCase("Real"));
		log.info("Teams in retrieveByName: {}", teamsService.retrieveByName("Barcelona"));
		log.info("Teams in findAllTeamsNative: {}", teamsService.findAllTeamNative());
		log.info("Teams in listSort: {}", teamsService.listSort());

		log.info("Games in a list: {}", gamesService.list());
		log.info("Games findByNameContainingIgnoreCase: {}", gamesService.findByNameContainingIgnoreCase("CS:GO"));
		log.info("Games in retrieveByName: {}", gamesService.retrieveByName("Dota 2"));
		log.info("Games in findAllPlayersNative: {}", gamesService.findAllGameNative());
		log.info("Games in listSort: {}", gamesService.listSort());

	}
}
