package org.ccem.otus.survey.template.item.questions.fillingRules;

import org.ccem.otus.survey.template.item.questions.fillingRules.validators.Mandatory;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.calendar.FutureDate;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.calendar.MaxDate;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.calendar.MinDate;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.calendar.PastDate;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.calendar.RangeDate;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.decimal.Scale;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.generic.GenericValidator;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.integer.Distinct;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.integer.In;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.integer.LowerLimit;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.integer.Precision;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.integer.UpperLimit;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.text.Alphanumeric;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.text.LowerCase;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.text.MaxLength;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.text.MinLength;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.text.Specials;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.text.UpperCase;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.time.MaxTime;
import org.ccem.otus.survey.template.item.questions.fillingRules.validators.time.MinTime;

public enum ValidatorsMapping {
	
	Mandatory(Mandatory.class, "mandatory"),
	
	/* CalendarQuestion */
	PAST_DATE(PastDate.class, "pastDate"),
	FUTURE_DATE(FutureDate.class, "futureDate"),
	MIN_DATE(MinDate.class, "minDate"),
	RANGE_DATE(RangeDate.class, "rangeDate"),
	MAX_DATE(MaxDate.class, "maxDate"),
	
	/* IntegerQuestion */
	DISTINCT(Distinct.class, "distinct"),
	LOWER_LIMIT(LowerLimit.class, "lowerLimit"),
	UPPER_LIMIT(UpperLimit.class, "upperLimit"),
	PRECISION(Precision.class, "precision"),
	IN(In.class, "in"),
	
	/* DecimalQuestion */
	SCALE(Scale.class, "scale"),
	
	/* TextQuestion */
	ALPHANUMERIC(Alphanumeric.class, "alphanumeric"),
	LOWER_CASE(LowerCase.class, "lowerCase"),
	UPPER_CASE(UpperCase.class, "upperCase"),
	SPECIALS(Specials.class, "specials"),
	MIN_LENGTH(MinLength.class, "minLength"),
	MAX_LENGTH(MaxLength.class, "maxLength"),
	
	/* TimeQuestion */
	MIN_TIME(MinTime.class, "minTime"),
	MAX_TIME(MaxTime.class, "maxTime");
	
	
	private Class<? extends GenericValidator> validator;
	private String type;
	
	private ValidatorsMapping(Class<? extends GenericValidator> validator, String type) {
		this.validator = validator;
		this.type = type;
	}
	
	public Class<? extends GenericValidator> getValidatorClass() {
		return validator;
	}

	public String getValidatorType() {
		return type;
	}
	
	public static ValidatorsMapping getEnumByObjectType(String objectType) {
		ValidatorsMapping aux = null;
		
		for (ValidatorsMapping item : values()) {
			if(item.getValidatorType().equals(objectType)) {
				aux = item;
			}
		}
		
		if(aux == null) {
			throw new RuntimeException("Error: " + objectType + " was not found at ValidatorsMapping.");
		};
		
		return aux;
	}

}
