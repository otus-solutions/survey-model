package org.ccem.otus.survey;

import java.util.List;

import org.ccem.otus.survey.identity.Identity;
import org.ccem.otus.survey.item.SurveyItem;
import org.ccem.otus.survey.metainfo.MetaInfo;
import org.ccem.otus.survey.navigation.Navigation;
import org.ccem.otus.survey.utils.adapters.SurveyItemAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Survey {

	public String extents;
	public String objectType;
	public String oid;
	public Identity identity;
	public MetaInfo metainfo;
	public List<SurveyItem> itemContainer;
	public List<Navigation> navigationList;
	
	public static Survey deserialize(String surveyJson) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		Gson gson = builder.create();

		return gson.fromJson(surveyJson, Survey.class);
	}

	public static String serialize(Survey survey) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		builder.disableHtmlEscaping();
		Gson gson = builder.create();

		return gson.toJson(survey);
	}

}
