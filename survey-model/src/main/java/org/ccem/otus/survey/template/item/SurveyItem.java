package org.ccem.otus.survey.template.item;

import java.util.ArrayList;
import java.util.List;

public class SurveyItem {
	
	public String extents;
	public String objectType;
	public String templateID;
	public String customID;
	public String dataType;

	public List<String> getOptionsIDs(){
		List<String> ids = new ArrayList<>();
		return ids;
	}

	public List<String> getAllIDs(){
		List<String> ids = new ArrayList<>();

		ids.addAll(getOptionsIDs());
		ids.addAll(getQuestionIDs());

		return ids;
	}

	private List<String> getQuestionIDs(){
		List<String> ids = new ArrayList<>();
		ids.add(customID + "_metadata");
		ids.add(customID + "_comment");
		return ids;
	}


}
