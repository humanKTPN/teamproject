<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>      
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    // 페이지 파라미터 처리
    int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
    int pageSize = 10;
    int startRow = (currentPage - 1) * pageSize;
    int endRow = startRow + pageSize;

    List<?> fullList = (List<?>) request.getAttribute("list");
    int totalCount = fullList != null ? fullList.size() : 0;
    int totalPage = (int) Math.ceil((double) totalCount / pageSize);

    List<?> pagedList = fullList != null ? fullList.subList(Math.min(startRow, totalCount), Math.min(endRow, totalCount)) : null;

    request.setAttribute("pagedList", pagedList);
    request.setAttribute("currentPage", currentPage);
    request.setAttribute("totalPage", totalPage);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공정 목록</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="resources/css/processDesc_main.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/processDesc_main.js"></script>
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>
<body>
    <div class="menuPage-con">
        <div class="background">
            <div class="margin">
                <!-- 탭 -->
                <div class="tab-con">
                    <div class="tab-name-div"><div class="tab-name">기준관리</div></div>
                    <div class="tab-name-div"><div class="tab-name">BOM</div></div>
                    <div class="tab-name-div"><div class="tab-name switch-color">공정</div></div>
                </div>
                <!-- 검색 -->
                <div class="dropBox">
                    <form action="rt" method="get">
                        <select name="categories" id="cate">
                            <option value="전체" <c:if test="${param.categories == '전체'}">selected</c:if>>전체</option>
                            <option value="공정코드" <c:if test="${param.categories == '공정코드'}">selected</c:if>>공정코드</option>
                            <option value="품목코드" <c:if test="${param.categories == '품목코드'}">selected</c:if>>품목코드</option>
                            <option value="공정명" <c:if test="${param.categories == '공정명'}">selected</c:if>>공정명</option>
                        </select>
                        <input type="text" class="sel" name="key" value="${param.key}">
                        <input type="submit" class="search" value="검색">
                    </form>
                </div>
                <!-- 테이블 -->
                <div class="command-loc">
                    <div class="command-div">
                        <table class="command-table">
                            <thead>
                                <tr>
                                    <th class="command-th">번호</th>
                                    <th class="command-th">공정코드</th>
                                    <th class="command-th">공정명</th>
                                    <th class="command-th">품목코드</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dt" items="${list}" varStatus="status">
                                    <tr>
                                        <td class="command-td">${status.count}</td>
                                        <td class="command-td">${dt.rt_cd}</td>
                                        <td class="command-td">
                                            <a href="rtDetail?rt_cd=${dt.rt_cd}">
                                                ${dt.rt_nm}
                                            </a>
                                        </td>
                                        <td class="command-td">${dt.item_cd}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- 페이징 & 추가 버튼 -->
 			<div class="page-num-con">
			   <div class="page-num">
			       <!-- 이전 버튼 -->
			       <c:choose>
			           <c:when test="${currentPage > 1}">
			               <a href="?page=${currentPage - 1}" class="page pre-page">이전</a>
			           </c:when>
			           <c:otherwise>
			               <span class="page pre-page disabled">이전</span>
			           </c:otherwise>
			       </c:choose>
			
			       <!-- 페이지 번호 -->
			       <c:forEach begin="1" end="${totalPage}" var="i">
			           <a href="?page=${i}" class="num <c:if test='${i == currentPage}'>bold</c:if>">${i}</a>
			       </c:forEach>
			
			       <!-- 다음 버튼 -->
			       <c:choose>
			           <c:when test="${currentPage < totalPage}">
			               <a href="?page=${currentPage + 1}" class="page next-page">다음</a>
			           </c:when>
			           <c:otherwise>
			               <span class="page next-page disabled">다음</span>
			           </c:otherwise>
			       </c:choose>
			    </div>
            </div>
            <div class="add-con">
                <div class="add">
                    추가
                </div>
            </div> 
        </div>
    </div>
</body>
</html>
