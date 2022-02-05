package ca.qc.cgodin.models;

public class Answer {
	
	private int AnswerID;
	private int OptionID;
	private int QuizID;
	
	
	public Answer() {
		super();
	}


	public Answer(int answerID, int optionID, int quizID) {
		super();
		AnswerID = answerID;
		OptionID = optionID;
		QuizID = quizID;
	}


	public int getAnswerID() {
		return AnswerID;
	}


	public void setAnswerID(int answerID) {
		AnswerID = answerID;
	}


	public int getOptionID() {
		return OptionID;
	}


	public void setOptionID(int optionID) {
		OptionID = optionID;
	}


	public int getQuizID() {
		return QuizID;
	}


	public void setQuizID(int quizID) {
		QuizID = quizID;
	}
	
	

}
