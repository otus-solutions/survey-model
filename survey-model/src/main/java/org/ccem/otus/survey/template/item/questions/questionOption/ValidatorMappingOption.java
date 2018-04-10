package org.ccem.otus.survey.template.item.questions.questionOption;


import org.ccem.otus.survey.template.item.questions.questionOption.validators.DisabledButton;
import org.ccem.otus.survey.template.item.questions.questionOption.validators.GenericOption;

public enum ValidatorMappingOption {
	
	DISABLED_BUTTON(DisabledButton.class, "disabledButton");

	private Class<? extends GenericOption> validator;
	private String type;
	
	private ValidatorMappingOption(Class<? extends GenericOption> validator, String type) {
		this.validator = validator;
		this.type = type;
	}
	
	public Class<? extends GenericOption> getValidatorClass() {
		return validator;
	}

	public String getValidatorType() {
		return type;
	}
	
	public static ValidatorMappingOption getEnumByObjectType(String objectType) {
		ValidatorMappingOption aux = null;
		
		for (ValidatorMappingOption item : values()) {
			if(item.getValidatorType().equals(objectType)) {
				aux = item;
			}
		}
		
		if(aux == null) {
			throw new RuntimeException("Error: " + objectType + " was not found at ValidatorsMappingOption.");
		};
		
		return aux;
	}

}

