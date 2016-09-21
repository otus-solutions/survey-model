package org.ccem.otus.survey.item.fillingRules.validators.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.item.questions.fillingRules.validators.text.Specials;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class SpecialsTest {
	
	private Specials specials;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"specials\",\"data\": {\"reference\": true}}";

		specials = new Gson().fromJson(json, Specials.class);
	}

	@Test
	public void should_deserialize_correctly_Specials() {
		assertEquals("StudioObject", specials.extents);
		assertEquals("Rule", specials.objectType);
		assertEquals("specials", specials.validatorType);
		assertTrue(specials.data.reference);
	}

}
