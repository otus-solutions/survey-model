package org.ccem.otus.survey.template.utils.adapters;

import java.lang.reflect.Type;

import org.ccem.otus.survey.template.utils.date.ImmutableDate;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ImmutableDateAdapter implements JsonSerializer<ImmutableDate>, JsonDeserializer<ImmutableDate> {

	@Override
	public ImmutableDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		return new ImmutableDate(json.getAsJsonObject().get("value").getAsString());
	}

	@Override
	public JsonElement serialize(ImmutableDate src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("objectType", src.getObjectType());
		jsonObject.addProperty("value", src.getFormattedValue());
		
		return context.serialize(jsonObject);
	}

}
