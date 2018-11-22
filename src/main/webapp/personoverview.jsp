<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Overview</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css"href="css/${cookie.color.value == null ? 'yellow' : cookie.color.value}.css" />
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp">
			<jsp:param name="title" value="Overview"/>
		</jsp:include>
		<main>
		<table>
			<tr>
				<th>E-mail</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Delete</th>
                <c:if test="${user.role == 'ADMIN'}">
                    <th>update person</th>
                </c:if>
			</tr>
			<c:forEach var="person" items="${users}">
				<tr>
					<td><c:out value='${person.email}'/></td>
					<td><c:out value='${person.firstName}'/></td>
					<td><c:out value='${person.lastName}'/></td>
					<c:if test="${person.userid == user.userid || user.role == 'ADMIN'}">
						<td><a href="Controller?action=deleteUser&id=<c:out value='${person.userid}'/>">delete</a></td>
                    </c:if>
                    <c:if test="${user.role == 'ADMIN'}">
                        <td><a href="Controller?action=userUpdate&id=<c:out value='${person.userid}'/>">update</a></td>
                    </c:if>
				</tr>
			</c:forEach>
			<caption>Users Overview</caption>
		</table>
		</main>
		<jsp:include page="footer.jsp">
			<jsp:param name="page" value="userOverview" />
		</jsp:include>
	</div>
</body>
</html>