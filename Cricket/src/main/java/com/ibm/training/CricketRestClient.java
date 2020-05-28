package com.ibm.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


@Component
public class CricketRestClient {
	
	@Value("${rapidapi.key.name}")
	String apiKeyName;
	
	@Value("${rapidapi.key.value}")
	String apiKeyValue;
	
	@Value("${rapidapi.host.name}")
	String hostName;
	
	@Value("${rapidapi.host.cricket.value}")
	String hostValue;
	
	public String getAllMatches(int compLim,int progLim,int upcomLim) {
		try {
			HttpResponse<String> response = Unirest.get("https://dev132-cricket-live-scores-v1.p.rapidapi.com/matches.php?completedlimit=" + compLim +"&inprogresslimit=" + progLim +"&upcomingLimit=" + upcomLim)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)
					.asString();
			return (response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getMatchesById(int serId,int matId) {
		try {
			HttpResponse<String> response = Unirest.get("https://dev132-cricket-live-scores-v1.p.rapidapi.com/match.php?seriesid=" + serId + "&matchid=" + matId)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)					
					.asString();
			return(response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getPartnership(int serId,int matId,String innId) {
		try {
			HttpResponse<String> response = Unirest.get("https://dev132-cricket-live-scores-v1.p.rapidapi.com/partnerships.php?seriesid=" + serId + "&matchid=" + matId +"&innid=" + innId)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)					
					.asString();
			return(response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getPlayer(int teamId) {
		try {
			HttpResponse<String> response = Unirest.get("https://dev132-cricket-live-scores-v1.p.rapidapi.com/playersbyteam.php?teamid=" + teamId)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)					
					.asString();
			return(response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getScoreCard(int serId,int matId) {
		try {
			HttpResponse<String> response = Unirest.get("https://dev132-cricket-live-scores-v1.p.rapidapi.com/scorecards.php?seriesid=" + serId + "&matchid=" + matId)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)					
					.asString();
			return(response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getTotalSeries() {
		try {
			HttpResponse<String> response = Unirest.get("https://dev132-cricket-live-scores-v1.p.rapidapi.com/series.php")
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)					
					.asString();
			return(response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public String getTeamInSeries(int serId) {
		try {
			HttpResponse<String> response = Unirest.get("https://dev132-cricket-live-scores-v1.p.rapidapi.com/seriesteams.php?seriesid=" + serId)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)					
					.asString();
			return(response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public String getCommentory(int serId,int matId) {
		try {
			HttpResponse<String> response = Unirest.get("https://dev132-cricket-live-scores-v1.p.rapidapi.com/comments.php?seriesid=" + serId + "&matchid=" + matId)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)					
					.asString();
			return(response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getGraph(int serId,int matId) {
		try {
			HttpResponse<String> response = Unirest.get("https://dev132-cricket-live-scores-v1.p.rapidapi.com/graph.php?seriesid=" + serId +"&matchid=" + matId)
					.header(hostName, hostValue)
					.header(apiKeyName, apiKeyValue)					
					.asString();
			return(response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
