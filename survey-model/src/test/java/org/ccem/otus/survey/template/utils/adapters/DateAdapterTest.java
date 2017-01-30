package org.ccem.otus.survey.template.utils.adapters;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class DateAdapterTest {

	@InjectMocks
	private DateAdapter adapter;
	private JsonObject dateMock;
	private Gson gson;

	@Before
	public void setup() {
		mockJSON();

		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Date.class, new DateAdapter());
		gson = builder.create();
	}

	@Test
	public void deserialize_method_should_create_a_Date_from_milliseconds() {
		DateAdapterTestPOJO result = gson.fromJson(dateMock, DateAdapterTestPOJO.class);
		assertEquals("Thu Jan 26 17:49:08 BRST 2017", result.anyDate.toString());
	}

	@Test
	public void serialize_method_should_return_a_Date_in_milliseconds() {
		String serialized = gson.toJson(dateMock);
		assertEquals(dateMock.toString(), serialized);
	}

	public JsonObject mockJSON() {
		dateMock = new JsonObject();
		dateMock.addProperty("anyDate", 1485460148991L);
		return dateMock;
	}

	class DateAdapterTestPOJO {
		public Date anyDate;
	}
}
