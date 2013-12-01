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
    <title>struts Example project| tweets</title>
</head>
<body>

    <s:url action="update.do" var="updateTweet" namespace="/tweet"  >
        <s:param name="id" > <s:property value="tweetId"/></s:param>
    </s:url>

<table>
        <%--<s:iterator var="tweetEntity" value="onlyUserNameWithIdsList">--%>
            <s:iterator var="tweetEntity" value="tweetEntities">
        <tbody>
             <td><s:property value="tweetId"/></td>
            <td><s:property value="tweet"/></td>
            <td><s:a action="update.do?tweetId=%{#tweetEntity.tweetId}">update</s:a></td>
             <td><s:url id ="delete" action="delete.do">
                 <s:param name="tweetId" value="tweetId"></s:param>
             </s:url> 
            <s:a href="%{delete}">delete</s:a>
             </td>
        </tbody>
   </s:iterator>
</table>
        <s:a action="create.do">create new tweet</s:a>

    <s:if test="hasActionMessages()">
        <s:actionmessage/>
    </s:if>
 </body>
</html>