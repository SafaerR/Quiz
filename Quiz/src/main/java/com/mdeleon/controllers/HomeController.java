package com.mdeleon.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdeleon.models.*;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) {
		DBManager dbManager=new DBManager();
		List<Question> questionsE = dbManager.getQuestionsEasy();
		List<Question> questionsM = dbManager.getQuestionsMedium();
		List<Question> questionsH = dbManager.getQuestionsHard();
		int maxE = questionsE.size();
		int maxM = questionsM.size();
		int maxH = questionsH.size();

		model.addAttribute("maxE",maxE);
		model.addAttribute("maxM",maxM);
		model.addAttribute("maxH",maxH);
		return("index");
	}	
	
	@RequestMapping(value="/quiz", method=RequestMethod.POST)
	public String quiz(HttpServletRequest request, Model model) {
		String userName = request.getParameter("userName");
		String email=request.getParameter("email");
		int nbrEasy=Integer.parseInt(request.getParameter("easy"));
		int nbrMedium=Integer.parseInt(request.getParameter("medium"));
		int nbrHard=Integer.parseInt(request.getParameter("hard"));
		
		model.addAttribute("userName",userName );
		model.addAttribute("email", email);
		
		//creation d'un quiz
		DBManager dbManager=new DBManager();
			Quiz quiz=new Quiz();
			quiz.setUserName(userName);
			quiz.setEmail(email);
			dbManager.addQuiz(quiz);	
			
		//Generer aleatoirement les questions du Quiz:

			List<Question> questionsE = dbManager.getQuestionsEasy();
			List<Question> questionsM = dbManager.getQuestionsMedium();
			List<Question> questionsH = dbManager.getQuestionsHard();
				
			List<Question>qList=new ArrayList<Question>();
				
			QuestionQuiz questionQuiz = new QuestionQuiz();
			
			Random random=new Random();
			
			for(int i=0; i<nbrEasy; i++) {
				int rand1=random.nextInt(questionsE.size());
				qList.add(questionsE.get(rand1));
				questionsE.remove(rand1);
			}
			
			for(int i=0; i<nbrMedium; i++) {
				int rand2=random.nextInt(questionsM.size());
				qList.add(questionsM.get(rand2));
				questionsM.remove(rand2);				
			}
			
			for(int i=0; i<nbrHard; i++) {
				int rand3=random.nextInt(questionsH.size());
				qList.add(questionsH.get(rand3));
				questionsH.remove(rand3);
			}
			
			//recuperer l'ID du Quiz
			quiz=dbManager.getQuiz(userName);
			int id=quiz.getQuizID();
			model.addAttribute("idQuiz", id);
			
					
		for (Question question : qList) {
			questionQuiz.setQuestionID(question.getQuestionID());
			questionQuiz.setQuizID(id);
			dbManager.addQuestionQuiz(questionQuiz);
		}
		
		//recuperer la liste des questionsQuiz
		List<Question>listQuestions=new ArrayList<Question>();	
		List<Question>listAllQuestions=new ArrayList<Question>();	
		listAllQuestions=dbManager.getAllQuestions();
		
		for(Question question :listAllQuestions) {
			for(Question ql : qList) {
				if (question.getQuestionID() == ql.getQuestionID()) {
					listQuestions.add(question);
				}
			}
		}
		
		//recuperer ttes les options des reponses
		List<Option>options=new ArrayList<Option>();
		options=dbManager.getOptions();
			
		model.addAttribute("listQuestions", listQuestions);	
		model.addAttribute("options", options);	
		
		return("quiz");
	}
	
}
