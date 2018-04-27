package org.ccem.otus.survey.form;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.ccem.otus.survey.template.SurveyTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SurveyForm {

	private static final String SURVEY_FORM = "SurveyForm";
	private String sender;
	private LocalDateTime sendingDate;
	private String objectType;
	private SurveyFormType surveyFormType;
	private SurveyTemplate surveyTemplate;
	private Integer version;
	private Boolean isDiscarded;

	public SurveyForm(SurveyTemplate surveyTemplate, String userEmail) {
		this.surveyTemplate = surveyTemplate;
		this.sender = userEmail;
		this.sendingDate = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC"));
		this.surveyFormType = SurveyFormType.FORM_INTERVIEW;
		this.objectType = SURVEY_FORM;
		this.isDiscarded = false;
	}

	public SurveyTemplate getSurveyTemplate() {
		return surveyTemplate;
	}

	public LocalDateTime getSendingDate() {
		return sendingDate;
	}

	public String getObjectType() {
		return objectType;
	}

	public SurveyFormType getSurveyTemplateType() {
		return surveyFormType;
	}

	public void setSurveyTemplateType(SurveyFormType surveyTemplateType) {
		this.surveyFormType = surveyTemplateType;
	}

	public String getSender() {
		return sender;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public static String serialize(SurveyForm survey) {
		Gson gson = getGsonBuilder().create();

		return gson.toJson(survey);
	}

	public static SurveyForm deserialize(String surveyJson) {
		return getGsonBuilder().create().fromJson(surveyJson, SurveyForm.class);
	}

	public static String serialize(List<SurveyForm> surveyforms) {
		return getGsonBuilder().create().toJson(surveyforms);
	}

	/**
	 * @return a GsonBuilder instance of SurveyTemplate.class
	 * {@link org.ccem.otus.survey.template.SurveyTemplate#getGsonBuilder()}
	 */
	public static GsonBuilder getGsonBuilder() {
		GsonBuilder builder = SurveyTemplate.getGsonBuilder();
		builder.serializeNulls();
		return builder;
	}

}
