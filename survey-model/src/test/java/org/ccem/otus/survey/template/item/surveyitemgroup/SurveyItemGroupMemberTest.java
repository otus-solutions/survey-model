package org.ccem.otus.survey.template.item.surveyitemgroup;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class SurveyItemGroupMemberTest {
    private SurveyItemGroupMember surveyItemGroupMember;

    @Before
    public void setUp() {
        String json = ""
                + "{\"id\": \"DIC1\","
                + "\"position\": \"start\"}";

       surveyItemGroupMember = new Gson().fromJson(json, SurveyItemGroupMember.class);
    }

    @Test
    public void should_parse_correctly_id_attribute(){
        assertEquals("DIC1",surveyItemGroupMember.id);
    }

     @Test
    public void should_parse_correctly_position_attribute(){
        assertEquals("start",surveyItemGroupMember.position);
    }
}