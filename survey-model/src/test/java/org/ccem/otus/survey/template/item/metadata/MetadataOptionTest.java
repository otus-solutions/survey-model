package org.ccem.otus.survey.template.item.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.item.label.Label;
import org.ccem.otus.survey.template.item.questions.metadata.MetadataOption;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MetadataOptionTest {
	
	public MetadataOption metadataOption;
	
	@Before
	public void setUp() {
		String json = "{\"extents\": \"StudioObject\","
				+ "\"objectType\": \"MetadataAnswer\","
				+ "\"dataType\": \"Integer\","
				+ "\"value\": 1,"
				+ "\"extractionValue\": \".anyValue\","
				+ "\"label\": "
					+ "{\"ptBR\": "
						+ "{\"extends\": \"StudioObject\","
						+ "\"objectType\": \"Label\","
						+ "\"oid\": \"123\","
						+ "\"plainText\": \"A participante não quer responder\","
						+ "\"formattedText\": \"<div>A participante não quer responder</div>\"},"
					+ "\"enUS\":"
						+ "{\"extends\": \"StudioObject\","
						+ "\"objectType\": \"Label\","
						+ "\"oid\": \"1561156\","
						+ "\"plainText\": \"The participant does not want to answer\","
						+ "\"formattedText\": \"<div>The participant does not want to answer</div>\"},"
					+ "\"esES\": {\"extends\": \"StudioObject\","
						+ "\"objectType\": \"Label\","
						+ "\"oid\": \"465465\","
						+ "\"plainText\": \"El participante no quiere contestar\","
						+ "\"formattedText\": \"<div>El participante no quiere contestar</div>\"}}}";
		
		metadataOption = new Gson().fromJson(json, MetadataOption.class);
	}
	
	@Test
	public void should_parse_correctly_extends_attribute() {
		assertEquals("StudioObject", metadataOption.extents);
	}

	@Test
	public void should_parse_correctly_objectType_attribute() {
		assertEquals("MetadataAnswer", metadataOption.objectType);
	}

	@Test
	public void should_parse_correctly_dataType_attribute() {
		assertEquals("Integer", metadataOption.dataType);
	}

	@Test
	public void should_parse_correctly_value_attribute() {
		assertEquals(Integer.valueOf("1"), metadataOption.value);
	}
	
	@Test
	public void should_parse_correctly_extraction_value_attribute() {
		assertEquals(".anyValue", metadataOption.extractionValue);
	}

	@Test
	public void should_parse_correctly_label_attribute() {
		assertTrue(metadataOption.label instanceof Label);
	}

}
