package org.ccem.otus.survey.navigation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class RouteTest {
	
	private Route route;
	
	@Before
	public void setUp() {
		
		String routeJson = "{"
				+ "\"extents\": \"StudioObject\","
				+ "\"objectType\": \"Route\","
				+ "\"name\": \"1\","
				+ "\"origin\": \"CO1\","
				+ "\"destination\": \"CO2\","
				+ "\"conditionSet\": {}}";
		
		route = new Gson().fromJson(routeJson, Route.class);
	}
	
	@Test
	public void should_deserialize_correctly_Route_Json() {
		
		assertEquals("StudioObject", route.extents);
		assertEquals("Route", route.objectType);
		assertEquals("1", route.name);
		assertEquals("CO1", route.origin);
		assertEquals("CO2", route.destination);
		
		assertTrue(route.conditionSet instanceof RouteConditionSet);
	}

}
