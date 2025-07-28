<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
    <div class="container">
        <h2>로그인</h2>

        <c:if test="${param.error}">
            <div class="error-message">아이디 또는 비밀번호가 일치하지 않습니다.</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/member/login" method="post">
            <div class="form-group">
                <label for="userId">아이디</label>
                <input type="text" class="form-control" id="userId" name="userId" required placeholder="아이디를 입력하세요">
            </div>

            <div class="form-group">
                <label for="userPw">비밀번호</label>
                <input type="password" class="form-control" id="userPw" name="userPw" required placeholder="비밀번호를 입력하세요">
            </div>

            <div class="remember-me">
                <input type="checkbox" id="remember-me" name="remember-me">
                <label for="remember-me">로그인 상태 유지</label>
            </div>

            <div class="links">
                <button type="submit">Login</button>
            </div>
        </form>
    </div>
</body>
</html>