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
<link rel="stylesheet" href="./layOut_kwak.css" type="text/css">
<link rel="stylesheet" href="./TestQA_report_park.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="./layOut_kwak.js"></script>
<script src="./TestQA_report_park.js" defer></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

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

			<!-- <div> -->
			<div class="menuPage-con">
				<!-- html 들어갈 곳 -->
				<!-- TestQA_report -->
				<div class="containerQA_report">
					<!-- background : darkgrey -->
					<div class="content">

						<div class="margin">

							<div class="tab-name-con">
								<div class="tab-name">품질 테스트 입력</div>
							</div>

							<div class="div_report_parent">
								<div class="div_report_name">
								</div>


								<div class="t_con">
									<form method="post" action="컨트롤러">
									<div class="con_1">
										테이블 행렬 바꿔서 표현
										<table>
											<thead>
												<tr>
													<th>항목</th>
													<th>내용</th>
												</tr>
											</thead>

											<tbody>

												
													<tr>
														<th>1. 생산코드</th>
														<td>${QcList.PROD_CD }</td>
													</tr>
													
													<tr>
														<th>2. 품목코드</th>
														<td>${QcList.ITEM_CD }</td>
													</tr>
													
													<tr>
														<th>3. 품목명</th>
														<td>${QcList.ITEM_NM }</td>
													</tr>
													
													<tr>
														<th>4. 작업자</th>
														<td>${QcList.WORK_NM }</td>
													</tr>
													
													<tr>
														<th>5. 생산완료시간</th>
														<td>${QcList.PROD_END_TIME }</td>
													</tr>
													
													<tr>
														<th>6. 지시수량</th>
														<td>${QcList.INDC_QNTT }</td>
													</tr>
													
													<tr>
														<th>7. 생산량</th>
														<td>${QcList.PROD_QNTT }</td>
													</tr>
													
													<tr>
														<th>8. 불량률</th>
														<td>${QcList.DFC_RT }</td>
													</tr>
												
											</tbody>
										</table>

<!-- 										<div class="div_report_QA"> -->
<!-- 											<div class="div_report_item"> -->
<!-- 												<div class="div_report_menu"> -->
<!-- 													<h3>항목</h3> -->
<!-- 												</div> -->
<!-- 												<div class="div_report_item_QA">1. 생산코드</div> -->
<!-- 												<div class="div_report_item_QA">2. 품목코드</div> -->
<!-- 												<div class="div_report_item_QA">3. 품목명</div> -->
<!-- 												<div class="div_report_item_QA">4. 작업자</div> -->
<!-- 												<div class="div_report_item_QA">5. 생산일</div> -->
<!-- 												<div class="div_report_item_QA">6. 지시수량</div> -->
<!-- 												<div class="div_report_item_QA">7. 생산량</div> -->
<!-- 												<div class="div_report_item_QA">8. 불량률</div> -->
<!-- 												<div class="div_report_item_QA">9. 검수자</div> -->


<!-- 											</div> -->
<!-- 										</div> -->


<!-- 										<div class="div_report_QA"> -->
<!-- 											<div class="div_report_item"> -->
<!-- 												<div class="div_report_menu"> -->
<!-- 													<h3>내용</h3> -->
<!-- 												</div> -->
<!-- 												<div class="div_report_item_QA">aaa111</div> -->
<!-- 												<div class="div_report_item_QA">aa-dd-cc</div> -->
<!-- 												<div class="div_report_item_QA">싹싹지우개</div> -->
<!-- 												<div class="div_report_item_QA">김철수</div> -->
<!-- 												<div class="div_report_item_QA">2025-01-01</div> -->
<!-- 												<div class="div_report_item_QA">100kg</div> -->
<!-- 												<div class="div_report_item_QA">99.5kg</div> -->

<!-- 												<div class="form_con"> -->
<!-- 													<form action="./TestQA_main_park.html"> -->
<!-- 														<div class="div_report_item_QA"> -->
<!-- 															<input id="QA_tester" type="text" value="" -->
<!-- 																placeholder="입력하시오" onchange="change()"> -->
<!-- 														</div> -->
<!-- 													</form> -->
<!-- 												</div> -->

