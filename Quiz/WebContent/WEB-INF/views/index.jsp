<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
		crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
		crossorigin="anonymous"></script>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
<title>Accueil</title>
</head>
<body data-new-gr-c-s-check-loaded="14.1043.0" data-gr-ext-installed="" data-new-gr-c-s-loaded="14.1043.0">
<div class="main-container container py-5 px-4">


 	
	 <div class="image-box" style="text-align: center;">
	 		<c:url value="/resources/images" var="images" />
			<img src="${images}/quiz7.png" class="img-responsive" alt="Responsive image"
            style="width:30%" />
	</div>

	
	<div class="text-box">
<!-- 	 <h1  style="padding-bottom:1%; width: 300px ; color:blue;margin-top:20px"  class="mx-auto">Créer votre Quiz</h1>  -->
<!-- 	<h1 class="mb-5 text-center">Créer votre Quiz</h1> -->
		<div class="alert alert-primary" role="alert">	
			<form action="quiz" method="post">
				<div class="mb-3">
					<label for="formGroupExampleInput" class="col-sm-2 col-form-label" style="display: inline;">User Name</label>
					<input type="text" class="form-control" name="userName" required>
				</div>
				<div class="mb-3">
					<label for="inputEmail3" class="col-sm-2 col-form-label" style="display: inline;">Email</label>
					<input type="email" name="email" class="form-control" style="margin-bottom: 10px;" required>
				</div><div class="mb-3">
					
					
				<h3 class="mb-5 text-center" style="color: rgb(0, 64, 133);">Niveau de difficulté</h3></div>
				<div class="row">
					
					<div class="col-sm-4">
						<label for="formGroupExampleInput" class="col-sm-4 col-form-label">Facile</label>
						<input type="number" min="0" max=${maxE} name="easy" class="form-control" value="1">
					</div>
					<div class="col-sm-4">
						<label for="formGroupExampleInput" class="col-sm-4 col-form-label">Moyen</label>
						<input type="number" min="0" max=${maxM} name="medium" class="form-control" value="1">
					</div>
					<div class="col-sm-4">
						<label for="formGroupExampleInput" class="col-sm-4 col-form-label">Difficile</label>
						<input type="number" min="0" max=${maxH} name="hard" class="form-control" value="1">
					</div>
				</div><br>
					<div class="mb-3">
						<input class="btn btn-warning" type="submit" value="Commencer votre Quiz">
					</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>




