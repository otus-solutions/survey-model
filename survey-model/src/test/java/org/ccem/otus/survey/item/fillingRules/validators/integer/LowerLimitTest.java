package org.ccem.otus.survey.item.fillingRules.validators.integer;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.item.questions.fillingRules.validators.integer.LowerLimit;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class LowerLimitTest {

	private LowerLimit lowerLimit;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"lowerLimit\",\"data\": {\"reference\": 1}}";

		lowerLimit = new Gson().fromJson(json, LowerLimit.class);
	}

	@Test
	public void should_deserialize_correctly_LowerLimit() {
		assertEquals("StudioObject", lowerLimit.extents);
		assertEquals("Rule", lowerLimit.objectType);
		assertEquals("lowerLimit", lowerLimit.validatorType);
		assertEquals(Integer.valueOf("1"), lowerLimit.data.reference);
	}

}
