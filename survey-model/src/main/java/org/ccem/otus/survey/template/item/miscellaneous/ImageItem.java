package org.ccem.otus.survey.template.item.miscellaneous;

import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.item.label.Label;

import java.util.ArrayList;
import java.util.List;

public class ImageItem extends SurveyItem {

	public String url;
	public Label footer;

	@Override
	public List<String> getAllIDs(){
		List<String> ids = new ArrayList<>();
		return ids;
	}
	
}
