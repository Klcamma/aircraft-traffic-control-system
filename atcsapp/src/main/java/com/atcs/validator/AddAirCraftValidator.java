package com.atcs.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.atcs.request.AircraftRequest;

public class AddAirCraftValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return AircraftRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "id", "id.field.required");
        ValidationUtils.rejectIfEmpty(errors, "type", "type.field.required");
        ValidationUtils.rejectIfEmpty(errors, "size", "size.field.required");
	}

}
