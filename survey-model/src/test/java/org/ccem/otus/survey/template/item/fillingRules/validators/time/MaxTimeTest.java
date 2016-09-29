package org.ccem.otus.survey.template.item.fillingRules.validators.time;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.time.MaxTime;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MaxTimeTest {
	
	private MaxTime maxTime;

	@Before
	public void setUp() {
		String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"maxTime\",\"data\": {\"reference\": \"Wed Mar 25 2015 01:30:00 GMT-0300 (BRT)\"}}";

		maxTime = new Gson().fromJson(json, MaxTime.class);
	}

	@Test	
	public void should_deserialize_correctly_MaxTime() {
		assertEquals("StudioObject", maxTime.extents);
		assertEquals("Rule", maxTime.objectType);
		assertEquals("maxTime", maxTime.validatorType);
		assertEquals("Wed Mar 25 2015 01:30:00 GMT-0300 (BRT)", maxTime.data.reference);
	}

}
