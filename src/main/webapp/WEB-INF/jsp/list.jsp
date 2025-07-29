<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            border: 1px solid #ddd;
        }
        .type-cell {
            width: 80px;
        }
        .no-cell {
            width: 60px;
        }
        .title-cell {
            width: auto;
        }
        .pagination {
            margin-top: 20px;
        }
        .board-type {
            margin-bottom: 10px;
        }
        .pagination {
            display: flex;
            justify-content: center;
            margin: 20px 0;
        }
        .pagination ul {
            display: flex;
            list-style: none;
            padding: 0;
        }
        .pagination li {
            margin: 0 5px;
        }
        .pagination li.active a {
            background-color: #007bff;
            color: white;
        }
        .pagination li a {
            padding: 5px 10px;
            text-decoration: none;
            border: 1px solid #ddd;
            border-radius: 3px;
        }
        .pagination li.disabled a {
            color: #ccc;
            pointer-events: none;
        }
        .button-group {
            float: right;
        }
    </style>
    <title>게시판 목록</title>

</head>
<body>
<div class="container">
    <div class="header">
        <c:if test="${empty sessionScope.user}">
            <a href="${pageContext.request.contextPath}/member/login">Login</a>
            <a href="${pageContext.request.contextPath}/member/moveJoin">Join</a>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <a href="${pageContext.request.contextPath}/member/logout">Logout</a>
        </c:if>
    </div>
    <span style="float: right;">total: ${totalElements}</span>
    <table>
        <thead>
        <tr>
            <th class="type-cell">Type</th>
            <th class="no-cell">No</th>
            <th class="title-cell">Title</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="board" items="${boardList}">
            <tr>
                <td><c:out value="${board.boardType}"/></td>
                <td><c:out value="${board.boardNum}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/board/read?boardType=${board.boardType}&boardNum=${board.boardNum}">
                        <c:out value="${board.boardTitle}"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<%--    <form action="${pageContext.request.contextPath}/board/list" method="get">--%>
<%--        <div class="board-type">--%>
<%--            <c:forEach var="menu" items="${menuCode}">--%>
<%--                <input type="radio" name="type" value="${menu.codeId}"--%>
<%--                       id="type-${menu.codeId}" <c:if test="${selectedType == menu.codeId}">checked</c:if>>--%>
<%--                <label for="type-${menu.codeId}">${menu.codeName}</label>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
<%--        <input type="hidden" name="page" value="${boardList.number}">--%>
<%--        <input type="hidden" name="size" value="${boardList.size}">--%>
<%--        <button type="submit">조회</button>--%>
<%--    </form>--%>

<%--    <div class="pagination">--%>
<%--        <ul>--%>
<%--            <li class="${boardList.first ? 'disabled' : ''}">--%>
<%--                <c:if test="${!boardList.first}">--%>
<%--                    <a href="${pageContext.request.contextPath}/board/list?page=${boardList.number -1}&size=${boardList.size}&type=${param.type}">이전</a>--%>
<%--                </c:if>--%>
<%--            </li>--%>

<%--            <c:forEach var="pageNum" begin="0" end="${boardList.totalPages - 1}">--%>
<%--                <li class="${pageNum == boardList.number ? 'active' : ''}">--%>
<%--                    <a href="${pageContext.request.contextPath}/board/list?page=${pageNum}&size=${boardList.size}&type=${param.type}">--%>
<%--                        ${pageNum + 1}--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--            </c:forEach>--%>

<%--            <li class="${boardList.last ? 'disabled' : ''}">--%>
<%--                <c:if test="${!boardList.last}">--%>
<%--                    <a href="${pageContext.request.contextPath}/board/list?page=${boardList.number + 1}&size=${boardList.size}&type=${param.type}">다음</a>--%>
<%--                </c:if>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>

    <div class="button-group">
        <a href="${pageContext.request.contextPath}/board/register" class="write-btn">글쓰기</a>
    </div>
</div>
</body>
</html>