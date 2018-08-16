package com.atcs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atcs.model.Aircraft;
import com.atcs.request.AircraftRequest;

@Controller
public class AircraftsViewController {

	@Autowired
	com.atcs.service.IAtcsService atcsService;
	
	public com.atcs.service.IAtcsService getAtcsService() {
		return atcsService;
	}

	public void setAtcsService(com.atcs.service.IAtcsService atcsService) {
		this.atcsService = atcsService;
	}

	@RequestMapping(value = "/showAircrafts", method = RequestMethod.GET)
	public String showAircrafts(Model model) {
		SortedSet<Aircraft> sortedSet = atcsService.showAircrafts();
		List<AircraftRequest> airCraftsList = buldRequestObjectFromModel(sortedSet);
		if(airCraftsList.size() > 0) {
			model.addAttribute("airCraftsList", airCraftsList);
		}else {
			model.addAttribute("msg", "No Aircrafts listed");
		}
		return "displayAircrafts";
	}

	private List<AircraftRequest> buldRequestObjectFromModel(SortedSet<Aircraft> aircraftSet) {
		List<AircraftRequest> aircraftRequests = new ArrayList<>();
		for (Aircraft aircraft : aircraftSet) {
			AircraftRequest aircraftRequest = new AircraftRequest();
			aircraftRequest.setId(aircraft.getId());
			aircraftRequest.setType(aircraft.getType().getType());
			aircraftRequest.setSize(aircraft.getSize().getSize());
			aircraftRequests.add(aircraftRequest);
		}
		return aircraftRequests;
	}
}
