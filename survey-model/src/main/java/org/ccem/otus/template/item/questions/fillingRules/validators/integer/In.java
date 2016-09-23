package org.ccem.otus.template.item.questions.fillingRules.validators.integer;

import org.ccem.otus.template.item.questions.fillingRules.validators.generic.GenericValidator;

public class In extends GenericValidator {

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
