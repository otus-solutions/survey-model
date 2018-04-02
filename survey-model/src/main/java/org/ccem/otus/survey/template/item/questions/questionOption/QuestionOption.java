package org.ccem.otus.survey.template.item.questions.questionOption;

import org.ccem.otus.survey.template.item.questions.fillingRules.Options;

import com.google.gson.annotations.SerializedName;

public class QuestionOption {
	@SerializedName("extends")
	public String extents;
	public String objectType;
	public OptionsItem data;
}
