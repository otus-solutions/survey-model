package org.ccem.otus.survey.item.fillingRules.validators.calendar;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.item.questions.fillingRules.validators.calendar.RangeDate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class RangeDateTest {

	private RangeDate rangeDate;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"rangeDate\",\"data\": "
				+ "{\"reference\": {\"initial\": \"2016-09-01T03:00:00.000Z\",\"end\": \"2016-10-01T03:00:00.000Z\"}}}";

		rangeDate = new Gson().fromJson(json, RangeDate.class);
	}

	@Test	
	public void should_deserialize_correctly_RangeDate() {
		assertEquals("StudioObject", rangeDate.extents);
		assertEquals("Rule", rangeDate.objectType);
		assertEquals("rangeDate", rangeDate.validatorType);
		assertEquals("2016-09-01T03:00:00.000Z", rangeDate.data.reference.initial);
		assertEquals("2016-10-01T03:00:00.000Z", rangeDate.data.reference.end);
	}
}
