package org.ccem.otus.survey.identity;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class IdentityTest {
	
	private Identity identity;
	
	@Before
	public void setUp() {
		String json = ""
				+ "{\"extents\": \"StudioObject\","
				+ "\"objectType\": \"SurveyIdentity\","
				+ "\"name\": \"Formulário Teste\","
				+ "\"acronym\": \"TST\","
				+ "\"recommendedTo\": \"Qualquer pesquisa\","
				+ "\"description\": \"Descrição do formulário\","
				+ "\"keywords\": [\"TESTE\", \"TST\"]}";
		
		identity = new Gson().fromJson(json, Identity.class);
	}
	
	@Test
	public void should_parse_correctly_extends_attribute() {
		assertEquals("StudioObject", identity.extents);
	}

	@Test
	public void should_parse_correctly_objectType_attribute() {
		assertEquals("SurveyIdentity", identity.objectType);
	}

	@Test
	public void should_parse_correctly_name_attribute() {
		assertEquals("Formulário Teste", identity.name);
	}

	@Test
	public void should_parse_correctly_acronym_attribute() {
		assertEquals("TST", identity.acronym);
	}

	@Test
	public void should_parse_correctly_recommendedTo_attribute() {
		assertEquals("Qualquer pesquisa", identity.recommendedTo);
	}

	@Test
	public void should_parse_correctly_description_attribute() {
		assertEquals("Descrição do formulário", identity.description);
	}

	@Test
	public void should_parse_correctly_keywords_attribute() {
		List<String> keywords = Arrays.asList("TESTE", "TST");
		assertEquals(keywords, identity.keywords);
	}

}
