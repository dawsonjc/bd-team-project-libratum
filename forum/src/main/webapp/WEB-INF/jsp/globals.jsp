<%@ page import="models.Users" %>
<%
    // if user is signed in
    if(request.getAttribute("current_user") != null) {
        Users currentUser = (Users) request.getSession().getAttribute("current_user");
        request.getSession().setAttribute("current_user", currentUser);
    }
    Users currentUser = (Users) request.getSession().getAttribute("current_user");
%>

