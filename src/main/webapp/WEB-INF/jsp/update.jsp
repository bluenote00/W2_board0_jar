<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
</head>
<body>
<h2>게시글 수정</h2>
<div class="container">
    <form action="${pageContext.request.contextPath}/board/update/${boardDTO.boardType}/${boardDTO.boardNum}" method="post">
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
            <a href="${pageContext.request.contextPath}/board/list" class="btn">List</a>
            <button type="submit">Update</button>
        </div>
    </form>
</div>
</body>
</html>