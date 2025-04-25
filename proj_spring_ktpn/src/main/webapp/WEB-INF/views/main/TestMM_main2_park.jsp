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
<link rel="stylesheet" href="resources/css/layOut_kwak.css"
	type="text/css">
<link rel="stylesheet" href="resources/css/TestMM_main_park.css"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="resources/js/TestMM_main_park.js" defer></script>
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
						<div class="select_table1">원자재</div>

						<div class="select_table2">완제품</div>
					</div>

					<div class="select_input_search-btn">

						<form action="searchList" method="get">

							<select name="type" id="select_MM">
								<option value="all" selected="selected">전체</option>
								<option value="Mcode">원자재코드</option>
								<option value="Mname">원자재명</option>
								<option value="Fcode">완제품코드</option>
								<option value="Fname">완제품명</option>
								<option value="EA">수량</option>
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

						<div class="div_form_order">
							<form method="get" action="order">
								<input type="hidden" name="command" value="order">
								<!-- 											<input type="submit" value="거래처"> -->


								<button type="submit" class="btn_main_order btn_text_color">
									거래처
									<!-- 												<a class="btn_text_color" href="./TestMM_order_park.jsp">거래처</a> -->
								</button>
							</form>
						</div>

						<div class="div_form_order">
							<form method="get" action="mlog">
								<!-- 											<input type="hidden" name="command" value="mLog">  -->
								<!-- 											<input type="submit" value="거래처"> -->


								<button name="command" value="mLog" type="submit"
									class="btn_main_order btn_text_color">원자재로그</button>
							</form>
						</div>

						<div class="div_form_order">
							<form method="get" action="plog">
								<input type="hidden" name="command" value="pLog">
								<!-- 											<input type="submit" value="거래처"> -->


								<button type="submit" class="btn_main_order btn_text_color">
									완제품로그</button>
							</form>
						</div>

					</div>

					<!-- 추후 추가 할 내용 
                                         원자재 테이블, 완제품 테이블을 만들어서
                                         메뉴에서 원자재, 완제품 버튼을 누르면 해당하는 테이블이 화면에 출력
                                         ex) 원자재(기본화면, 강조 표시)   완제품
                                             자재코드   자재명   수량 ... ... ...
                                             AA-dd-01 염화비닐  1000 ... ...

                                             원자재            완제품(클릭, 강조 표시)
                                             품목코드     품목명     수량 ... ... ... 
                                             aa-dd-cc   싹싹지우개   1000 ... ...  
                                    -->

					
					<%
							// 페이지 파라미터 처리
							int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
							int pageSize = 10;
							int startRow = (currentPage - 1) * pageSize;
							int endRow = startRow + pageSize;

							List<?> fullList = (List<?>) request.getAttribute("MtableSelect");
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
						<!-- 					<form method="post" action="undom"> -->
						<div id="show_table1">
							<table class="material-table">
								<thead>
									<tr>
										<th scope="col"
											style="border: 1px solid darkgrey; background-color: #2f373a; color: white;">✅</th>
										<th scope="col" class="material-th">원자재코드</th>
										<th scope="col" class="material-th">원자재명</th>
										<th scope="col" class="material-th">기준 수량</th>
										<th scope="col" class="material-th">현재 수량</th>
										<th scope="col" class="material-th">주문필요</th>
										<th scope="col" class="material-th">위치</th>
										<th scope="col" class="material-th">수정</th>

									</tr>
								</thead>
								<tbody>
								
									<c:if test="${not empty pagedList }">
									<c:forEach var="Mdata" items="${pagedList }">

										<tr>

											<td style="border: 1px solid darkgrey;"><input
												class="checkboxx" type="radio" name="undoCheck"
												value="${Mdata.mtrl_cd }"></td>

											<td id="Mcode" class="material-td Mcode"><input
												type="hidden" name="code" value="${Mdata.mtrl_cd }">
												${Mdata.mtrl_cd }</td>

											<td id="Mname" class="material-td"><input type="hidden"
												name="name" value="${Mdata.mtrl_nm }">
												${Mdata.mtrl_nm }</td>

											<td id="Msntea" class="material-td"><input type="hidden"
												name="sntea" value="${Mdata.stn_cnt }">
												${Mdata.stn_cnt }</td>

											<td id="Mcurea" class="material-td"><input type="hidden"
												name="ea" value="${Mdata.crnt_aftr_cnt }">
												${Mdata.crnt_aftr_cnt }</td>

											<td id="Morder" class="material-td"><input type="hidden"
												name="order" value="${Mdata.ordr_rqrd_yn }">
												${Mdata.ordr_rqrd_yn }</td>

											<td id="Mloc" class="material-td"><input type="hidden"
												name="loc" value="${Mdata.mtrl_loc_nm }">
												${Mdata.mtrl_loc_nm }</td>

											<td id="Mbutton" class="material-td">
												<!-- 																<input type="hidden" name="command" value="update">  -->
												<!-- 																<input type="submit" value="수정"> --> <!-- 																<button type="button" class="btn_main_update"> -->
												<!-- 																	<a class="btn_text_color" --> <!-- 																		href="./TestMM_update_park.jsp">수정</a> -->
												<!-- 																</button> -->

												<form action="updatem1" method="get">
													<button name="mcode" value="${Mdata.mtrl_cd }"
														type="submit" class="btn_main_update">수정</button>
												</form>
											</td>
											
										</tr>
									</c:forEach>
									</c:if>
									
									<c:if test="${empty pagedList }">
										<tr>
											<td colspan="8">조회 결과가 없습니다</td>
										</tr>
									</c:if>

								</tbody>

							</table>

							<div class="div_none">
								<!-- 빈 공간 -->
							</div>

							<div class="div_form_order">

								<input type="hidden" name="command" value="undo">
								<!-- 											<input type="submit" value="거래처"> -->


								<button id="btn_undom" type="button"
									class="btn_main_order btn_text_color">입력취소(undo)</button>

							</div>


							<div class="div_button">
								<!-- 								<form method="post" action="imcon"> -->
								<a href="addm1">
									<button class="btn_main_order" name="command" value="move_add2_Page" type="button"
										id="btn_main_addm">원자재 추가</button>
								</a>
								<!-- 								</form> -->

								<!-- 									<a href="updatem1"> -->
								<!-- 									<button name="command" value="move_update2_Page" type="button" -->
								<!-- 										id="btn_main_updatem">원자재 수정</button> -->
								<!-- 									</a> -->


								<!-- 								<form method="post" action="impcon"> -->
								<!-- 									<button name="command" value="move_addP2_Page" type="submit" -->
								<!-- 										id="btn_main_add">완제품 재고 추가</button> -->
								<!-- 								</form> -->



								<!-- 										<button type="button" id="btn_main_add"> -->
								<!-- 											<a class="btn_text_color" href="TestMM_add_park.jsp">추가</a> -->
								<!-- 										</button> -->

								<!-- 										<button type="button" id="btn_main_delete"> -->

								<!-- 											<a class="btn_text_color" href="TestMM_delete_park.jsp">삭제</a> -->
								<!-- 										</button> -->

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
						<!-- 					</form> -->

						
						<%
							// 페이지 파라미터 처리
							int currentPage1 = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
							int pageSize1 = 10;
							int startRow1 = (currentPage1 - 1) * pageSize1;
							int endRow1 = startRow1 + pageSize1;

							List<?> fullList1 = (List<?>) request.getAttribute("PtableSelect");
							int totalCount1 = fullList1 != null ? fullList1.size() : 0;
							int totalPage1 = (int) Math.ceil((double) totalCount1 / pageSize1);

							List<?> pagedList1 = fullList1 != null
									? fullList1.subList(Math.min(startRow1, totalCount1), Math.min(endRow1, totalCount1))
									: null;

							request.setAttribute("pagedList1", pagedList1);
							request.setAttribute("currentPage1", currentPage1);
							request.setAttribute("totalPage1", totalPage1);
							%>

						<!-- 					<form method="post" action="undop"> -->
						<div id="show_table2" class="hide">
							<table class="material-table product-table">
								<thead>
									<tr>
										<th scope="col"
											style="border: 1px solid darkgrey; background-color: #2f373a; color: white;">✅</th>
										<th scope="col" class="material-th product-th">완제품코드</th>
										<th scope="col" class="material-th product-th">완제품명</th>
										<th scope="col" class="material-th product-th">수량</th>
										<th scope="col" class="material-th product-th">재고위치</th>
										<th scope="col" class="material-th product-th">수정</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${not empty pagedList1 }">

									<c:forEach var="Pdata" items="${pagedList1 }">

										<tr>



											<td style="border: 1px solid darkgrey"><input
												class="checkboxx" type="radio" name="undoCheck"
												value="${Pdata.fnsh_code }"></td>

											<td id="Pcode" class="material-td Mcode product-td"><input
												type="hidden" name="code" value="${Pdata.fnsh_code }">
												${Pdata.fnsh_code }</td>

											<td id="Pname" class="material-td product-td"><input
												type="hidden" name="code" value="${Pdata.fnsh_nm }">
												${Pdata.fnsh_nm }</td>

											<td id="Pcurea" class="material-td product-td"><input
												type="hidden" name="code" value="${Pdata.crnt_aftr_cnt }">
												${Pdata.crnt_aftr_cnt }</td>

											<td id="Ploc" class="material-td product-td"><input
												type="hidden" name="code" value="${Pdata.fnsh_loc_nm }">
												${Pdata.fnsh_loc_nm }</td>

											<td id="Mbutton" class="material-td product-td">
												<!-- 													<input type="hidden" name="command" value="move_updateP_Page"> -->
												<!-- 													<input type="submit" value="수정">  -->

												<form action="updatep1" method="get">
													<button class="btn_main_update" type="submit" name="fcode"
														value="${Pdata.fnsh_code }">수정</button>
												</form> <!-- 															<button type="button" class="btn_main_update"> -->
												<!-- 																<a class="btn_text_color" --> <!-- 																	href="./TestMM_update_park.jsp">수정</a> -->
												<!-- 															</button> -->
											</td>


										</tr>
									</c:forEach>
									</c:if>
									
									<c:if test="${empty pagedList1 }">
										<tr>
											<td colspan="6">조회 결과가 없습니다</td>
										</tr>
									</c:if>

								</tbody>

							</table>

							<div class="div_none">
								<!-- 빈 공간 -->
							</div>

							<div class="div_form_order">

								<!-- 								<form method="post" action="impcon"> -->
								<input type="hidden" name="command" value="undo">
								<!-- 												<input type="submit" value="거래처"> -->


								<button id="btn_undop" type="button"
									class="btn_main_order btn_text_color">입력취소(undo)</button>
								<!-- 								</form> -->
							</div>


							<div class="div_button">

								<!-- 								<form method="post" action="impcon"> -->
								<a href="addp1">
									<button class="btn_main_order" name="command" value="move_addP_Page" type="button"
										id="btn_main_addp">완제품 추가</button>
								</a>
								<!-- 								</form> -->

								<!-- 									<button name="command" value="move_updateP_Page" type="button" -->
								<!-- 										id="btn_main_updatep">완제품 수정</button> -->

								<!-- 										<button type="button" id="btn_main_add"> -->
								<!-- 											<a class="btn_text_color" href="TestMM_add_park.jsp">추가</a> -->
								<!-- 										</button> -->

								<!-- 										<button type="button" id="btn_main_delete"> -->

								<!-- 											<a class="btn_text_color" href="TestMM_delete_park.jsp">삭제</a> -->
								<!-- 										</button> -->

							</div>

							

							<div class="page-num-con">
								<div class="page-num">
									<!-- 이전 버튼 -->
									<!--<c:choose>
										<c:when test="${currentPage1 > 1}">
											<a href="?page=${currentPage1 - 1}" class="page pre-page">이전</a>
										</c:when>
										<c:otherwise>
											<span class="page pre-page disabled">이전</span>
										</c:otherwise>
									</c:choose> -->

									<!-- 페이지 번호 -->
									<!-- <c:forEach begin="1" end="${totalPage1}" var="i">
										<a href="?page=${i}"
											class="num <c:if test='${i == currentPage1}'>bold</c:if>">${i}</a>
									</c:forEach> -->

									<!-- 다음 버튼 -->
									<!-- <c:choose>
										<c:when test="${currentPage1 < totalPage1}">
											<a href="?page=${currentPage1 + 1}" class="page next-page">다음</a>
										</c:when>
										<c:otherwise>
											<span class="page next-page disabled">다음</span>
										</c:otherwise>
									</c:choose> -->
									
									
									
									
									<!-- 이전 버튼 -->
									<c:choose>
										<c:when test="${currentPage1 > 1}">
											<a href="?type=${dto.type }&keyword=${dto.keyword }&page=${currentPage1 - 1}" class="page pre-page">이전</a>
										</c:when>
										<c:otherwise>
											<span class="page pre-page disabled">이전</span>
										</c:otherwise>
									</c:choose>

									<!-- 페이지 번호 -->
									<c:forEach begin="1" end="${totalPage1}" var="i">
										<a href="?type=${dto.type }&keyword=${dto.keyword }&page=${i}"
											class="num <c:if test='${i == currentPage1}'>bold</c:if>">${i}</a>
									</c:forEach>

									<!-- 다음 버튼 -->
									<c:choose>
										<c:when test="${currentPage1 < totalPage1}">
											<a href="?type=${dto.type }&keyword=${dto.keyword }&page=${currentPage1 + 1}" class="page next-page">다음</a>
										</c:when>
										<c:otherwise>
											<span class="page next-page disabled">다음</span>
										</c:otherwise>
									</c:choose>
								</div>
							</div>

						</div>
						<!-- 					</form> -->


						<!-- 자재코드 입력하면 자재명이 자동으로 입력
                                        수량은 기존에 있는것과 연동
                                        주문 필요도 입력창에선 없고 결과창에만 표시 -->

						<!-- 히스토리 항목 추가 -->

						<!-- 페이지 번호 -->
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

