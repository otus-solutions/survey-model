package org.ccem.otus.template.item.questions.fillingRules.validators.generic;

import com.google.gson.annotations.SerializedName;

public abstract class GenericValidator {
	
	@SerializedName("extends")
	public String extents;
	public String objectType;
	public String validatorType;
	
}
