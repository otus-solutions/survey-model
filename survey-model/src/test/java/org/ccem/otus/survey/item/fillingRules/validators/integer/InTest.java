package org.ccem.otus.survey.item.fillingRules.validators.integer;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.item.questions.fillingRules.validators.integer.In;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class InTest {
	
	private In in;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"in\",\"data\": {\"reference\": {\"initial\": 1,\"end\": 11}}}";

		in = new Gson().fromJson(json, In.class);
	}

	@Test
	public void should_deserialize_correctly_In() {
		assertEquals("StudioObject", in.extents);
		assertEquals("Rule", in.objectType);
		assertEquals("in", in.validatorType);
		assertEquals(Integer.valueOf("1"), in.data.reference.initial);
		assertEquals(Integer.valueOf("11"), in.data.reference.end);
	}

}
