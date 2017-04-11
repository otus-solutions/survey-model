package org.ccem.otus.survey.template.item.fillingRules.validators.calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.calendar.PastDate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class PastDateTest {
	
	private PastDate pastDate;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"pastDate\",\"data\": {\"reference\": true}}";

		pastDate = new Gson().fromJson(json, PastDate.class);
	}

	@Test
	public void should_deserialize_correctly_PastDate() {
		assertEquals("StudioObject", pastDate.extents);
		assertEquals("Rule", pastDate.objectType);
		assertEquals("pastDate", pastDate.validatorType);
		assertTrue(pastDate.data.reference);
	}

}
