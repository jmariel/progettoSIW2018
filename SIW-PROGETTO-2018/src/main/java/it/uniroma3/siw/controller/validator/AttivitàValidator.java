package it.uniroma3.siw.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Attività;

@Component
public class AttivitàValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Attività.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataEora", "campo obbligatorio");
	}

}
