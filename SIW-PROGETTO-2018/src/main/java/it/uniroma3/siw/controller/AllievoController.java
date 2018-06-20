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

import it.uniroma3.siw.controller.validator.AllievoValidator;
import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.service.AllievoService;

@Controller
public class AllievoController {
	
	@Autowired
	private AllievoService service;
	
	@Autowired
	private AllievoValidator valid;

	@RequestMapping("/allievi")
	public String allievi(Model model) {
		model.addAttribute("allievi", this.service.findAll());
		return "allievoList";
	}
	
	@RequestMapping("/addAllievo")
	public String addAllievo(Model model) {
		model.addAttribute("allievo", new Allievo());
		return "allievoForm";
	}
	
	@RequestMapping(value = "/allievo/{id}", method = RequestMethod.GET)
	public String getAllievo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("allievo", service.findById(id));
		return "mostraAllievo";
	}
	
	@RequestMapping(value="/allievo", method=RequestMethod.POST)
	public String newAllievo(@Valid @ModelAttribute("allievo") Model model, Allievo allievo, BindingResult bindingResult) {
			this.valid.validate(allievo, bindingResult);
			if(this.service.alreadyExist(allievo)) {
				model.addAttribute("esistente", "questo allievo è già presente nel database");
				return "allievoForm";
			} else {
				if(bindingResult.hasErrors()){
					this.service.save(allievo);
					model.addAttribute("allievo", this.service.findAll());
					return "allievoList";
				}
			}
			return "allievoForm";
	}
}