<!-- 											</div> -->
<!-- 										</div> -->
									</div>


									<div class="con_2">
										테이블 행렬 바꿔서 표현
										<table>
											<thead>
												<tr>
													<th>항목</th>
													<th>내용</th>
												</tr>
											</thead>

											<tbody>

												
													<tr>
														<th>9. 검수자</th>
														<td>
															<select name="worker" required="required">
                                    							<c:forEach var = "worker" items = "${workerList }">
                                    								<option value="${worker.MBR_NM }">${worker.MBR_NM }</option>
                                    							</c:forEach>
                                    						</select>
														</td>
													</tr>
													
													<tr>
														<th>10. 검수일</th>
														<td>
															<input type="date" id="currentDate" required="required">
														</td>
													</tr>
													
													<tr>
														<th>11. 강도값</th>
														<td>
															<select name="fiber" required="required">
																<!-- <option value="fiber_select">선택</option> -->
																<option value="fiber_1">1</option>
																<option value="fiber_2">2</option>
																<option value="fiber_3">3</option>
																<option value="fiber_4">4</option>
																<option value="fiber_5">5</option>
																<option value="fiber_6">6</option>
																<option value="fiber_7">7</option>
																<option value="fiber_8">8</option>
																<option value="fiber_9">9</option>
																<option value="fiber_10" selected>10</option>
															</select>
														</td>
													</tr>
													
													<tr>
														<th>12. 크기값</th>
														<td>
															<select name="size" required="required">
																<!-- <option value="size_select">선택</option> -->
																<option value="size_1">1</option>
																<option value="size_2">2</option>
																<option value="size_3">3</option>
																<option value="size_4">4</option>
																<option value="size_5">5</option>
																<option value="size_6">6</option>
																<option value="size_7">7</option>
																<option value="size_8">8</option>
																<option value="size_9">9</option>
																<option value="size_10" selected>10</option>
															</select>
														</td>
													</tr>
													
													<tr>
														<th>13. 색상값</th>
														<td>
															<input name="color" type="color" value="" placeholder="입력하세요">
														</td>
													</tr>
													
													<tr>
														<th>14. 품질값</th>
														<td>
															<select name="erase" required="required">
																<!-- <option value="erase_select">선택</option> -->
																<option value="erase_1">1</option>
																<option value="erase_2">2</option>
																<option value="erase_3">3</option>
																<option value="erase_4">4</option>
																<option value="erase_5">5</option>
																<option value="erase_6">6</option>
																<option value="erase_7">7</option>
																<option value="erase_8">8</option>
																<option value="erase_9">9</option>
																<option value="erase_10" selected>10</option>
															</select>
														</td>
													</tr>
													
													<tr>
														<th>15. 불합격사유</th>
														<td>
															<input type="text" name="notpass" value="" placeholder="입력하세요">
														</td>
													</tr>
													
													<tr>
														<th>16. 비고</th>
														<td>
															<input type="text" name="note" value="" placeholder="입력하세요">
														</td>
													</tr>
													
													
<!-- 													<tr> -->
<!-- 														<th>9. 검수자</th> -->
<%-- 														<td>${QcList.CHCKR_NM }</td> --%>
<!-- 													</tr> -->
													
<!-- 													<tr> -->
<!-- 														<th>10. 검수일</th> -->
<%-- 														<td>${QcList.Chckr_dttm }</td> --%>
<!-- 													</tr> -->
													
<!-- 													<tr> -->
<!-- 														<th>11. 강도값</th> -->
<%-- 														<td>${QcList.STRTH_VAL }</td> --%>
<!-- 													</tr> -->
													
<!-- 													<tr> -->
<!-- 														<th>12. 크기값</th> -->
<%-- 														<td>${QcList.SZ_VAL }</td> --%>
<!-- 													</tr> -->
													
<!-- 													<tr> -->
<!-- 														<th>13. 색상값</th> -->
<%-- 														<td>${QcList.Clrl_val }</td> --%>
<!-- 													</tr> -->
													
<!-- 													<tr> -->
<!-- 														<th>14. 품질값</th> -->
<%-- 														<td>${QcList.Qlty_val }</td> --%>
<!-- 													</tr> -->
													
<!-- 													<tr> -->
<!-- 														<th>15. 불합격사유</th> -->
<%-- 														<td>${QcList.Fail_caus_desc }</td> --%>
<!-- 													</tr> -->
													
<!-- 													<tr> -->
<!-- 														<th>16. 비고</th> -->
<%-- 														<td>${QcList.Rmrk }</td> --%>
<!-- 													</tr> -->
												
											</tbody>
										</table>
									
<!-- 										<div class="div_report_QA"> -->
<!-- 											<div class="div_flex_2"> -->
<!-- 											<div class="div_report_item"> -->
<!-- 												<div class="div_report_menu hide_menu"> -->
<!-- 													<h3>항목</h3> -->
<!-- 												</div> -->
<!-- 												<div class="div_report_item_QA">9. 검수일</div> -->
<!-- 												<div class="div_report_item_QA">10. 강도</div> -->
<!-- 												<div class="div_report_item_QA">11. 크기</div> -->
<!-- 												<div class="div_report_item_QA">12. 색상</div> -->
<!-- 												<div class="div_report_item_QA">13. 잘지워지는 정도</div> -->
<!-- 												<div class="div_report_item_QA">14. 최종 합격률</div> -->
<!-- 												<div class="div_report_item_QA">15. 최종 불량률</div> -->
<!-- 												<div class="div_report_item_QA">16. 불합격 사유</div> -->

<!-- 											</div> -->
<!-- 										</div> -->
<!-- 										<div class="div_report_QA"> -->
<!-- 											<div class="div_report_item"> -->
<!-- 												<div class="div_report_menu hide_menu"> -->
<!-- 													<h3>내용</h3> -->
<!-- 												</div> -->
<!-- 												<div class="form_con"> -->
<!-- 													<form action="./TestQA_main_park.html"> -->

