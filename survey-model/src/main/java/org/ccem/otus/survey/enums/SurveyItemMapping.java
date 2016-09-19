package org.ccem.otus.survey.enums;

import org.ccem.otus.survey.item.SurveyItemDto;
import org.ccem.otus.survey.item.miscellaneous.ImageItemDto;
import org.ccem.otus.survey.item.miscellaneous.TextItemDto;
import org.ccem.otus.survey.item.questions.CalendarQuestionDto;
import org.ccem.otus.survey.item.questions.EmailQuestionDto;
import org.ccem.otus.survey.item.questions.PhoneQuestionDto;
import org.ccem.otus.survey.item.questions.TextQuestionDto;
import org.ccem.otus.survey.item.questions.TimeQuestionDto;
import org.ccem.otus.survey.item.questions.numeric.DecimalQuestionDto;
import org.ccem.otus.survey.item.questions.numeric.IntegerQuestionDto;
import org.ccem.otus.survey.item.questions.selectable.CheckboxQuestionDto;
import org.ccem.otus.survey.item.questions.selectable.SingleSelectionQuestionDto;

public enum SurveyItemMapping {
	
	CALENDAR_QUESTION(CalendarQuestionDto.class, "CalendarQuestion"),
	INTEGER_QUESTION(IntegerQuestionDto.class, "IntegerQuestion"),
	DECIMAL_QUESTION(DecimalQuestionDto.class, "DecimalQuestion"),
	SINGLE_SELECTION_QUESTION(SingleSelectionQuestionDto.class, "SingleSelectionQuestion"),
	CHECKBOX_QUESTION(CheckboxQuestionDto.class, "CheckboxQuestion"),
	TEXT_QUESTION(TextQuestionDto.class, "TextQuestion"),
	EMAIL_QUESTION(EmailQuestionDto.class, "EmailQuestion"),
	TIME_QUESTION(TimeQuestionDto.class, "TimeQuestion"),
	PHONE_QUESTION(PhoneQuestionDto.class, "PhoneQuestion"),
	
	TEXT_ITEM(TextItemDto.class, "TextItem"),
	IMAGE_ITEM(ImageItemDto.class, "ImageItem");
	
	private Class<? extends SurveyItemDto> surveyItemDto;
	private String type;
	
	private SurveyItemMapping(Class<? extends SurveyItemDto> surveyItemDto, String type) {
		this.surveyItemDto = surveyItemDto;
		this.type = type;
	}
	
	public Class<? extends SurveyItemDto> getDtoClass() {
		return surveyItemDto;
	}

	public String getSurveyItemType() {
		return type;
	}
	
	public static SurveyItemMapping getEnumByObjectType(String objectType) {
		SurveyItemMapping aux = null;
		
		for (SurveyItemMapping item : values()) {
			if(item.getSurveyItemType().equals(objectType)) {
				aux = item;
			}
		}
		
		if(aux == null) {
			throw new RuntimeException("Error: " + objectType + " was not found at SurveyItemMapping.");
		};
		
		return aux;
	}

}
