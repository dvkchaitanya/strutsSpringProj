<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
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
    <sj:head jqueryui="true"/>
</head>
<body>

    <s:url action="update.do" var="updateUser" namespace="/user"  >
        <s:param name="id" > <s:property value="userId"/></s:param>
    </s:url>

<table>
        <%--<s:iterator var="userEntity" value="userEntities">--%>
        <s:iterator var="onlyUserNameWithId" value="onlyUserNameWithIdsList">
        <tbody>
             <td><s:property value="userId"/></td>
            <td><s:property value="userName"/></td>
            <td><s:a action="update.do?userId=%{#onlyUserNameWithId.userId}">update</s:a></td>
             <td><s:url id ="delete" action="delete.do">
                 <s:param name="userId" value="userId"></s:param>
             </s:url>
            <s:a href="%{delete}">delete</s:a>
             </td>
        </tbody>
   </s:iterator>
</table>
        <s:a action="create.do">create new user</s:a>
          <s:if test="hasActionMessages()">
        <s:actionmessage/>
    </s:if>

<%--    &lt;%&ndashtodo;
    to create
    current condition:
     give an option to choose the date from a list and display all the list of values
    &ndash;%&gt;
<table>
    <thead></thead>
    <tbody>
    <tr>
       <td>cloudcover</td>
        <td>humidity</td>
        <td>observation_time</td>
    </tr>
    <tr>
        <td><span id="cloudCover"></span></td>
        <td><span id="humidity"></span></td>
        <td><span id="observation_time"></span></td>
    </tr>
    </tbody>
</table>
    <div id="testTarget"></div>
   <s:url id="getWeatherUrl" action="getWeatherResult.do" />
   <sj:a id="getWeatherResult"  href="%{getWeatherUrl}" targets="testTarget">test struts 2 jquery</sj:a>
   --%>
 </body>
</html>