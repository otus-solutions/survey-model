package org.ccem.otus.survey.template.item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.ccem.otus.survey.template.item.SurveyItem;
import org.ccem.otus.survey.template.item.label.Label;
import org.ccem.otus.survey.template.item.miscellaneous.ImageItem;
import org.ccem.otus.survey.template.item.miscellaneous.TextItem;
import org.ccem.otus.survey.template.item.questions.CalendarQuestion;
import org.ccem.otus.survey.template.item.questions.EmailQuestion;
import org.ccem.otus.survey.template.item.questions.PhoneQuestion;
import org.ccem.otus.survey.template.item.questions.TextQuestion;
import org.ccem.otus.survey.template.item.questions.TimeQuestion;
import org.ccem.otus.survey.template.item.questions.fillingRules.FillingRules;
import org.ccem.otus.survey.template.item.questions.metadata.MetadataGroup;
import org.ccem.otus.survey.template.item.questions.numeric.DecimalQuestion;
import org.ccem.otus.survey.template.item.questions.numeric.IntegerQuestion;
import org.ccem.otus.survey.template.item.questions.numeric.unit.Unit;
import org.ccem.otus.survey.template.item.questions.selectable.CheckboxQuestion;
import org.ccem.otus.survey.template.item.questions.selectable.SingleSelectionQuestion;
import org.ccem.otus.survey.template.utils.adapters.SurveyItemAdapter;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SurveyItemTest {
	
	private SurveyItem surveyItem;
	private Gson gson;
	
	@Before
	public void setUp() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SurveyItem.class, new SurveyItemAdapter());
		gson = builder.create();
	}
	
	@Test
	public void should_deserialize_correctly_Calendar_Question() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.CALENDAR_QUESTION.json(), SurveyItem.class);
		
		CalendarQuestion calendarQuestionDto = new CalendarQuestion();
		calendarQuestionDto = (CalendarQuestion) surveyItem;
		
		assertTrue(surveyItem instanceof CalendarQuestion);
		
		assertEquals("SurveyItem", calendarQuestionDto.extents);
		assertEquals("CalendarQuestion", calendarQuestionDto.objectType);
		assertEquals("TY1", calendarQuestionDto.templateID);
		assertEquals("TY1", calendarQuestionDto.customID);
		assertEquals("LocalDate", calendarQuestionDto.dataType);
		
		assertTrue(calendarQuestionDto.label instanceof Label);
		assertTrue(calendarQuestionDto.metadata instanceof MetadataGroup);
		assertTrue(calendarQuestionDto.fillingRules instanceof FillingRules);
	}
	
	@Test
	public void should_deserialize_correctly_Integer_Question() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.INTEGER_QUESTION.json(), SurveyItem.class);
		
		IntegerQuestion integerQuestionDto = new IntegerQuestion();
		integerQuestionDto = (IntegerQuestion) surveyItem;
		
		
		assertEquals("SurveyItem", integerQuestionDto.extents);
		assertEquals("IntegerQuestion", integerQuestionDto.objectType);
		assertEquals("TY2", integerQuestionDto.templateID);
		assertEquals("TY2", integerQuestionDto.customID);
		assertEquals("Integer", integerQuestionDto.dataType);
		
		assertTrue(integerQuestionDto.label instanceof Label);
		assertTrue(integerQuestionDto.metadata instanceof MetadataGroup);
		assertTrue(integerQuestionDto.fillingRules instanceof FillingRules);
		
		assertTrue(integerQuestionDto.unit instanceof Unit);
	}

	@Test
	public void should_deserialize_correctly_Decimal_Question() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.DECIMAL_QUESTION.json(), SurveyItem.class);
		
		DecimalQuestion decimalQuestionDto = new DecimalQuestion();
		decimalQuestionDto = (DecimalQuestion) surveyItem;
		
		assertEquals("SurveyItem", decimalQuestionDto.extents);
		assertEquals("DecimalQuestion", decimalQuestionDto.objectType);
		assertEquals("TY3", decimalQuestionDto.templateID);
		assertEquals("TY3", decimalQuestionDto.customID);
		assertEquals("Decimal", decimalQuestionDto.dataType);
		
		assertTrue(decimalQuestionDto.label instanceof Label);
		assertTrue(decimalQuestionDto.metadata instanceof MetadataGroup);
		assertTrue(decimalQuestionDto.fillingRules instanceof FillingRules);

		assertTrue(decimalQuestionDto.unit instanceof Unit);
	}
	
	@Test
	public void should_deserialize_correctly_Text_Question() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.TEXT_QUESTION.json(), SurveyItem.class);
		
		TextQuestion textQuestionDto = new TextQuestion();
		textQuestionDto = (TextQuestion) surveyItem;
		
		assertEquals("SurveyItem", textQuestionDto.extents);
		assertEquals("TextQuestion", textQuestionDto.objectType);
		assertEquals("TY6", textQuestionDto.templateID);
		assertEquals("TY6", textQuestionDto.customID);
		assertEquals("String", textQuestionDto.dataType);
		
		assertTrue(textQuestionDto.label instanceof Label);
		assertTrue(textQuestionDto.metadata instanceof MetadataGroup);
		assertTrue(textQuestionDto.fillingRules instanceof FillingRules);
	}

	@Test
	public void should_deserialize_correctly_Email_Question() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.EMAIL_QUESTION.json(), SurveyItem.class);
		
		EmailQuestion emailQuestionDto = new EmailQuestion();
		emailQuestionDto = (EmailQuestion) surveyItem;
		
		assertEquals("SurveyItem", emailQuestionDto.extents);
		assertEquals("EmailQuestion", emailQuestionDto.objectType);
		assertEquals("TY7", emailQuestionDto.templateID);
		assertEquals("TY7", emailQuestionDto.customID);
		assertEquals("String", emailQuestionDto.dataType);
		
		assertTrue(emailQuestionDto.label instanceof Label);
		assertTrue(emailQuestionDto.metadata instanceof MetadataGroup);
		assertTrue(emailQuestionDto.fillingRules instanceof FillingRules);
	}

	@Test
	public void should_deserialize_correctly_Phone_Question() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.PHONE_QUESTION.json(), SurveyItem.class);
		
		PhoneQuestion phoneQuestionDto = new PhoneQuestion();
		phoneQuestionDto = (PhoneQuestion) surveyItem;
		
		assertEquals("SurveyItem", phoneQuestionDto.extents);
		assertEquals("PhoneQuestion", phoneQuestionDto.objectType);
		assertEquals("TY9", phoneQuestionDto.templateID);
		assertEquals("TY9", phoneQuestionDto.customID);
		assertEquals("Integer", phoneQuestionDto.dataType);
		
		assertTrue(phoneQuestionDto.label instanceof Label);
		assertTrue(phoneQuestionDto.metadata instanceof MetadataGroup);
		assertTrue(phoneQuestionDto.fillingRules instanceof FillingRules);
	}
	
	@Test
	public void should_deserialize_correctly_Time_Question() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.TIME_QUESTION.json(), SurveyItem.class);
		
		TimeQuestion timeQuestionDto = new TimeQuestion();
		timeQuestionDto = (TimeQuestion) surveyItem;
		
		assertEquals("SurveyItem", timeQuestionDto.extents);
		assertEquals("TimeQuestion", timeQuestionDto.objectType);
		assertEquals("TY8", timeQuestionDto.templateID);
		assertEquals("TY8", timeQuestionDto.customID);
		assertEquals("LocalTime", timeQuestionDto.dataType);
		
		assertTrue(timeQuestionDto.label instanceof Label);
		assertTrue(timeQuestionDto.metadata instanceof MetadataGroup);
		assertTrue(timeQuestionDto.fillingRules instanceof FillingRules);
	}
	
	@Test
	public void should_deserialize_correctly_Single_Selection_Question() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.SINGLE_SELECTION_QUESTION.json(), SurveyItem.class);
		
		SingleSelectionQuestion singleSelectionQuestionDto = new SingleSelectionQuestion();
		singleSelectionQuestionDto = (SingleSelectionQuestion) surveyItem;
		
		
		assertEquals("SurveyItem", singleSelectionQuestionDto.extents);
		assertEquals("SingleSelectionQuestion", singleSelectionQuestionDto.objectType);
		assertEquals("TY4", singleSelectionQuestionDto.templateID);
		assertEquals("TY4", singleSelectionQuestionDto.customID);
		assertEquals("Integer", singleSelectionQuestionDto.dataType);
		
		assertTrue(singleSelectionQuestionDto.label instanceof Label);
		assertTrue(singleSelectionQuestionDto.metadata instanceof MetadataGroup);
		assertTrue(singleSelectionQuestionDto.fillingRules instanceof FillingRules);

		assertTrue(singleSelectionQuestionDto.options instanceof List<?>);
	}

	@Test
	public void should_deserialize_correctly_Checkbox_Question() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.CHECKBOX_QUESTION.json(), SurveyItem.class);
		
		CheckboxQuestion checkboxQuestionDto = new CheckboxQuestion();
		checkboxQuestionDto = (CheckboxQuestion) surveyItem;
		
		assertEquals("SurveyItem", checkboxQuestionDto.extents);
		assertEquals("CheckboxQuestion", checkboxQuestionDto.objectType);
		assertEquals("TY5", checkboxQuestionDto.templateID);
		assertEquals("TY5", checkboxQuestionDto.customID);
		assertEquals("Array", checkboxQuestionDto.dataType);
		
		assertTrue(checkboxQuestionDto.label instanceof Label);
		assertTrue(checkboxQuestionDto.metadata instanceof MetadataGroup);
		assertTrue(checkboxQuestionDto.fillingRules instanceof FillingRules);

		assertTrue(checkboxQuestionDto.options instanceof List<?>);
	}
	
	@Test
	public void should_deserialize_correctly_Text_Item() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.TEXT_ITEM.json(), SurveyItem.class);
		
		TextItem textItemDto = new TextItem();
		textItemDto = (TextItem) surveyItem;
		
		assertEquals("SurveyItem", textItemDto.extents);
		assertEquals("TextItem", textItemDto.objectType);
		assertEquals("TY10", textItemDto.templateID);
		assertEquals("TY10", textItemDto.customID);
		assertEquals("String", textItemDto.dataType);
		
		assertTrue(textItemDto.value instanceof Label);
	}

	@Test
	public void should_deserialize_correctly_Image_Item() {
		surveyItem = gson.fromJson(SurveyItemTestUtils.IMAGE_ITEM.json(), SurveyItem.class);
		
		ImageItem imageItemDto = new ImageItem();
		imageItemDto = (ImageItem) surveyItem;
		
		assertEquals("SurveyItem", imageItemDto.extents);
		assertEquals("ImageItem", imageItemDto.objectType);
		assertEquals("TY11", imageItemDto.templateID);
		assertEquals("TY11", imageItemDto.customID);
		assertEquals("String", imageItemDto.dataType);
		
		assertEquals("http://www.site.com/imagem.jpg", imageItemDto.url);

		assertTrue(imageItemDto.footer instanceof Label);
	}
	
}
