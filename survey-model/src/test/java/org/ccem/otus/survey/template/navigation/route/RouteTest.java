package org.ccem.otus.survey.template.navigation.route;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.ccem.otus.survey.template.navigation.route.Route;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class RouteTest {
	
	private Route route;
	
	@Before
	public void setUp() {
		
		String routeJson = "{\"extents\": \"SurveyTemplateObject\","
								+ "\"objectType\": \"Route\","
								+ "\"origin\": \"CAD1\","
								+ "\"destination\": \"CAD4\","
								+ "\"name\": \"CAD1_CAD4\","
								+ "\"isDefault\": true,"
								+ "\"conditions\": []}";
		
		route = new Gson().fromJson(routeJson, Route.class);
	}
	
	@Test
	public void should_deserialize_correctly_Route_Json() {
		
		assertEquals("SurveyTemplateObject", route.extents);
		assertEquals("Route", route.objectType);
		assertEquals("CAD1", route.origin);
		assertEquals("CAD4", route.destination);
		assertEquals("CAD1_CAD4", route.name);
		assertTrue(route.isDefault);
		
		assertTrue(route.conditions instanceof List<?>);
	}

}
