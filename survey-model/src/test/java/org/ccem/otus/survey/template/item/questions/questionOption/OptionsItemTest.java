package org.ccem.otus.survey.template.item.questions.questionOption;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.ccem.otus.survey.template.item.questions.questionOption.validators.GenericOption;
import org.junit.Before;
import org.junit.Test;

public class OptionsItemTest {

	private OptionsItem option;
	GenericOption genericValidator = new GenericOption() {
	};

	@Before
	public void setUp() {
		option = new OptionsItem();
		genericValidator.extents = "StudioObject";
		genericValidator.objectType = "OptionItem";
//		genericValidator.value = "true";
	}

	@Test
	public void should_get_options_method() {
		String value = "disabledButton";

		option.addOption(value, genericValidator);
		assertTrue(option.getOptions() instanceof Object);
		assertTrue(option.getOptions().get(value) instanceof GenericOption);
		option.getOptions().clear();
		assertEquals(option.getOptions().isEmpty(),true);
	}

	@Test
	public void should_add_option_method() {
		String value = "disabledButton";

		option.addOption(value, genericValidator);

		assertEquals("StudioObject", option.getOptions().get(value).extents);
		assertEquals("OptionItem", option.getOptions().get(value).objectType);
//		assertEquals("true", option.getOptions().get(value).value);
	}

}
