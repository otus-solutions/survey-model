package org.ccem.otus.survey.staticVariable;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class StaticVariableDefinitionTest {
    private static final String CUSTOMIZATIONS = "{\"value\":\"60kg\",\"label\":\"Peso\"}";

    private StaticVariableDefinition staticVariableDefinition;

    @Mock
    private CustomizationDefinition customizationDefinition;

    @Before
    public void setUp() {
        String json = ""
                + "{\"objectType\": \"StaticVariable\","
                + "\"name\": \"ACTA\","
                + "\"label\": \"Peso\","
                + "\"sending\": \"1\","
                + "\"bindToWholeTemplate\": \"true\","
                + "\"bindTo\": [\"teste\",\"TST\"],"
                + "\"customizations\": [{\"value\":\"60kg\",\"label\":\"Peso\"}]}";

        staticVariableDefinition = new Gson().fromJson(json, StaticVariableDefinition.class);
    }

    @Test
    public void should_parse_correctly_objectType_attribute() {
        assertEquals("StaticVariable", staticVariableDefinition.objectType);
    }

    @Test
    public void should_parse_correctly_name_attribute() {
        assertEquals("ACTA", staticVariableDefinition.name);
    }

    @Test
    public void should_parse_correctly_label_attribute() {
        assertEquals("Peso", staticVariableDefinition.label);
    }

    @Test
    public void should_parse_correctly_sending_attribute() {
        assertEquals("1", staticVariableDefinition.sending);
    }

    @Test
    public void should_parse_correctly_bindTo_attribute() {
        assertEquals(true, staticVariableDefinition.bindToWholeTemplate);
    }

    @Test
    public void should_parse_correctly_bindToWholeTemplate_attribute() {
        List<String> bindTo = Arrays.asList("teste", "TST");
        assertEquals(bindTo, staticVariableDefinition.bindTo);
    }

    @Test
    public void should_parse_correctly_customizations_attribute() {
        customizationDefinition = new Gson().fromJson(CUSTOMIZATIONS, CustomizationDefinition.class);
        List<CustomizationDefinition> customizations = Arrays.asList(customizationDefinition);
        assertEquals(new Gson().toJson(customizations), new Gson().toJson(staticVariableDefinition.customizations));
    }
}