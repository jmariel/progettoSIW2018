package it.uniroma3.siw.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Allievo;

public class AllievoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Allievo.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors e) {
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nome", "campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "cognome", "campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "dataDiNascita", "campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "luogoDiNascita", "campo obbligatorio");
	}

}
