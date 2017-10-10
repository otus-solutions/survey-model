package org.ccem.otus.survey.template.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ccem.otus.survey.template.enums.SurveyItemMapping;

public class SurveyItem {

	public String extents;
	public String objectType;
	public String templateID;
	public String customID;
	public String dataType;

	public List<String> getExtractionIDs() {
		List<String> ids = new ArrayList<>();
		ids.add(this.customID);
		return ids;
	}

	public Map<String, String> mapIDS(){
		Map<String, String> map = new HashMap<>();
		map.put(templateID, customID);
		return map;
	}

	public boolean isQuestion() {
		return SurveyItemMapping.isQuestion(objectType);
	}

	public String getTemplateID() {
		return templateID;
	}

	public String getCustomID() {
		return customID;
	}

}
