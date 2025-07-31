<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"], textarea { width: 100%; padding: 8px; }
        textarea { min-height: 200px; }
        .btn-group { margin-top: 20px; float: right;}
    </style>
    <title>게시글 수정</title>
</head>
<body>
<h2>게시글 수정</h2>
<div class="container">
    <c:forEach var="boardDto" items="${boardDetail}">
        <form action="${pageContext.request.contextPath}/board/BoardModify" method="post">
            <div class="form-group">
                <input type="hidden" name="boardType" value="${boardDto.boardType}">
                <input type="hidden" name="boardNum" value="${boardDto.boardNum}">

                <label>Title</label>
                <input type="text" name="boardTitle" value="${boardDto.boardTitle}">
            </div>

            <div class="form-group">
                <label>Comment</label>
                <textarea name="boardComment">${boardDto.boardComment}</textarea>
            </div>

            <div class="form-group">
                <label>Writer</label>
                <input type="text" value="${boardDto.creator}" readonly>
            </div>

            <div class="btn-group">
                <a href="${pageContext.request.contextPath}/" class="btn">List</a>
                <button type="submit">Update</button>
            </div>
        </form>
    </c:forEach>
</div>
</body>
</html>