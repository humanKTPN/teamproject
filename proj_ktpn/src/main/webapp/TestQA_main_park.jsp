<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="layOut_kwak.css" type="text/css">
<link rel="stylesheet" href="TestQA_main_park.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="layOut_kwak.js"></script>
<script src="TestQA_main_park.js" defer></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<body>
<body>
	<div class="menu-con work">
		<div>
			<div id="title-name">
				<div class="titleName">
					<i id="ham" class=" main-menu fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;
					<div class="logo">
						<i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES
						solution
					</div>
				</div>
				<div class="icon-sub">
					관리자님 환영합니다.
					<!-- <i class="fas fa-solid fa-gear fa-lg" style="display: flex; width: 60px; justify-content: space-between;" > -->
					<i class="fas fa-regular fa-arrow-right-from-bracket fa-md"> <span
						class="subBut">로그아웃</span>
					</i>
					<!-- </i> -->
				</div>
			</div>
		</div>
		<div class="main-menu-con">
			<!-- <div class="main-menu" id="main-menu">MENU 닫기</div> -->
			<div class="menu">기준관리</div>
			<div class="menu">작업관리</div>
			<div class="menu">생산관리</div>
			<div class="menu">생산리포팅</div>
			<div class="menu">재고관리</div>
			<div class="menu">품질관리</div>
		</div>
	</div>
	<div class="board">

		<div class="mainmenu" id="work1">
			<div class="menuBut">대시보드</div>
			<div class="menuBut">게시판</div>
			<div class="menuBut">공지사항</div>
			<!-- <div class="menuBut">기준관리</div> -->
		</div>
		<div class="bome-con">

			<div>
				<div class="menuPage-con">
					<!-- html 들어갈 곳 -->
					<!-- TestQA_main -->
					<div class="containerQA">
						<!-- background : darkgrey -->
						<div class="content">

							<div class="margin">

								<div class="tab-name-con">
									<div class="tab-name">제품 검사 목록</div>
								</div>

								<div class="select_input_search-btn">

									<form action="#">

										<select name="select_QA" id="select_QA">
											<option value="all" selected="selected">전체</option>
											<option value="QA_code1">생산코드</option>
											<option value="QA_code2">품목코드</option>
											<option value="QA_code3">품목명</option>
<!-- 											<option value="QA_code4">최종결과</option> -->
										</select> <input type="select" class="select">
										<!-- <input class="select_day" id="select_QA_eve" type="date" value=""
                                                max="2999-12-31" , min="1970-01-01"> -->
										<input class="select_day" id="select_QA_today" type="date"
											value="" max="2999-12-31" , min="1970-01-01"> <input
											type="submit" class="submit" value="검색">


									</form>

									
											
									<div class="right_chi">
										<button class="btn" type="button">
											<a href="./TestQA_report_park_table_add2.jsp">추가</a>
										</button>
											
										<button class="btn" type="submit" value="delete" name="command">
											<input type="hidden" name="command" value="delete">
												삭제
										</button>
									</div>
											
									
								</div>

								<!-- <div class="div_none0"></div> -->
								<div>
									
									<form method="post" action="qccon">
									<div>
									<table class="QA-table">
										<thead>
											<tr>
											
												<th scope="col" class="QA-th">✔</th>
												<th scope="col" class="QA-th">생산코드</th>
												<th scope="col" class="QA-th">품목코드</th>
												<th scope="col" class="QA-th">품목명</th>
												<th scope="col" class="QA-th">강도값</th>
												<th scope="col" class="QA-th">크기값</th>
												<th scope="col" class="QA-th">색상값</th>
												<th scope="col" class="QA-th">품질값</th>
												<th scope="col" class="QA-th">검수자</th>
											</tr>
										</thead>

										<tbody>
											
											<c:forEach var="QCdata" items="${QCList }">

												<tr>
													

														<td>
															<input type="checkbox" name="delcode" value="${QCdata.PROD_CD }">
														</td>
														
<!-- 													<form method="post" action="qccon"> -->
														
														<td class="QA-td">
															<input type="hidden" name="code" value="${QCdata.PROD_CD }">
															<a class="enter_reportPage" href="./TestQA_report_park_table_show.jsp">
																${QCdata.PROD_CD }
															</a>
														</td>
														
														<td class="QA-td">
														<input type="hidden" name="code" value="${QCdata.PROD_CD }">
														${QCdata.ITEM_CD }</td>
														
														<td class="QA-td">
														<input type="hidden" name="name" value="${QCdata.ITEM_NM }">
														${QCdata.ITEM_NM }</td>
														
														<td class="QA-td">
														<input type="hidden" name="fiber" value="${QCdata.STRTH_VAL }">
														${QCdata.STRTH_VAL }</td>
														
														<td class="QA-td">
														<input type="hidden" name="size" value="${QCdata.SZ_VAL }">
														${QCdata.SZ_VAL }</td>
														
														<td class="QA-td">
														<input type="hidden" name="color" value="${QCdata.Clrl_val }">
														${QCdata.Clrl_val }</td>
														
														<td class="QA-td">
														<input type="hidden" name="erase" value="${QCdata.Qlty_val }">
														${QCdata.Qlty_val }</td>
														
														<td class="QA-td">
														<input type="hidden" name="tester" value="${QCdata.CHCKR_NM }">
														${QCdata.CHCKR_NM }</td>
														
														<td>
															<input type="hidden" name="command" value="update">
															<input type="submit" value="수정">
														</td>

<!--                                                 	</form> -->
												</tr>


											</c:forEach>
											
										</tbody>
									</table>
									</div>
<!-- 										<input type="hidden" name="command" value="delete"> -->
<!-- 										<input type="submit" value="삭제"> -->
										
<!-- 										<div class="right"> -->
											
<!-- 											<div class="right_chi"> -->
<!-- 												<button class="btn" type="button"> -->
<!-- 													<a href="./TestQA_report_park_table_add2.jsp">추가</a> -->
<!-- 												</button> -->
											
<!-- 												<button class="btn" type="submit" value="delete" name="command"> -->
<!-- 													<input type="hidden" name="command" value="delete"> -->
<!-- 													삭제 -->
<!-- 												</button> -->
<!-- 											</div> -->
											
<!-- 										</div> -->
									</form>
								</div>
								
								
								
								<div class="div_none">
									<!-- 빈 공간 -->
								</div>
								
								

								<!-- 페이지 번호 -->
								<div class="flex_page">

									<div class="item_page pre_page">
										<a id="a_before_page" href=""> < 이전 </a>
									</div>

									<div class="item_page">
										<a class="num bold" href="">1</a> <a class="num" href="">2</a>
										<a class="num" href="">3</a> <a class="num" href="">4</a> <a
											class="num" href="">5</a>
									</div>

									<div class="item_page next_page">
										<a id="a_after_page" href=""> 다음 > </a>
									</div>
								</div>
							</div>


						</div>
					</div>


				</div>


				<div></div>
			</div>
		</div>
	</div>
</body>

</body>

</html>