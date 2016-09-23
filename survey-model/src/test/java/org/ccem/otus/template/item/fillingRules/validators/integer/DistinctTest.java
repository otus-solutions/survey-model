package org.ccem.otus.template.item.fillingRules.validators.integer;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.template.item.questions.fillingRules.validators.integer.Distinct;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class DistinctTest {
	
	private Distinct distinct;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"distinct\",\"data\": {\"reference\": 1}}";

		distinct = new Gson().fromJson(json, Distinct.class);
	}

	@Test
	public void should_deserialize_correctly_Distinct() {
		assertEquals("StudioObject", distinct.extents);
		assertEquals("Rule", distinct.objectType);
		assertEquals("distinct", distinct.validatorType);
		assertEquals(Integer.valueOf("1"), distinct.data.reference);
	}

}
