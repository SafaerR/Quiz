package com.mdeleon.models;

public class Category {
	private int CategoryID;
	private String Description;
	
	public Category() {
		
	}

	public Category(int categoryID, String description) {
		
		CategoryID = categoryID;
		Description = description;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Category [CategoryID=" + CategoryID + ", Description=" + Description + "]";
	}
	
	
}
