$(function (code) {

    //댓글 등록 버튼
    $("#replyAdd").click(function () {
        $.ajax({
            type: 'POST',
            url: '${path}/comment/add',
            data: $("#commentForm").serialize(),
            success: function (data) {
                if (data == "success") {
                    getCommentList();
                    $("#comment").val("");
                }
            }
        });
    });

    //댓글 목록
    function commentList() {
        $.ajax({
            type: 'GET',
            url: '${path}/detail/{id}/comment/list',
            dataType: "json",
            data: $("#commentForm").serialize(),
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            success: function (data) {

                var html = "";
                var cCnt = data.length;

                if (data.length > 0) {

                    for (i = 0; i < data.length; i++) {
                        html += "<div>";
                        html += "<div><table class='table'><h6><strong>" + data[i].writer + "</strong></h6>";
                        html += data[i].comment + "<tr><td></td></tr>";
                        html += "</table></div>";
                        html += "</div>";
                    }

                } else {

                    html += "<div>";
                    html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                    html += "</table></div>";
                    html += "</div>";

                }

                $("#cCnt").jsp(cCnt);
                $("#commentList").jsp(html);

            },
        });
    }

});