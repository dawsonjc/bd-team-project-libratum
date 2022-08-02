<%@ page import="models.PostThread" %>
<%@ page import="models.Post" %>
<%@ page import="java.util.List" %>
<%--
    This page is going to heavily rely on parameters to render
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../globals.jsp"%>

<%
    PostThread thread = (PostThread) request.getAttribute("PostThread");
    List<Post> posts = thread.getPosts();
%>

<html>
<% final String title = thread.getTitle(); %>
<%@ include file="../header.jsp"%>
<body>
<script src="<%= request.getContextPath() %>/static/js/post.js"></script>
<table id="postThreadTable">
    <thead>
        <tr>
            <td>
                <table>
                    <tbody>
                    <tr>
                        <td><h3><%= thread.getTitle() %></h3></td>
                        <td><%= thread.getPost(0).getFromUser().getUsername() %></td>
                    </tr>
                    <tr>
                        <td><%= thread.getPost(0).getContent() %></td>
                    </tr>
                    </tbody>
                </table>
            </td>
        </tr>
    </thead>
    <tbody>
        <%
            for(int i = 1; i < posts.size(); i++) {
              Post currentPost = posts.get(i);
        %>
        <tr>
            <td>
                <table>
                    <tbody>
                        <tr>
                            <td>
                                <table>
                                    <tbody>
                                    <tr>
                                        <td><%= currentPost.getFromUser() %></td>
                                    </tr>
                                    <tr>
                                        <td><%= currentPost.getDate() %></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </td>
                            <td><%= currentPost.getContent() %></td>
                            <td><%= currentPost.getLikes() %></td>
                        </tr>
                        <tr>
                            <td><button onclick="like(<%= i %>)">like</button></td>
                            <td><button class="reply" id="<%= i %>">reply</button></td>
                            <td>
                                <form class="postReply">
                                    <input type="hidden" name="postId" value="<%= i %>">

                                    <label for="content">Text</label>
                                    <input id="content" name="content" type="text" >

                                    <button type="submit">Post Reply</button>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>
