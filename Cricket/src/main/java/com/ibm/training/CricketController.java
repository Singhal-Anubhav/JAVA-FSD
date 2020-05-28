package com.ibm.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CricketController {
	
	@Autowired
	CricketRestClient cricketClient;
	
	@RequestMapping("/{compLim}/{progLim}/{upcomLim}/allMatches")
	String allMatchesGet(@PathVariable int compLim,int progLim,int upcomLim) {
		return cricketClient.getAllMatches(compLim, progLim, upcomLim);
	}

}
