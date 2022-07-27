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

%>

<!DOCTYPE html>
<html lang="en">
<%! private final String title = "Forum"; %>
<%@include file="../header.jsp" %>
<body>
<h2>My Playlists</h2>
<ul id="playlists">
</ul>
<h2>Create a Playlist</h2>

<table>
    <tbody>
    <%
        for(int i = 0; i < 10; i++) {
    %>
    <tr><td></td></tr>
    <%
        }
    %>
    </tbody>

</table>



<p><%= e %></p>
<form class="card-content" id="create-playlist-form">
    <div class="">

    </div>
</form>
</body>
</html>
