package it.uniroma3.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.controller.validator.AttivitàValidator;
import it.uniroma3.siw.model.Attività;
import it.uniroma3.siw.service.AttivitàService;

@Controller
public class AttivitaController {
	@Autowired
	private AttivitàService service;
	
	@Autowired
	private AttivitàValidator valid;
	
	@RequestMapping("/attività")
	public String activities(Model model) {
		model.addAttribute("activities", this.service.findAll());
		return "attivitàList";
	}
	
	@RequestMapping("/addAttività")
	public String addAttività(Model model) {
		model.addAttribute("attività", new Attività());
		return "attivitàForm";
	}

	@RequestMapping(value="/attivita/{id}", method = RequestMethod.GET)
	public String getAttività(@PathVariable("id") Long id, Model model) {
		model.addAttribute("attività", this.service.findById(id));
		return "mostraAttività";
	}
	
	@RequestMapping(value="/attività", method=RequestMethod.POST)
	public String newAttività(@Valid @ModelAttribute("attività") Model model, Attività attività, BindingResult bindingResult) {
			this.valid.validate(attività, bindingResult);
			if(this.service.alreadyExist(attività)) {
				model.addAttribute("esistente", "questa attività è già presente nel database");
				return "attivitàForm";
			} else {
				if(bindingResult.hasErrors()){
					this.service.save(attività);
					model.addAttribute("attività", this.service.findAll());
					return "attivitàList";
				}
			}
			return "attivitàForm";
	}
}
