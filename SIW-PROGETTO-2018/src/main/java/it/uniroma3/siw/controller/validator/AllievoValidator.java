package it.uniroma3.siw.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Allievo;

@Component
public class AllievoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Allievo.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataDiNascita", "campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoDiNascita", "campo obbligatorio");
	}

}
