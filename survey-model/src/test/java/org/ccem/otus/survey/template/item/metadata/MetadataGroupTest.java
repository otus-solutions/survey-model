package org.ccem.otus.survey.template.item.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.ccem.otus.survey.template.item.questions.metadata.MetadataGroup;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MetadataGroupTest {
	
	public MetadataGroup metadataGroup;
	
	@Before
	public void setUp() {
		String json = ""
				+ "{\"extents\": \"StudioObject\","
				+ "\"objectType\": \"MetadataGroup\","
				+ "\"options\": []}";
		
		metadataGroup = new Gson().fromJson(json, MetadataGroup.class);
	}
	
	@Test
	public void should_parse_correctly_extends_attribute() {
		assertEquals("StudioObject", metadataGroup.extents);
	}

	@Test
	public void should_parse_correctly_objectType_attribute() {
		assertEquals("MetadataGroup", metadataGroup.objectType);
	}

	@Test
	public void should_parse_correctly_options_attribute() {
		assertTrue(metadataGroup.options instanceof List<?>);
	}

	@Test
	public void should_contain_two_MetadataOptionsDto() {
		assertEquals(0, metadataGroup.options.size());
	}

}
