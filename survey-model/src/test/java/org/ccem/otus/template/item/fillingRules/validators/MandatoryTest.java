package org.ccem.otus.template.item.fillingRules.validators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.template.item.questions.fillingRules.validators.Mandatory;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MandatoryTest {

	private Mandatory mandatory;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"mandatory\",\"data\": {\"reference\": true}}";

		mandatory = new Gson().fromJson(json, Mandatory.class);
	}

	@Test
	public void should_deserialize_correctly_Mandatory() {
		assertEquals("StudioObject", mandatory.extents);
		assertEquals("Rule", mandatory.objectType);
		assertEquals("mandatory", mandatory.validatorType);
		assertTrue(mandatory.data.reference);
	}
	
}
