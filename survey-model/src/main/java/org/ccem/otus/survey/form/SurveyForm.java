package org.ccem.otus.survey.form;

import java.util.Date;
import java.util.List;

import org.ccem.otus.survey.template.SurveyTemplate;
import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.item.questions.fillingRules.Options;
import org.ccem.otus.survey.template.utils.adapters.DateAdapter;
import org.ccem.otus.survey.template.utils.adapters.OptionsAdapter;
import org.ccem.otus.survey.template.utils.adapters.SurveyItemAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author fagner
 *
 */
/**
 * @author fagner
 *
 */
public class SurveyForm {

	private static final String SURVEY_FORM = "SurveyForm";
	private String sender;
	private Date sendingDate;
	private String objectType;
	private SurveyFormType surveyFormType;
	private SurveyTemplate surveyTemplate;

	public SurveyForm(SurveyTemplate surveyTemplate, String userEmail) {
		this.surveyTemplate = surveyTemplate;
		this.sender = userEmail;
		this.sendingDate = new Date();
		this.surveyFormType = SurveyFormType.FORM_INTERVIEW;
		this.objectType = SURVEY_FORM;
	}

	public SurveyTemplate getSurveyTemplate() {
		return surveyTemplate;
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

	public Date getSendingDate() {
		return sendingDate;
	}

	public String getSender() {
		return sender;
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
	 * @return a GsonBuilder instance with SurveyItemAdapter, DateAdapter and
	 *         OptionsAdapter registered and also disableHtmlEscaping option.
	 */
	public static GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();

		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		builder.registerTypeAdapter(Date.class, new DateAdapter());
		builder.registerTypeAdapter(Options.class, new OptionsAdapter());
		builder.disableHtmlEscaping();

		return builder;
	}

}
