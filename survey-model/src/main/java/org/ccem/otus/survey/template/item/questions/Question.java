package org.ccem.otus.survey.template.item.questions;

import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.item.label.Label;
import org.ccem.otus.survey.template.item.questions.fillingRules.FillingRules;
import org.ccem.otus.survey.template.item.questions.metadata.MetadataGroup;

public class Question extends SurveyItem {
	
	public Label label;
	public MetadataGroup metadata;
	public FillingRules fillingRules;
	
}
