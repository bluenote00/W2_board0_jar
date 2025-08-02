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
    </style>
    <title>게시글 작성</title>

</head>
<body>
<div class="container">
    <h2>게시글 작성</h2>
    <form action="${pageContext.request.contextPath}/board/boardwrite" method="post">
        <input type="hidden" id="userId" name="userId" value ="${userId}"/>
        <input type="hidden" id="creator" name="creator" value ="${creator}"/>
        <input type="hidden" id="userName" name="userName" value ="${userName}"/>


        <label for="Type">게시글 타입</label>

        <select id="Type" name="boardType">
            <option value="">게시글 타입 선택</option>
        </select>

        <div class="form-group">
            <label>Title</label>
            <input type="text" name="boardTitle" value="${boardDto.boardTitle}">
        </div>

        <div class="form-group">
            <label>Comment</label>
            <textarea name="boardComment" value="${boardDto.boardComment}"></textarea>
        </div>

        <div class="form-group">
            <label>파일 업로드</label>
            <input type="file" name="uploadFile" value="${boardDto.boardFile}">
        </div>

        <div class="form-group">
            <label>Writer</label>
            <input type="text" value="${sessionScope.creator}" readonly>
        </div>

        <div class="btn-group">
            <button type="submit">작성</button>
            <a style="float: right;" href="${pageContext.request.contextPath}/" class="btn">List</a>
        </div>
    </form>
</div>

<script>

    document.addEventListener("DOMContentLoaded", function() {
        loadBoardType();
    });

    function loadBoardType() {
        fetch('${pageContext.request.contextPath}/selectComcode?codeType=menu')
            .then(response => response.json())
            .then(boardType => {
                const select = document.querySelector('select[name="boardType"]');
                select.innerHTML = '<option value="">게시글 타입 선택</option>';

                boardType.forEach(menu => {
                    const option = document.createElement('option');
                    option.value = menu.codeId;
                    option.textContent = menu.codeName;
                    select.appendChild(option);
                });
            })
            .catch(error => {
                console.error(error);
            });
    }
</script>
</body>
</html>