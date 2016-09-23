package org.ccem.otus.template.item.questions.fillingRules;

import org.ccem.otus.template.item.questions.fillingRules.validators.Mandatory;
import org.ccem.otus.template.item.questions.fillingRules.validators.calendar.FutureDate;
import org.ccem.otus.template.item.questions.fillingRules.validators.calendar.MaxDate;
import org.ccem.otus.template.item.questions.fillingRules.validators.calendar.MinDate;
import org.ccem.otus.template.item.questions.fillingRules.validators.calendar.PastDate;
import org.ccem.otus.template.item.questions.fillingRules.validators.calendar.RangeDate;
import org.ccem.otus.template.item.questions.fillingRules.validators.decimal.Scale;
import org.ccem.otus.template.item.questions.fillingRules.validators.integer.Distinct;
import org.ccem.otus.template.item.questions.fillingRules.validators.integer.In;
import org.ccem.otus.template.item.questions.fillingRules.validators.integer.LowerLimit;
import org.ccem.otus.template.item.questions.fillingRules.validators.integer.Precision;
import org.ccem.otus.template.item.questions.fillingRules.validators.integer.UpperLimit;
import org.ccem.otus.template.item.questions.fillingRules.validators.text.Alphanumeric;
import org.ccem.otus.template.item.questions.fillingRules.validators.text.LowerCase;
import org.ccem.otus.template.item.questions.fillingRules.validators.text.MaxLength;
import org.ccem.otus.template.item.questions.fillingRules.validators.text.MinLength;
import org.ccem.otus.template.item.questions.fillingRules.validators.text.Specials;
import org.ccem.otus.template.item.questions.fillingRules.validators.text.UpperCase;
import org.ccem.otus.template.item.questions.fillingRules.validators.time.MaxTime;
import org.ccem.otus.template.item.questions.fillingRules.validators.time.MinTime;

public class Options {
	
	public Mandatory mandatory;
	
	/* CalendarQuestion */
	public PastDate pastDate;
	public FutureDate futureDate;
	public MinDate minDate;
	public RangeDate rangeDate;
	public MaxDate maxDate;
	
	/* IntegerQuestion */
	public Distinct distinct;
	public LowerLimit lowerLimit;
	public UpperLimit upperLimit;
	public Precision precision;
	public In in;
	
	/* DecimalQuestion */
	public Scale scale;
	
	/* TextQuestion */
	public Alphanumeric alphanumeric;
	public LowerCase lowerCase;
	public UpperCase upperCase;
	public Specials specials;
	public MinLength minLength;
	public MaxLength maxLength;
	
	/* TimeQuestion */
	public MinTime minTime;
	public MaxTime maxTime;
	
}
