package org.ccem.otus.survey.item.fillingRules.validators.calendar;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.item.questions.fillingRules.validators.calendar.MaxDate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MaxDateTest {

	private MaxDate maxDate;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"maxDate\",\"data\": {\"reference\": \"2016-12-01T02:00:00.000Z\"}}";

		maxDate = new Gson().fromJson(json, MaxDate.class);
	}

	@Test
	public void should_deserialize_correctly_MaxDate() {
		assertEquals("StudioObject", maxDate.extents);
		assertEquals("Rule", maxDate.objectType);
		assertEquals("maxDate", maxDate.validatorType);
		assertEquals("2016-12-01T02:00:00.000Z", maxDate.data.reference);
	}
}
