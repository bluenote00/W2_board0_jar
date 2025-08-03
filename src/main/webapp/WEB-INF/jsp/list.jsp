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
        <c:if test="${not empty sessionScope.userId}">
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
                <td><c:out value="${board.boardTypeName}"/></td>
                <td><c:out value="${board.boardNum}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/board/read?&boardNum=${board.boardNum}">
                        <c:out value="${board.boardTitle}"/>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form action="${pageContext.request.contextPath}/" method="get">
            <div class="board-type">
                <input type="radio" name="boardType" value="" id="type-all"
                       <c:if test="${empty selectedType}">checked</c:if>>
                <label for="type-${menu.codeId}">전체</label>

                <c:forEach var="menu" items="${menuCode}">
                    <input type="radio" name="boardType" value="${menu.codeId}"
                           id="type-${menu.codeId}"
                    <c:if test="${selectedType == menu.codeId}">checked</c:if>>
                    <label for="type-${menu.codeId}">${menu.codeName}</label>
                </c:forEach>
            </div>
            <input type="hidden" name="pageNum" value="${currentPage}">
            <input type="hidden" name="size" value="${pageSize}">
            <button type="submit" value="${menu.codeId}">조회</button>
    </form>


    <div class="pagination">
        <ul>
            <li class="${currentPage == 1 ? 'disabled' : ''}">
                <c:if test="${currentPage > 1}">
                    <a href="?pageNum=${currentPage - 1}&size=${pageSize}&boardType=${selectedType}">이전</a>
                </c:if>
            </li>

            <c:forEach var="i" begin="1" end="${totalPages}">
                <li class="${i == currentPage ? 'active' : ''}">
                    <a href="?pageNum=${i}&size=${pageSize}&boardType=${selectedType}">${i}</a>
                </li>
            </c:forEach>

            <li class="${currentPage == totalPages ? 'disabled' : ''}">
                <c:if test="${currentPage < totalPages}">
                    <a href="?pageNum=${currentPage + 1}&size=${pageSize}&boardType=${selectedType}">다음</a>
                </c:if>
            </li>
        </ul>
    </div>


    <div class="button-group">
        <c:if test="${not empty sessionScope.userId}">
            <a href="${pageContext.request.contextPath}/board/register" class="write-btn">글쓰기</a>
        </c:if>
    </div>
</div>


<script>
    document.addEventListener("DOMContentLoaded", function() {
        loadBoardType();
    });

    function loadBoardType() {
        fetch('${pageContext.request.contextPath}/selectComcode?codeType=menu')
            .then(response => response.json())
            .then(boardType => {
                const container = document.querySelector('.board-type');

                boardType.forEach(menu => {
                    const input = document.createElement('input');
                    input.type = 'radio';
                    input.name = 'boardType';
                    input.value = menu.codeId;
                    input.id = `${menu.codeId}`;

                    const label = document.createElement('label');
                    label.setAttribute('for', `type-${menu.codeId}`);
                    label.textContent = menu.codeName;

                    container.appendChild(input);
                    container.appendChild(label);
                });
            })
            .catch(error => {
                console.error(error);
            });
    }

</script>
</body>
</html>