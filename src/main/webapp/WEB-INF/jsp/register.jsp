<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
</head>
<body>
<div class="container">
    <h2>게시글 작성</h2>
    <form action="${pageContext.request.contextPath}/board/register" method="post">

        <label for="Type">게시글 타입</label>
        <select id="Type" name="boardType" required>
            <option value="" disabled selected>게시글 타입 선택</option>
            <c:forEach var="menu" items="${comCodes}">
                <option value="${menu.codeName}" <c:if test="${menu.codeName == boardDTO.boardType}">selected</c:if>>
                    ${menu.codeName}
                </option>
            </c:forEach>
        </select>

        <div class="form-group">
            <label>Title</label>
            <input type="text" name="boardTitle" value="${boardDTO.boardTitle}">
        </div>

        <div class="form-group">
            <label>Comment</label>
            <textarea name="boardComment">${boardDTO.boardComment}</textarea>
        </div>

        <div class="form-group">
            <label>Writer</label>
            <input type="text" value="${boardDTO.creator}" readonly>
        </div>

        <div class="btn-group">
            <button type="submit">작성</button>
            <a style="float: right;" href="${pageContext.request.contextPath}/board/list" class="btn">List</a>
        </div>
    </form>
</div>
</body>
</html>