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
    <title>아이디 찾기</title>



    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
<div class="container">
    <h2>아이디 찾기</h2>
        <!-- 이메일 -->
        <div class="form-group">
            <label for="userEmail">이메일</label>
            <input type="text" class="form-control" id="userEmail" name="userEmail" value="${userEmail}">
            <button type="button" class="btn-check-email" onclick="checkSendEmail()">인증 메일 발송</button>
        </div>
</div>

<script>
    let emailSendYN = false;

    function validateForm() {
        const userId = document.getElementById('userId').value;
        const userEmail = document.getElementById('userEmail').value;

        // 전화번호 결합
        const userPhone = phone1 + phone2 + phone3;
        document.getElementById('userPhone').value = userPhone;

        if (!userId || !userPw || !pwCheck || !userName) {
            alert('필수 정보를 모두 입력해주세요.');
            return false;
        }

        if (!idChecked) {
            alert('아이디 중복 확인을 해주세요.');
            return false;
        }

        if (!nameChecked) {
            alert('이름 중복 확인을 해주세요.');
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

        if (!emailChecked) {
            alert('이메일 인증을 해주세요.');
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

    function filterToNumbers(input) {
        input.value = input.value.replace(/[^0-9]/g, '');
    }

    function checkDuplicateId() {
        const userId = document.getElementById('userId').value;

        if (!userId) {
            alert('아이디를 입력해주세요.');
            return;
        }

        fetch('${pageContext.request.contextPath}/member/check-id?userId=' + userId)
            .then(response => response.json())
            .then(duplicateCount => {
                if (duplicateCount < 1) {
                    alert('사용 가능한 아이디입니다.');
                    idChecked = true;
                } else {
                    alert('이미 사용중인 아이디입니다.');
                    idChecked = false;
                }
            });
    }

    function checkDuplicateName() {
        const userName = document.getElementById('userName').value;

        if (!userName) {
            alert('이름을 입력해주세요.');
            return;
        }

        fetch('${pageContext.request.contextPath}/member/check-name?userName=' + userName)
            .then(response => response.json())
            .then(duplicateCount2 => {
                if (duplicateCount2 < 1) {
                    alert('사용 가능한 이름입니다.');
                    nameChecked = true;
                } else {
                    alert('이미 사용중인 이름입니다.');
                    nameChecked = false;
                }
            });
    }

    function checkSendEmail() {
        const userEmail = document.getElementById('userEmail').value;

        if (!userEmail) {
            alert('이메일 주소를 입력해주세요.');
            return;
        }

        fetch('${pageContext.request.contextPath}/member/sendmail?userEmail=' + userEmail)
            .then(response => response.json())
            .then(checkEmail => {
                if (checkEmail === 1) {
                    alert('메일이 발송되었습니다.');
                    emailSendYN = true;
                    document.getElementById('emailCodeArea').style.display = 'flex';
                } else {
                    alert('메일 발송에 실패하였습니다.');
                    emailSendYN = false;
                }
            });
    }

    function checkRandomCode() {
        const userCode = document.getElementById('userCode').value;

        if (!userCode) {
            alert('코드를 입력해주세요.');
            return;
        }

        fetch('${pageContext.request.contextPath}/member/emailChecked?userCode=' + userCode)
            .then(response => response.json())
            .then(checkCode => {
                if (checkCode === 1) {
                    alert('인증이 완료되었습니다.');
                    emailChecked = true;
                } else {
                    alert('인증에 실패하였습니다.');
                    emailChecked = false;
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

        document.addEventListener("DOMContentLoaded", function() {
            loadPhoneNumbers();
            });

        function loadPhoneNumbers() {
            fetch('${pageContext.request.contextPath}/selectComcode?codeType=phone')
            .then(response => response.json())
            .then(phoneNumbers => {
                const select = document.querySelector('select[name="userPhone1"]');
                select.innerHTML = '<option value="">선택</option>';

                phoneNumbers.forEach(phone => {
                    const option = document.createElement('option');
                    option.value = phone.codeName;
                    option.textContent = phone.codeName;
                    select.appendChild(option);
                });
            })
            .catch(error => {
                console.error(error);
            });
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
    }
</script>
</body>
</html>