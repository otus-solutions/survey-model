package org.ccem.otus.survey.template.item.fillingRules.validators.calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.SurveyTemplate;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.calendar.RangeDate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;

public class RangeDateTest {

	private RangeDate rangeDate;
	private JsonObject json;

	@Before
	public void setUp() {
		json = mockJson();

		rangeDate = SurveyTemplate.getGsonBuilder().create().fromJson(json, RangeDate.class);
	}

	@Test
	public void should_deserialize_correctly_RangeDate() {
		assertEquals("StudioObject", rangeDate.extents);
		assertEquals("Rule", rangeDate.objectType);
		assertEquals("rangeDate", rangeDate.validatorType);
		assertTrue(rangeDate.data.canBeIgnored);
		assertEquals("2017-02-16 00:00:00.000", rangeDate.data.reference.initial.getFormattedValue());
		assertEquals("2017-02-17 00:00:00.000", rangeDate.data.reference.end.getFormattedValue());
	}

	private JsonObject mockJson() {
		json = new JsonObject();
		json.addProperty("extends", "StudioObject");
		json.addProperty("objectType", "Rule");
		json.addProperty("validatorType", "rangeDate");
		json.add("data", getRangeData());
		
		return json;
	}
	
	private JsonObject getRangeData() {
		JsonObject referenceInitial = new JsonObject();
		referenceInitial.addProperty("objectType", "ImmutableDate");
		referenceInitial.addProperty("value", "2017-02-16 00:00:00.000");
		
		JsonObject referenceEnd = new JsonObject();
		referenceEnd.addProperty("objectType", "ImmutableDate");
		referenceEnd.addProperty("value", "2017-02-17 00:00:00.000");

		JsonObject reference = new JsonObject();
		reference.add("initial", referenceInitial);
		reference.add("end", referenceEnd);
		
		JsonObject data = new JsonObject();
		data.addProperty("canBeIgnored", true);
		data.add("reference", reference);
		
		return data;
	}

}
