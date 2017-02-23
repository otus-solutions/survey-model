package org.ccem.otus.survey.template.utils.adapters;

import java.lang.reflect.Type;
import java.time.Instant;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class InstantAdapter implements JsonDeserializer<Instant>, JsonSerializer<Instant> {

	@Override
	public JsonElement serialize(Instant src, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(src.toString());
	}

	@Override
	public Instant deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return Instant.parse(json.getAsString());
	}

}
