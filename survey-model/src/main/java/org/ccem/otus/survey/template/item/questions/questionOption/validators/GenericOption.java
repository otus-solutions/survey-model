package org.ccem.otus.survey.template.item.questions.questionOption.validators;

import com.google.gson.annotations.SerializedName;

public abstract class GenericOption {
	@SerializedName("extends")
	public String extents;
	public String objectType;
	public String name;
	public String value;
}
