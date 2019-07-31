package org.ccem.otus.survey.staticVariable;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class CustomizationDefinitionTest {
    private CustomizationDefinition customizationDefinition;

    @Before
    public void setUp() {
        String json = ""
                + "{\"value\": \"60Kg\","
                + "\"label\": \"Peso\"}";

        customizationDefinition = new Gson().fromJson(json, CustomizationDefinition.class);
    }

    @Test
    public void should_parse_correctly_value_attribute() {
        assertEquals("60Kg", customizationDefinition.value);
    }

    @Test
    public void should_parse_correctly_label_attribute() {
        assertEquals("Peso", customizationDefinition.label);
    }
}