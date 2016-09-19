package org.ccem.otus.survey.item.questions.fillingRules;

import org.ccem.otus.survey.item.questions.fillingRules.validators.MandatoryDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.calendar.FutureDateDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.calendar.MaxDateDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.calendar.MinDateDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.calendar.PasteDateDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.calendar.RangeDateDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.decimal.ScaleDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.integer.DistinctDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.integer.InDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.integer.LowerLimitDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.integer.PrecisionDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.integer.UpperLimitDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.text.AlphanumericDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.text.LowerCaseDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.text.MaxLengthDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.text.MinLengthDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.text.SpecialsDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.text.UpperCaseDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.time.MaxTimeDto;
import org.ccem.otus.survey.item.questions.fillingRules.validators.time.MinTimeDto;

public class OptionsDto {
	
	public MandatoryDto mandatory;
	
	/* CalendarQuestion */
	public PasteDateDto pastDate;
	public FutureDateDto futureDate;
	public MinDateDto minDate;
	public RangeDateDto rangeDate;
	public MaxDateDto maxDate;
	
	/* IntegerQuestion */
	public DistinctDto distinct;
	public LowerLimitDto lowerLimit;
	public UpperLimitDto upperLimit;
	public PrecisionDto precision;
	public InDto in;
	
	/* DecimalQuestion */
	public ScaleDto scale;
	
	/* TextQuestion */
	public AlphanumericDto alphanumeric;
	public LowerCaseDto lowerCase;
	public UpperCaseDto upperCase;
	public SpecialsDto specials;
	public MinLengthDto minLength;
	public MaxLengthDto maxLength;
	
	/* TimeQuestion */
	public MinTimeDto minTime;
	public MaxTimeDto maxTime;
	
}
