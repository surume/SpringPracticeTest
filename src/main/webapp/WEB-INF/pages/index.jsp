<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<style>
    .userTextArea{
        resize: none;
    }
</style>
<body>
<h1>しょっぱなページ</h1>

ログイン
<form:form modelAttribute="signinForm" action="/postLoginForm" method="post">
    <p>メールアドレス</p>
    <form:textarea cssClass="userTextArea" path="email" cols="50" rows="1"/><br/>
    <p>パスワード</p>
    <form:password path="password"/><br/>
    <input type="submit">
</form:form>



新規登録
<form:form modelAttribute="signinForm" action="/account/signup" method="post">
    <p>ユーザーネーム</p>
    <form:textarea cssClass="userTextArea" path="userName" cols="50" rows="1"/>
    <p>メールアドレス</p>
    <form:textarea cssClass="userTextArea" path="email" cols="50" rows="1"/>
    <p>パスワード</p>
    <form:password path="password"/>
    <div>
        <input type="submit">
    </div>
</form:form>

</body>
</html>