package org.ccem.otus.survey.template.navigation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.ccem.otus.survey.template.navigation.Navigation;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class NavigationTest {
	
	private Navigation navigation;
	
	@Before
	public void setUp() {
		
		String navigationJson = "{\"extents\": \"SurveyTemplateObject\","
				+ "\"objectType\": \"Navigation\","
				+ "\"origin\": \"CAD1\","
				+ "\"index\": 0,"
				+ "\"inNavigations\": [],"
				+ "\"routes\": []}";
		
		navigation = new Gson().fromJson(navigationJson, Navigation.class);
	}
	
	@Test
	public void should_deserialize_correctly_Navigation_Json() {
		assertEquals("SurveyTemplateObject", navigation.extents);
		assertEquals("Navigation", navigation.objectType);
		assertEquals("CAD1", navigation.origin);
		assertEquals(Integer.valueOf("0"), navigation.index);
		
		assertTrue(navigation.routes instanceof List<?>);
		assertTrue(navigation.inNavigations instanceof List<?>);
		
	}

}
