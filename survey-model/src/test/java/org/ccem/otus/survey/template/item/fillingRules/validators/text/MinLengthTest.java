package org.ccem.otus.survey.template.item.fillingRules.validators.text;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.text.MinLength;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MinLengthTest {
	
	private MinLength minLength;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"minLength\",\"data\": {\"reference\": 5}}";

		minLength = new Gson().fromJson(json, MinLength.class);
	}

	@Test
	public void should_deserialize_correctly_MinLength() {
		assertEquals("StudioObject", minLength.extents);
		assertEquals("Rule", minLength.objectType);
		assertEquals("minLength", minLength.validatorType);
		assertEquals(Integer.valueOf("5"), minLength.data.reference);
	}

}
