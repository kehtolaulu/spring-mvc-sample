<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: cosmos
  Date: 2019-02-26
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <p>${message}</p>
    <form>
      <label for="name_field">Your name, please</label>
      <input type="text" id="name_field" name="name" placeholder="John">
      <input type="submit" value="say my name">
    </form>
  </body>
</html>
