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
    <title> Struts Exampele |Create Form</title>
</head>
<body>
    <s:form namespace="/tweet" action="processUpdate.do" >
        <s:textfield value="" label="tweet id" name="tweetId"/>
        <s:textfield label="tweet some thing" name = "tweet"/>
        <s:submit value="submit" />
    </s:form>
    <s:if test="hasActionErrors()">
        <s:actionerror/>
    </s:if>

</body>
</html>