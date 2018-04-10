package org.ccem.otus.survey.template.utils.adapters;

import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.Set;

import org.ccem.otus.survey.template.item.questions.questionOption.OptionsItem;
import org.ccem.otus.survey.template.item.questions.questionOption.ValidatorMappingOption;
import org.ccem.otus.survey.template.item.questions.questionOption.validators.GenericOption;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class OptionsItemAdapter implements JsonDeserializer<OptionsItem>, JsonSerializer<OptionsItem> {

	@Override
	public JsonElement serialize(OptionsItem src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();

		Set<Entry<String, GenericOption>> entrySet = src.getOptions().entrySet();

		for (Entry<String, GenericOption> validator : entrySet) {
			ValidatorMappingOption validatorEnum = ValidatorMappingOption.getEnumByObjectType(validator.getKey());
			JsonElement serialized = context.serialize(validator.getValue(), validatorEnum.getValidatorClass());

			jsonObject.add(validator.getKey(), serialized);
		}

		return jsonObject;

	}

	@Override
	public OptionsItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		OptionsItem options = new OptionsItem();

		Set<Entry<String, JsonElement>> set = json.getAsJsonObject().entrySet();

		for (Entry<String, JsonElement> entry : set) {
			ValidatorMappingOption validatorEnum = ValidatorMappingOption.getEnumByObjectType(entry.getKey());
			validatorEnum.getValidatorType();
			GenericOption deserialized = context.deserialize(entry.getValue(), validatorEnum.getValidatorClass());

			options.addOption(entry.getKey(), deserialized);
		}

		return options;
	}

}

