package org.ccem.otus.survey.template.utils.adapters;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.utils.date.ImmutableDate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class ImmutableDateAdapterTest {

	private static final String STRING_DATE_VALUE = "2017-02-14 03:33:24.952";

	private JsonObject jsonMock;
	private ImmutableDate immutableDateMock;
	private Gson gson;

	@Before
	public void setup() {
		mockJSON();
		mockImmutableDateObject();
		createGsonInstace();
	}

	@Test
	public void deserialize_method_should_create_a_ImmutableDate_equals() {
		assertEquals(immutableDateMock.toString(), gson.fromJson(jsonMock, ImmutableDate.class).toString());
	}

	@Test
	public void serialize_method_should_return_a_ImmutableDate_format() {
		assertEquals(jsonMock.toString(), gson.toJson(immutableDateMock));
	}

	public void mockJSON() {
		jsonMock = new JsonObject();
		jsonMock.addProperty("objectType", "ImmutableDate");
		jsonMock.addProperty("value", STRING_DATE_VALUE);
	}

	private void mockImmutableDateObject() {
		immutableDateMock = new ImmutableDate(STRING_DATE_VALUE);
	}

	private void createGsonInstace() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(ImmutableDate.class, new ImmutableDateAdapter());
		gson = builder.create();
	}

}
