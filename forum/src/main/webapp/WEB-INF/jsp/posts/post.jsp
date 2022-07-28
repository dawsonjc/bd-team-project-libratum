<%@ page import="models.PostThread" %>
<%@ page import="models.Post" %>
<%@ page import="java.util.LinkedList" %><%--
    This page is going to heavily rely on parameters to render
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../globals.jsp"%>

<%
    PostThread thread = (PostThread) request.getAttribute("PostThread");
    LinkedList<Post> posts = thread.getPosts();
%>

<html>
<%! private final String title = "Post"; %>
<%@ include file="../header.jsp"%>
<body>
<table>
    <tr>
        <tr>
            <% for(int i = 1; i < posts.size(); i++) { %>
                <% Post currentPost = posts.get(i); %>
            <td><%= currentPost.getFromUser() %><br> <%= currentPost.getDate() %></td>
            <td><%= currentPost.getContent() %></td>
            <td><%= currentPost.getLikes() %></td>
        </tr>
        <tr>
            <td>likes: <button>like</button></td>
            <td>reply: <button>reply</button></td>
        </tr>
    </tr>
        <%}%>
    <tr>
        <td><h3>posts.get(1)></h3></td>
    </tr>



</table>
</body>
</html>
