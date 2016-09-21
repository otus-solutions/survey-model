package org.ccem.otus.survey.item.fillingRules.validators.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.item.questions.fillingRules.validators.text.LowerCase;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class LowerCaseTest {
	
	private LowerCase lowerCase;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"lowerCase\",\"data\": {\"reference\": true}}";

		lowerCase = new Gson().fromJson(json, LowerCase.class);
	}

	@Test
	public void should_deserialize_correctly_LowerCase() {
		assertEquals("StudioObject", lowerCase.extents);
		assertEquals("Rule", lowerCase.objectType);
		assertEquals("lowerCase", lowerCase.validatorType);
		assertTrue(lowerCase.data.reference);
	}

}
