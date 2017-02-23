package org.ccem.otus.survey.template.utils.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImmutableDate {

	private static final String IMMUTABLE_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
	private final transient DateTimeFormatter formatter;
	private LocalDateTime value;
	private String objectType;

	private ImmutableDate() {
		formatter = DateTimeFormatter.ofPattern(IMMUTABLE_DATE_PATTERN);
	}

	public ImmutableDate(String date) {
		this();
		this.objectType = "ImmutableDate";
		this.value = LocalDateTime.parse(date, formatter);
	}
	
	public ImmutableDate(LocalDate date) {
		this();
		this.objectType = "ImmutableDate";
		this.value = LocalDateTime.parse(resetTime(date), formatter);
	}

	public LocalDateTime getValue() {
		return value;
	}

	public String getFormattedValue() {
		return formatter.format(value);
	}

	public String getObjectType() {
		return objectType;
	}
	
	private String resetTime(LocalDate date) {
		return date.toString().concat(" 00:00:00.000");
	}

	@Override
	public String toString() {
		return "ImmutableDate [value=" + value + ", objectType=" + objectType + ", getFormattedValue="
				+ getFormattedValue() + "]";
	}

}
