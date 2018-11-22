<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/${cookie.color.value == null ? 'yellow' : cookie.color.value}.css" />
</head>
<body>
	<div id="container">
		<jsp:include page="header.jsp">
			<jsp:param name="title" value="Add Product"/>
		</jsp:include>
		<%--@elvariable id="errors" type="controller"--%>
		<c:if test="${ errors != null}">
			<div class="alert-danger">
				<ul>
					<c:forEach var="error" items="${errors}">
						<li><c:out value="${error}"/></li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<form action="Controller?action=productUpdateConfirmed" method="post">
			<p>
				<%--@elvariable id="id" type="domain.Product"--%>
				<input type="hidden" name="id" value="<c:out value='${id}'/>"/>
			</p>
			<p>
				<label for="name">naam</label>
				<%--@elvariable id="name" type="domain.Product"--%>
				<input id="name" name="name" type="text" value="<c:out value='${name}'/>"/>
			</p>
			<p>
				<label for="description">description</label>
                <%--@elvariable id="description" type="domain.Product"--%>
				<input id="description" name="description" type="text" value="<c:out value='${description}'/>"/>
			</p>
			<p>
                <%--@elvariable id="price" type="domain.Product"--%>
				<label for="price">price</label> <input id="price" name="price" type="text" value="<c:out value='${price}'/>"/>
			</p>
			<input type="submit" />
		</form>
		<jsp:include page="footer.jsp">
			<jsp:param name="page" value="updateProduct&id=${id}" />
		</jsp:include>
	</div>
</body>
</html>