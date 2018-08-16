package com.atcs.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.atcs.model.Aircraft;
import com.atcs.model.AircraftSize;
import com.atcs.model.AircraftType;
import com.atcs.request.AircraftRequest;
import com.atcs.validator.AddAirCraftValidator;

@Controller
public class AirCraftAddController {

	@Autowired
	private com.atcs.service.IAtcsService atcsService;

	private Map<String, String> airCraftTypes;

	private Map<String, String> airCraftSizes;

	@PostConstruct
	public void init() {
		buildAirCraftTypes();
		buildAircraftSizes();
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new AddAirCraftValidator());
	}

	@GetMapping("/addAircraftForm")
	public String addAircraftForm(Model model) {
		AircraftRequest aircraftRequest = new AircraftRequest();
		model.addAttribute("aircraftRequest", aircraftRequest);
		model.addAttribute("airCraftTypes", airCraftTypes);
		model.addAttribute("airCraftSizes", airCraftSizes);
		return "addAircraftForm";
	}

	@PostMapping(value = "/addAircraft")
	public String addAircraft(@ModelAttribute("aircraftRequest") @Validated AircraftRequest aircraftRequest,
			BindingResult bidingResult, Model model) {
		if (bidingResult.hasErrors()) {
			model.addAttribute("airCraftTypes", airCraftTypes);
			model.addAttribute("airCraftSizes", airCraftSizes);
			return "addAircraftForm";
		}
		boolean isAdded = atcsService.queueAircraft(buildModelFromRequest(aircraftRequest));
		if (!isAdded) {
			model.addAttribute("airCraftTypes", airCraftTypes);
			model.addAttribute("airCraftSizes", airCraftSizes);
			model.addAttribute("msg", "Aircraft " + aircraftRequest.getId() + " Already Presented in List");
			return "addAircraftForm";
		}
		model.addAttribute("msg", "Aircraft " + aircraftRequest.getId() + " EnQueued SuccessFully");
		return "index";
	}

	private Aircraft buildModelFromRequest(AircraftRequest aircraftRequest) {
		Aircraft aircraft = new Aircraft();
		aircraft.setId(aircraftRequest.getId());
		buildAircraftType(aircraftRequest, aircraft);
		buildAircraftSize(aircraftRequest, aircraft);
		return aircraft;
	}

	private void buildAircraftSize(AircraftRequest aircraftRequest, Aircraft aircraft) {
		if (aircraftRequest.getSize().equals("Large")) {
			aircraft.setSize(AircraftSize.Large);
		} else if (aircraftRequest.getSize().equals("Small")) {
			aircraft.setSize(AircraftSize.Small);
		}
	}

	private void buildAircraftType(AircraftRequest aircraftRequest, Aircraft aircraft) {
		if (aircraftRequest.getType().equals("Emergency")) {
			aircraft.setType(AircraftType.Emergency);
		} else if (aircraftRequest.getType().equals("VIP")) {
			aircraft.setType(AircraftType.VIP);
		} else if (aircraftRequest.getType().equals("Passenger")) {
			aircraft.setType(AircraftType.Passenger);
		} else if (aircraftRequest.getType().equals("Cargo")) {
			aircraft.setType(AircraftType.Cargo);
		}
	}

	private void buildAircraftSizes() {
		airCraftSizes = new LinkedHashMap<String, String>();
		airCraftSizes.put("", "---Select Value---");
		airCraftSizes.put("Large", "Large");
		airCraftSizes.put("Small", "Small");
	}

	private void buildAirCraftTypes() {
		airCraftTypes = new LinkedHashMap<String, String>();
		airCraftTypes.put("", "---Select Value---");
		airCraftTypes.put("Emergency", "Emergency");
		airCraftTypes.put("VIP", "VIP");
		airCraftTypes.put("Passenger", "Passenger");
		airCraftTypes.put("Cargo", "Cargo");
	}

	public com.atcs.service.IAtcsService getAtcsService() {
		return atcsService;
	}

	public void setAtcsService(com.atcs.service.IAtcsService atcsService) {
		this.atcsService = atcsService;
	}

}
