<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/${cookie.color.value == null ? 'yellow' : cookie.color.value}.css" />
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp">
			<jsp:param name="title" value="Check Password" />
		</jsp:include>
		<form action="Controller?action=checkPasswordConfirmed" method="post">
			<%--@elvariable id="id" type="domain.Person"--%>
			<input type="hidden" name="id" value="<c:out value='${id}'/>"/>
			<p>
				<label for="password">Fill out your password</label> 
				<input id="password" name="password" type="password" />
			</p>
			<input type="submit" />
		</form>
		<%--@elvariable id="check" type="controller"--%>
		<p><c:out value="${check}"/></p>
		<jsp:include page="footer.jsp">
			<jsp:param name="page" value="checkPassword&id=${id}" />
		</jsp:include>
	</div>
</body>
</html>