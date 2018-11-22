<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<h1>
		<span>Web shop</span>
	</h1>
	<nav>
		<ul>
            <li><a href="Controller?action=index">Home</a></li>
            <c:choose>
                <%--@elvariable id="user" type="domain.Person"--%>
                <c:when test="${(user.role == 'CUSTOMER') || user.role == 'ADMIN'}">
                    <li id="actual"><a href="Controller?action=productOverview">products</a></li>
                    <%--@elvariable id="user" type="domain.Person"--%>
                    <li id="actual"><a href="Controller?action=userOverview">users</a></li>
                    <c:if test="${user.role == 'ADMIN'}">
                        <li id="actual"><a href="Controller?action=productForm">add product</a></li>
                    </c:if>
                    <li id="actual"><a href="Controller?action=shopingCart">shoping cart</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="Controller?action=signUp">Sign up</a></li>
                </c:otherwise>
            </c:choose>
		</ul>
	</nav>
	<h2>${param.title}</h2>
</header>