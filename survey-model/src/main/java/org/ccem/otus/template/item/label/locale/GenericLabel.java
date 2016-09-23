package org.ccem.otus.template.item.label.locale;

import com.google.gson.annotations.SerializedName;

public abstract class GenericLabel {

	@SerializedName("extends")
	public String extents;
	public String objectType;
	public String oid;
	public String plainText;
	public String formattedText;

}
