<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
					<!-- External bootstrap css imports -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
		<c:if test="${film == null}">Sorry.. we couldn't update that film.</c:if>
			<c:if test="${not empty film }">
		<h2>Title: ${film.title}</h2>
			Film ID: ${film.id}
		<table>
			<tr>
				<td>Film Title:</td>
				<td>${film.title}</td>
			</tr>
			<tr>
				<td>Film Description:</td>
				<td>${film.description}</td>
			</tr>
			<tr>
				<td>Release Year:</td>
				<td>${film.releaseYear}</td>
			</tr>
			<tr>
				<td>Language:</td>
				<td>${film.language}</td>
			</tr>
			<tr>
				<td>Rental Duration:</td>
				<td>${film.rentalDuration}</td>
			</tr>
			<tr>
				<td>Rental Rate:</td>
				<td>${film.rentalRate}</td>
			</tr>
			<tr>
				<td>Length:</td>
				<td>${film.length}</td>
			</tr>
			<tr>
				<td>Replacement Cost:</td>
				<td>${film.replacementCost}</td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td>${film.rating}</td>
			</tr>
			<tr>
				<td>Special Features:</td>
				<td>${film.special_features}</td>
			</tr>
			<c:if test="${not empty film.categories}">
			<tr>
			<td>Categories:</td>
			<c:forEach var="category" items="${film.categories}">
			<td>${category}</td>
			
			</c:forEach>
			
			</tr>
			</c:if>
				
				<c:if test="${not empty film.actors}">
					<tr>
						<td>Actors:</td>
						<td><c:forEach var="actor" items="${film.actors}">

								<ul>
									<li>${actor.firstName}${actor.lastName }</li>

								</ul>

							</c:forEach></td>
					</tr>
				</c:if>
		</table>
		</c:if>
				<br>
  			<br>
				<a href="returntomain.do" class="btn btn-default"> Return to Home Page </a>
  	  		<br>
</body>
</html>