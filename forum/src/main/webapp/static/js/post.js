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
    return $("<table>").append(
        $("<tbody>").append(
            $("<tr>").append(
                $("<td>").append(
                    $("<table>").append(
                        $("<tbody>").append(
                            $("<tr>").append(
                                $("<td>").html(`\${data.fromUser.username}`)
                            )
                        ).append(
                            $("<tr>").append(
                                $("<td>").html(`\${new Date()}`)
                            )
                        )
                    )
                )
            ).append(
                $("<td>").html(`\${postContent}`)
            ).append(
                $("<td>").html(0)
            )
        ).append(
            $("<tr>").append(
                $("<td>").append(
                    $("<button>", { onclick:"like(1)" }).html("Like")
                )
            ).append(
                $("<td>").append(
                    $("<button>", { class:"reply", id:"1" }).html("reply")
                )
            )
        )
    );
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



