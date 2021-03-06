<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<jsp:include page="header.jsp">
			<jsp:param name="title" value="Delete"/>
		</jsp:include>
		<form action="Controller?action=userdeleteConfirmed" method="post">
			<%--@elvariable id="id" type="domain.Person"--%>
			<input type="hidden" name="id" value="<c:out value='${id}'/>"/>
			<input type="submit" name="submit" value="ja"/>
			<input type="submit" name="submit" value="nee"/>
		</form>
		<jsp:include page="footer.jsp">
			<%--@elvariable id="id" type="domain.Person"--%>
			<jsp:param name="page" value="deleteUser&id=${id}" />
		</jsp:include>
	</div>
</body>
</html>