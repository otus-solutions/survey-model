package org.ccem.otus.survey.template.item.questions.selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


	@Override
	public Map<String, String> mapIDS(){
		Map<String, String> map = new HashMap<>();
		map.put(templateID, customID);
		for (CheckboxOption option : options) {
			map.put(option.optionID, option.customOptionID);
		}
		return map;
	}


}
