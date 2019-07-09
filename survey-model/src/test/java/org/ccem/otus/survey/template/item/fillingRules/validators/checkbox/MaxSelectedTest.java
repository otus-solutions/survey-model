package org.ccem.otus.survey.template.item.fillingRules.validators.checkbox;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.checkbox.MaxSelected;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MaxSelectedTest {

  private MaxSelected maxSelected;

  @Before
  public void setUp() {
      String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"maxSelected\",\"data\": {\"canBeIgnored\":true, \"reference\": 1}}";

      maxSelected = new Gson().fromJson(json, MaxSelected.class);
  }

  @Test
  public void should_deserialize_correctly_Distinct() {
      assertEquals("StudioObject", maxSelected.extents);
      assertEquals("Rule", maxSelected.objectType);
      assertEquals("maxSelected", maxSelected.validatorType);
      assertEquals(Double.valueOf("1.0"), maxSelected.data.reference);
  }
  
}
