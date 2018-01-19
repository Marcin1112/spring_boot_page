package com.zabadaj.marcin.zabadaj.marcin.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zabadaj.marcin.zabadaj.marcin.model.Box;
import com.zabadaj.marcin.zabadaj.marcin.model.Reagent;
import com.zabadaj.marcin.zabadaj.marcin.services.BoxRepositoryService;
import com.zabadaj.marcin.zabadaj.marcin.services.EmailSender;
import com.zabadaj.marcin.zabadaj.marcin.services.ReagentsRepositoryService;

@Controller
public class MainController {

	@Autowired
	ReagentsRepositoryService reagentsRepositoryService;

	@Autowired
	BoxRepositoryService boxRepositoryService;

	@Autowired
	EmailSender emailSender;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mainPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/about_me", method = RequestMethod.GET)
	public ModelAndView aboutMe() {
		ModelAndView model = new ModelAndView();
		model.setViewName("about_me");
		return model;
	}

	@RequestMapping(value = "/contact_me", method = RequestMethod.GET)
	public ModelAndView contactMe() {
		ModelAndView model = new ModelAndView();
		model.setViewName("contact_me");
		return model;
	}

	@RequestMapping(value = "/publications", method = RequestMethod.GET)
	public ModelAndView publications() {
		ModelAndView model = new ModelAndView();
		model.setViewName("publications");
		return model;
	}

	@RequestMapping(value = "/reagents", method = RequestMethod.GET)
	public ModelAndView reagents() {
		ModelAndView model = new ModelAndView();
		model.setViewName("reagents");
		return model;
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/reagents_edit", method = RequestMethod.GET)
	public ModelAndView findOneReagent() {
		ModelAndView model = new ModelAndView();
		model.setViewName("reagents_edit");
		return model;
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/reagents_new", method = RequestMethod.GET)
	public ModelAndView addNewReagent() {
		ModelAndView model = new ModelAndView();
		model.setViewName("reagents_new");
		return model;
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/reagents_delete", method = RequestMethod.GET)
	public ModelAndView deleteReagent() {
		ModelAndView model = new ModelAndView();
		model.setViewName("reagents_delete");
		return model;
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "finish", method = RequestMethod.POST)
	public String updateReagent(@RequestParam("id") String id, @RequestParam("name1") String name,
			@RequestParam("manufacturer") String manufacturer, @RequestParam("purity") String purity,
			@RequestParam("amount") String amount, @RequestParam("volume") String volume,
			@RequestParam("comment") String comment, @RequestParam("box") String box) {
		Reagent reagent = reagentsRepositoryService.getOne(id);
		reagent.setAmount(amount);
		reagent.setComment(comment);
		reagent.setManufacturer(manufacturer);
		reagent.setName(name);
		reagent.setPurity(purity);
		reagent.setVolume(volume);

		Box foundedBox = boxRepositoryService.findByName(box);
		reagent.setBox(foundedBox);
		reagentsRepositoryService.updateReagent(reagent);

		return "redirect:/#!/reagents";
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "reagents_delete", method = RequestMethod.POST)
	public String deleteReagent(@RequestParam("id") String id) {
		Reagent reagent = reagentsRepositoryService.getOne(id);

		reagentsRepositoryService.deleteReagent(reagent);

		return "redirect:/#!/reagents";
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String addNewReagent(@RequestParam("name1") String name, @RequestParam("manufacturer") String manufacturer,
			@RequestParam("purity") String purity, @RequestParam("amount") String amount,
			@RequestParam("volume") String volume, @RequestParam("comment") String comment,
			@RequestParam("box") String box) {
		Reagent reagent = new Reagent();
		reagent.setAmount(amount);
		reagent.setComment(comment);
		reagent.setManufacturer(manufacturer);
		reagent.setName(name);
		reagent.setPurity(purity);
		reagent.setVolume(volume);

		Box foundedBox = boxRepositoryService.findByName(box);
		reagent.setBox(foundedBox);
		reagentsRepositoryService.save(reagent);

		return "redirect:/#!/reagents";
	}

	@RequestMapping(value = "send", method = RequestMethod.POST)
	public String contactMePost(@RequestParam("nameAndSurname") String nameAndSurname,
			@RequestParam("email") String email, @RequestParam("topic") String topic,
			@RequestParam("content") String content) {
		String message = "e-mail: " + email + "\nName and Surname: " + nameAndSurname + "\n\n" + content;
		emailSender.sendEmail("zabadajmarcin@gmail.com", topic, message);
		return "redirect:/#!/contact_me";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
}
