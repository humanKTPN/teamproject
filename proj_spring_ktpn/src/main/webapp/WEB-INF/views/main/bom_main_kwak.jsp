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
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="resources/css/bom_main_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/bom_main_kwak.js"></script>    
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
                <div class="tab-con">
                    <div class = "tab-name-div">
                        <div class="tab-name">기준관리</div>
                    </div>
                    <div class = "tab-name-div">
                        <div class="tab-name switch-color">BOM</div>
                    </div>
                    <div class = "tab-name-div">
                        <div class="tab-name">공정</div>
                    </div>
                </div>
            <div class="dropBox">
            <form action="bm" method="get">
                <select name="categories" id="cate">
<%--                 	<option value="" <c:if test="${empty param.categories}">selected</c:if>> --%>
                    <option value="전체" <c:if test="${param.categories == '전체'}">selected</c:if>>전체</option>
                    <option value="코드" <c:if test="${param.categories == '코드'}">selected</c:if>>코드</option>
                    <option value="BOM명" <c:if test="${param.categories == 'BOM명'}">selected</c:if>>BOM명</option>
                </select>
                <input type="select" class="sel" name="key" value="<c:out value='${param.key}'/>">
                <input type="submit" class="search" value="검색">
                </form>
            </div>
            
            <div class="command-loc">
                <div class="command-div">
                    <table class="command-table">
                        <tr>
                            <th class="command-th" scope = "col">번호</th>
                            <th class="command-th" scope = "col">BOM코드</th>
                            <th class="command-th" scope = "col">BOM명</th>
                            <th class="command-th" scope = "col">품목코드</th>
                        </tr>
                             <c:forEach var="user" items="${pagedList}" varStatus="status">
                                            <tr>
                                                <td class="command-td">${(currentPage - 1) * 10 + status.index + 1}</td>
                                                <td class="command-td">${user.bom_cd}</td>
                                                <td class="command-td">
                                                    <a href="bmDetail?bom_cd=${user.bom_cd}">
                                                        ${user.bom_nm}
                                                    </a>
                                                </td>
                                                <td class="command-td">${user.item_cd}</td>
                                            </tr>
                             </c:forEach>
                        <tr>
<!--                             <td class="command-td">i</td> -->
<%--                             <td class="command-td">${list.bom_cd}</td> --%>
<%--                             <td class="command-td"><a href="bom_select_kwak.jsp?bom_cd=<%=dt.getBom_cd() %>"><%=dt.getBom_nm() %></a></td> --%>
<%--                             <td class="command-td"><%=dt.getItem_cd() %></td> --%>
	                        </tr>
	                    </table>
	                </div>
	            </div>
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
			
			    <div class="add-con">
			        <div class="add">추가</div>
			    </div>
			</div>   
        </div>
    </div>
    </div>
    
</body>
</html>