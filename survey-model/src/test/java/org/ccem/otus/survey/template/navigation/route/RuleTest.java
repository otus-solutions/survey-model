package org.ccem.otus.survey.template.navigation.route;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.navigation.route.Rule;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class RuleTest {
	
	private Rule rule;
	
	@Before
	public void setUp() {
		
		String ruleJson = "{\"extents\": \"SurveyTemplateObject\","
						  + "\"objectType\": \"Rule\","
						  + "\"when\": \"CAD1\","
						  + "\"operator\": \"equal\","
						  + "\"answer\": 1,"
						  + "\"isMetadata\": true}";
		
		rule = new Gson().fromJson(ruleJson, Rule.class);
	}
	
	@Test
	public void should_deserialize_correctly_Rule_Json() {
		
		assertEquals("SurveyTemplateObject", rule.extents);
		assertEquals("Rule", rule.objectType);
		assertEquals("CAD1", rule.when);
		assertEquals("equal", rule.operator);
		assertEquals("1", rule.answer);
		assertTrue(rule.isMetadata);
	}

}
