package com.atcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.atcs.request.AircraftRequest;
import com.atcs.validator.DeleteAirCraftValidator;

@Controller
public class AtcsDeleteController {

	@Autowired
	com.atcs.service.IAtcsService atcsService;
	
	public com.atcs.service.IAtcsService getAtcsService() {
		return atcsService;
	}

	public void setAtcsService(com.atcs.service.IAtcsService atcsService) {
		this.atcsService = atcsService;
	}
		
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new DeleteAirCraftValidator());
	}
	
	@GetMapping("/deleteAircraftForm")
	public String deleteAircraftForm(Model model) {
		AircraftRequest aircraftRequest = new AircraftRequest();
		model.addAttribute("aircraftRequest", aircraftRequest);
		return "deleteAircraftForm";
	}
	
	@RequestMapping(value = "/deleteAircraft", method = RequestMethod.POST)
	public String deleteAircraft(@ModelAttribute("aircraftRequest") @Validated AircraftRequest aircraftRequest,
			BindingResult bidingResult, Model model) {
		if (bidingResult.hasErrors()) {
			return "deleteAircraftForm";
		}
		boolean isdeleted = atcsService.deQueueAircraft(aircraftRequest.getId());
		if(!isdeleted) {
			model.addAttribute("msg", "Aircraft Id " + aircraftRequest.getId() + " is Invalid, Please enter valid one");
			return "deleteAircraftForm";
		}
		model.addAttribute("msg", "Aircraft " + aircraftRequest.getId() + " DeQueued SuccessFully");
		return "index";
	}
}
