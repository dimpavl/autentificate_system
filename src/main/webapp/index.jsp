<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>        
    </head>   
    <body>
        <c:if test="${not empty errors.autentificationFailed}">
            <font color="red">
               * <c:out value="${errors.autentificationFailed}"/>
            </font>                            
        </c:if>
         <form action="login" method="post">
            <table>
                <tr>
                    <td>
                        <label for="login">Login:</label>
                    </td>
                    <td>                        
                        <input type="text" name="login" value='${login}'/>
                        <c:if test="${not empty errors.login}">
                            <font color="red">
                               * <c:out value="${errors.login}"/>
                            </font>                            
                        </c:if>
                    </td>
                </tr>
                    
            <tr>
                <td>
                    <label for="password">Password:</label>
                </td>
                <td>
                    <input type="password" name="password" value='${password}' />
                    <c:if test="${not empty errors.password}">
                        <font color="red">
                           * <c:out value="${errors.password}"/>
                        </font>                            
                    </c:if>
                </td>
            </tr>
            </table>
             <input type="submit" value="LogIn"/>
             <input type="button" onclick="window.location.href='./registrate'" value="Registrate"/>
        </form>
    </body>
</html>
