package org.ccem.otus.survey.template.item.fillingRules.validators.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.SurveyTemplate;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.time.MaxTime;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;

public class MaxTimeTest {
	
	private MaxTime maxTime;
	private JsonObject json;

	@Before
	public void setUp() {
		json = mockJson();

		maxTime = SurveyTemplate.getGsonBuilder().create().fromJson(json, MaxTime.class);
	}

	@Test
	public void should_deserialize_correctly_MinDate() {
		assertEquals("StudioObject", maxTime.extents);
		assertEquals("Rule", maxTime.objectType);
		assertTrue(maxTime.data.canBeIgnored);
		assertEquals("minDate", maxTime.validatorType);
		assertEquals("2017-02-16 01:00:00.000", maxTime.data.reference.getFormattedValue());
	}

	private JsonObject mockJson() {
		json = new JsonObject();
		json.addProperty("extends", "StudioObject");
		json.addProperty("objectType", "Rule");
		json.addProperty("validatorType", "minDate");
		json.add("data", getData());

		return json;
	}

	private JsonObject getData() {
		JsonObject reference = new JsonObject();
		reference.addProperty("objectType", "ImmutableDate");
		reference.addProperty("value", "2017-02-16 01:00:00.000");

		JsonObject data = new JsonObject();
		data.addProperty("canBeIgnored", true);
		data.add("reference", reference);

		return data;
	}

}
