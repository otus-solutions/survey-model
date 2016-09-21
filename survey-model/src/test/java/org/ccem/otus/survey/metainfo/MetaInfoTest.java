package org.ccem.otus.survey.metainfo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MetaInfoTest {

	private MetaInfo metainfo;
	
	@Before
	public void setUp() {
		String json = "{\"extents\": \"StudioObject\",\"objectType\": \"SurveyMetaInfo\",\"creationDatetime\": 1471355878772,\"otusStudioVersion\": \"1.0\"}";
		metainfo = new Gson().fromJson(json, MetaInfo.class);
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
		assertEquals("1471355878772", metainfo.creationDatetime);
	}

	@Test
	public void should_parse_correctly_otusStudioVersion_attribute() {
		assertEquals("1.0", metainfo.otusStudioVersion);
	}

}
