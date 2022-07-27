<%--
    This file is dependent upon a title declaration before inclusion
    ```jsp
    <%! private final String title = "[title]"; %>
    <%@ include file="header.jsp" %>
    ```
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= title %></title>
    <meta charset="UTF-8">
    <meta name="viewport content="width=device-width, initial-scale="1.0">
    <link rel="stylesheet" href="styles.css">
    <script src=""></script>
    <script src="index.js" defer></script>
    <title>Fun with JS!</title>

</head>
<body>
<nav>
    <button><a href="/">Home</a></button>
    <button><a href="<%= request.getContextPath() + "/account/registration" %>">registration</a></button>
</nav>
</body>
</html>
