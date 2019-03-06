<%--
  Created by IntelliJ IDEA.
  User: kehtolaulu
  Date: 28/02/2019
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    ${message}
    <form>
        <input type="number" name="arg1">
        <select name="operation" id="operation_input">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
        <input type="number" name="arg2">
        <input type="submit" value="=">
        ${value}
    </form>
</body>
</html>
