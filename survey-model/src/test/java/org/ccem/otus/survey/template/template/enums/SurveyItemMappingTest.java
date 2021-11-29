package org.ccem.otus.survey.template.template.enums;

import org.ccem.otus.survey.template.enums.SurveyItemMapping;
import org.ccem.otus.survey.template.item.miscellaneous.ImageItem;
import org.ccem.otus.survey.template.item.miscellaneous.TextItem;
import org.ccem.otus.survey.template.item.questions.*;
import org.ccem.otus.survey.template.item.questions.grid.integer.GridIntegerQuestion;
import org.ccem.otus.survey.template.item.questions.grid.single_selection.GridSingleSelectionQuestion;
import org.ccem.otus.survey.template.item.questions.grid.text.GridTextQuestion;
import org.ccem.otus.survey.template.item.questions.numeric.DecimalQuestion;
import org.ccem.otus.survey.template.item.questions.numeric.IntegerQuestion;
import org.ccem.otus.survey.template.item.questions.selectable.CheckboxQuestion;
import org.ccem.otus.survey.template.item.questions.selectable.SingleSelectionQuestion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SurveyItemMappingTest {
    public static final String CALENDAR_QUESTION = "CalendarQuestion";
    public static final String INTEGER_QUESTION = "IntegerQuestion";
    public static final String DECIMAL_QUESTION = "DecimalQuestion";
    public static final String SINGLE_SELECTION_QUESTION = "SingleSelectionQuestion";
    public static final String CHECKBOX_QUESTION = "CheckboxQuestion";
    public static final String TEXT_QUESTION = "TextQuestion";
    public static final String EMAIL_QUESTION = "EmailQuestion";
    public static final String TIME_QUESTION = "TimeQuestion";
    public static final String PHONE_QUESTION = "PhoneQuestion";
    public static final String FILE_UPLOAD_QUESTION = "FileUploadQuestion";
    public static final String GRID_TEXT_QUESTION = "GridTextQuestion";
    public static final String GRID_INTEGER_QUESTION = "GridIntegerQuestion";
    public static final String GRID_SINGLE_SELECTION_QUESTION = "GridSingleSelectionQuestion";
    public static final String TEXT_ITEM = "TextItem";
    public static final String IMAGE_ITEM = "ImageItem";

    @Test
    public void method_getEnumByObjectType_should_return_calendar_question(){
        SurveyItemMapping calendarQuestion = SurveyItemMapping.getEnumByObjectType(CALENDAR_QUESTION);
        assertEquals(calendarQuestion.getItemClass(), CalendarQuestion.class);
        assertEquals(calendarQuestion.getSurveyItemType(), CALENDAR_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_integer_question(){
        SurveyItemMapping integerQuestion = SurveyItemMapping.getEnumByObjectType(INTEGER_QUESTION);
        assertEquals(integerQuestion.getItemClass(), IntegerQuestion.class);
        assertEquals(integerQuestion.getSurveyItemType(), INTEGER_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_decimal_question(){
        SurveyItemMapping decimalQuestion = SurveyItemMapping.getEnumByObjectType(DECIMAL_QUESTION);
        assertEquals(decimalQuestion.getItemClass(), DecimalQuestion.class);
        assertEquals(decimalQuestion.getSurveyItemType(), DECIMAL_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_single_selection_question(){
        SurveyItemMapping singleSelectionQuestion = SurveyItemMapping.getEnumByObjectType(SINGLE_SELECTION_QUESTION);
        assertEquals(singleSelectionQuestion.getItemClass(), SingleSelectionQuestion.class);
        assertEquals(singleSelectionQuestion.getSurveyItemType(), SINGLE_SELECTION_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_checkbox_question(){
        SurveyItemMapping checkboxQuestion = SurveyItemMapping.getEnumByObjectType(CHECKBOX_QUESTION);
        assertEquals(checkboxQuestion.getItemClass(), CheckboxQuestion.class);
        assertEquals(checkboxQuestion.getSurveyItemType(), CHECKBOX_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_text_question(){
        SurveyItemMapping textQuestion = SurveyItemMapping.getEnumByObjectType(TEXT_QUESTION);
        assertEquals(textQuestion.getItemClass(), TextQuestion.class);
        assertEquals(textQuestion.getSurveyItemType(), TEXT_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_email_question(){
        SurveyItemMapping emailQuestion = SurveyItemMapping.getEnumByObjectType(EMAIL_QUESTION);
        assertEquals(emailQuestion.getItemClass(), EmailQuestion.class);
        assertEquals(emailQuestion.getSurveyItemType(), EMAIL_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_time_question(){
        SurveyItemMapping timeQuestion = SurveyItemMapping.getEnumByObjectType(TIME_QUESTION);
        assertEquals(timeQuestion.getItemClass(), TimeQuestion.class);
        assertEquals(timeQuestion.getSurveyItemType(), TIME_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_phone_question(){
        SurveyItemMapping phoneQuestion = SurveyItemMapping.getEnumByObjectType(PHONE_QUESTION);
        assertEquals(phoneQuestion.getItemClass(), PhoneQuestion.class);
        assertEquals(phoneQuestion.getSurveyItemType(), PHONE_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_autocomplete_question(){
        SurveyItemMapping phoneQuestion = SurveyItemMapping.getEnumByObjectType(PHONE_QUESTION);
        assertEquals(phoneQuestion.getItemClass(), PhoneQuestion.class);
        assertEquals(phoneQuestion.getSurveyItemType(), PHONE_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_file_upload_question(){
        SurveyItemMapping fileUploadQuestion = SurveyItemMapping.getEnumByObjectType(FILE_UPLOAD_QUESTION);
        assertEquals(fileUploadQuestion.getItemClass(), FileUploadQuestion.class);
        assertEquals(fileUploadQuestion.getSurveyItemType(), FILE_UPLOAD_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_grid_text_question(){
        SurveyItemMapping gridTextQuestion = SurveyItemMapping.getEnumByObjectType(GRID_TEXT_QUESTION);
        assertEquals(gridTextQuestion.getItemClass(), GridTextQuestion.class);
        assertEquals(gridTextQuestion.getSurveyItemType(), GRID_TEXT_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_grid_single_selection_question() {
      SurveyItemMapping question = SurveyItemMapping.getEnumByObjectType(GRID_SINGLE_SELECTION_QUESTION);
      assertEquals(GridSingleSelectionQuestion.class, question.getItemClass());
      assertEquals(GRID_SINGLE_SELECTION_QUESTION, question.getSurveyItemType());
    }

    @Test
    public void method_getEnumByObjectType_should_return_grid_integer_question(){
        SurveyItemMapping gridIntegerQuestion = SurveyItemMapping.getEnumByObjectType(GRID_INTEGER_QUESTION);
        assertEquals(gridIntegerQuestion.getItemClass(), GridIntegerQuestion.class);
        assertEquals(gridIntegerQuestion.getSurveyItemType(), GRID_INTEGER_QUESTION);
    }

    @Test
    public void method_getEnumByObjectType_should_return_text_item(){
        SurveyItemMapping textItem = SurveyItemMapping.getEnumByObjectType(TEXT_ITEM);
        assertEquals(textItem.getItemClass(), TextItem.class);
        assertEquals(textItem.getSurveyItemType(), TEXT_ITEM);
    }

    @Test
    public void method_getEnumByObjectType_should_return_image_item(){
        SurveyItemMapping imageItem = SurveyItemMapping.getEnumByObjectType(IMAGE_ITEM);
        assertEquals(imageItem.getItemClass(), ImageItem.class);
        assertEquals(imageItem.getSurveyItemType(), IMAGE_ITEM);
    }
}
