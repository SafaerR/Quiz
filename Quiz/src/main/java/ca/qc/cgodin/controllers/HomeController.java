package ca.qc.cgodin.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ca.qc.cgodin.models.*;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {		
	
		return "index"; 
	}
	
		
	@RequestMapping(value="/createQuiz", method=RequestMethod.POST)
	public String createQuiz(HttpServletRequest request, Model model) {
		String userName = request.getParameter("userName");
		String email=request.getParameter("email");
		model.addAttribute("userName",userName );
		model.addAttribute("email", email);
		
		//creation d'un quiz
		DBManager dbManager=new DBManager();
		Quiz quiz=new Quiz();
			quiz.setUserName(userName);
			quiz.setEmail(email);
		dbManager.addQuiz(quiz);
		//recuperer l'ID du Quiz
		int QuizID=dbManager.getQuizID(userName);
		//Generer aleatoirement les questions du Quiz:

		List<Question> questionsE = dbManager.getQuestionsEasy();
		List<Question> questionsM = dbManager.getQuestionsMedium();
		List<Question> questionsH = dbManager.getQuestionsHard();
		
		List<Question>qList=new ArrayList<Question>();
		
		QuestionQuiz questionQuiz = new QuestionQuiz();
		
		
		Random random=new Random();
		
			for(int i=0; i<2; i++) {
				int rand1=random.nextInt(questionsE.size());
				qList.add(questionsE.get(rand1));
				questionsE.remove(rand1);
			}
			
			for(int i=0; i<2; i++) {
				int rand2=random.nextInt(questionsM.size());
				qList.add(questionsM.get(rand2));
				questionsM.remove(rand2);				
			}
			
			for(int i=0; i<2; i++) {
				int rand3=random.nextInt(questionsH.size());
				qList.add(questionsH.get(rand3));
				questionsH.remove(rand3);
			}
			
		for (Question question : qList) {
			questionQuiz.setQuestionID(question.getQuestionID());
			questionQuiz.setQuizID(QuizID);
			dbManager.addQuestionQuiz(questionQuiz);
		}
		
		return "quiz";
	}
	
}
