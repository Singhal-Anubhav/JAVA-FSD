package com.ibm.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class NBARestClient {
	
	@Value("${rapidapi.NBA.url}")
	String NbaUrl;

	@Value("${rapidapi.key.name}")
	String apiKeyName;
	
	@Value("${rapidapi.key.value}")
	String apiKeyValue;
	
	@Value("${rapidapi.host.name}")
	String hostName;
	
	@Value("${rapidapi.host.NBA.value}")
	String hostValue;
	
	public String getSeasons() {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "seasons/")
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getLeagues() {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "leagues/")
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getTeamById(String teamId) {
	try {
		HttpResponse<String> response = Unirest.get(NbaUrl + "teams/teamId/" + teamId)
				.header(hostName, hostValue)
				.header(apiKeyName, apiKeyValue)
				.asString();
		return (response.getBody());
	} catch (UnirestException e) {
		e.printStackTrace();
	}
	return null;
}
	
	public String getTeamByCity(String city) {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "teams/city/" + city)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getPlayerById(String playerId) {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "players/playerId/" + playerId)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	public String getPlayerByCountry(String country) {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "players/country/" + country)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPlayerByTeamId(String teamId) {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "players/teamId/" + teamId)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getGameBySeasonYear(String seasonYear) {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "games/seasonYear/" + seasonYear)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getGameByDate(String date) {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "games/date/" + date)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public String getGameLive() {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "games/live/")
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getGameDetails(String gameId) {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "gameDetails/" +gameId)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getGameStanding(String league,String year) {
		try {
			HttpResponse<String> response = Unirest.get(NbaUrl + "standings/" +league + "/" + year)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
