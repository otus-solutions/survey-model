package org.ccem.otus.template.utils.adapters;

import java.lang.reflect.Type;

import org.ccem.otus.template.enums.SurveyItemMapping;
import org.ccem.otus.template.item.SurveyItem;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SurveyItemAdapter implements JsonDeserializer<SurveyItem>, JsonSerializer<SurveyItem> {

	private static final String OBJECT_TYPE = "objectType";
	
	@Override
	public JsonElement serialize(SurveyItem src, Type typeOfSrc, JsonSerializationContext context) {
		return context.serialize(src);
	}
	
	@Override
	public SurveyItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		JsonPrimitive prim = (JsonPrimitive) json.getAsJsonObject().get(OBJECT_TYPE);
        String objectType = prim.getAsString();
		return context.deserialize(json, SurveyItemMapping.getEnumByObjectType(objectType).getItemClass());
	}

}
