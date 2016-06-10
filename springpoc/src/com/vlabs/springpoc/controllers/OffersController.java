package com.vlabs.springpoc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vlabs.springpoc.beans.Offer;
import com.vlabs.springpoc.service.OffersService;

@Controller
public class OffersController {
	@Autowired
	private OffersService service;
	
	@RequestMapping("/offers")
	public String showOffers(Model model){
		model.addAttribute("offers", service.getAllOffers());
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(){
		return "createoffer";
	}
	
	@RequestMapping(value = "/docreate", method= RequestMethod.POST)
	public String doCreate(Model model, Offer offer){
		System.out.println(offer);
		return "offercreated";
	}


}
