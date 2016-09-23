package org.ccem.otus.template.item.questions;

import org.ccem.otus.template.item.SurveyItem;
import org.ccem.otus.template.item.label.Label;
import org.ccem.otus.template.item.questions.fillingRules.FillingRules;
import org.ccem.otus.template.item.questions.metadata.MetadataGroup;

public class Question extends SurveyItem {
	
	public Label label;
	public MetadataGroup metadata;
	public FillingRules fillingRules;
	
}
