<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>UserList</title>
</head>
<body>
<h1>

    <%--<c:forEach var="item" items="${userlist}">--%>
        team name : <c:out value="${userlist}"/><br>
        <c:out value="${userlist[0].name}"/>
    <%--</c:forEach>--%>

</h1>
</body>
</html>