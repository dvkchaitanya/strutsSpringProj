<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: venkatakrishnachaita
  Date: 11/3/13
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<s:url action="index" namespace="/tweet" var="tweet_index"></s:url>
<s:url action="index" namespace="/user" var="user_index"></s:url>

<ul>
    <li> <s:a href="%{tweet_index}"> tweet</s:a></li>
    <li> <s:a href="%{user_index}"> user</s:a></li>
</ul>
</body>
</html>