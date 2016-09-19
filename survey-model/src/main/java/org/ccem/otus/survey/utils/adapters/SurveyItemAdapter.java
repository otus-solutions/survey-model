package org.ccem.otus.survey.utils.adapters;

import java.lang.reflect.Type;

import org.ccem.otus.survey.enums.SurveyItemMapping;
import org.ccem.otus.survey.item.SurveyItemDto;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SurveyItemAdapter implements JsonDeserializer<SurveyItemDto>, JsonSerializer<SurveyItemDto> {

	private static final String OBJECT_TYPE = "objectType";
	
	@Override
	public JsonElement serialize(SurveyItemDto src, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(src);
	}
	
	@Override
	public SurveyItemDto deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		JsonPrimitive prim = (JsonPrimitive) json.getAsJsonObject().get(OBJECT_TYPE);
        String objectType = prim.getAsString();
		return context.deserialize(json, SurveyItemMapping.getEnumByObjectType(objectType).getDtoClass());
	}

}
