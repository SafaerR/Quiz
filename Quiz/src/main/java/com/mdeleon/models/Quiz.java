package com.mdeleon.models;

public class Quiz {
	
	private int QuizID;
	private String UserName;
	private String Email;
	
	public Quiz() {
		super();
	}

	public Quiz(int quizID, String userName, String email) {
		super();
		QuizID = quizID;
		UserName = userName;
		Email = email;
	}

	public int getQuizID() {
		return QuizID;
	}

	public void setQuizID(int quizID) {
		QuizID = quizID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Quiz [QuizID=" + QuizID + ", UserName=" + UserName + ", Email=" + Email + "]";
	}
	
	

}
