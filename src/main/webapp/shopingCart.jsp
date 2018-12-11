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
                <th>name</th>
                <th>price</th>
                <th>qty</th>
                <th>delete</th>
            </tr>
            <c:forEach var="cart" items="${cartInfo}">
                <tr>
                    <td><c:out value="${cart.key.name}"/></td>
                    <td><c:out value="${cart.key.price * cart.value}"/></td>
                    <td><c:out value="${cart.value}"/></td>
                    <td><a href="Controller?action=deleteProductFromCart&id=<c:out value='${cart.key.productId}'/>"><c:out value="delete"/></a></td>
                </tr>
            </c:forEach>
            <caption>shoping cart</caption>
        </table>
        <p>total price: <c:out value="${totalPrice}"/></p>

        <a href="Controller?action=EmptyCart">Empty Cart</a>
    </main>
    <jsp:include page="footer.jsp">
        <jsp:param name="page" value="productOverview" />
    </jsp:include>
</div>
</body>
</html>