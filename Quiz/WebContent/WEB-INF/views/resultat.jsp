<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<title>Resultat</title>
</head>
<body data-new-gr-c-s-check-loaded="14.1043.0" data-gr-ext-installed="" data-new-gr-c-s-loaded="14.1043.0">
	
	<div class="main-container container py-5 px-4">

		<h1>Resultat</h1>
	
		<div class="alert alert-primary" role="alert" style="width:60%; margin-left:250px">
			<h3>Votre score est : ${score}/${listQuestionsQ.size()}</h3>
			<h3>${pourcentage}% Correct!</h3>
		
			<h5>Vous avez raté : ${listQuestionsQ.size()-score} questions</h5><br>
		
			<ol>
				<c:forEach var="question" items="${listQuestionsQ}">
				<br>
				<li>
					<h5>${question.getText()}</h5>
					
					<c:forEach var="option" items="${listVosReponses}">
					
						<c:if test="${question.getQuestionID() == option.getQuestionID()}">
							<span>Votre réponse: </span><span >&nbsp;${option.getText()}&nbsp;</span><br>
							
							<c:if test="${option.isIsRight() == true}">
								<span style="color: green">La reponse est bonne.</span><br>
							</c:if>
							
							<c:if test="${option.isIsRight() == false}">
								<span class="text-danger">Vous avez une mauvaise réponse.</span><br>
							
								<c:forEach var="bonne" items="${listBonnesReponses}">
									<c:if test="${question.getQuestionID() == bonne.getQuestionID()}">
										<span class="bg-success p-1 text-dark bg-opacity-25">La bonne réponse : ${bonne.getText()}</span><br>
									</c:if>
								</c:forEach>
							</c:if>
						</c:if>
					</c:forEach>
					</li>
				</c:forEach>
			</ol>
			<br>
			<form action="home" method="GET">
				<input type="submit" class="btn btn-warning" value="Refaire un QUIZ" />
			</form>
		</div>
	</div>
		
</body>
</html>