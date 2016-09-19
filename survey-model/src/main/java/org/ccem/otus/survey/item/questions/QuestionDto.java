package org.ccem.otus.survey.item.questions;

import org.ccem.otus.survey.item.SurveyItemDto;
import org.ccem.otus.survey.item.label.LabelDto;
import org.ccem.otus.survey.item.questions.fillingRules.FillingRulesDto;
import org.ccem.otus.survey.item.questions.metadata.MetadataGroupDto;

public class QuestionDto extends SurveyItemDto {
	
	public LabelDto label;
	public MetadataGroupDto metadata;
	public FillingRulesDto fillingRules;
	
}
