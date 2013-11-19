<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: venkatakrishnachaita
  Date: 9/26/13
  Time: 1:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>struts Example project| users</title>
</head>
<body>

    <s:url action="update.do" var="updateUser" namespace="/user"  >
        <s:param name="id" > <s:property value="userId"/></s:param>
    </s:url>

<table>
        <s:iterator var="userEntity" value="userEntities">
        <tbody>
             <td><s:property value="userId"/></td>
            <td><s:property value="userName"/></td>
            <td><s:a action="update.do?userId=%{#userEntity.userId}">update</s:a></td>
             <td><s:url id ="delete" action="delete.do">
                 <s:param name="userId" value="userId"></s:param>
             </s:url>
            <s:a href="%{delete}">delete</s:a>
             </td>
        </tbody>
   </s:iterator>
</table>
        <s:a action="create">create new user</s:a>
          <s:if test="hasActionMessages()">
        <s:actionmessage/>
    </s:if>
 </body>
</html>