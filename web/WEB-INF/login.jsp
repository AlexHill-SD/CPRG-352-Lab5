<%-- 
    Document   : login
    Created on : 07-Oct-2021, 12:03:09
    Author     : BritishWaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        
        <div>
            <form action="login" method="post">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" value="${username}" placeholder="Enter username here">
                <br>
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" value="${password}">
                <br>
                <button type="submit">Login</button>
            </form>
        </div>
        <p>
            ${server_message}
        </p>
    </body>
</html>
