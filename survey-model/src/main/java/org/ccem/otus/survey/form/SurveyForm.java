package org.ccem.otus.survey.form;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import org.ccem.otus.survey.template.SurveyTemplate;

import com.google.gson.Gson;
import org.bson.types.ObjectId;
import com.google.gson.GsonBuilder;
import org.ccem.otus.survey.template.utils.adapters.ObjectIdToStringAdapter;

public class SurveyForm {

	private static final String SURVEY_FORM = "SurveyForm";
	@SerializedName("_id")
	private ObjectId surveyID;
	private String sender;
	private LocalDateTime sendingDate;
	private String objectType;
	private SurveyFormType surveyFormType;
	private SurveyTemplate surveyTemplate;
	private String name;
	private String acronym;
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

	public ObjectId getSurveyID() {
		return surveyID;
	}

	public void setSurveyID(ObjectId surveyID) {
		this.surveyID = surveyID;
	}

	public SurveyTemplate getSurveyTemplate() {
		return surveyTemplate;
	}

	public void setSurveyTemplate(SurveyTemplate surveyTemplate) {
		this.surveyTemplate = surveyTemplate;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getAcronym() {
		return acronym;
	}

	public String getName() {
		return name;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Boolean getDiscarded() {
		return isDiscarded;
	}

	public void setDiscarded(Boolean discarded) {
		isDiscarded = discarded;
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
		builder.registerTypeAdapter(ObjectId.class, new ObjectIdToStringAdapter());
		builder.serializeNulls();
		return builder;
	}
}
