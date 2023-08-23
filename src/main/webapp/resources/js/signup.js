$(function () {
    var isCheck;

    $('#infoCheck').click(function () {
        const form = document.signup_form;
        const checkBox = $('#aggrement').is(":checked")

        if (form.name.value == '') {
            alert('이름을 입력해주세요');
            form.name.focus();
            return;
        }else if (form.id.value == '') {
            alert('이메일을 입력하세요');
            form.id.focus();
            return;
        } else if (form.passwd.value == '') {
            alert('비밀번호를 입력하세요');
            form.passwd.focus();
            return;
        } else if (form.passwd_2.value == '') {
            alert('비밀번호를 확인하세요');
            form.passwd_2.focus();
            return;
        } else if (form.passwd.value != passwd_2.value) {
            alert('비밀번호가 서로 다릅니다');
            form.passwd.focus();
            return;
        } else if (isCheck != form.id.value) {
            alert('중복체크 해주세요');
            return;
        } else if(checkBox == false) {
            alert('개인정보 수집 및 이용에 동의해주세요');
            return;
        }
        alert('회원가입 완료');
        form.submit();
    });

    $('#checkId').click(function () {
        var id = $('#id').val(); //이메일의 id값
        $.ajax({
            url: '/checkId/{id}', //컨트롤러에서 요청 받을 주소
            type: "GET",
            data: { id: id },
            success: function (id) { 
                if (id == 'OK') {
                    console.log("성공"+id);
                    alert('사용가능 합니다');
                    isCheck = $('#id').val();
                } else {
                    console.log("실패"+id);
                    alert('사용 불가능합니다');
                    $('#id').val('');
                }
            },
            //error:
        });
    });
});
