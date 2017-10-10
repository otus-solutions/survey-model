package org.ccem.otus.survey.template.item.questions.grid.text;

import org.ccem.otus.survey.template.item.questions.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridTextQuestion extends Question {

	public List<GridTextLine> lines;

	@Override
	public List<String> getExtractionIDs(){
		List<String> ids = new ArrayList<>();
		lines.forEach(gridTextLine -> gridTextLine.gridTextList.forEach(gridText -> ids.add(gridText.customID)));
		return ids;
	}

	@Override
	public Map<String, String> mapIDS(){
		Map<String, String> map = new HashMap<>();
		map.put(templateID, customID);
		for (GridTextLine line : lines) {
			for (GridText gridText : line.gridTextList) {
				map.put(gridText.templateID, gridText.customID);
			}
		}
		return map;
	}

}
