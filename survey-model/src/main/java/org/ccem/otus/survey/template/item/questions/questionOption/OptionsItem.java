package org.ccem.otus.survey.template.item.questions.questionOption;

import java.util.HashMap;
import java.util.Map;

import org.ccem.otus.survey.template.item.questions.questionOption.validators.GenericOption;

public class OptionsItem {
	private Map<String, GenericOption> validators;

	public OptionsItem() {
		this.validators = new HashMap<String, GenericOption>();
	}

	public Map<String, GenericOption> getOptions() {
		return validators;
	}

	public void addOption(String option, GenericOption genericOption) {
		validators.put(option, genericOption);
	}
}
