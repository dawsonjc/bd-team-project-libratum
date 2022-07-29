<%--
    This file is dependent upon a title declaration before inclusion
    ```jsp
    <%! private final String title = ["Title"]; %>
    <%@ include file="header.jsp" %>
    ```
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title><%= title %></title>
    <meta charset="UTF-8">
    <meta name="viewport content="width=device-width, initial-scale="1.0">
    <link rel="stylesheet" href="css/styles.css">
    <script src=""></script>
    <script src="<%= request.getContextPath() %>/index.js" defer></script>
    <title>Fun with JS!</title>

</head>
<body>
    <div class ="header">
        <div class-"inner_header">
            <div class="logo_container">
                <h1>LIBRATUM</h1>
            </div>
        </div>
    </div>
<nav>
    <button><a href="/">Home</a></button>
    <button><a href="<%= request.getContextPath() + "/account/registration" %>">registration</a></button>
</nav>
</body>
</html>
