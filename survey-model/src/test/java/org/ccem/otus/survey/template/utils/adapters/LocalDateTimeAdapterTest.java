package org.ccem.otus.survey.template.utils.adapters;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;

public class LocalDateTimeAdapterTest {

	private static final String INVALID_FORMAT = "invalid_format";
	private static final String ISO_STRING_DATE = "2017-02-13T20:12:12.227Z";

	private JsonPrimitive jsonMock;
	private LocalDateTime localDateTimeMock;
	private Gson gson;

	@Before
	public void setup() {
		mockJSON();
		mockLocalDateTimeObject();
		createGsonInstace();
	}

	@Test
	public void deserialize_method_should_create_a_Date_from_ISODate_format() {
		assertEquals(localDateTimeMock, gson.fromJson(jsonMock, LocalDateTime.class));
	}
	
	@Test(expected = DateTimeParseException.class)
	public void deserialize_method_must_throw_an_exception_when_ISO_format_was_invalid() {
		gson.fromJson(INVALID_FORMAT, LocalDateTime.class);
	}
	
	@Test
	public void serialize_method_should_return_a_Date_in_ISODate_format() {
		assertEquals(gson.toJson(ISO_STRING_DATE), gson.toJson(localDateTimeMock));
	}

	public void mockJSON() {
		jsonMock = new JsonPrimitive(ISO_STRING_DATE);
	}

	private void mockLocalDateTimeObject() {
		localDateTimeMock = LocalDateTime.parse(ISO_STRING_DATE, DateTimeFormatter.ISO_DATE_TIME);
	}

	private void createGsonInstace() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter());
		gson = builder.create();
	}

}
