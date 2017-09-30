package org.ccem.otus.survey.template.item.miscellaneous;

import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.item.label.Label;

import java.util.ArrayList;
import java.util.List;

public class TextItem extends SurveyItem {

	public Label value;

	@Override
	public List<String> getOptionsIDs(){
		List<String> ids = new ArrayList<>();
		return ids;
	}
}
