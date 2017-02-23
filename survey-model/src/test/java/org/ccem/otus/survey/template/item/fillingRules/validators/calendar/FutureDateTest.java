package org.ccem.otus.survey.template.item.fillingRules.validators.calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.calendar.FutureDate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class FutureDateTest {

	private FutureDate futureDate;
	private JsonObject json;

	@Before
	public void setUp() {
		json = mockJson();

		futureDate = new Gson().fromJson(json, FutureDate.class);
	}

	@Test
	public void should_deserialize_correctly_FutureDate() {
		assertEquals("StudioObject", futureDate.extents);
		assertEquals("Rule", futureDate.objectType);
		assertEquals("futureDate", futureDate.validatorType);
		assertTrue(futureDate.data.reference);
	}

	private JsonObject mockJson() {
		json = new JsonObject();
		
		JsonObject booleanReference = new JsonObject();
		booleanReference.addProperty("reference", true);

		json.addProperty("extends", "StudioObject");
		json.addProperty("objectType", "Rule");
		json.addProperty("validatorType", "futureDate");
		json.add("data", booleanReference);
		
		return json;
	}

}
