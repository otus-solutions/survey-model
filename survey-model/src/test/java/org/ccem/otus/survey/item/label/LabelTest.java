package org.ccem.otus.survey.item.label;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class LabelTest {
	
	public Label label;
	
	@Before
	public void setUp() {
		String json = "{\"ptBR\": "
				+ "{\"extends\": \"StudioObject\","
				+ "\"objectType\": \"Label\","
				+ "\"oid\": \"1\","
				+ "\"plainText\": \"Qual sua data de nascimento?\","
				+ "\"formattedText\": \"<div style='text-align: center;'>Qual sua data de nascimento?</div>\"},"
				+ "\"enUS\": "
				+ "{\"extends\": \"StudioObject\","
				+ "\"objectType\": \"Label\","
				+ "\"oid\": \"2\",\"plainText\": \"What is your birth date?\","
				+ "\"formattedText\": \"<div style='text-align: center;'>What is your birth date?</div>\"},"
				+ "\"esES\": {\"extends\": \"StudioObject\","
				+ "\"objectType\": \"Label\","
				+ "\"oid\": \"3\","
				+ "\"plainText\": \"¿Cuál es su fecha de nacimiento?\","
				+ "\"formattedText\": \"<div style='text-align: center;'>¿Cuál es su fecha de nacimiento?</div>\"}}";
		
		label = new Gson().fromJson(json, Label.class);
	}
	
	@Test
	public void should_parse_correctly_ptBR_extends_attribute() {
		assertEquals("StudioObject", label.ptBR.extents);
	}

	@Test
	public void should_parse_correctly_ptBR_objectType_attribute() {
		assertEquals("Label", label.ptBR.objectType);
	}

	@Test
	public void should_parse_correctly_ptBR_oid_attribute() {
		assertEquals("1", label.ptBR.oid);
	}

	@Test
	public void should_parse_correctly_ptBR_plainText_attribute() {
		assertEquals("Qual sua data de nascimento?", label.ptBR.plainText);
	}

	@Test
	public void should_parse_correctly_ptBR_formattedText_attribute() {
		assertEquals("<div style='text-align: center;'>Qual sua data de nascimento?</div>", label.ptBR.formattedText);
	}

	@Test
	public void should_parse_correctly_enUS_extends_attribute() {
		assertEquals("StudioObject", label.enUS.extents);
	}
	
	@Test
	public void should_parse_correctly_enUS_objectType_attribute() {
		assertEquals("Label", label.enUS.objectType);
	}
	
	@Test
	public void should_parse_correctly_enUS_oid_attribute() {
		assertEquals("2", label.enUS.oid);
	}
	
	@Test
	public void should_parse_correctly_enUS_plainText_attribute() {
		assertEquals("What is your birth date?", label.enUS.plainText);
	}
	
	@Test
	public void should_parse_correctly_enUS_formattedText_attribute() {
		assertEquals("<div style='text-align: center;'>What is your birth date?</div>", label.enUS.formattedText);
	}

	@Test
	public void should_parse_correctly_esES_extends_attribute() {
		assertEquals("StudioObject", label.esES.extents);
	}
	
	@Test
	public void should_parse_correctly_esES_objectType_attribute() {
		assertEquals("Label", label.esES.objectType);
	}
	
	@Test
	public void should_parse_correctly_esES_oid_attribute() {
		assertEquals("3", label.esES.oid);
	}
	
	@Test
	public void should_parse_correctly_esES_plainText_attribute() {
		assertEquals("¿Cuál es su fecha de nacimiento?", label.esES.plainText);
	}
	
	@Test
	public void should_parse_correctly_esES_formattedText_attribute() {
		assertEquals("<div style='text-align: center;'>¿Cuál es su fecha de nacimiento?</div>", label.esES.formattedText);
	}

}
