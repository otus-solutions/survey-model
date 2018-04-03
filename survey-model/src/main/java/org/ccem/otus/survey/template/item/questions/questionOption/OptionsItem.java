package org.ccem.otus.survey.template.item.questions.questionOption;

import java.util.HashMap;
import java.util.Map;

import org.ccem.otus.survey.template.item.questions.questionOption.validators.GenericOption;

public class OptionsItem {
	private Map<String, GenericOption> options;

	public OptionsItem() {
		this.options = new HashMap<String, GenericOption>();
	}

	public Map<String, GenericOption> getOptions() {
		return options;
	}

	public void addOption(String option, GenericOption genericValidator) {
		options.put(option, genericValidator);
	}
}
