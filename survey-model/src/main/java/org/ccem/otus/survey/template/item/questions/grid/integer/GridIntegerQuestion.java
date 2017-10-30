package org.ccem.otus.survey.template.item.questions.grid.integer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ccem.otus.survey.template.item.questions.Question;

public class GridIntegerQuestion extends Question {

	public List<GridIntegerLine> lines;

	@Override
	public List<String> getExtractionIDs(){
		List<String> ids = new ArrayList<>();
		lines.forEach(gridIntegerLine -> gridIntegerLine.gridIntegerList.forEach(gridInteger -> ids.add(gridInteger.customID)));
		return ids;
	}

	@Override
	public Map<String, String> mapIDS(){
		Map<String, String> map = new HashMap<>();
		map.put(templateID, customID);
		for (GridIntegerLine line : lines) {
			for (GridInteger gridInteger : line.gridIntegerList) {
				map.put(gridInteger.templateID, gridInteger.customID);
			}
		}
		return map;
	}

}
