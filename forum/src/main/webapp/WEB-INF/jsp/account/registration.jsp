<%--
  Created by IntelliJ IDEA.
  User: dawso
  Date: 07/27/2022
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../globals.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<%! private final String title = "Registration"; %>
<%@include file="../header.jsp"%>
<body>
<table>
    <tbody>
    <tr>
        <td><h3>Register</h3></td>
        <td><h3>Login</h3></td>
    </tr>
    <tr>
        <!-- Register -->
        <td>
            <form:form action="${pageContext.request.contextPath}/account/register" method="post" modelAttribute="register_user">
                <form:label path="username">Username</form:label>
                <form:input path="username" placeholder="username"/>

                <form:label path="password">Password</form:label>
                <form:input path="password" type="password" />

                <form:button>Register</form:button>
            </form:form>
        </td>

        <!-- Login -->
        <td>
            <form:form action="${pageContext.request.contextPath}/account/login" method="get" modelAttribute="login_user">
                <form:label path="username">Username</form:label>
                <form:input path="username" placeholder="username"/>

                <form:label path="password">Password</form:label>
                <form:input path="password" type="password" />

                <form:button>login</form:button>
            </form:form>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>
