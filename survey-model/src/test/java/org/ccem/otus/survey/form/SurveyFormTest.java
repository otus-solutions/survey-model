package org.ccem.otus.survey.form;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.ccem.otus.survey.template.SurveyTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.gson.Gson;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SurveyForm.class)
public class SurveyFormTest {	
	private SurveyForm surveyForm;


	@Before
	public void setUp(){
		String json = ""
				+ "{\"extents\": \"StudioObject\","
				+ "\"objectType\": \"Survey\","
				+ "\"oid\": \"dXNlclVVSUQ6W3VuZGVmaW5lZF1zdXJ2ZXlVVUlEOls3MDZlMTE2MC02M2I5LTExZTYtOWJjNy0xNWVhN2RkZDA4NTZdcmVwb3NpdG9yeVVVSUQ6WyBOb3QgZG9uZSB5ZXQgXQ==\","
				+ "\"identity\": {\"name\":\"TERMO DE CONSENTIMENTO LIVRE E ESCLARECIDO\"},"
				+ "\"metainfo\": {\"objectType\":\"SurveyMetaInfo\"},"
				+ "\"itemContainer\": [],"
				+ "\"navigationList\": []}";


		String timeDateInject = "2017-04-04 19:07:59.457";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime timeSedingDateInject = LocalDateTime.parse(timeDateInject, formatter);				
		
		SurveyTemplate surveyTemplate = new Gson().fromJson(json, SurveyTemplate.class);		
		
		
		PowerMockito.mockStatic(LocalDateTime.class);
		PowerMockito.when(LocalDateTime.ofInstant(Mockito.any(), Mockito.any())).thenReturn(timeSedingDateInject);
		
		
		surveyForm = new SurveyForm(surveyTemplate, "fabiano@gmail.com");		

		
		Gson gson = SurveyForm.getGsonBuilder().create();
		
	}
	
	@Test	
	public void should_serialize_survey_form(){
		String expectedJson = "" +
				"{\"_id\":null," +
				"\"sender\":\"fabiano@gmail.com\"," +
				"\"sendingDate\":\"2017-04-04T19:07:59.457Z\"," +
				"\"objectType\":\"SurveyForm\"," +				
				"\"surveyFormType\":\"FORM_INTERVIEW\"," +
				"\"surveyTemplate\":{\"extents\":\"StudioObject\",\"objectType\":\"Survey\",\"oid\":\"dXNlclVVSUQ6W3VuZGVmaW5lZF1zdXJ2ZXlVVUlEOls3MDZlMTE2MC02M2I5LTExZTYtOWJjNy0xNWVhN2RkZDA4NTZdcmVwb3NpdG9yeVVVSUQ6WyBOb3QgZG9uZSB5ZXQgXQ==\",\"identity\":{\"extents\":null,\"objectType\":null,\"name\":\"TERMO DE CONSENTIMENTO LIVRE E ESCLARECIDO\",\"acronym\":null,\"recommendedTo\":null,\"description\":null,\"keywords\":null},\"dataSources\":null,\"metainfo\":{\"extents\":null,\"objectType\":\"SurveyMetaInfo\",\"creationDatetime\":null,\"otusStudioVersion\":null}," +
				"\"itemContainer\":[]," +
				"\"navigationList\":[]}," +
				"\"name\":null," +
				"\"acronym\":null," +
				"\"version\":null," +
				"\"isDiscarded\":false" +
				"}";

		
		assertEquals(expectedJson, SurveyForm.serialize(surveyForm));
		
	}
	
	

}
