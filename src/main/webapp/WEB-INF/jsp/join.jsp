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
    <title>회원가입</title>

    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<div class="container">
    <h2>회원가입</h2>

    <div class="form-group">
        <a href="${pageContext.request.contextPath}/">List</a>
    </div>
    <form id="joinForm"
           action="${pageContext.request.contextPath}/member/join" method="post" onsubmit="return validateForm()">

        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>

        <!-- ID -->
        <div class="form-group">
            <label for="userId">id</label>
            <input type="text" class="form-control" id="userId" name="userId" value="${userId}">
            <button type="button" class="btn-check-id" onclick="checkDuplicateId()">중복확인</button>
        </div>

        <!-- Password -->
        <div class="form-group">
            <label for="userPw">pw</label>
            <input type="password" class="form-control" id="userPw" name="userPw" value="${userPw}" oninput="checkPasswordMatch()">
        </div>

        <!-- Password Check -->
        <div class="form-group">
            <label for="pwCheck">pw check</label>
            <input type="password" class="form-control" id="pwCheck" oninput="checkPasswordMatch()">
            <span id="passwordMatchMessage"></span>
        </div>

        <!-- Name -->
        <div class="form-group">
            <label for="userName">name</label>
            <input type="text" class="form-control" id="userName" name="userName" value="${userName}">
        </div>

        <!-- Phone -->
        <div class="form-group">
            <label>phone</label>
            <div class="phone-group">
                <select class="phone-select" name="userPhone1">
                    <option value="">선택</option>
                    <c:forEach var="phone" items="${phoneNumbers}">
                        <option value="${phone.codeName}">${phone.codeName}</option>
                    </c:forEach>
                </select>
                <input type="text" class="phone-input" name="userPhone2" value="${userPhone2}" maxlength="4">
                <input type="text" class="phone-input" name="userPhone3" value="${userPhone3}" maxlength="4">
            </div>
        </div>

        <!-- Address 1 -->
        <div class="form-group">
            <label for="userAddr1">postNo</label>
            <input type="text" class="form-control" id="userAddr1" name="userAddr1" value="${userAddr1}">
            <input type="button" onclick="PostCode()" value="우편번호 찾기">
        </div>

        <!-- Address 2 -->
        <div class="form-group">
            <label for="userAddr2">address</label>
            <input type="text" class="form-control" id="userAddr2" name="userAddr2" value="${userAddr2}" placeholder="상세주소를 입력해주세요">
        </div>

        <!-- Company -->
        <div class="form-group">
            <label for="userCompany">company</label>
            <input type="text" class="form-control" id="userCompany" name="userCompany" value="${userCompany}">
        </div>

        <button type="submit" class="btn-submit" onclick="joinSubmit()">Join</button>
    </form>
</div>

<script>
    let idChecked = false;

    function validateForm() {
        const userId = document.getElementById('userId').value;
        const userPw = document.getElementById('userPw').value;
        const pwCheck = document.getElementById('pwCheck').value;
        const userName = document.getElementById('userName').value;
        const phone2 = document.querySelector('[name="userPhone2"]').value;
        const phone3 = document.querySelector('[name="userPhone3"]').value;

        if (!userId || !userPw || !pwCheck || !userName) {
            alert('필수 정보를 모두 입력해주세요.');
            return false;
        }

        if (!idChecked) {
            alert('아이디 중복 확인을 해주세요.');
            return false;
        }

        if (userPw !== pwCheck) {
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }

        if (!validatePassword(userPw)) {
            alert('비밀번호는 최소 8자 이상이며, 영문자, 숫자, 특수문자를 포함해야 합니다.');
            return false;
        }

        if (phone2 && phone3) {
            if (!/^\d{3,4}$/.test(phone2) || !/^\d{4}$/.test(phone3)) {
                alert('전화번호 형식이 올바르지 않습니다.');
                return false;
            }
       }
        return true;
    }

    function checkDuplicateId() {
        const userId = document.getElementById('userId').value;
        if (!userId) {
            alert('아이디를 입력해주세요.');
            return;
        }

        fetch(`/member/check-id?userId=${userId}`)
            .then(response => response.json())
            .then(duplicateCount => {
                if (duplicateCount === 0) {
                    alert('사용 가능한 아이디입니다.');
                    idChecked = true;
                } else {
                    alert('이미 사용중인 아이디입니다.');
                    idChecked = false;
                }
            });
    }

    function checkPasswordMatch() {
        const password = document.getElementById('userPw').value;
        const confirmPassword = document.getElementById('pwCheck').value;
        const messageSpan = document.getElementById('passwordMatchMessage');

        const styleMatch = 'color: green; font-size: 0.8em; margin-left: 5px;';
        const styleMismatch = 'color: red; font-size: 0.8em; margin-left: 5px;';

        if (password || confirmPassword) {
            if (!validatePassword(password)) {
                messageSpan.textContent = '비밀번호는 최소 8자 이상이며, 영문자, 숫자, 특수문자를 포함해야 합니다.';
                messageSpan.style.cssText = styleMismatch;
                return;
            }

            if (password === confirmPassword) {
                messageSpan.textContent = '비밀번호가 일치합니다.';
                messageSpan.style.cssText = styleMatch;
            } else {
                messageSpan.textContent = '비밀번호가 일치하지 않습니다.';
                messageSpan.style.cssText = styleMismatch;
            }
        } else {
            messageSpan.textContent = '';
        }
    }

    function validatePassword(password) {
        const regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
        return regex.test(password);
    }

    function PostCode() {
        new daum.Postcode({
            oncomplete: function (data) {
                var addr = '';
                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }

                document.getElementById('userAddr1').value = data.zonecode;
                document.getElementById('userAddr2').value = addr;
                document.getElementById('userAddr2').focus();
            }
        }).open();
    }

    function joinSubmit() {
        document.getElementById('joinForm').submit();

        alert("가입이 완료되었습니다.");
        return 'list';
    }
</script>
</body>
</html>