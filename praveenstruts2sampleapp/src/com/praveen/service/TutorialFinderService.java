package com.praveen.service;

public class TutorialFinderService {

	public String getBestTutorialSite(String language) {
		if(language.equalsIgnoreCase("java")) {
		  return "http://praveenoruganti.wikidot.com";
		}else {
			return "language not supported yet!";
		}
	}
}
