package ca.qc.cgodin.models;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	
	public class DBManager {
		static final String DB_URL = "jdbc:mysql://mysql-safaer.alwaysdata.net/safaer_quiz?useSSL=false";
		static final String USER = "youruser";
		static final String PASS = "yourpsw";
		Connection conn=null;
		
		public DBManager(){
			// Open a connection				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);	
					} catch (ClassNotFoundException|SQLException  e) {
					
						e.printStackTrace();
					}
		}
		
		public void addQuiz(Quiz quiz) {
			String query = "INSERT INTO TbL_Quiz (UserName, Email) VALUES ('"+ quiz.getUserName() +"', '"+quiz.getEmail() +"');";
			try {
				Statement stmt = conn.createStatement();
				 stmt.executeUpdate(query);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	
		public void addQuestionQuiz(QuestionQuiz questionQuiz) {
			String query = "INSERT INTO TbL_QuestionQuiz (QuestionID, QuizID) VALUES ("+ questionQuiz.getQuestionID() +", "+questionQuiz.getQuizID() +");";
			try {
				Statement stmt = conn.createStatement();
				 stmt.executeUpdate(query);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		public List<Question> getQuestionsEasy(){//recuperer ttes les questions easy
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
		
		public List<Question> getQuestionsMedium(){//recuperer ttes les questions Medium
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

		public List<Question> getQuestionsHard(){//recuperer ttes les questions Hard
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
		
		public int getQuizID(String userName) {
			String query = "SELECT QUIZID FROM TbL_Quiz WHERE UserName ="+ userName;
			int id=0;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while (rs.next()) {
					 id=rs.getInt("QuizID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			return id ;
		}
		
		
}
