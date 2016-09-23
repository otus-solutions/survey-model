package org.ccem.otus.template.item.fillingRules.validators.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.template.item.questions.fillingRules.validators.text.UpperCase;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class UpperCaseTest {
	
	private UpperCase upperCase;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"upperCase\",\"data\": {\"reference\": true}}";

		upperCase = new Gson().fromJson(json, UpperCase.class);
	}

	@Test
	public void should_deserialize_correctly_UpperCase() {
		assertEquals("StudioObject", upperCase.extents);
		assertEquals("Rule", upperCase.objectType);
		assertEquals("upperCase", upperCase.validatorType);
		assertTrue(upperCase.data.reference);
	}


}
