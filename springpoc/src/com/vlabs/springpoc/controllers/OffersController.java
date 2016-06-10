package com.vlabs.springpoc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vlabs.springpoc.beans.Offer;
import com.vlabs.springpoc.service.OffersService;

@Controller
public class OffersController {
	@Autowired
	private OffersService service;

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		model.addAttribute("offers", service.getAllOffers());
		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		if (result.hasErrors()) {
			return "createoffer";
		} else {
			service.create(offer);
			return "offercreated";
		}
	}
	
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException e){
		return "error";
	}

}
