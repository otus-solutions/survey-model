package org.ccem.otus.survey.template.utils.adapters;

import org.ccem.otus.survey.template.item.questions.fillingRules.Options;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class OptionsAdapterTest {
	
	private Options options;
	private Gson gson;
	public JsonObject json;
	
	
	@Before
	public void setUp() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Options.class, new OptionsAdapter());
		gson = builder.create();

		JsonObject booleanDataReference = new JsonObject();
		booleanDataReference.addProperty("reference", true);

		JsonObject mandatory = new JsonObject();
		mandatory.addProperty("extends", "StudioObject");
		mandatory.addProperty("objectType", "Rule");
		mandatory.addProperty("validatorType", "mandatory");
		mandatory.add("data", booleanDataReference);
		
		
		json = new JsonObject();
		json.add("mandatory", mandatory);
		

	}
	@Ignore
	@Test
	public void should_deserialize_correctly_Object_Options() {
		options = gson.fromJson(json.toString(), Options.class);
		System.out.println(gson.toJson(options));
		System.out.println(json.toString());
		Assert.assertTrue(gson.toJson(options).contentEquals((CharSequence) json.toString().chars()));
	}

}
