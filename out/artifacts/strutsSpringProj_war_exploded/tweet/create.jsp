<%--
  Created by IntelliJ IDEA.
  User: venkatakrishnachaita
  Date: 9/26/13
  Time: 1:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title> Struts Example |Create Form</title>
</head>
<body>

    <s:property value="exampString"/>
    <s:form namespace="/tweet" action="insert.do">
        <s:textfield value="" label="tweet id" name="tweetId"/>
        <s:textfield value="" label="tweet any thing" name="tweet"/>

        <s:select label="select an user" name="userSel"
                      list="userEntities" listKey="userId"

                      listValue="userName" headerKey="0" headerValue="user name"/>

        <s:submit value="submit" />
    </s:form>

    <s:if test="hasActionErrors()">
        <s:actionerror/>
    </s:if>
</body>
</html>