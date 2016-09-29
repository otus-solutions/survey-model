package org.ccem.otus.survey.template;

import java.util.List;

import org.ccem.otus.survey.template.identity.Identity;
import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.metainfo.MetaInfo;
import org.ccem.otus.survey.template.navigation.Navigation;
import org.ccem.otus.survey.template.utils.adapters.SurveyItemAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SurveyTemplate {

	public String extents;
	public String objectType;
	public String oid;
	public Identity identity;
	public MetaInfo metainfo;
	public List<SurveyItem> itemContainer;
	public List<Navigation> navigationList;
	
	public static SurveyTemplate deserialize(String surveyJson) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		Gson gson = builder.create();

		return gson.fromJson(surveyJson, SurveyTemplate.class);
	}

	public static String serialize(SurveyTemplate survey) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		builder.disableHtmlEscaping();
		Gson gson = builder.create();

		return gson.toJson(survey);
	}
	
}
