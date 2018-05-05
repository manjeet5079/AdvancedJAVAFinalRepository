package com.praveen.action;

import com.praveen.service.TutorialFinderService;

public class TutorialAction {
	private String bestTutorialSite;
	private String language;

	public String execute() {
		TutorialFinderService tutfs = new TutorialFinderService();
		setBestTutorialSite(tutfs.getBestTutorialSite(language));
		return "success";
	}

	public String getBestTutorialSite() {
		return bestTutorialSite;
	}

	public void setBestTutorialSite(String bestTutorialSite) {
		this.bestTutorialSite = bestTutorialSite;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