<!-- 														<div class="div_report_item_QA"> -->
<!-- 															<input id="QA_day" type="date" value="" max="2999-12-31" -->
<!-- 																, min="1970-01-01" required="required" -->
<!-- 																onchange="change()"> -->
<!-- 														</div> -->
<!-- 														<div class="div_report_item_QA"> -->
<!-- 															<select name="fiber" id="QA_fiber" required="required"> -->
<!-- 																<option value="fiber_select">선택</option> -->
<!-- 																<option value="fiber_1">1</option> -->
<!-- 																<option value="fiber_2">2</option> -->
<!-- 																<option value="fiber_3">3</option> -->
<!-- 																<option value="fiber_4">4</option> -->
<!-- 																<option value="fiber_5">5</option> -->
<!-- 																<option value="fiber_6">6</option> -->
<!-- 																<option value="fiber_7">7</option> -->
<!-- 																<option value="fiber_8">8</option> -->
<!-- 																<option value="fiber_9">9</option> -->
<!-- 																<option value="fiber_10" selected>10</option> -->
<!-- 															</select> -->
<!-- 														</div> -->
<!-- 														<div class="div_report_item_QA"> -->
<!-- 															<select name="size" id="QA_size" required="required"> -->
<!-- 																<option value="size_select">선택</option> -->
<!-- 																<option value="size_1">1</option> -->
<!-- 																<option value="size_2">2</option> -->
<!-- 																<option value="size_3">3</option> -->
<!-- 																<option value="size_4">4</option> -->
<!-- 																<option value="size_5">5</option> -->
<!-- 																<option value="size_6">6</option> -->
<!-- 																<option value="size_7">7</option> -->
<!-- 																<option value="size_8">8</option> -->
<!-- 																<option value="size_9">9</option> -->
<!-- 																<option value="size_10" selected>10</option> -->
<!-- 															</select> -->
<!-- 														</div> -->

<!-- 														<div class="div_report_item_QA"> -->
<!-- 															<input id="QA_color" type="text" value="" -->
<!-- 																placeholder="입력하시오" onchange="change()"> -->
<!-- 														</div> -->
<!-- 														<div class="div_report_item_QA"> -->
<!-- 															<select name="erase" id="QA_erase" required="required"> -->
<!-- 																<option value="erase_select">선택</option> -->
<!-- 																<option value="erase_1">1</option> -->
<!-- 																<option value="erase_2">2</option> -->
<!-- 																<option value="erase_3">3</option> -->
<!-- 																<option value="erase_4">4</option> -->
<!-- 																<option value="erase_5">5</option> -->
<!-- 																<option value="erase_6">6</option> -->
<!-- 																<option value="erase_7">7</option> -->
<!-- 																<option value="erase_8">8</option> -->
<!-- 																<option value="erase_9">9</option> -->
<!-- 																<option value="erase_10" selected>10</option> -->
<!-- 															</select> -->
<!-- 														</div> -->

<!-- 														<div class="div_report_item_QA"> -->
<!-- 															<input id="QA_Pass" type="text" value="" -->
<!-- 																placeholder="입력하시오" onchange="change()"> -->
<!-- 														</div> -->

<!-- 														<div class="div_report_item_QA"> -->
<!-- 															<input id="QA_Defect" type="text" value="" -->
<!-- 																placeholder="입력하시오" onchange="change()"> -->
<!-- 														</div> -->

<!-- 														<div class="div_report_item_QA"> -->
<!-- 															<input id="QA_DefectReason" type="text" value="" -->
<!-- 																placeholder="입력하시오" onchange="change()"> -->
<!-- 														</div> -->
													</form>
												</div>



												<!-- <form action="./TestQA.html">
                                        <input id="QA_tester" type="text" value="" placeholder="입력하시오" onchange="change()">
                                        <br>
                                        <input id="QA_day" type="text" value="" placeholder="입력하시오" onchange="change()">
                                        <br>
                                        <input id="QA_fiber" type="text" value="" placeholder="입력하시오" onchange="change()">
                                        <br>
                                        <input id="QA_size" type="text" value="" placeholder="입력하시오" onchange="change()">
                                        <br>
                                        <input id="QA_color" type="text" value="" placeholder="입력하시오" onchange="change()">
                                        <br>
                                        <input id="QA_erase" type="text" value="" placeholder="입력하시오" onchange="change()">
                                        <br>
                                        <input id="QA_etc" type="text" value="" placeholder="입력하시오" onchange="change()">
                                        <br>
                                        <input id="QA_result" type="text" value="" placeholder="입력하시오" onchange="change()">
                                        <br>
                                        </form> -->
											</div>
										</div>
									</div>
									</form>
								</div>
								
							</div>


							<div class="div_button">
								<div class="div_none">
									<!-- 빈 공간 -->
								</div>
								<button type="button" id="btn_report_confirm">
									<a class="btn_text_color" href="./TestQA_main_park.html">확인</a>
								</button>

								<div class="div_none">
									<!-- 빈 공간 -->
								</div>
							</div>
						</div>



					</div>

				</div>

			</div>




		</div>

		<div></div>
		<!-- </div> -->
	</div>
	</div>


</body>

</html>