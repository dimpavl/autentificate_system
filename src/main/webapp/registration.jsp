<%-- 
    Document   : registration
    Created on : Mar 24, 2015, 11:23:48 AM
    Author     : Дима
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>Registrate new user</title>
    </head>
    <body>
                       
        <h3>Registrate new user</h3>
        <form method="POST" action="registrate">
            <table>
                 <tr>
                    <td>
                        <label for="username">Username:</label>
                    </td>
                    <td>                                                
                        <input type="text" name="username" value='${username}'/>
                        <c:if test="${not empty errors.username}">
                            <font color="red">
                               * <c:out value="${errors.username}"/>
                            </font>                            
                        </c:if>
                    </td>
                </tr>                 
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
                        <label for="email">Email:</label>
                    </td>
                    <td>                        
                        <input type="text" name="email" value='${email}'/>
                       <c:if test="${not empty errors.email}">
                            <font color="red">
                               * <c:out value="${errors.email}"/>
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
                <tr>
                    <td>
                        <label for="password_confirm">Password confirm:</label>
                    </td>
                    <td>
                        <input type="password" name="password_confirm" value='${password_confirm}'/>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Registrate">
        </form>
    </body>
</html>
