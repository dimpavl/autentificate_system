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
        <script type="text/javascript" src="./js/jquery-1.11.2.min.js"></script>
       
    </head>
    <body>
        

    <script>
        function clicke(btn){
            $.post( "./blocking", { id: btn.id, checked: btn.checked});
        }        
    </script>
        
       <a href="./logout">Logout</a><br/>
       Hello ${userAuth.login}! 
       
       <br/>
       Your role is: ${userAuth.role.role}</br>
       You are blocked ${userAuth.entrance.blocking}</br>       
       
       
       <c:forEach var="lst" items="${allUsers}">
            Role: ${lst.key}
            <table border>
            <tr>
               <td>Username</td><td>Login</td><td>Email</td><td>Blocking</td><td>Role</td>               
           </tr>           
           <c:forEach var="user" items="${lst.value}">
               <tr>
               <td>${user.username}</td><td>${user.login}</td><td>${user.email}</td>                              
               <td>                                                              
                       <c:if test="${user.entrance.blocking}">
                            <input type="checkbox" checked id="${user.entrance.id}" onclick="clicke(this);"/>
                        </c:if>  
                        <c:if test="${not user.entrance.blocking}">
                            <input type="checkbox" id="${user.entrance.id}" onclick="clicke(this);"/>
                        </c:if>                                                                                                                   
               </td>
               <td>${user.role.role}</td>
               </tr>
           </c:forEach>
           
           </table>
           <br/><br/>  
       </c:forEach>       
    </body>
</html>
