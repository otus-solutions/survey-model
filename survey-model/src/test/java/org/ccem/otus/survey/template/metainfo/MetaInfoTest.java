package org.ccem.otus.survey.template.metainfo;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.SurveyTemplate;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MetaInfoTest {

	private MetaInfo metainfo;
	private JsonObject json;
	private Gson gson;

	@Before
	public void setUp() {
		json = mockJson();
		gson = SurveyTemplate.getGsonBuilder().create();
		metainfo = gson.fromJson(json, MetaInfo.class);
	}

	@Test
	public void should_parse_correctly_extends_attribute() {
		assertEquals("StudioObject", metainfo.extents);
	}

	@Test
	public void should_parse_correctly_objectType_attribute() {
		assertEquals("SurveyMetaInfo", metainfo.objectType);
	}

	@Test
	public void should_parse_correctly_creationDatetime_attribute() {
		assertEquals(gson.toJson(json.get("creationDatetime")), gson.toJson(metainfo.creationDatetime));
	}

	@Test
	public void should_parse_correctly_otusStudioVersion_attribute() {
		assertEquals("1.0", metainfo.otusStudioVersion);
	}

	private JsonObject mockJson() {
		JsonObject metainfo = new JsonObject();

		metainfo.addProperty("extents", "StudioObject");
		metainfo.addProperty("objectType", "SurveyMetaInfo");
		metainfo.addProperty("creationDatetime", "2017-02-13T20:12:12.227Z");
		metainfo.addProperty("otusStudioVersion", "1.0");

		return metainfo;
	}

}
