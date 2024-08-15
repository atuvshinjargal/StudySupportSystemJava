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
            <form:form action="result" modelAttribute="test">
                <form:input path="password" />
                <form:button> Submit</form:button>
            </form:form>
            <p>${msg}</p>
        </body>

        </html>