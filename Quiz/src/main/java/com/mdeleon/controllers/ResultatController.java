package com.mdeleon.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdeleon.models.*;

@Controller
@RequestMapping("/resultat")
public class ResultatController {
@RequestMapping(value="/getResultat", method=RequestMethod.POST)
public String getResultat(HttpServletRequest request, Model model) {
int score=0;
List<Integer> reponsesRates=new ArrayList<Integer>();
List<Option>listAllOptions=new ArrayList<Option>();
List<Answer>answers=new ArrayList<Answer>();
List<Question>listAllQuestions=new ArrayList<Question>();
List<Question>listQuestionsQ=new ArrayList<Question>();
DBManager dbManager=new DBManager();
listAllQuestions=dbManager.getAllQuestions();
List<Option>listVosReponses =new ArrayList<Option>();
List<Option>listBonnesReponses =new ArrayList<Option>();
String []questionIDs =request.getParameterValues("questionID");
int [] questionIDs2=new int[questionIDs.length];
int quizID=Integer.parseInt(request.getParameter("quizID"));


listAllOptions=dbManager.getOptions();

//convertir le tableau en int
for(int i=0;i<questionIDs.length;i++){
questionIDs2[i]=Integer.parseInt(questionIDs[i]);
}

//Stocker les reponses dans la BD + calcul du score
for(int questionId : questionIDs2) {
int idOption=Integer.parseInt(request.getParameter("optionR"+questionId));
Answer answer=new Answer();
answer.setOptionId(idOption);
answer.setQuizID(quizID);
dbManager.addAnswer(answer);
answers.add(answer);

for(Option op :listAllOptions) {
/*if (idOption == op.getOptionID()) {

if (op.isIsRight() == true) {

score++;
}
else {
reponsesRates.add(questionId);
}

}*/





		if (op.isIsRight() == true && questionId == op.getQuestionID()) {

			listBonnesReponses.add(op);


		if (idOption == op.getOptionID()) {

		score++;

		}
		}

		if (idOption == op.getOptionID() && questionId == op.getQuestionID()) {


		listVosReponses.add(op);

		}
	
	
	
	
	
	
}
	
	
	
	
}


for(Question question :listAllQuestions) {
for(Integer q : questionIDs2) {
if (question.getQuestionID() == q) {
listQuestionsQ.add(question);
}
}
}
int p=0;
p=listQuestionsQ.size();
model.addAttribute("listBonnesReponses", listBonnesReponses);
model.addAttribute("listVosReponses", listVosReponses);
model.addAttribute("answers", answers);
model.addAttribute("questionIDs2", questionIDs2);
model.addAttribute("reponsesRates", reponsesRates);
model.addAttribute("listAllOptions", listAllOptions);
model.addAttribute("listQuestionsQ", listQuestionsQ);
model.addAttribute("score", score);
int pourcentage=Math.round(((p/score)*10)*100/100);                             ;
model.addAttribute("pourcentage",pourcentage);
return("resultat");
}
@GetMapping("home")
public String inputbook() {
  return ("index");
}

}