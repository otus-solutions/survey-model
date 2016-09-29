package org.ccem.otus.survey.template;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.ccem.otus.survey.template.SurveyTemplate;
import org.ccem.otus.survey.template.identity.Identity;
import org.ccem.otus.survey.template.metainfo.MetaInfo;
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
	
}
