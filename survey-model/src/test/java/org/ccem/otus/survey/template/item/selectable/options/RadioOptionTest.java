package org.ccem.otus.survey.template.item.selectable.options;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.item.label.Label;
import org.ccem.otus.survey.template.item.questions.selectable.options.RadioOption;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class RadioOptionTest {
	
	private RadioOption radioOption;
	private String radioOptionJson;
	
	@Before
	public void setUp() {
		
		radioOptionJson = ""
				+ "{\"extents\": \"StudioObject\","
				+ "\"objectType\": \"AnswerOption\"," 
				+ "\"value\": 1,"
				+ "\"extractionValue\": \"1\","
				+ "\"dataType\": \"Integer\","
				+ "\"label\": {}}";
	}
	
	@Test
	public void should_deserialize_correctly_Radio_Option_Dto() {
		radioOption = new Gson().fromJson(radioOptionJson, RadioOption.class);
		
		assertEquals("StudioObject", radioOption.extents);
		assertEquals("AnswerOption", radioOption.objectType);
		assertEquals(new Integer(1), radioOption.value);
		assertEquals("1", radioOption.extractionValue);
		assertEquals("Integer", radioOption.dataType);
		
		assertTrue(radioOption.label instanceof Label);
	}

}
