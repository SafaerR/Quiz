package ca.qc.cgodin.models;

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
	
	

}
