<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            width: 500px;
            margin: 0 auto;
        }
        .form-group {
            margin-bottom: 15px;
            display: flex;
            align-items: center;
        }
        .form-group label {
            width: 100px;
            text-align: right;
            margin-right: 15px;
            font-weight: bold;
        }
        .form-control {
            flex: 1;
            padding: 5px;
            border: 1px solid #ccc;
        }
        .phone-group {
            display: flex;
            gap: 5px;
        }
        .phone-select {
            width: 70px;
        }
        .phone-input {
            width: 60px;
        }
        .btn-check-id {
            padding: 5px 10px;
            margin-left: 5px;
            background-color: #f0f0f0;
            border: 1px solid #ccc;
            cursor: pointer;
        }
        .btn-submit {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            float: right;
        }
        .error-message {
            color: red;
            font-size: 12px;
            margin-left: 115px;
        }
        #passwordMatchMessage {
            display: inline-block;
            margin-left: 5px;
            font-size: 0.8em;
        }
    </style>
    <title>비밀번호 찾기</title>

</head>
<body>
<div class="container">
    <h2>비밀번호 찾기</h2>

    <h3>가입할 때 입력한 이메일을 입력해주세요</h3>
    <!-- 이메일 -->
    <div class="form-group">
        <label for="userEmail">이메일</label>
        <input type="text" class="form-control" id="userEmail" name="userEmail" value="${userEmail}">
        <button type="button" class="btn-check-email" onclick="checkSendEmail()">인증 메일 발송</button>
    </div>
    <a href="${pageContext.request.contextPath}/member/moveLogin">로그인 화면으로</a>
</div>

<script>

    function checkSendEmail() {
        const userEmail = document.getElementById('userEmail').value;

        if (!userEmail) {
            alert('이메일 주소를 입력해주세요.');
            return;
        }

        fetch('${pageContext.request.contextPath}/member/findPW?userEmail=' + userEmail)
            .then(response => response.text())
            .then(result => {
                if (result === "1") {
                    alert("이메일로 비밀번호를 발송했습니다.");
                } else if (result === "3") {
                    alert("해당 이메일로 가입된 아이디가 없습니다.");
                } else {
                    alert("오류가 발생했습니다. 다시 시도해주세요.");
                }
            });
    }
</script>
</body>
</html>