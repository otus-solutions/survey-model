package org.ccem.otus.survey.enums;

import org.ccem.otus.survey.item.SurveyItem;
import org.ccem.otus.survey.item.miscellaneous.ImageItem;
import org.ccem.otus.survey.item.miscellaneous.TextItem;
import org.ccem.otus.survey.item.questions.CalendarQuestion;
import org.ccem.otus.survey.item.questions.EmailQuestion;
import org.ccem.otus.survey.item.questions.PhoneQuestion;
import org.ccem.otus.survey.item.questions.TextQuestion;
import org.ccem.otus.survey.item.questions.TimeQuestion;
import org.ccem.otus.survey.item.questions.numeric.DecimalQuestion;
import org.ccem.otus.survey.item.questions.numeric.IntegerQuestion;
import org.ccem.otus.survey.item.questions.selectable.CheckboxQuestion;
import org.ccem.otus.survey.item.questions.selectable.SingleSelectionQuestion;

public enum SurveyItemMapping {
	
	CALENDAR_QUESTION(CalendarQuestion.class, "CalendarQuestion"),
	INTEGER_QUESTION(IntegerQuestion.class, "IntegerQuestion"),
	DECIMAL_QUESTION(DecimalQuestion.class, "DecimalQuestion"),
	SINGLE_SELECTION_QUESTION(SingleSelectionQuestion.class, "SingleSelectionQuestion"),
	CHECKBOX_QUESTION(CheckboxQuestion.class, "CheckboxQuestion"),
	TEXT_QUESTION(TextQuestion.class, "TextQuestion"),
	EMAIL_QUESTION(EmailQuestion.class, "EmailQuestion"),
	TIME_QUESTION(TimeQuestion.class, "TimeQuestion"),
	PHONE_QUESTION(PhoneQuestion.class, "PhoneQuestion"),
	
	TEXT_ITEM(TextItem.class, "TextItem"),
	IMAGE_ITEM(ImageItem.class, "ImageItem");
	
	private Class<? extends SurveyItem> surveyItem;
	private String type;
	
	private SurveyItemMapping(Class<? extends SurveyItem> surveyItem, String type) {
		this.surveyItem = surveyItem;
		this.type = type;
	}
	
	public Class<? extends SurveyItem> getItemClass() {
		return surveyItem;
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
