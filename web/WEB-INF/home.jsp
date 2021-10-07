<%-- 
    Document   : home
    Created on : 07-Oct-2021, 12:26:40
    Author     : BritishWaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
        <h1>Homepage</h1>
        
        <div>
            <p>
                Hello & welcome to your home page ${username}.
            </p>
        </div>
        
        <a href="login?logout">Logout!</a>
    </body>
</html>
