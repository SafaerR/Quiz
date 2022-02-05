package com.mdeleon.models;

public class QuestionQuiz {
	private int QuestionID;
	private int QuizID;
	
	public QuestionQuiz() {
		super();
	}

	public QuestionQuiz(int questionID, int quizID) {
		super();
		QuestionID = questionID;
		QuizID = quizID;
	}

	public int getQuestionID() {
		return QuestionID;
	}

	public void setQuestionID(int questionID) {
		QuestionID = questionID;
	}

	public int getQuizID() {
		return QuizID;
	}

	public void setQuizID(int quizID) {
		QuizID = quizID;
	}

	@Override
	public String toString() {
		return "QuestionQuiz [QuestionID=" + QuestionID + ", QuizID=" + QuizID + "]";
	}
	
	
}
