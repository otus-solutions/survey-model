package org.ccem.otus.template.navigation.route;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class RouteConditionTest {

	private RouteCondition routeCondition;
	
	@Before
	public void setUp() {
		
		String routeConditionJson = "{\"extents\": \"SurveyTemplateObject\","
								+ "\"objectType\": \"RouteCondition\","
								+ "\"name\": \"ROUTE_CONDITION\","
								+ "\"rules\": []}";
		
		routeCondition = new Gson().fromJson(routeConditionJson, RouteCondition.class);
	}
	
	@Test
	public void should_deserialize_correctly_RouteCondition_Json() {
		assertEquals("SurveyTemplateObject", routeCondition.extents);
		assertEquals("RouteCondition", routeCondition.objectType);
		assertEquals("ROUTE_CONDITION", routeCondition.name);
		
		assertTrue(routeCondition.rules instanceof List<?>);
	}
}
