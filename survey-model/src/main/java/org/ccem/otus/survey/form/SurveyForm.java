package org.ccem.otus.survey.form;

import java.util.Date;

import org.ccem.otus.survey.template.SurveyTemplate;
import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.utils.adapters.SurveyItemAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SurveyForm {

	private String sender;
	private Date sendingDate;
	private SurveyFormType surveyFormType;
	private SurveyTemplate surveyTemplate;

	public SurveyForm(SurveyTemplate surveyTemplate, String userEmail) {
		this.surveyTemplate = surveyTemplate;
		this.sender = userEmail;
		this.sendingDate = new Date();
		this.surveyFormType = SurveyFormType.FORM_INTERVIEW;
	}

	public SurveyTemplate getSurveyTemplate() {
		return surveyTemplate;
	}

	public SurveyFormType getSurveyTemplateType() {
		return surveyFormType;
	}

	public void setSurveyTemplateType(SurveyFormType surveyTemplateType) {
		this.surveyFormType = surveyTemplateType;
	}

	public Date getSendingDate() {
		return sendingDate;
	}

	public String getSender() {
		return sender;
	}

	public static String serialize(SurveyForm survey) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		builder.disableHtmlEscaping();
		Gson gson = builder.create();

		return gson.toJson(survey);
	}

	public static SurveyForm deserialize(String surveyJson) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		Gson gson = builder.create();

		return gson.fromJson(surveyJson, SurveyForm.class);
	}

}
