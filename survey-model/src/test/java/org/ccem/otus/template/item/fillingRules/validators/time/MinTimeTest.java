package org.ccem.otus.template.item.fillingRules.validators.time;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.template.item.questions.fillingRules.validators.time.MinTime;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MinTimeTest {
	
	private MinTime minTime;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"minTime\",\"data\": {\"reference\": \"Wed Mar 25 2015 01:30:00 GMT-0300 (BRT)\"}}";

		minTime = new Gson().fromJson(json, MinTime.class);
	}

	@Test	
	public void should_deserialize_correctly_MinTimeDto() {
		assertEquals("StudioObject", minTime.extents);
		assertEquals("Rule", minTime.objectType);
		assertEquals("minTime", minTime.validatorType);
		assertEquals("Wed Mar 25 2015 01:30:00 GMT-0300 (BRT)", minTime.data.reference);
	}

}
