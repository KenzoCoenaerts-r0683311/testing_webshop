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
			<jsp:param name="title" value="Product overview"/>
		</jsp:include>
		<main>
		<table>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>description</th>
				<th>price</th>
                <th>add to cart</th>
				<th>delete</th>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td><c:out value="${product.productId}"/></td>
                    <c:choose>
                        <c:when test="${person.userid == user.userid || user.role == 'ADMIN'}">
                            <td><a href="Controller?action=updateProduct&id=<c:out value='${product.productId}'/>"><c:out value="${product.name}"/></a></td>
                        </c:when>
                        <c:otherwise>
                            <td><c:out value="${product.name}"/></td>
                        </c:otherwise>
                    </c:choose>

					<td><c:out value="${product.description}"/></td>
					<td><c:out value="${product.price}"/></td>
					<td><a href="Controller?action=addProductToCart&id=<c:out value='${product.productId}'/>">add to cart</a></td>

                    <c:if test="${person.userid == user.userid || user.role == 'ADMIN'}">
					    <td><a href="Controller?action=deleteProduct&id=<c:out value='${product.productId}'/>"><c:out value="delete"/></a></td>
                    </c:if>
				</tr>
			</c:forEach>
			<caption>Users Overview</caption>
		</table>
		</main>
		<jsp:include page="footer.jsp">
			<jsp:param name="page" value="productOverview" />
		</jsp:include>
	</div>
</body>
</html>