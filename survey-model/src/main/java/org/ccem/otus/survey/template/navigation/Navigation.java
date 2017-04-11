package org.ccem.otus.survey.template.navigation;

import java.util.List;

import org.ccem.otus.survey.template.navigation.route.Route;

public class Navigation {

	public String extents;
	public String objectType;
	public String origin;
	public Integer index;
	public List<InNavigations> inNavigations;
	public boolean isDefault;
	public List<Route> routes;

}
