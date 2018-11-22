<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css"href="css/${cookie.color.value == null ? 'yellow' : cookie.color.value}.css" />
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp">
			<jsp:param name="title" value="Add Product"/>
		</jsp:include>
		<c:if test="${ errors != null}">
			<div class="alert-danger">
				<ul>
					<c:forEach var="error" items="${errors}">
						<li><c:out value="${error}"/></li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<form action="Controller?action=userUpdateConfirmed" method="post">
			<p>
				<input type="hidden" name="id" value="<c:out value='${id}'/>"/>
			</p>
			<p>
				<label for="firstName">First Name</label>
				<input type="text"id="firstName" name="firstName" value="<c:out value='${firstName}'/>"/>
			</p>
			<p>
				<label for="lastName">Last Name</label>
				<input type="text" id="lastName" name="lastName" value="<c:out value='${lastName}'/>"/>
			</p>
			<p>
				<label for="email">Email</label><input type="email" id="email" name="email" value="<c:out value='${email}'/>"/>
			</p>
			<p>
				<label for="role">Role</label>
				<select id="role" name="role" value="<c:out value='${role}'/>">
				  <option value="CUSTOMER">CUSTOMER</option>
				  <option value="ADMIN">ADMIN</option>
				</select>
			</p>
			<p>
				<input type="submit" value="Update">
			</p>
		</form>
		<jsp:include page="footer.jsp">
			<jsp:param name="page" value="updatePerson&id=${id}"/>
		</jsp:include>
	</div>
</body>
</html>