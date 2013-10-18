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

    <s:url action="update" var="updateTweet" namespace="/tweet"  >
        <s:param name="id" > <s:property value="tweetId"/></s:param>
    </s:url>
 <%--   <s:url action="delete" var="deleteTweet" namespace="/tweet" />
    <s:url action="create" id="createTweetId" var="createTweetId" namespace="/tweet"/>
--%>
<table>
    <s:iterator var="tweetModel" value="tweetModels">
        <tbody>
             <td><s:property value="tweetId"></s:property></td>
            <td><s:property value="tweet"></s:property></td>
            <%--<td><a href="<s:url var="%{updateTweet}"/>">update</a></td>--%>
            <td><s:a action="update?tweetId=%{#tweetModel.tweetId}">update</s:a></td>
            <td><s:a action="delete?tweetId=%{#tweetModel.tweetId}">delete</s:a></td>
        </tbody>
<%--        <td><a href="<s:property value="#updateTweet"/>">update</a></td>
        <td><a href="<s:property value="#deleteTweet"/>">delete</a></td>--%>
       <%-- <td></td>
        <td></td>--%>
    </s:iterator>
</table>
        <s:a action="create">create new tweet</s:a>
    <s:if test="hasActionMessages()">
        <s:actionmessage/>
    </s:if>
            <%--<a href="<s:property value="#add" />">create a new tweet</a>--%>
 </body>
</html>