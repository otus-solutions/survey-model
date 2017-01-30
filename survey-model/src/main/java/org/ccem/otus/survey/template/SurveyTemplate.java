package org.ccem.otus.survey.template;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.ccem.otus.survey.template.identity.Identity;
import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.item.questions.fillingRules.Options;
import org.ccem.otus.survey.template.item.questions.selectable.CheckboxQuestion;
import org.ccem.otus.survey.template.metainfo.MetaInfo;
import org.ccem.otus.survey.template.navigation.Navigation;
import org.ccem.otus.survey.template.utils.adapters.DateAdapter;
import org.ccem.otus.survey.template.utils.adapters.OptionsAdapter;
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
    
    public List<String> getCustomIdItems() {
        return itemContainer.stream()
                .map(item -> item.customID)
                .collect(Collectors.toList());
    }

    public List<String> getCustomIdOptions() {
        return itemContainer.stream()
                .filter(item -> item instanceof CheckboxQuestion)
                .flatMap(item -> ((CheckboxQuestion) item).options.stream())
                .map(option -> option.customOptionID)
                .collect(Collectors.toList());
    }

    public Set<String> getCustomIds(){
        Set<String> customIds = new HashSet<>();
        customIds.addAll(getCustomIdItems());
        customIds.addAll(getCustomIdOptions());
        return customIds;
    }

    public static SurveyTemplate deserialize(String surveyJson) {
        Gson builder = SurveyTemplate.getGsonBuilder();
        return builder.fromJson(surveyJson, SurveyTemplate.class);
    }

    public static String serialize(SurveyTemplate survey) {
        Gson builder = SurveyTemplate.getGsonBuilder();
        return builder.toJson(survey);
    }

    private static Gson getGsonBuilder(){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Options.class, new OptionsAdapter());
        builder.registerTypeAdapter(Date.class, new DateAdapter());
        builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
        builder.disableHtmlEscaping();
        return builder.create();
    }

}
