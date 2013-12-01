<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: venkatakrishnachaita
  Date: 11/3/13
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <table>
        <tr>
            <td colspan="3" height="30"><tiles:insertAttribute name="header"/> </td>
        </tr>
        <tr>
            <td height="250"><tiles:insertAttribute name="menu"/> </td>
            <td height="250"><tiles:insertAttribute name="body"/> </td>
        </tr>
        <tr>
            <td height="30" colspan="3"><tiles:insertAttribute name="footer"/></td>
        </tr>
    </table>
</body>
</html>