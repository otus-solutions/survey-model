package org.ccem.otus.template.item.selectable.options;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.template.item.label.Label;
import org.ccem.otus.template.item.questions.selectable.options.CheckboxOption;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class CheckboxOptionTest {

	private CheckboxOption checkboxOption;
	private String checkboxAnswerOptionJson;

	@Before
	public void setUp() {

		checkboxAnswerOptionJson = ""
				+ "{\"extents\": \"StudioObject\","
				+ "\"objectType\": \"CheckboxAnswerOption\","
				+ "\"optionID\": \"CO2a\","
				+ "\"customOptionID\": \"CO2a\","
				+ "\"dataType\": \"Boolean\","
				+ "\"label\": {}}";
	}

	@Test
	public void should_deserialize_correctly_Checkbox_Answer_Option() {
		checkboxOption = new Gson().fromJson(checkboxAnswerOptionJson, CheckboxOption.class);

		assertEquals("StudioObject", checkboxOption.extents);
		assertEquals("CheckboxAnswerOption", checkboxOption.objectType);
		assertEquals("CO2a", checkboxOption.optionID);
		assertEquals("CO2a", checkboxOption.customOptionID);
		assertEquals("Boolean", checkboxOption.dataType);

		assertTrue(checkboxOption.label instanceof Label);
	}
	
}
