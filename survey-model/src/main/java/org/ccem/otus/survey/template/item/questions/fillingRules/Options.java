package org.ccem.otus.survey.template.item.questions.fillingRules;

import java.util.HashMap;
import java.util.Map;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.generic.GenericValidator;

public class Options {

	private Map<String, GenericValidator> validators;

	public Options() {
		this.validators = new HashMap<String, GenericValidator>();
	}

	public Map<String, GenericValidator> getValidators() {
		return validators;
	}

	public void addValidator(String validator, GenericValidator genericValidator) {
		validators.put(validator, genericValidator);
	}

}
