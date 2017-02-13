package org.ccem.otus.survey.template.item.questions.fillingRules.validators.reference;

public class RangeDateReference {

	public RangeReferenceDto reference;
	public boolean canBeIgnored;

	// Inner class
	public class RangeReferenceDto {

		public String initial;
		public String end;

	}

}
