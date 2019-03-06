<%--
  Created by IntelliJ IDEA.
  User: kehtolaulu
  Date: 28/02/2019
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forum</title>
</head>
<body>
    <form method="POST">
        <label for="textarea">input message</label>
        <textarea name="text" id="textarea" cols="30" rows="10" required></textarea>
        <input type="text" name="author" placeholder="author">
        <input type="submit" value="create post">
    </form>
    <c:forEach items="${posts}" var="post">
        <hr>
        <p>${post.text}</p>
        <small>${post.author}</small>
        <small>${post.date}</small>
        <hr>
    </c:forEach>
</body>
</html>
