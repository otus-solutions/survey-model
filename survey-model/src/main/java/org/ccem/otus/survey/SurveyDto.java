package org.ccem.otus.survey;

import java.util.List;

import org.ccem.otus.survey.identity.Identity;
import org.ccem.otus.survey.item.SurveyItemDto;
import org.ccem.otus.survey.metainfo.MetaInfoDto;
import org.ccem.otus.survey.navigation.NavigationDto;

public class SurveyDto {

	public String extents;
	public String objectType;
	public String oid;
	public Identity identity;
	public MetaInfoDto metainfo;
	public List<SurveyItemDto> itemContainer;
	public List<NavigationDto> navigationList;

}
