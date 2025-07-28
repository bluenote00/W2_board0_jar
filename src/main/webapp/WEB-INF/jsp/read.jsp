<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세</title>
</head>
<body>
<div class="container">
    <div class="view-group">
        <span class="label">Title:</span>
        <div class="content"><c:out value="${boardDTO.boardTitle}"/></div>
    </div>
    <div class="view-group">
        <span class="label">Comment:</span>
        <div class="content"><c:out value="${boardDTO.boardComment}"/></div>
    </div>
    <div class="view-group">
        <span class="label">Writer:</span>
        <div class="content"><c:out value="${boardDTO.creator}"/></div>
    </div>
    <div class="btn-group">
        <a href="${pageContext.request.contextPath}/board/list" class="btn">List</a>
        <a href="${pageContext.request.contextPath}/board/update/${boardDTO.boardType}/${boardDTO.boardNum}" class="btn">Update</a>
    </div>
</div>
</body>
</html>