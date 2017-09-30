package org.ccem.otus.survey.template.item.questions.grid.text;

import org.ccem.otus.survey.template.item.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class GridTextQuestion extends Question {

	public List<GridTextLine> lines;

	@Override
	public List<String> getOptionsIDs(){
		List<String> ids = new ArrayList<>();
		final String customID = super.customID;
		ids.add(customID);
		lines.forEach(gridTextLine -> {
			gridTextLine.gridTextList.forEach(gridText -> ids.add(gridText.customID));
		});
		return ids;
	}
}
