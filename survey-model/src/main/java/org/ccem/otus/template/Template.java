package org.ccem.otus.template;

import java.util.List;

import org.ccem.otus.template.identity.Identity;
import org.ccem.otus.template.item.SurveyItem;
import org.ccem.otus.template.metainfo.MetaInfo;
import org.ccem.otus.template.navigation.Navigation;
import org.ccem.otus.template.utils.adapters.SurveyItemAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Template {

	public String extents;
	public String objectType;
	public String oid;
	public Identity identity;
	public MetaInfo metainfo;
	public List<SurveyItem> itemContainer;
	public List<Navigation> navigationList;
	
	public static Template deserialize(String surveyJson) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		Gson gson = builder.create();

		return gson.fromJson(surveyJson, Template.class);
	}

	public static String serialize(Template survey) {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		builder.disableHtmlEscaping();
		Gson gson = builder.create();

		return gson.toJson(survey);
	}
	
}
