package org.ccem.otus.survey;

import org.ccem.otus.template.Template;
import org.ccem.otus.template.item.SurveyItem;
import org.ccem.otus.template.utils.adapters.SurveyItemAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Survey {
	
	public Template template;
	
	public String sender;
	public String sendingDate;
	public String templateType;
	
	public static String serialize(Survey survey) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		builder.disableHtmlEscaping();
		Gson gson = builder.create();

		return gson.toJson(survey);
	}
	
	public static Survey deserialize(String surveyJson) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		Gson gson = builder.create();

		return gson.fromJson(surveyJson, Survey.class);
	}


}
