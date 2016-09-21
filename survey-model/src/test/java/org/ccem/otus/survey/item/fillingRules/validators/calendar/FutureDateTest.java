package org.ccem.otus.survey.item.fillingRules.validators.calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.item.questions.fillingRules.validators.calendar.FutureDate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class FutureDateTest {
	
	private FutureDate futureDate;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"futureDate\",\"data\": {\"reference\": true}}";

		futureDate = new Gson().fromJson(json, FutureDate.class);
	}

	@Test
	public void should_deserialize_correctly_FutureDate() {
		assertEquals("StudioObject", futureDate.extents);
		assertEquals("Rule", futureDate.objectType);
		assertEquals("futureDate", futureDate.validatorType);
		assertTrue(futureDate.data.reference);
	}

}
