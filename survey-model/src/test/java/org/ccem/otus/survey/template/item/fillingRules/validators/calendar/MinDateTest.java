package org.ccem.otus.survey.template.item.fillingRules.validators.calendar;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.calendar.MinDate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MinDateTest {
	
	private MinDate minDate;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"minDate\",\"data\": {\"reference\": \"2016-12-01T02:00:00.000Z\"}}";

		minDate = new Gson().fromJson(json, MinDate.class);
	}

	@Test	
	public void should_deserialize_correctly_MinDate() {
		assertEquals("StudioObject", minDate.extents);
		assertEquals("Rule", minDate.objectType);
		assertEquals("minDate", minDate.validatorType);
		assertEquals("2016-12-01T02:00:00.000Z", minDate.data.reference);
	}

}
