<%-- 
    Document   : sequre
    Created on : Mar 24, 2015, 11:04:07 AM
    Author     : Дима
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>Secure</title>
    </head>
    <body>
       Hello ${userAuth.login}!
       
    <c:forEach items="${roles}" var="element"> 
        <tr>
            <td>${element.idrole}</td>
            <td>${element.role}</td>            
        </tr>
    </c:forEach>
    </body>
</html>
