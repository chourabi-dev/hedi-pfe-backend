package com.grokonez.jwtauthentication.message.request;

public class CategoryModel {

	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public CategoryModel(String label) {
		super();
		this.label = label;
	}

	public CategoryModel() {
		super();
	}
	
}
