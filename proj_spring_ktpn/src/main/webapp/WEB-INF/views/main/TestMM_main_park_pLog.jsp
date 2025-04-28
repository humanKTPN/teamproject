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
<link rel="stylesheet" href="resources/css/layOut_kwak.css" type="text/css">
<link rel="stylesheet" href="resources/css/TestMM_main_park.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="resources/js/TestMM_log_park.js" defer></script>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="resources/js/layOut_kwak.js"></script>

<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<body>
	<div class="menuPage-con">
		<!-- html 들어갈 곳 -->
		<!-- TestMM_main -->
		<div class="containerMM">
			<div class="content">

				<div class="margin">

					<div class="tab-name-con">
						<div class="tab-name">재고현황</div>
					</div>

					<!-- 원자재 테이블과 완제품 테이블 구분 -->
					<div class="select_table">
						<div class="select_table1">완제품 로그</div>

<!-- 						<div class="select_table2">완제품</div> -->
					</div>

					<div class="select_input_search-btn">

						<form action="searchplog" method="get">

							<select name="type" id="select_MM">
								<option value="all" selected="selected">전체</option>
								<option value="Pcode">생산코드</option>
								<option value="Fcode">완제품코드</option>
								<option value="Fname">완제품명</option>
								<option value="EA">수량</option>
								<option value="day">변동일</option>
