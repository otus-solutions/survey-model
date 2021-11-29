package org.ccem.otus.survey.template.item.questions.selectable;

import java.util.List;
import java.util.Optional;

import org.ccem.otus.survey.template.item.questions.Question;
import org.ccem.otus.survey.template.item.questions.selectable.options.RadioOption;

public class SingleSelectionQuestion extends Question {
	
	public List<RadioOption> options;
	public Optional<String> imageUrl;

}
