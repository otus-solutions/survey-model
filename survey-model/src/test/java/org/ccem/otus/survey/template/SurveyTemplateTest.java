package org.ccem.otus.survey.template;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.ccem.otus.survey.template.identity.Identity;
import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.item.questions.selectable.CheckboxQuestion;
import org.ccem.otus.survey.template.item.questions.selectable.options.CheckboxOption;
import org.ccem.otus.survey.template.metainfo.MetaInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class SurveyTemplateTest {
  private SurveyTemplate survey;
  private SurveyTemplate surveyWithGridCustomIds;

  @Before
  public void setUp() {
    String json = ""
      + "{\"extents\": \"StudioObject\","
      + "\"objectType\": \"Survey\","
      + "\"oid\": \"dXNlclVVSUQ6W3VuZGVmaW5lZF1zdXJ2ZXlVVUlEOls3MDZlMTE2MC02M2I5LTExZTYtOWJjNy0xNWVhN2RkZDA4NTZdcmVwb3NpdG9yeVVVSUQ6WyBOb3QgZG9uZSB5ZXQgXQ==\","
      + "\"identity\": {},"
      + "\"metainfo\": {},"
      + "\"staticVariableList\": [],"
      + "\"surveyItemGroupList\": [],"
      + "\"itemContainer\": [],"
      + "\"navigationList\": []}";

    String jsonFull =
      "{\"extents\":\"StudioObject\"," +
      "\"objectType\":\"Survey\"," +
      "\"oid\":\"dXNlclVVSUQ6W3VuZGVmaW5lZF1zdXJ2ZXlVVUlEOlsxNjI5ZWI0MC03ZjNkLTExZWEtOWViYS05YjI0YjM3NzY3OTZdcmVwb3NpdG9yeVVVSUQ6WyBOb3QgZG9uZSB5ZXQgXQ==\"," +
      "\"identity\":{\"extents\":\"StudioObject\",\"objectType\":\"SurveyIdentity\",\"name\":\"OA-180 Validação de custom ID A\",\"acronym\":\"VCIDA\",\"recommendedTo\":\"\",\"description\":\"\",\"keywords\":[]}," +
      "\"metainfo\":{}," +
      "\"staticVariableList\":[]," +
      "\"surveyItemGroupList\":[]," +
      "\"itemContainer\":[{\"extents\":\"SurveyItem\",\"objectType\":\"CheckboxQuestion\",\"templateID\":\"VCIDA1\",\"customID\":\"VCIDA1\",\"dataType\":\"Array\",\"label\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"Validação de custom ID em  checkbox\",\"formattedText\":\"Validação de custom ID em&nbsp; checkbox\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}},\"options\":[{\"extents\":\"StudioObject\",\"objectType\":\"CheckboxAnswerOption\",\"optionID\":\"VCIDA1a\",\"customOptionID\":\"VCIDA1a\",\"dataType\":\"Boolean\",\"value\":false,\"label\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"sim\",\"formattedText\":\"sim\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}}},{\"extents\":\"StudioObject\",\"objectType\":\"CheckboxAnswerOption\",\"optionID\":\"VCIDA1b\",\"customOptionID\":\"VCIDA1b\",\"dataType\":\"Boolean\",\"value\":false,\"label\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"não\",\"formattedText\":\"não\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}}}],\"metadata\":{\"extents\":\"StudioObject\",\"objectType\":\"MetadataGroup\",\"options\":[]},\"fillingRules\":{\"extends\":\"StudioObject\",\"objectType\":\"FillingRules\",\"options\":{\"mandatory\":{\"extends\":\"StudioObject\",\"objectType\":\"Rule\",\"validatorType\":\"mandatory\",\"data\":{\"canBeIgnored\":false,\"reference\":true}}}}},{\"extents\":\"SurveyItem\",\"objectType\":\"GridTextQuestion\",\"templateID\":\"VCIDA2\",\"customID\":\"VCIDA2\",\"metadata\":{\"extents\":\"StudioObject\",\"objectType\":\"MetadataGroup\",\"options\":[]},\"fillingRules\":{\"extends\":\"StudioObject\",\"objectType\":\"FillingRules\",\"options\":{\"mandatory\":{\"extends\":\"StudioObject\",\"objectType\":\"Rule\",\"validatorType\":\"mandatory\",\"data\":{\"canBeIgnored\":false,\"reference\":true}}}},\"label\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"Validação de Custom ID em Grid de texto\",\"formattedText\":\"Validação de Custom ID em Grid de texto\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}},\"lines\":[{\"extents\":\"StudioObject\",\"objectType\":\"GridTextLine\",\"gridTextList\":[{\"extents\":\"SurveyItem\",\"objectType\":\"GridText\",\"templateID\":\"VCIDA2a\",\"customID\":\"VCIDA2a\",\"dataType\":\"String\",\"label\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}},\"layout\":{\"extents\":\"StudioObject\",\"objectType\":\"LayoutGrid\",\"width\":100},\"unit\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}}},{\"extents\":\"SurveyItem\",\"objectType\":\"GridText\",\"templateID\":\"VCIDA2b\",\"customID\":\"VCIDA2b\",\"dataType\":\"String\",\"label\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}},\"layout\":{\"extents\":\"StudioObject\",\"objectType\":\"LayoutGrid\",\"width\":100},\"unit\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}}}]}]},{\"extents\":\"SurveyItem\",\"objectType\":\"GridIntegerQuestion\",\"templateID\":\"VCIDA3\",\"customID\":\"VCIDA3\",\"metadata\":{\"extents\":\"StudioObject\",\"objectType\":\"MetadataGroup\",\"options\":[]},\"fillingRules\":{\"extends\":\"StudioObject\",\"objectType\":\"FillingRules\",\"options\":{\"mandatory\":{\"extends\":\"StudioObject\",\"objectType\":\"Rule\",\"validatorType\":\"mandatory\",\"data\":{\"canBeIgnored\":false,\"reference\":true}}}},\"label\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"Validação de Custom ID em Grid de Número Inteiro\",\"formattedText\":\"Validação de Custom ID em Grid de Número Inteiro\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}},\"lines\":[{\"extents\":\"StudioObject\",\"objectType\":\"GridIntegerLine\",\"gridIntegerList\":[{\"extents\":\"SurveyItem\",\"objectType\":\"GridInteger\",\"templateID\":\"VCIDA3a\",\"customID\":\"VCIDA3a\",\"dataType\":\"Integer\",\"label\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}},\"layout\":{\"extents\":\"StudioObject\",\"objectType\":\"LayoutGrid\",\"width\":100},\"unit\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}}},{\"extents\":\"SurveyItem\",\"objectType\":\"GridInteger\",\"templateID\":\"VCIDA3b\",\"customID\":\"VCIDA3b\",\"dataType\":\"Integer\",\"label\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Label\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}},\"layout\":{\"extents\":\"StudioObject\",\"objectType\":\"LayoutGrid\",\"width\":100},\"unit\":{\"ptBR\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"enUS\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"},\"esES\":{\"extends\":\"StudioObject\",\"objectType\":\"Unit\",\"oid\":\"\",\"plainText\":\"\",\"formattedText\":\"\"}}}]}]}]," +
      "\"navigationList\":[]}";

    survey = new Gson().fromJson(json, SurveyTemplate.class);
    surveyWithGridCustomIds = SurveyTemplate.deserialize(jsonFull);
  }

  @Test
  public void should_deserialize_correctly_Survey_Json() {
    assertEquals("StudioObject", survey.extents);
    assertEquals("Survey", survey.objectType);
    assertEquals("dXNlclVVSUQ6W3VuZGVmaW5lZF1zdXJ2ZXlVVUlEOls3MDZlMTE2MC02M2I5LTExZTYtOWJjNy0xNWVhN2RkZDA4NTZdcmVwb3NpdG9yeVVVSUQ6WyBOb3QgZG9uZSB5ZXQgXQ==", survey.oid);

    assertTrue(survey.identity instanceof Identity);
    assertTrue(survey.metainfo instanceof MetaInfo);
    assertTrue(survey.staticVariableList instanceof List<?>);
    assertTrue(survey.surveyItemGroupList instanceof List<?>);
    assertTrue(survey.itemContainer instanceof List<?>);
    assertTrue(survey.navigationList instanceof List<?>);
  }

  @Test
  public void should_return_customIds_all_items() {
    List<SurveyItem> surveyItems = new ArrayList<>();
    surveyItems.add(buildSurveyItem("ID1"));
    surveyItems.add(buildSurveyItem("ID2"));
    surveyItems.add(buildSurveyItem("ID3"));

    SurveyTemplate surveyTemplate = new SurveyTemplate();
    surveyTemplate.itemContainer = surveyItems;

    List<String> foundedIds = surveyTemplate.getCustomIdItems();
    Assert.assertFalse(foundedIds.isEmpty());
    Assert.assertEquals(foundedIds.get(0), "ID1");
    Assert.assertEquals(foundedIds.get(1), "ID2");
    Assert.assertEquals(foundedIds.get(2), "ID3");
  }

  @Test
  public void should_return_customIdsOption_all_QuestionCheckbox() {
    List<SurveyItem> surveyItems = new ArrayList<>();
    surveyItems.add(buildCheckboxQuestion("ID1a"));
    surveyItems.add(buildCheckboxQuestion("ID2b"));
    surveyItems.add(buildCheckboxQuestion("ID3c"));
    surveyItems.add(buildCheckboxQuestion("ID4d"));

    SurveyTemplate surveyTemplate = new SurveyTemplate();
    surveyTemplate.itemContainer = surveyItems;

    List<String> foundedIds = surveyTemplate.getCustomIdOptions();
    Assert.assertFalse(foundedIds.isEmpty());
    Assert.assertEquals(foundedIds.get(0), "ID1a");
    Assert.assertEquals(foundedIds.get(1), "ID2b");
    Assert.assertEquals(foundedIds.get(2), "ID3c");
    Assert.assertEquals(foundedIds.get(3), "ID4d");
  }

  private CheckboxQuestion buildCheckboxQuestion(String customIdOption) {
    CheckboxQuestion checkboxQuestion = new CheckboxQuestion();
    CheckboxOption checkboxOption = new CheckboxOption();
    checkboxOption.customOptionID = customIdOption;
    checkboxQuestion.options = Arrays.asList(checkboxOption);
    return checkboxQuestion;
  }

  private SurveyItem buildSurveyItem(String customId) {
    SurveyItem surveyItem = new SurveyItem();
    surveyItem.customID = customId;
    return surveyItem;
  }

  @Test
  public void getCustomIdGridTextItemMethod_should_return_list_of_customIds_by_gridText(){
    List<String>expectedCustomIdGridTexts = Arrays.asList("VCIDA2a", "VCIDA2b");
    assertEquals(expectedCustomIdGridTexts, surveyWithGridCustomIds.getGridTextCustomIds());
  }

  @Test
  public void getCustomIdGridIntegerItemMethod_should_return_list_of_customIds_by_gridInteger(){
    List<String>expectedCustomIdGridIntegers = Arrays.asList("VCIDA3a", "VCIDA3b");
    assertEquals(expectedCustomIdGridIntegers, surveyWithGridCustomIds.getGridIntegerCustomIds());
  }
  @Test
  public void getCustomIdsMethod_should(){
    List<String>customIds = Arrays.asList("VCIDA3a", "VCIDA1a", "VCIDA2b", "VCIDA3", "VCIDA3b", "VCIDA2a", "VCIDA2", "VCIDA1", "VCIDA1b");
    Set<String> expectedCustomIds = new HashSet<>(customIds);
    assertEquals(expectedCustomIds, surveyWithGridCustomIds.getCustomIds());
  }
}

