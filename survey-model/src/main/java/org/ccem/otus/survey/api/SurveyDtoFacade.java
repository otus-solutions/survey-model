package org.ccem.otus.survey.api;

import org.ccem.otus.survey.SurveyDto;
import org.ccem.otus.survey.item.SurveyItemDto;
import org.ccem.otus.survey.utils.adapters.SurveyItemAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SurveyDtoFacade {

	public static SurveyDto deserialize(String surveyJson) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItemDto.class, new SurveyItemAdapter());
		Gson gson = builder.create();

		return gson.fromJson(surveyJson, SurveyDto.class);
	}

	public static String serialize(SurveyDto surveyDto) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItemDto.class, new SurveyItemAdapter());
		builder.disableHtmlEscaping();
		Gson gson = builder.create();

		return gson.toJson(surveyDto);
	}

}
