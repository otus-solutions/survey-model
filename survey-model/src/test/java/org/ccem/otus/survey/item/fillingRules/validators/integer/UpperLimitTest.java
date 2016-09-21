package org.ccem.otus.survey.item.fillingRules.validators.integer;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.item.questions.fillingRules.validators.integer.UpperLimit;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class UpperLimitTest {
	
	private UpperLimit upperLimit;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"upperLimit\",\"data\": {\"reference\": 1}}";

		upperLimit = new Gson().fromJson(json, UpperLimit.class);
	}

	@Test
	public void should_deserialize_correctly_UpperLimit() {
		assertEquals("StudioObject", upperLimit.extents);
		assertEquals("Rule", upperLimit.objectType);
		assertEquals("upperLimit", upperLimit.validatorType);
		assertEquals(Integer.valueOf("1"), upperLimit.data.reference);
	}

}
