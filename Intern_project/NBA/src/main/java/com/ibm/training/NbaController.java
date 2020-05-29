package com.ibm.training;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class NbaController {
	
	@Autowired
	NBARestClient nbaClient;
	
	@RequestMapping("/seasons")
	String seasonsGet() {
		return nbaClient.getSeasons();
	}
	
	@RequestMapping("/leagues")
	String leaguesGet() {
		return nbaClient.getLeagues();
	}
	
	@RequestMapping("/teamById/{teamId}")
	 String TeamByIdGet(@PathVariable String teamId) {
		return nbaClient.getTeamById(teamId);
	}
	
	@RequestMapping("/teamByCity/{city}")
	String TeamByCityGet(@PathVariable String city) {
		return nbaClient.getTeamByCity(city);
	}
	
	@RequestMapping("/playerById/{playerId}")
	String playerByIdGet(@PathVariable String playerId) {
		return nbaClient.getPlayerById(playerId);
	}
	
	@RequestMapping("/playerByCountry/{country}")
	String playerByCountryGet(@PathVariable String country) {
		return nbaClient.getPlayerByCountry(country);
	}
	
	@RequestMapping("/playerByTeamId/{teamId}")
	String playerByTeamIdGet(@PathVariable String teamId) {
		return nbaClient.getPlayerByTeamId(teamId);
	}
	
	@RequestMapping("/gameBySeasonYear/{seasonYear}")
	String gameBySeasonYearGet(@PathVariable String seasonYear) {
		return nbaClient.getGameBySeasonYear(seasonYear);
	}
	
	@RequestMapping("/gameByDate/{date}")
	String gameByDateGet(@PathVariable String date) {
		return nbaClient.getGameByDate(date);
	}
	
	@RequestMapping("/gameLive")
	String gameLiveGet() {
		return nbaClient.getGameLive();
	}
	
	@RequestMapping("/gameDetails/{gameId}")
	String gameDetails(@PathVariable String gameId) {
		return nbaClient.getGameDetails(gameId);
	}
	
	@RequestMapping("/gameStanding/{league}/{year}")
	String gameStanding(@PathVariable String league, @PathVariable String year) {
		return nbaClient.getGameStanding(league, year);
	}
	
	
	
	
	
	

}
