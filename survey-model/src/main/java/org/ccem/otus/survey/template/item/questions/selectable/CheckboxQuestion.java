package org.ccem.otus.survey.template.item.questions.selectable;

import java.util.ArrayList;
import java.util.List;

import org.ccem.otus.survey.template.item.questions.Question;
import org.ccem.otus.survey.template.item.questions.selectable.options.CheckboxOption;

public class CheckboxQuestion extends Question {
	
	public List<CheckboxOption> options;

	@Override
	public List<String> getExtractionIDs(){
		List<String> ids = new ArrayList<>();
		options.forEach(checkboxOption -> ids.add(checkboxOption.customOptionID));
		return ids;
	}
}
