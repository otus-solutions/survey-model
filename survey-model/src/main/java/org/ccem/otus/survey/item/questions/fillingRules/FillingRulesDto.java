package org.ccem.otus.survey.item.questions.fillingRules;

import com.google.gson.annotations.SerializedName;

public class FillingRulesDto {
	
	@SerializedName("extends")
	public String extents;
	public String objectType;
	public OptionsDto options;

}
