<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>User managment</title>
        </head>

        <body>
            <p> New user create</p>
            <form:form action="user" method="post" modelAttribute="userForm">
                <label>loginId:</label></label>
                <form:input path="login_id" />
                </br>
                <label>Name:</label>
                <form:input path="name" />
                </br>
                <label>Password:</label>
                <form:input path="password" />
                </br>
                <label>Roles:</label>
                <div>
                    <form:radiobutton path="role" value="ADMIN" />
                    <label>Admin</label>
                </div>
                <div>
                    <form:radiobutton path="role" value="USER" />
                    <label>User</label>
                </div>
                </br>
                <form:button> Login</form:button>
                </br>
            </form:form>
            <p>${errMsg}</p>
        </body>

        </html>