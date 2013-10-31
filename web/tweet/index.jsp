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
    <%--<s:iterator var="tweetModel" value="tweetModels">--%>
        <s:iterator var="tweetEntity" value="tweetEntities">
        <tbody>
             <td><s:property value="tweetId"/></td>
            <td><s:property value="tweet"/></td>
            <%--<td><a href="<s:url var="%{updateTweet}"/>">update</a></td>--%>
            <td><s:a action="update?tweetId=%{#tweetEntity.tweetId}">update</s:a></td>
             <td><s:url id ="delete" action="delete">
                 <s:param name="tweetId" value="tweetId"></s:param>
             </s:url> 
            <s:a href="%{delete}">delete</s:a>
             </td>
             <%--<td><s:url action="delete"><s:param value= <s:property value="tweetId">>delete</s:url></td>--%>
              <%--<td><s:a action="delete?tweetId=%{tweetId}">delete</s:a></td>--%>
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