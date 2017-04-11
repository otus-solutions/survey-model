package org.ccem.otus.survey.template.item.questions.fillingRules.validators.reference;

import org.ccem.otus.survey.template.utils.date.ImmutableDate;

public class RangeImmutableDateReference {

	public RangeReferenceDto reference;
	public boolean canBeIgnored;

	// Inner class
	public class RangeReferenceDto {

		public ImmutableDate initial;
		public ImmutableDate end;

	}

}
