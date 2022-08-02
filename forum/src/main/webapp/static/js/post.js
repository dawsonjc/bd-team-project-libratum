/**
 * I want to die
 *
 */
const table =

$(".reply").click(function() {
    let id = this.attr("id");

    let postContent = "";

    let link = window.location.href + "/post"
    $.post(link, {
            postId: id,
            content: postContent
        }, function(data, status) {
            if(status === "ok") {
                let response = data.response;

                console.log(response);
                let newPost = $("<tr>").append(createTable(response, postContent));
                $("#postThreadTable tbody").append(newPost);
            }
        }
    )


});

function createTable(data, postContent) {
    return `
            <table>
                <tbody>
                    <tr>
                        <td>
                            <table>
                                <tbody>
                                <tr>
                                    <td>\${data.fromUser.username}</td>
                                </tr>
                                <tr>
                                    <td>\${new Date()}}</td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                        <td>\${postContent}</td>
                        <td>0</td>
                    </tr>
                    <tr>
                        <td>like: <button onclick="like(1)">like</button></td>
                        <td>reply: <button class="reply" id="1">reply</button></td>
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



