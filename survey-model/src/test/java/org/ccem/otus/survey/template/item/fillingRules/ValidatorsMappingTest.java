package org.ccem.otus.survey.template.item.fillingRules;

import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.item.questions.fillingRules.ValidatorsMapping;
import org.junit.Test;

public class ValidatorsMappingTest {

  @Test
  public void getEnumByObjectType_method_should_return_quantity_validator() {
    ValidatorsMapping validatorEnum = ValidatorsMapping.getEnumByObjectType("quantity");

    assertTrue(validatorEnum.getValidatorClass().getSimpleName().equals("Quantity"));
  }

  @Test
  public void getEnumByObjectType_method_should_return_minSelected_validator() {
    ValidatorsMapping validatorEnum = ValidatorsMapping.getEnumByObjectType("minSelected");

    assertTrue(validatorEnum.getValidatorClass().getSimpleName().equals("MinSelected"));
  }

  @Test
  public void getEnumByObjectType_method_should_return_maxSelected_validator() {
    ValidatorsMapping validatorEnum = ValidatorsMapping.getEnumByObjectType("maxSelected");

    assertTrue(validatorEnum.getValidatorClass().getSimpleName().equals("MaxSelected"));
  }

}
