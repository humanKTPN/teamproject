<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MD Detail</title>
</head>
<body>
    <h1>MD Detail List</h1>
    <!-- list가 존재하는지 확인합니다 -->
    <c:choose>
        <c:when test="${not empty list}">
            <table border="1" cellspacing="0" cellpadding="5">
                <thead>
                    <tr>
                        <th>MT_MNG_CD</th>
                        <th>MT_MNG_NM</th>
                        <!-- 필요한 컬럼을 추가하세요 -->
                    </tr>
                </thead>
                <tbody>
                    <!-- 리스트의 각 항목을 출력 -->
                    <c:forEach var="item" items="${list}">
                        <tr>
                            <td>${item.MT_MNG_CD}</td>
                            <td>${item.MT_MNG_NM}</td>
                            <!-- 다른 항목들도 필요시 출력 -->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>조회된 데이터가 없습니다.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
