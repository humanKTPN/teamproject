<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- 여기에 대시보드 css 파일옮기기 -->
<!-- <link rel="stylesheet" href="resources/css/layOut_kwak.css" type="text/css"> -->
<link rel="stylesheet" href="resources/css/TestMM_order_park.css"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<!-- <script src="resources/js/layOut_kwak.js"></script> -->
<script src="resources/js/TestMM_order_park.js" defer></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<body>
	<div class="menuPage-con">
		<!-- html 들어갈 곳 -->
		<!-- TestMM_order -->

		<div class="containerMM_order">
			<div class="content">

				<div class="margin">

					<div class="tab-name-con">
						<div class="tab-name">거래처</div>
					</div>

					<div class="select_input_search-btn">

						<form action="searchorder" method="get">

							<select name="type" id="select_MM">
								<option value="all" selected="selected">전체</option>
								<option value="Ccode">거래처코드</option>
								<option value="Cname">회사명</option>
								<option value="TPname">거래품목</option>
								<!-- 								<option value="Morder">주문필요</option> -->
								<!-- 								<option value="Mloc">재고위치</option> -->
							</select> <input type="text" class="select" name="keyword"
								value="${dto.keyword }">
							<!-- <input class="select_day" id="select_MM_eve" type="date" value=""
                                                max="2999-12-31" , min="1970-01-01"> -->
							<!-- 							<input class="select_day" id="select_MM_today" type="date" -->
							<!-- 								value="" max="2999-12-31" , min="1970-01-01">  -->
							<input type="submit" class="submit" value="검색">


						</form>

					</div>

					<%
					// 페이지 파라미터 처리
					int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
					int pageSize = 10;
					int startRow = (currentPage - 1) * pageSize;
					int endRow = startRow + pageSize;

					List<?> fullList = (List<?>) request.getAttribute("companyList");
					int totalCount = fullList != null ? fullList.size() : 0;
					int totalPage = (int) Math.ceil((double) totalCount / pageSize);

					List<?> pagedList = fullList != null ? fullList.subList(Math.min(startRow, totalCount), Math.min(endRow, totalCount))
							: null;

					request.setAttribute("pagedList", pagedList);
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("totalPage", totalPage);
					%>

					<!-- <div class="div_none"></div> -->

					<div>
						<table class="order_table">

							<tr>
								<th scope="col" class="order_th">거래처코드</th>
								<th scope="col" class="order_th">회사</th>
								<th scope="col" class="order_th">담당자</th>
								<th scope="col" class="order_th">연락처</th>
								<th scope="col" class="order_th">거래품목</th>
							</tr>
							<c:if test="${not empty pagedList }">
							<c:forEach var="company" items="${pagedList }">

								<tr>
									<td class="order_td">${company.cstmr_code }</td>
									<td class="order_td">${company.cmp_nm }</td>
									<td class="order_td">${company.mngr_nm }</td>
									<td class="order_td">${company.tel_no }</td>
									<td class="order_td">${company.trn_itm_item_nm }</td>
								</tr>

							</c:forEach>
							</c:if>
							
							<c:if test="${empty pagedList }">
								<tr>
									<td colspan="5">조회 결과가 없습니다</td>
								</tr>
							</c:if>
						</table>

						<div class="div_none">
							<!-- 빈 공간 -->
						</div>

						<div class="div_button">
							<button type="button" id="btn_order_confirm">
								<a class="btn_text_color" href="mainmp">확인</a>
							</button>
						</div>

					</div>

					<div class="page-num-con">
						<div class="page-num">
							<!-- 이전 버튼 -->
							<c:choose>
								<c:when test="${currentPage > 1}">
									<a href="?type=${dto.type }&keyword=${dto.keyword }&page=${currentPage - 1}" class="page pre-page">이전</a>
								</c:when>
								<c:otherwise>
									<span class="page pre-page disabled">이전</span>
								</c:otherwise>
							</c:choose>

							<!-- 페이지 번호 -->
							<c:forEach begin="1" end="${totalPage}" var="i">
								<a href="?type=${dto.type }&keyword=${dto.keyword }&page=${i}"
									class="num <c:if test='${i == currentPage}'>bold</c:if>">${i}</a>
							</c:forEach>

							<!-- 다음 버튼 -->
							<c:choose>
								<c:when test="${currentPage < totalPage}">
									<a href="?type=${dto.type }&keyword=${dto.keyword }&page=${currentPage + 1}" class="page next-page">다음</a>
								</c:when>
								<c:otherwise>
									<span class="page next-page disabled">다음</span>
								</c:otherwise>
							</c:choose>
						</div>
					</div>

				</div>


			</div>

		</div>




	</div>

</body>

</html>