package com.mdeleon.models;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	
	public class DBManager {
		static final String DB_URL = "jdbc:mysql://mysql-safaer.alwaysdata.net/safaer_quiz?useSSL=false";
		static final String USER = "safaer_a";
		static final String PASS = "SafaerA*+";
		Connection conn=null;
		
		public DBManager(){
			// Open a connection				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);	
					} catch (ClassNotFoundException|SQLException  e) {
					
						e.printStackTrace();
					}
		}
		
		//creer un nouveau Quiz
		public void addQuiz(Quiz quiz) {
			String query = "INSERT INTO TbL_Quiz (UserName, Email) VALUES ('"+ quiz.getUserName() +"', '"+quiz.getEmail() +"');";
			try {
				Statement stmt = conn.createStatement();
				 stmt.executeUpdate(query);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		//recuperer ttes les questions easy
		public List<Question> getQuestionsEasy(){
			String query = "SELECT * FROM TbL_Question WHERE CategoryID="+ 1;
			List<Question>questionsEasy=null; 
			
			try {
				questionsEasy=new ArrayList<Question>();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// Extract data from result set
				while (rs.next()) {
					// Retrieve by column name
					Question question=new Question();
					question.setQuestionID(rs.getInt("QuestionID"));
					question.setText(rs.getString("Text"));
					question.setCategoryID(rs.getInt("CategoryID"));
					//add question to List
					questionsEasy.add(question);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return questionsEasy;
		}
		
		//recuperer ttes les questions Medium
		public List<Question> getQuestionsMedium(){
			String query = "SELECT * FROM TbL_Question WHERE CategoryID="+ 2;
			List<Question>questionsMedium=null; 
			
			try {
				questionsMedium=new ArrayList<Question>();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// Extract data from result set
				while (rs.next()) {
					// Retrieve by column name
					Question question=new Question();
					question.setQuestionID(rs.getInt("QuestionID"));
					question.setText(rs.getString("Text"));
					question.setCategoryID(rs.getInt("CategoryID"));
					//add question to List
					questionsMedium.add(question);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return questionsMedium;
		}
		
		//recuperer ttes les questions Hard
		public List<Question> getQuestionsHard(){
			String query = "SELECT * FROM TbL_Question WHERE CategoryID="+ 3;
			List<Question>questionsHard=null; 
			
			try {
				questionsHard=new ArrayList<Question>();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// Extract data from result set
				while (rs.next()) {
					// Retrieve by column name
					Question question=new Question();
					question.setQuestionID(rs.getInt("QuestionID"));
					question.setText(rs.getString("Text"));
					question.setCategoryID(rs.getInt("CategoryID"));
					//add question to List
					questionsHard.add(question);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return questionsHard;
		}

		//Recuperer le Quiz
		public Quiz getQuiz(String userName) {
			String query = "SELECT * FROM TbL_Quiz WHERE UserName ='"+ userName+"'";
				Quiz quiz=new Quiz();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					// Retrieve by column name
					
					quiz.setQuizID(rs.getInt("QuizID"));
					quiz.setUserName(rs.getString("UserName"));
					quiz.setEmail(rs.getString("Email"));
					
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			return quiz ;
		}
		
		//Ajouter les questions aleatoires dans la table QuestionQuiz
		public void addQuestionQuiz(QuestionQuiz questionQuiz) {
			String query = "INSERT INTO TbL_QuestionQuiz (QuestionID, QuizID) VALUES ("+ questionQuiz.getQuestionID() +", "+questionQuiz.getQuizID() +");";
			try {
				Statement stmt = conn.createStatement();
				 stmt.executeUpdate(query);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		//recuperer ttes les questionsQuiz
			public List<QuestionQuiz> getQuestionsQuiz(int quizID){
					String query = "SELECT * FROM TbL_QuestionQuiz WHERE QuizID="+ quizID;
					List<QuestionQuiz>questionsQuiz=null; 
					
					try {
						questionsQuiz=new ArrayList<QuestionQuiz>();
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						// Extract data from result set
						while (rs.next()) {
							// Retrieve by column name
							QuestionQuiz questionQuiz=new QuestionQuiz();
							questionQuiz.setQuestionID(rs.getInt("QuestionID"));
							questionQuiz.setQuizID(rs.getInt("QuizID"));
							//add question to List
							questionsQuiz.add(questionQuiz);
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return questionsQuiz;
				}
			
			
			//recuperer la description des questions a partir de leurs ID
			public List<Question> getQuestions(int QuestionID){
					String query = "SELECT * FROM TbL_Question WHERE QuestionID="+ QuestionID;
					List<Question>questions=null; 
					
					try {
						questions=new ArrayList<Question>();
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						// Extract data from result set
						while (rs.next()) {
							// Retrieve by column name
							Question question=new Question();
							question.setQuestionID(rs.getInt("QuestionID"));
							question.setText(rs.getString("Text"));
							question.setCategoryID(rs.getInt("CategoryID"));
							//add question to List
							questions.add(question);
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return questions;
				}
			
			//recuperer ttes les questions 
			public List<Question> getAllQuestions(){
				String query = "SELECT * FROM TbL_Question";
				List<Question>allQuestions=null; 
				
				try {
					allQuestions=new ArrayList<Question>();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					// Extract data from result set
					while (rs.next()) {
						// Retrieve by column name
						Question question=new Question();
						question.setQuestionID(rs.getInt("QuestionID"));
						question.setText(rs.getString("Text"));
						question.setCategoryID(rs.getInt("CategoryID"));
						//add question to List
						allQuestions.add(question);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return allQuestions;
			}

			//recuperer la liste des options
			public List<Option> getOptions(){
					String query = "SELECT * FROM TbL_Option";
					List<Option>options=null; 
					
					try {
						options=new ArrayList<Option>();
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						// Extract data from result set
						while (rs.next()) {
							// Retrieve by column name
							Option option=new Option();
							option.setOptionID(rs.getInt("OptionID"));
							option.setText(rs.getString("Text"));
							option.setIsRight(rs.getBoolean("IsRight"));
							option.setQuestionID(rs.getInt("QuestionID"));
							//add question to List
							options.add(option);
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return options;
				}
			
			//Enregistrer les reponses
			public void addAnswer(Answer answer) {
				String query = "INSERT INTO TbL_Answer (OptionID, QuizID) VALUES ("+ answer.getOptionId() +", "+answer.getQuizID() +");";
				try {
					Statement stmt = conn.createStatement();
					 stmt.executeUpdate(query);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
			
			
			//recuperer les questions d'un  quiz donné
			public List<QuestionQuiz> getAllQuestionsQuiz(int QuizID){
					String query = "SELECT * FROM TbL_QuestionQuiz WHERE QuizID="+ QuizID;
					List<QuestionQuiz>questionsQuiz=null; 
					
					try {
						questionsQuiz=new ArrayList<QuestionQuiz>();
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						// Extract data from result set
						while (rs.next()) {
							// Retrieve by column name
							QuestionQuiz questionQuiz=new QuestionQuiz();
							questionQuiz.setQuestionID(rs.getInt("QuestionID"));
							questionQuiz.setQuizID(rs.getInt("QuizID"));
							//add question to List
							questionsQuiz.add(questionQuiz);
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return questionsQuiz;
				}
			//recuperer les options d'une  question donnée
			public List<Option> getAllOptionsQ(int QuestionID){
					String query = "SELECT * FROM TbL_Option WHERE QuestionID="+ QuestionID;
					List<Option>optionsQuestion=null; 
					
					try {
						optionsQuestion=new ArrayList<Option>();
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						// Extract data from result set
						while (rs.next()) {
							// Retrieve by column name
							Option option=new Option();
							option.setOptionID(rs.getInt("OptionID"));
							option.setText(rs.getString("Text"));
							option.setIsRight(rs.getBoolean("IsRight"));
							option.setQuestionID(rs.getInt("QuestionID"));
							//add question to List
							optionsQuestion.add(option);
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return optionsQuestion;
				}
	
			
			
}
