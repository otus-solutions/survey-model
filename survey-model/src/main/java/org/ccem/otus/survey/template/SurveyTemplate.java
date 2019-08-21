package org.ccem.otus.survey.template;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.ccem.otus.survey.datasource.DataSourceDefinition;
import org.ccem.otus.survey.staticVariable.StaticVariableDefinition;
import org.ccem.otus.survey.template.identity.Identity;
import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.item.questions.fillingRules.Options;
import org.ccem.otus.survey.template.item.questions.questionOption.OptionsItem;
import org.ccem.otus.survey.template.item.questions.selectable.CheckboxQuestion;
import org.ccem.otus.survey.template.item.surveyItemGroup.SurveyItemGroupManager;
import org.ccem.otus.survey.template.metainfo.MetaInfo;
import org.ccem.otus.survey.template.navigation.Navigation;
import org.ccem.otus.survey.template.utils.adapters.ImmutableDateAdapter;
import org.ccem.otus.survey.template.utils.adapters.InstantAdapter;
import org.ccem.otus.survey.template.utils.adapters.LocalDateTimeAdapter;
import org.ccem.otus.survey.template.utils.adapters.OptionsAdapter;
import org.ccem.otus.survey.template.utils.adapters.OptionsItemAdapter;
import org.ccem.otus.survey.template.utils.adapters.SurveyItemAdapter;
import org.ccem.otus.survey.template.utils.date.ImmutableDate;

import com.google.gson.GsonBuilder;

public class SurveyTemplate {

  public String extents;
  public String objectType;
  public String oid;
  public Identity identity;
  public MetaInfo metainfo;
  public List<DataSourceDefinition> dataSources;
  public List<StaticVariableDefinition> staticVariableList;
  public List<SurveyItemGroupManager> surveyItemGroupManagerlist;
  public List<SurveyItem> itemContainer;
  public List<Navigation> navigationList;

  public List<String> getCustomIdItems() {
    return itemContainer.stream().map(item -> item.customID).collect(Collectors.toList());
  }

  public List<String> getCustomIdOptions() {
    // TODO: 28/09/17 include grid issues in this list! Use getExtractionIDs method from SurveyItem
    return itemContainer.stream().filter(item -> item instanceof CheckboxQuestion)
        .flatMap(item -> ((CheckboxQuestion) item).options.stream()).map(option -> option.customOptionID)
        .collect(Collectors.toList());
  }

  public Set<String> getCustomIds() {
    Set<String> customIds = new HashSet<>();
    customIds.addAll(getCustomIdItems());
    customIds.addAll(getCustomIdOptions());
    return customIds;
  }

  public Map<String, String> mapTemplateAndCustomIDS() {
    Map<String, String> templateMap = new HashMap<>();
    itemContainer.forEach(surveyItem -> {
      templateMap.putAll(surveyItem.mapIDS());
    });
    return templateMap;
  }

  public Optional<SurveyItem> findSurveyItem(String templateID) {
    return itemContainer.stream().filter(surveyItem -> surveyItem.templateID.equals(templateID)).findFirst();
  }

  public static SurveyTemplate deserialize(String surveyJson) {
    return getGsonBuilder().create().fromJson(surveyJson, SurveyTemplate.class);
  }

  public static String serialize(SurveyTemplate survey) {
    return getGsonBuilder().create().toJson(survey);
  }

  /**
   * @return a GsonBuilder instance with SurveyItemAdapter, LocalDateTimeAdapter,
   *         InstantAdapter, ImmutableDateAdapter and OptionsAdapter registered
   *         and also disableHtmlEscaping option.
   */
  public static GsonBuilder getGsonBuilder() {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
    builder.registerTypeAdapter(Instant.class, new InstantAdapter());
    builder.registerTypeAdapter(OptionsItem.class, new OptionsItemAdapter());
    builder.registerTypeAdapter(Options.class, new OptionsAdapter());
    builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter());
    builder.registerTypeAdapter(ImmutableDate.class, new ImmutableDateAdapter());
    builder.disableHtmlEscaping();
    return builder;
  }

}
