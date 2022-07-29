<%@ page import="daos.PostThreadDAO" %>
<%@ page import="models.PostThread" %>
<%@ include file="../globals.jsp"%>
<%
    String indexParam = request.getParameter("page");

    int start = 0;
    if(indexParam != null) {
        int pageNum = Integer.parseInt(indexParam);
        if(pageNum > 1) {
            for(int i = 0; i < pageNum; i++) {
                start += 10;
            }
        }
    }
    PostThreadDAO dao = (PostThreadDAO) request.getAttribute("dao");
%>

<!DOCTYPE html>
<html lang="en">
<%! private final String title = "Forum"; %>
<%@include file="../header.jsp" %>
<body>


<table>
    <tbody>
    <%
        for(int i = start; i < start + 10; i++) {
            //PostThread thread = dao.findById("" + i);
    %>
    <tr>
        <td>2</td>
        <td><a href="">1</a></td>
    </tr>
    <%
        }
    %>
    </tbody>

</table>
<script type="text/javascript">
    const string = "<%= currentUser %>";
</script>



