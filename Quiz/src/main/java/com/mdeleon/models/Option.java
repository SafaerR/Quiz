package com.mdeleon.models;

public class Option {
	
	private int OptionID;
	private String Text;
	private boolean IsRight;
	private int QuestionID;
	
	public Option() {
		super();
	}

	
	public Option(int optionID, String text, boolean isRight, int questionID) {
		super();
		OptionID = optionID;
		Text = text;
		IsRight = isRight;
		QuestionID = questionID;
	}


	public int getOptionID() {
		return OptionID;
	}

	public void setOptionID(int optionID) {
		OptionID = optionID;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	

	public boolean isIsRight() {
		return IsRight;
	}


	public void setIsRight(boolean isRight) {
		IsRight = isRight;
	}

	public int getQuestionID() {
		return QuestionID;
	}

	public void setQuestionID(int questionID) {
		QuestionID = questionID;
	}


	@Override
	public String toString() {
		return "Option [OptionID=" + OptionID + ", Text=" + Text + ", IsRight=" + IsRight + ", QuestionID=" + QuestionID
				+ "]";
	}
	
	
}
