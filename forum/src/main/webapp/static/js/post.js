var state = false;

function openForm() {
    $("reply").css("display", "block");
    state = true;
}

function closeForm() {
    $("reply").css("display", "none");
    state = false;
}

var postContent = "";

$(".reply").click(function() {
    if(!state) {
        openForm();
    } else {
        closeForm();
    }
});


$(".postReply").submit(function(e) {
    e.preventDefault();

    let link = window.location.href + "/post";
    $.post(link, $(this).serialize(), function(data, status) {
            if(status === "ok") {
                let response = data.response;

                let postThread = $("#postThreadTable tbody");

                let lastNumber = parseInt(postThread.last()) + 1;

                console.log(response);
                let newPost = $("<tr>").append(
                    $(createTable(response, postContent, lastNumber))
                );
                postThread.append(newPost);
            }
        }
    )
});

function createTable(data, postContent, lastNumber) {
    return `
            <table>
                <tbody>
                    <tr>
                        <td>
                            <table>
                                <tbody>
                                <tr>
                                    <td>${data.fromUser.username}</td>
                                </tr>
                                <tr>
                                    <td>${new Date()}</td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                        <td>${postContent}</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>like: <button onclick="like(${lastNumber})">like</button></td>
                        <td>reply: <button class="reply" id="${lastNumber}">reply</button></td>
                        <td>
                            <form class="postReply">
                                <input type="hidden" name="postId" value="${lastNumber}">
                                
                                <label for="content">Text</label>
                                <input id="content" name="content" type="text" >
                                
                                <button type="submit">Post Reply</button>
                            </form>
                        </td>
                    </tr>
                </tbody>
            </table>
    `;
}

class Table {
    constructor() {
        this.table = $("<table><tbody></tbody></table>");
        this.tbody = this.table.find("tbody");
    }


    appendRow(attributes) {
        let row;
        if(attributes === null) {
            row = $("<tr>");
            this.tbody.append(row);
        } else {
            row = $("<tr>", attributes);
        }
        this.table.append(row);

        return row;
    }

    appendCell(row, attributes) {
        let cell;
        if (attributes === null) {
            cell = $("<td>");
        } else {
            cell = $("<td>", attributes);
        }
        row.append(cell);
        return cell;
    }

    build() {
        return this.table;
    }
}



