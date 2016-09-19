package org.ccem.otus.survey.item.questions.fillingRules.validators.integer;

import org.ccem.otus.survey.item.questions.fillingRules.validators.generic.GenericValidatorDto;

public class InDto extends GenericValidatorDto {

	public ValidatorInData data;

	// Inner class
	public class ValidatorInData {

		public RangeInReference reference;

		// Inner class
		public class RangeInReference {
			
			public Integer initial;
			public Integer end;
		}

	}

}
