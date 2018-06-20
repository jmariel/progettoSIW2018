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

import it.uniroma3.siw.controller.validator.CentroValidator;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.service.CentroService;

@Controller
public class CentroController {
	@Autowired
	private CentroService service;
	
	@Autowired
	private CentroValidator valid;
	
	@RequestMapping("/centri")
	public String centri(Model model) {
		model.addAttribute("centri", this.service.findAll());
		return "centroList";
	}
	
	@RequestMapping("/addCentro")
	public String addCentro(Model model) {
		model.addAttribute("centro", new Centro());
		return "centroForm";
	}
	
	@RequestMapping(value = "/centro/{id}", method = RequestMethod.GET)
	public String getCentro(@PathVariable("id") Long id, Model model) {
		model.addAttribute("centro", service.findById(id));
		return "mostraCentro";
	}
	
	@RequestMapping(value="/centro", method=RequestMethod.POST)
	public String newCentro(@Valid @ModelAttribute("centro") Model model, Centro centro, BindingResult bindingResult) {
			this.valid.validate(centro, bindingResult);
			if(this.service.alreadyExist(centro)) {
				model.addAttribute("esistente", "questo centro è già presente nel database");
				return "centroForm";
			} else {
				if(bindingResult.hasErrors()){
					this.service.save(centro);
					model.addAttribute("centro", this.service.findAll());
					return "centroList";
				}
			}
			return "centroForm";
	}
}