<script>
	//const btn_add = document.querySelector('#btn_main_add')

	/*btn_add.addEventListener('click', function() {
		
		const xhr = new XMLHttpRequest();
		xhr.open('get', 'addm1');
		
		
		xhr.onload = function() {
			console.log("xhr.responseText", xhr.responseText);
			location.href=xhr.responseText;
		}
	})*/

	// ajax로 입력취소 기능구현
	// 원자재 입력취소
	const btn_undom = document.querySelector('#btn_undom');

	btn_undom.addEventListener('click', function() {

		let checkboxes = document.querySelectorAll('.checkboxx');
		let undoCheck;
		for (let i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {

				undoCheck = checkboxes[i].value;

			}
		}
		console.log("undoCheck : ", undoCheck);

		const xhr = new XMLHttpRequest();
		xhr.open('post', 'undom');
		xhr.setRequestHeader('Content-Type', 'application/json')
		//xhr.send(delcode);
		xhr.send(JSON.stringify(undoCheck));
		console.log("데이터 보냄");

		xhr.onload = function() {
			if (xhr.responseText == 1) {
				alert('입력취소 성공');
				location.href = 'mainmp';
			} else {
				alert('입력취소 실패');
			}
		}
	})

	// 완제품 입력취소
	const btn_undop = document.querySelector('#btn_undop');

	btn_undop.addEventListener('click', function() {

		let checkboxes = document.querySelectorAll('.checkboxx');
		let undoCheck;
		for (let i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {

				undoCheck = checkboxes[i].value;

			}
		}
		console.log("undoCheck : ", undoCheck);

		const xhr = new XMLHttpRequest();
		xhr.open('post', 'undop');
		xhr.setRequestHeader('Content-Type', 'application/json')
		//xhr.send(delcode);
		xhr.send(JSON.stringify(undoCheck));
		console.log("데이터 보냄");

		xhr.onload = function() {
			if (xhr.responseText == 1) {
				alert('입력취소 성공');
				location.href = 'mainmp';
			} else {
				alert('입력취소 실패');
			}
		}
	})
</script>

</html>