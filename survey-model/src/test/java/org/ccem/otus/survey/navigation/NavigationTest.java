package org.ccem.otus.survey.navigation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class NavigationTest {
	
private Navigation navigation;
	
	@Before
	public void setUp() {
		
		String navigationJson = ""
				+ "{\"extents\": \"StudioObject\","
				+ "\"objectType\": \"Navigation\","
				+ "\"origin\": \"CO1\","
				+ "\"routes\": []}";
		
		navigation = new Gson().fromJson(navigationJson, Navigation.class);
	}
	
	@Test
	public void should_deserialize_correctly_Navigation_Json() {
		
		assertEquals("StudioObject", navigation.extents);
		assertEquals("Navigation", navigation.objectType);
		assertEquals("CO1", navigation.origin);
		
		assertTrue(navigation.routes instanceof List<?>);
	}

}
