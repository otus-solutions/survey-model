package org.ccem.otus.survey.template.item.fillingRules.validators.decimal;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.decimal.Scale;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class ScaleTest {
	
	private Scale scale;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"scale\",\"data\": {\"reference\": 2}}";

		scale = new Gson().fromJson(json, Scale.class);
	}

	@Test
	public void should_deserialize_correctly_Scale() {
		assertEquals("StudioObject", scale.extents);
		assertEquals("Rule", scale.objectType);
		assertEquals("scale", scale.validatorType);
		assertEquals(Integer.valueOf("2"), scale.data.reference);
	}


}
