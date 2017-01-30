package org.ccem.otus.survey.template;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ccem.otus.survey.template.identity.Identity;
import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.item.questions.selectable.CheckboxQuestion;
import org.ccem.otus.survey.template.item.questions.selectable.options.CheckboxOption;
import org.ccem.otus.survey.template.metainfo.MetaInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class SurveyTemplateTest {
	private SurveyTemplate survey;
	
	@Before
	public void setUp() {
		String json = ""
				+ "{\"extents\": \"StudioObject\","
				+ "\"objectType\": \"Survey\","
				+ "\"oid\": \"dXNlclVVSUQ6W3VuZGVmaW5lZF1zdXJ2ZXlVVUlEOls3MDZlMTE2MC02M2I5LTExZTYtOWJjNy0xNWVhN2RkZDA4NTZdcmVwb3NpdG9yeVVVSUQ6WyBOb3QgZG9uZSB5ZXQgXQ==\","
				+ "\"identity\": {},"
				+ "\"metainfo\": {},"
				+ "\"itemContainer\": [],"
				+ "\"navigationList\": []}";
		
		survey = new Gson().fromJson(json, SurveyTemplate.class);
	}
	
	@Test
	public void should_deserialize_correctly_Survey_Json() {
		assertEquals("StudioObject", survey.extents);
		assertEquals("Survey", survey.objectType);
		assertEquals("dXNlclVVSUQ6W3VuZGVmaW5lZF1zdXJ2ZXlVVUlEOls3MDZlMTE2MC02M2I5LTExZTYtOWJjNy0xNWVhN2RkZDA4NTZdcmVwb3NpdG9yeVVVSUQ6WyBOb3QgZG9uZSB5ZXQgXQ==", survey.oid);
		
		assertTrue(survey.identity instanceof Identity);
		assertTrue(survey.metainfo instanceof MetaInfo);
		assertTrue(survey.itemContainer instanceof List<?>);
		assertTrue(survey.navigationList instanceof List<?>);
	}

	@Test
	public void should_return_customIds_all_items(){
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
	public void should_return_customIdsOption_all_QuestionCheckbox(){
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

	private CheckboxQuestion buildCheckboxQuestion(String customIdOption){
		CheckboxQuestion checkboxQuestion = new CheckboxQuestion();
		CheckboxOption checkboxOption = new CheckboxOption();
		checkboxOption.customOptionID = customIdOption;
		checkboxQuestion.options = Arrays.asList(checkboxOption);
		return checkboxQuestion;
	}

	private SurveyItem buildSurveyItem(String customId){
		SurveyItem surveyItem = new SurveyItem();
		surveyItem.customID = customId;
		return surveyItem;
	}

}
