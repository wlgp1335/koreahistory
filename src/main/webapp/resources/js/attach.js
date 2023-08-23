//돔 생성해서 summernote실행 : 마지막에 실행됨
$(function() {
    $("#summernote").summernote({
        lang: 'ko-KR' // default: 'en-US'   
    });
    
    //각 첨부파일 삭제(여러개의 데이터에 속성 부여 class)
    //버튼 클릭이 실행의 주체가 되어 요청만 함
    //#files의 id선택자의 자손(ex:손자)
    $("#files .delete").click(function(){
        //data-id 찾기
        const id = $(this).data("id");
        //버튼의 실행값을 변수에 저장
        const button = $(this);
    
        //ajax처리
        $.ajax({
            type:'POST',
            url: '../delete_attach/' + id,
            //실행 주체가 달라짐
            success: function(result) {
                console.log(result);
                //가까이 있는 li태그 찾기
                button.closest("li").remove();
            }
        });
    });
    
    //첨부파일 추가버튼 눌렀을때 파일선택의 삭제 기능 위임
    $("#attachs").on("click",".delete", function(){
        $(this).closest(".input-group").remove();
    })
    
    $("#add").click(function(){
        //<div id="attachs" class="input-group mb-3"><button type="button" class="btn btn-sm btn-outline-secondary">삭제</button></div>
        const div = $("<div>");
        
        div.addClass("input-group");
        div.addClass("mb-3");
        
        //<input type="file" name="attach" class="form-control">
        const input = $("<input>");
        
        input.attr("type","file");
        input.attr("name","attach");
        input.addClass("form-control");
        input.addClass("form-control-sm");
        
        const button = $("<button>");
        
        button.attr("type","button");
        button.addClass("btn")
        button.addClass("btn-sm");
        button.addClass("btn-outline-danger");
        button.addClass("delete");
        button.text("삭제");
        
        div.append(input);
        div.append(button);
        
        $("#attachs").append(div);
    });
    
});