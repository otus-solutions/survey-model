package org.ccem.otus.survey.template.item.fillingRules.validators.checkbox;

import static org.junit.Assert.assertEquals;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.checkbox.Quantity;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class QuantityTest {

  private Quantity quantity;

  @Before
  public void setUp() {
    String json = "{\"extends\": \"StudioObject\",\"objectType\": \"Rule\",\"validatorType\": \"quantity\",\"data\": {\"canBeIgnored\":true, \"reference\": 1}}";

    quantity = new Gson().fromJson(json, Quantity.class);
  }

  @Test
  public void should_deserialize_correctly_Distinct() {
    assertEquals("StudioObject", quantity.extents);
    assertEquals("Rule", quantity.objectType);
    assertEquals("quantity", quantity.validatorType);
    assertEquals(Double.valueOf("1.0"), quantity.data.reference);
  }

}
