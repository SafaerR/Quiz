package ca.qc.cgodin.models;

public class Category {
	
	private int CategoryID;
	private String Description;
	public Category() {
		super();
	}
	public Category(int categoryID, String description) {
		super();
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
	
	

}
