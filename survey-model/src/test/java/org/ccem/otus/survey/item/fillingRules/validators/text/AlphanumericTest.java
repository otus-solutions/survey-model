package org.ccem.otus.survey.item.fillingRules.validators.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.item.questions.fillingRules.validators.text.Alphanumeric;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class AlphanumericTest {
	
	private Alphanumeric alphanumeric;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"alphanumeric\",\"data\": {\"reference\": true}}";

		alphanumeric = new Gson().fromJson(json, Alphanumeric.class);
	}

	@Test
	public void should_deserialize_correctly_Alphanumeric() {
		assertEquals("StudioObject", alphanumeric.extents);
		assertEquals("Rule", alphanumeric.objectType);
		assertEquals("alphanumeric", alphanumeric.validatorType);
		assertTrue(alphanumeric.data.reference);
	}

}
