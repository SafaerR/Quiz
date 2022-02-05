package com.mdeleon.models;

public class Answer {
		private int AnswerID;
		private int OptionId;
		private int QuizID;
		
		public Answer() {
			super();
		}

		public Answer(int answerID, int optionId, int quizID) {
			super();
			AnswerID = answerID;
			OptionId = optionId;
			QuizID = quizID;
		}

		public int getAnswerID() {
			return AnswerID;
		}

		public void setAnswerID(int answerID) {
			AnswerID = answerID;
		}

		public int getOptionId() {
			return OptionId;
		}

		public void setOptionId(int optionId) {
			OptionId = optionId;
		}

		public int getQuizID() {
			return QuizID;
		}

		public void setQuizID(int quizID) {
			QuizID = quizID;
		}

		@Override
		public String toString() {
			return "Answer [AnswerID=" + AnswerID + ", OptionId=" + OptionId + ", QuizID=" + QuizID + "]";
		}
		
		
}
