package org.ccem.otus.survey.template.item;

import java.util.ArrayList;
import java.util.List;

public class SurveyItem {
	
	public String extents;
	public String objectType;
	public String templateID;
	public String customID;
	public String dataType;

	public List<String> getExtractionIDs(){
		List<String> ids = new ArrayList<>();
		ids.add(this.customID);
		return ids;
	}

	public String getTemplateID() {
		return templateID;
	}

	public String getCustomID() {
		return customID;
	}

	// TODO: 02/10/17 refactor
	public List<String> getItemIDs(){
		List<String> ids = new ArrayList<>();
		ids.addAll(getExtractionIDs());
		return ids;
	}


}