<!-- 								<option value="Morder">주문필요</option> -->
<!-- 								<option value="Mloc">재고위치</option> -->
							</select> <input type="text" class="select" name="keyword" value="${dto.keyword }">
							<!-- <input class="select_day" id="select_MM_eve" type="date" value=""
                                                max="2999-12-31" , min="1970-01-01"> -->
							<input class="select_day" id="select_MM_today" type="date"
								name="Pday" value="" max="2999-12-31" , min="1970-01-01"> <input
								type="submit" class="submit" value="검색">


						</form>

					</div>

					<%
							// 페이지 파라미터 처리
							int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
							int pageSize = 5;
							int startRow = (currentPage - 1) * pageSize;
							int endRow = startRow + pageSize;

							List<?> fullList = (List<?>) request.getAttribute("plogList");
							int totalCount = fullList != null ? fullList.size() : 0;
							int totalPage = (int) Math.ceil((double) totalCount / pageSize);

							List<?> pagedList = fullList != null
									? fullList.subList(Math.min(startRow, totalCount), Math.min(endRow, totalCount))
									: null;

							request.setAttribute("pagedList", pagedList);
							request.setAttribute("currentPage", currentPage);
							request.setAttribute("totalPage", totalPage);
							%>

					<div>
						<div id="show_table1">
							<table class="material-table table_sticky">
								<thead>
									<tr>
										<!-- 													<th scope="col" class="material-th">삭제체크</th> -->
										<th scope="col" class="material-th">번호</th>
										<th scope="col" class="material-th">생산코드</th>
										<th scope="col" class="material-th">완제품코드</th>
										<th scope="col" class="material-th">완제품명</th>
										<th scope="col" class="material-th">변동 수량</th>
										<th scope="col" class="material-th">변동 후 수량</th>
										<th scope="col" class="material-th">입고/출고</th>
										<th scope="col" class="material-th">작업자</th>
										<th scope="col" class="material-th">위치</th>
										<th scope="col" class="material-th">변동 일자</th>
										<th scope="col" class="material-th">입력 일자</th>
										<th scope="col" class="material-th">비고</th>
									</tr>
								</thead>
								<tbody>
								
									<c:if test="${not empty pagedList }">
									<c:forEach var="pLogdata" items="${pagedList }">

										<tr>

											<!-- 															<td><input type="checkbox" name="deleteCheck" -->
											<!-- 																value="Y"></td> -->
											<td id="PSN" class="material-td">${pLogdata.sn }</td>
											<td id="Pcode" class="material-td Mcode">${pLogdata.prod_cd }</td>
											<td id="Pcode" class="material-td Mcode">${pLogdata.fnsh_code }</td>
											<td id="Pname" class="material-td">${pLogdata.fnshd_item_nm }</td>
											<td id="Psntea" class="material-td">${pLogdata.crnt_cnt }</td>
											<td id="Pcurea" class="material-td">${pLogdata.crnt_aftr_cnt }</td>
											<%-- 															<td id="Ploc" class="material-td">${pLogdata.IOB_SE_CD }</td> --%>
											<td id="Ploc" class="material-td"><c:choose>
													<c:when test="${pLogdata.iob_se_cd eq 'i'}">
																		입고
																	</c:when>
													<c:when test="${pLogdata.iob_se_cd ne 'i'}">
																		출고
																	</c:when>
												</c:choose></td>

											<td id="Ploc" class="material-td">${pLogdata.work_nm }</td>
											<td id="Ploc" class="material-td">${pLogdata.fnshl_loc_nm }</td>
											<td id="Ploc" class="material-td">${pLogdata.chng_dt }</td>
											<td id="Ploc" class="material-td">${pLogdata.reg_dttm }</td>
											<td id="Ploc" class="material-td">${pLogdata.rmrk }</td>
										</tr>
									</c:forEach>
									</c:if>
									
									<c:if test="${empty pagedList }">
										<tr>
											<td colspan="12">조회 결과가 없습니다</td>
										</tr>
									</c:if>

								</tbody>

							</table>


						

						<form action="mainmp" method="get">

							<div class="div_button">
								<button type="sumbit" id="btn_main_add" name="" value="">
									확인</button>

							</div>


							<!-- 										<div class="div_button"> -->
							<!-- 											<button type="button" id="btn_main_add"> -->
							<!-- 												<a class="btn_text_color" href="TestMM_main_park.jsp">확인</a> -->
							<!-- 											</button> -->

							<!-- 										</div> -->

						</form>
						
                        </div>
						<!-- 페이지 번호 -->
						
							<div class="page-num-con">
								<div class="page-num">
									<!-- 이전 버튼 -->
									<!-- <c:choose>
										<c:when test="${currentPage > 1}">
											<a href="?page=${currentPage - 1}" class="page pre-page">이전</a>
										</c:when>
										<c:otherwise>
											<span class="page pre-page disabled">이전</span>
										</c:otherwise>
									</c:choose> -->

									<!-- 페이지 번호 -->
									<!-- <c:forEach begin="1" end="${totalPage}" var="i">
										<a href="?page=${i}"
											class="num <c:if test='${i == currentPage}'>bold</c:if>">${i}</a>
									</c:forEach> -->

									<!-- 다음 버튼 -->
									<!-- <c:choose>
										<c:when test="${currentPage < totalPage}">
											<a href="?page=${currentPage + 1}" class="page next-page">다음</a>
										</c:when>
										<c:otherwise>
											<span class="page next-page disabled">다음</span>
										</c:otherwise>
									</c:choose> -->
									
									
									
									<!-- 이전 버튼 -->
									<c:choose>
										<c:when test="${currentPage > 1}">
											<a href="?type=${dto.type }&keyword=${dto.keyword }&Pday=${param.Pday }&page=${currentPage - 1}" class="page pre-page">이전</a>
										</c:when>
										<c:otherwise>
											<span class="page pre-page disabled">이전</span>
										</c:otherwise>
									</c:choose>

									<!-- 페이지 번호 -->
									<c:forEach begin="1" end="${totalPage}" var="i">
										<a href="?type=${dto.type }&keyword=${dto.keyword }&Pday=${param.Pday }&page=${i}"
											class="num <c:if test='${i == currentPage}'>bold</c:if>">${i}</a>
									</c:forEach>

									<!-- 다음 버튼 -->
									<c:choose>
										<c:when test="${currentPage < totalPage}">
											<a href="?type=${dto.type }&keyword=${dto.keyword }&Pday=${param.Pday }&page=${currentPage + 1}" class="page next-page">다음</a>
										</c:when>
										<c:otherwise>
											<span class="page next-page disabled">다음</span>
										</c:otherwise>
									</c:choose>
									
								</div>
							</div>
						
<!-- 						<div class="flex_page"> -->
<!-- 							<div class="item_page pre_page"> -->
<!-- 								<a id="a_before" href=""> < 이전 </a> -->
<!-- 							</div> -->

<!-- 							<div class="item_page"> -->
<!-- 								<a class="num bold" href="">1</a> <a class="num" href="">2</a> <a -->
<!-- 									class="num" href="">3</a> <a class="num" href="">4</a> <a -->
<!-- 									class="num" href="">5</a> -->
<!-- 							</div> -->

<!-- 							<div class="item_page next_page"> -->
<!-- 								<a id="a_after" href=""> 다음 > </a> -->
<!-- 							</div> -->
<!-- 						</div> -->

					</div>
					
				</div>

			</div>
		</div>

	</div>

</body>

</html>