package org.ccem.otus.survey.item.questions;

import org.ccem.otus.survey.item.SurveyItem;
import org.ccem.otus.survey.item.label.Label;
import org.ccem.otus.survey.item.questions.fillingRules.FillingRules;
import org.ccem.otus.survey.item.questions.metadata.MetadataGroup;

public class Question extends SurveyItem {
	
	public Label label;
	public MetadataGroup metadata;
	public FillingRules fillingRules;
	
}
