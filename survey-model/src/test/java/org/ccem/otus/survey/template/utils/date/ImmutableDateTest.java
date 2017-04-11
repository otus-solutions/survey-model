package org.ccem.otus.survey.template.utils.date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.format.DateTimeParseException;

import org.junit.Before;
import org.junit.Test;

public class ImmutableDateTest {

	private static final String STRING_DATE_VALUE = "2017-02-14 03:33:24.952";
	private static final String INVALID_DATE_VALUE = "invalid_value";

	private ImmutableDate immutableDate;

	@Before
	public void setUp() {
		immutableDate = new ImmutableDate(STRING_DATE_VALUE);
	}

	@Test
	public void should_contain_a_value() {
		assertNotNull(immutableDate.getValue());
	}

	@Test
	public void should_contain_a_value_with_year() {
		assertEquals(2017, immutableDate.getValue().getYear());
	}

	@Test
	public void should_contain_a_value_with_month() {
		assertEquals(2, immutableDate.getValue().getMonthValue());
	}

	@Test
	public void should_contain_a_value_with_day() {
		assertEquals(14, immutableDate.getValue().getDayOfMonth());
	}

	@Test
	public void should_contain_a_value_with_hour() {
		assertEquals(3, immutableDate.getValue().getHour());
	}

	@Test
	public void should_contain_a_value_with_minutes() {
		assertEquals(33, immutableDate.getValue().getMinute());
	}

	@Test
	public void should_contain_a_value_with_seconds() {
		assertEquals(24, immutableDate.getValue().getSecond());
	}

	@Test
	public void should_contain_a_value_with_nano() {
		assertEquals(952000000, immutableDate.getValue().getNano());
	}

	@Test
	public void should_create_an_instance_when_the_value_was_valid() {
		assertNotNull(immutableDate);
	}

	@Test
	public void getFormattedValue_method_should_return_the_same_formatt_that_was_created() {
		assertEquals(STRING_DATE_VALUE, immutableDate.getFormattedValue());
	}

	@Test(expected = DateTimeParseException.class)
	public void should_throw_a_DateTimeParseException_when_the_value_was_invalid() {
		new ImmutableDate(INVALID_DATE_VALUE);
	}

}
