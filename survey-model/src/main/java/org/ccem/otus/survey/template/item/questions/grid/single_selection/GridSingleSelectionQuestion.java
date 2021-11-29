package org.ccem.otus.survey.template.item.questions.grid.single_selection;

import java.util.List;

import org.ccem.otus.survey.template.item.questions.Question;
import org.ccem.otus.survey.template.item.questions.selectable.SingleSelectionQuestion;
import org.ccem.otus.survey.template.item.questions.selectable.options.RadioOption;

public class GridSingleSelectionQuestion extends Question {
  public List<SingleSelectionQuestion> items;
  public List<RadioOption> options;
}