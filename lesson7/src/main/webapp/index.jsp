<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lesson 7 - Login Page</title>
</head>
<body>
<div style="text-align: center;">
    <h1><%= "Login" %></h1>
</div>
<br/>
<form action="handle-login" method="post">
    <div style="padding: 25px">
        <label>
            <%= "Username: " %>
            <input type="text" placeholder="Enter Username" name="username" required>
        </label>
        <label>
            <%= "Password: " %>
            <input type="password" placeholder="Enter Password" name="password" required>
        </label>
        <button type="submit">Login</button>
    </div>
</form>
</body>
</html>