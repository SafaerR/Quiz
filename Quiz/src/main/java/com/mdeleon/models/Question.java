package com.mdeleon.models;

public class Question {
	
	private int QuestionID;
	private String Text;
	private int CategoryID;
	
	public Question() {
		super();
	}

	public Question(int questionID, String text, int categoryID) {
		super();
		QuestionID = questionID;
		Text = text;
		CategoryID = categoryID;
	}

	public int getQuestionID() {
		return QuestionID;
	}

	public void setQuestionID(int questionID) {
		QuestionID = questionID;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}

	@Override
	public String toString() {
		return "Question [QuestionID=" + QuestionID + ", Text=" + Text + ", CategoryID=" + CategoryID + "]";
	}
	
	

}
