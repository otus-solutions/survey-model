package org.ccem.otus.survey.template.item.questions.grid.single_selection;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.ccem.otus.survey.template.item.questions.Question;
import org.ccem.otus.survey.template.item.questions.selectable.SingleSelectionQuestion;
import org.ccem.otus.survey.template.item.questions.selectable.options.RadioOption;

public class GridSingleSelectionQuestion extends Question {
  public List<SingleSelectionQuestion> items;
  public List<RadioOption> options;

	@Override
	public List<String> getExtractionIDs(){
		return items.stream()
      .map(question -> question.customID)
      .collect(Collectors.toList());
	}

	@Override
	public Map<String, String> mapIDS(){
    return items.stream()
      .collect(Collectors.toMap(
        SingleSelectionQuestion::getTemplateID,
        SingleSelectionQuestion::getCustomID
      ));
	}
}