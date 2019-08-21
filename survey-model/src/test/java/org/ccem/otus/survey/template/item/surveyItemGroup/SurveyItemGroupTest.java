package org.ccem.otus.survey.template.item.surveyItemGroup;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class SurveyItemGroupTest {
    private SurveyItemGroup surveyItemGroup;

    @Before
    public void setUp() {
        String json = ""
                + "{\"objectType\": \"SurveyItemGroup\","
                + "\"start\": \"DIC1\","
                + "\"end\": \"DIC3\","
                + "\"members\":[]}";

        surveyItemGroup = new Gson().fromJson(json, SurveyItemGroup.class);
    }

    @Test
    public void should_parse_correctly_objectType_attribute(){
        assertEquals("SurveyItemGroup",surveyItemGroup.objectType);
    }

    @Test
    public void should_parse_correctly_start_attribute(){
        assertEquals("DIC1",surveyItemGroup.start);
    }

    @Test
    public void should_parse_correctly_end_attribute(){
        assertEquals("DIC3",surveyItemGroup.end);
    }

    @Test
    public void should_parse_correctly_members_attribute(){
        assertTrue(surveyItemGroup.members instanceof List<?>);
    }
}