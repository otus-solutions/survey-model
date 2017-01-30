package org.ccem.otus.survey.template.utils.adapters;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		Long asLong = null;
		
		try {
			asLong = arg0.getAsLong();
		} catch (UnsupportedOperationException e) {
			JsonElement element = arg0.getAsJsonObject().get("$numberLong");
			asLong = element.getAsLong();
		}
		
		return new Date(asLong);
	}

	@Override
	public JsonElement serialize(Date arg0, Type arg1, JsonSerializationContext arg2) {
		return arg2.serialize(arg0.getTime());
	}

}
