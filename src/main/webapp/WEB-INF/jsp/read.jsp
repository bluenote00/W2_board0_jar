<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        .view-group { margin-bottom: 15px; border-bottom: 1px solid #ddd; }
        .label { font-weight: bold; }
        .content { margin: 10px 0; }
        .btn-group { margin-top: 20px; float: right;}

        #nextBoard{
            border-top: 1px solid #dbdbdb;
            border-bottom: 1px solid #dbdbdb;
            width: 100%;
        }

        #nextBoard tr{
            height: 60px;
        }

        #nextBoard td:nth-child(1){
            width: 120px;
            font-size: 14px;
            line-height: 1.07;
            text-align: center;
            color: #767676;
        }

        #nextBoard td:nth-child(2){
            width: 880px;
            font-size: 16px;
            padding: 17px 98px 17px 32px;
        }
    </style>
    <title>게시글 상세</title>

</head>
<body>
<div class="container">
    <c:forEach var="boardDto" items="${boardDetail}">
        <div class="view-group">
            <span class="label">Title:</span>
            <div class="content"><c:out value="${boardDto.boardTitle}"/></div>
        </div>
        <div class="view-group">
            <span class="label">Comment:</span>
            <div class="content"><c:out value="${boardDto.boardComment}"/></div>
        </div>
        <div class="view-group">
            <span class="label">Writer:</span>
            <div class="content"><c:out value="${boardDto.creator}"/></div>
        </div>

        <div>
            <c:forEach var="listLevel" items="${sequenceList}">
                <table id="nextBoard">
                    <tr style="border-top: 1px solid #dbdbdb;">
                        <td>다음</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/board/read?boardType=${boardDto.boardType}&boardNum=${listLevel.NEXT_NUM}">${listLevel.NEXT_TITLE}</a>
                            <c:if test="${empty listLevel.NEXT_TITLE}">
                                다음글이 없습니다.
                            </c:if>
                        </td>
                    </tr>

                    <tr>
                        <td>이전</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/board/read?boardType=${boardDto.boardType}&boardNum=${listLevel.PREV_NUM}">${listLevel.PREV_TITLE}</a>
                            <c:if test="${empty listLevel.PREV_TITLE}">
                               이전글이 없습니다.
                            </c:if>
                        </td>
                    </tr>
                </table>
            </c:forEach>
        </div>

        <div class="btn-group">
            <a href="${pageContext.request.contextPath}/" class="btn">List</a>

            <c:if test="${not empty sessionScope.userId && sessionScope.creator == boardDto.creator}">
                <a href="${pageContext.request.contextPath}/board/update/${boardDto.boardType}/${boardDto.boardNum}" class="btn">수정</a>
                <a href="${pageContext.request.contextPath}/board/delete?boardNum=${boardDto.boardNum}" class="btn">삭제</a>
            </c:if>
        </div>
    </c:forEach>
</div>

<script>
    let backCount = 0; // 뒤로가기 횟수

    window.addEventListener('popstate', function(event) {
        if (backCount < 1) {
            backCount++;
        } else {
            event.preventDefault();
            goBack("${pageContext.request.contextPath}/")
        }
    });

    // 뒤로가기 버튼 클릭 시
    function goBack() {
        if (backCount < 1) {
            window.history.back();
        } else {
            goBack("${pageContext.request.contextPath}/")
        }
    }

</script>
</body>
</html>