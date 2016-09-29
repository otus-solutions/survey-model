package org.ccem.otus.survey.template.item.fillingRules.validators.integer;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.integer.Precision;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class PrecisionTest {
	
	private Precision precision;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"precision\",\"data\": {\"reference\": 1}}";

		precision = new Gson().fromJson(json, Precision.class);
	}

	@Test
	public void should_deserialize_correctly_Precision() {
		assertEquals("StudioObject", precision.extents);
		assertEquals("Rule", precision.objectType);
		assertEquals("precision", precision.validatorType);
		assertEquals(Integer.valueOf("1"), precision.data.reference);
	}

}
