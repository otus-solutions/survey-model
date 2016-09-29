package org.ccem.otus.survey.template.item.fillingRules.validators.text;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.text.MaxLength;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MaxLengthTest {
	
	private MaxLength maxLength;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"maxLength\",\"data\": {\"reference\": 5}}";

		maxLength = new Gson().fromJson(json, MaxLength.class);
	}

	@Test
	public void should_deserialize_correctly_MaxLength() {
		assertEquals("StudioObject", maxLength.extents);
		assertEquals("Rule", maxLength.objectType);
		assertEquals("maxLength", maxLength.validatorType);
		assertEquals(Integer.valueOf("5"), maxLength.data.reference);
	}

}
