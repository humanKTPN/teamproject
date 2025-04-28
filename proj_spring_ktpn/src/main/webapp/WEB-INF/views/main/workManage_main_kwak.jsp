<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
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
    <title>작업지시서 조회</title>
    <link rel="stylesheet" href="resources/css/workManage_main_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/workManage_main_kwak.js"></script>
</head>
<body>
<div class="menuPage-con">
    <div class="background">
        <div class="content-con">

            <div class="tab-name-div">
                <div class="tab-name">작업지시서 조회</div>
            </div>

            <div class="dropBox">
                <form method="get" action="pr">
                    <select name="categories" id="cate">
                        <option value="전체" <c:if test="${param.categories == '전체'}">selected</c:if>>전체</option>
                        <option value="품목코드" <c:if test="${param.categories == '품목코드'}">selected</c:if>>품목코드</option>
                        <option value="담당자명" <c:if test="${param.categories == '담당자명'}">selected</c:if>>담당자명</option>
                        <option value="호기코드" <c:if test="${param.categories == '호기코드'}">selected</c:if>>호기코드</option>
                        <option value="작업일자" <c:if test="${param.categories == '작업일자'}">selected</c:if>>작업일자</option>
                    </select>
                    <input type="text" class="select" name="key" value="${param.key}" />
<!--                     <input type="hidden" name="ss" value="ss" /> -->
                    <input type="submit" class="submit" value="검색" />
                    <input type="date" name="str_dt" ></input>
                    ~
                    <input type="date" name="end_dt"/>
                </form>
            </div>

            <div class="command-loc">
                <div class="command-div">
                    <table class="command-table">
                        <tr>
                            <th class="command-th">생산코드</th>
                            <th class="command-th">생산일정코드</th>
                            <th class="command-th">라인호기코드</th>
                            <th class="command-th">라인호기명</th>
                            <th class="command-th">품목코드</th>
                            <th class="command-th">담당자명</th>
                            <th class="command-th">작업일자</th>
                            <th class="command-th">지시수량</th>
                        </tr>

                        <!-- 검색 결과 리스트 출력 -->
                        <c:choose>
                            <c:when test="${not empty pagedList}">
                                <c:forEach var="dt" items="${pagedList}">
                                    <tr>
                                        <td class="command-td"><a href="prDetail?prod_cd=${dt.prod_cd}">${dt.prod_cd}</a></td>
                                        <td class="command-td">${dt.prod_pln_cd}</td>
                                        <td class="command-td">${dt.liun_cd}</td>
                                        <td class="command-td">${dt.liun_nm}</td>
                                        <td class="command-td">${dt.item_cd}</td>
                                        <td class="command-td">${dt.mngr_nm}</td>
                                        <td class="command-td">${dt.prod_dt}</td>
                                        <td class="command-td">${dt.indc_qntt}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="8" style="text-align:center;">조회 결과가 없습니다.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </table>
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
</div>
</body>
</html>