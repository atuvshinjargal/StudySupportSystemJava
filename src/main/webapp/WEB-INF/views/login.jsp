<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>User Login</title>
        </head>

        <body>
            <p> Messages received on ❦ ❦ will be displayed. </p>
            <form:form action="login" method="post" modelAttribute="loginForm">
                <label>loginId:</label></label>
                <form:input path="login_id" />
                </br>
                <label>Password:</label>
                <form:input path="password" />
                </br>
                <form:button> Login</form:button>
                </br>
            </form:form>
            <p>${errMsg}</p>
        </body>

        </html>