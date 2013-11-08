<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: venkatakrishnachaita
  Date: 11/6/13
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>
<body>
    <s:form name="loginForm" id="loginForm" action="validateUser">
        <s:label name="userName"/>
        <s:textfield name="userName"/>
        <s:password name="password"/>
        <s:submit/>
    </s:form>

</body>
</html>