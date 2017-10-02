package org.ccem.otus.survey.template.item.questions.grid.integer;

import java.util.ArrayList;
import java.util.List;

import org.ccem.otus.survey.template.item.questions.Question;

public class GridIntegerQuestion extends Question {

	public List<GridIntegerLine> lines;

	@Override
	public List<String> getExtractionIDs(){
		List<String> ids = new ArrayList<>();
		lines.forEach(gridIntegerLine -> gridIntegerLine.gridIntegerList.forEach(gridInteger -> ids.add(gridInteger.customID)));
		return ids;
	}
}
