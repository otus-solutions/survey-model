package org.ccem.otus.survey.template.utils.adapters;

import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.Set;

import org.ccem.otus.survey.template.item.questions.fillingRules.Options;
import org.ccem.otus.survey.template.item.questions.fillingRules.ValidatorsMapping;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.generic.GenericValidator;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class OptionsAdapter implements JsonDeserializer<Options>, JsonSerializer<Options> {

	@Override
	public JsonElement serialize(Options src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();

		Set<Entry<String, GenericValidator>> entrySet = src.getValidators().entrySet();

		for (Entry<String, GenericValidator> validator : entrySet) {
			ValidatorsMapping validatorEnum = ValidatorsMapping.getEnumByObjectType(validator.getKey());
			JsonElement serialized = context.serialize(validator.getValue(), validatorEnum.getValidatorClass());

			jsonObject.add(validator.getKey(), serialized);
		}

		return jsonObject;

	}

	@Override
	public Options deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		Options options = new Options();

		Set<Entry<String, JsonElement>> set = json.getAsJsonObject().entrySet();

		for (Entry<String, JsonElement> entry : set) {
			ValidatorsMapping validatorEnum = ValidatorsMapping.getEnumByObjectType(entry.getKey());
			validatorEnum.getValidatorType();
			GenericValidator deserialized = context.deserialize(entry.getValue(), validatorEnum.getValidatorClass());

			options.addValidator(entry.getKey(), deserialized);
		}

		return options;
	}

}
