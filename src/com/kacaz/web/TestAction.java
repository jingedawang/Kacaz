package com.kacaz.web;

import org.springframework.stereotype.Controller;

@Controller
public class TestAction {
	
	public String createActivity() {
		return "createActivity";
	}
	
	public String home() {
		return "home";
	}
	
	public String edit() {
		return "edit";
	}
	
	public String participatedActivities() {
		return "participatedActivities";
	}
	
	public String heldActivities() {
		return "heldActivities";
	}
	
	public String activities() {
		return "activities";
	}
	
	public String moments() {
		return "moments";
	}
	
	public String createMoment() {
		return "createMoment";
	}
	
	public String sb() {
		return "sb";
	}
}
