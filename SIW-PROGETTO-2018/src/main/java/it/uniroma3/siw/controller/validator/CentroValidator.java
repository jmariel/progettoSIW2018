package it.uniroma3.siw.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Centro;

@Component
public class CentroValidator implements Validator {

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numMaxAllievi", "campo obbligatorio");
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Centro.class.equals(clazz);
		}
}
