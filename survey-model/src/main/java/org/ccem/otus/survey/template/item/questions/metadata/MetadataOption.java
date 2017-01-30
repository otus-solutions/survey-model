package org.ccem.otus.survey.template.item.questions.metadata;

import org.ccem.otus.survey.template.item.label.Label;

import com.google.gson.annotations.SerializedName;

public class MetadataOption {

	@SerializedName("extends")
	public String extents;
	public String objectType;
	public String dataType;
	public Integer value;
	public String extractionValue;
	public Label label;

}
