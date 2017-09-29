package org.ccem.otus.survey.template.item;

import java.util.ArrayList;
import java.util.List;

public class SurveyItem {
	
	public String extents;
	public String objectType;
	public String templateID;
	public String customID;
	public String dataType;

	public List<String> getAllIDs(){
		List<String> ids = new ArrayList<>();
		ids.add(customID);
		return ids;
	}

}
