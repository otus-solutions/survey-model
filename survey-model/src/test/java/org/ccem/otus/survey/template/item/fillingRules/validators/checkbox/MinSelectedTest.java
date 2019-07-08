package org.ccem.otus.survey.template.item.fillingRules.validators.checkbox;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.checkbox.MinSelected;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class MinSelectedTest {

  private MinSelected minSelected;

  @Before
  public void setUp() {
    String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"minSelected\",\"data\": {\"canBeIgnored\":true, \"reference\": 1}}";

    minSelected = new Gson().fromJson(json, MinSelected.class);
  }

  @Test
  public void should_deserialize_correctly_Distinct() {
    assertEquals("StudioObject", minSelected.extents);
    assertEquals("Rule", minSelected.objectType);
    assertEquals("minSelected", minSelected.validatorType);
    assertEquals(Double.valueOf("1.0"), minSelected.data.reference);
  }

}
