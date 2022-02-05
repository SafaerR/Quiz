<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<title>Quiz</title>
</head>
<body data-new-gr-c-s-check-loaded="14.1043.0" data-gr-ext-installed="" data-new-gr-c-s-loaded="14.1043.0">
	
	<div class="main-container container py-5 px-4">
	
	<h1>Quiz</h1>
	<div class="alert alert-primary" role="alert" style="width:60%; margin-left:250px">	
		<form action="resultat/getResultat" method="POST">
		
				<ol type="1">
					<c:forEach var="question" items="${listQuestions}">
	
						<li>
							<p>${question.getText()}</p>
							<input type="hidden" value="${question.getQuestionID()}" name="questionID">
							<c:forEach var="option" items="${options}">
								<c:if test="${question.getQuestionID() == option.getQuestionID()}">
									<div>&emsp;
										<input type="radio" value="${option.getOptionID()}" name="optionR${option.getQuestionID()}" required>&emsp;${option.getText()}
									</div>
								</c:if>
							</c:forEach>
							</li><br>
							<input type="hidden" value="${option.getOptionID()}" name="optionID"> 
							<input type="hidden" value="${idQuiz}" name="quizID">
					</c:forEach>
					</ol>
					<div>
						<input type="submit" class="btn btn-warning" value="TERMINER" />
					</div>
			</form>
			
		</div>
	</div>
		
</body>
</html>