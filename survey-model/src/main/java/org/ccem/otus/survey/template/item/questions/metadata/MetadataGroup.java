package org.ccem.otus.survey.template.item.questions.metadata;

import java.util.List;
import java.util.Optional;

public class MetadataGroup {

	public String extents;
	public String objectType;
	public List<MetadataOption> options;

	public Optional<MetadataOption> getMetadataByValue(Integer value){
		return options.stream().filter(metadata -> metadata.value.equals(value)).findFirst();
	}

}
