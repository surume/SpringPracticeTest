<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<h1>ログイン</h1>

<form:form modelAttribute="signinForm" action="/postSigninForm" method="post">
    <form:textarea path="userName"></form:textarea><br/>
    <form:password path="password"></form:password>
    <input type="submit">
</form:form>
</body>
</html>