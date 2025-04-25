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
<link rel="stylesheet" href="resources/css/layOut_kwak.css" type="text/css">
<link rel="stylesheet" href="resources/css/TestQA_report_park.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="resources/js/layOut_kwak.js"></script>
<script src="resources/js/TestQA_report_park.js" defer></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<body>

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
						<div class="div_report_name"></div>


						<div class="t_con">
							<form method="post" action="컨트롤러">
								<div class="con_1">

									<table id="qctable">
										<thead>
											<tr>
												<th class="qc-th">생산코드</th>
												<th class="qc-th">품목코드</th>
												<th class="qc-th">품목명</th>
												<th class="qc-th">검수자</th>
												<th class="qc-th">검수일</th>
												<th class="qc-th">강도값</th>
												<th class="qc-th">크기값</th>
												<th class="qc-th">색상값</th>
												<th class="qc-th">품질값</th>
												<th class="qc-th">불합격사유</th>
												<th class="qc-th">비고</th>
											</tr>
										</thead>

										<tbody>


											<tr>

												<td><select id="select1" name="Pcode"
													onchange="changeP()">
														<c:forEach var="pcode" items="${pList }">
															<option value="${pcode.prod_cd }"
																auto_icode="${pcode.item_cd }"
																auto_iname="${pcode.item_nm }">${pcode.prod_cd }
															</option>
														</c:forEach>
												</select></td>

												<script>
													// 셀렉트 박스에서 선택한 옵션값 가져오기
													function changeP() {
														var select1 = document
																.getElementById('select1');
														var select1_option = select1.options[select1.selectedIndex];
														// 	                                                    		var select1_option = select1.options[select1.selectedIndex].value;
														//																.value 쓰면 안된다

														var auto_icode = select1_option
																.getAttribute('auto_icode');
														document
																.getElementById('icode').value = auto_icode;

														var auto_iname = select1_option
																.getAttribute('auto_iname');
														document
																.getElementById('iname').value = auto_iname;
													}
												</script>

												<td><input type="text" id="icode" name="code" value=""
													readonly="readonly"></td>

												<td><input type="text" id="iname" name="name" value=""
													readonly="readonly"></td>

												<td><select name="tester" required="required">
														<c:forEach var="worker" items="${mList }">
															<option value="${worker.mbr_nm }">${worker.mbr_nm }</option>
														</c:forEach>
												</select></td>


												<td><input type="date" name="date" id="currentDate"
													required="required"></td>

												<td><select name="fiber" required="required">
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
												</select></td>

												<td><select name="size" required="required">
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
												</select></td>

												<td><input name="color" type="color" value=""
													placeholder="입력하세요"></td>

												<td><select name="erase" required="required">
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
												</select></td>

												<td><input type="text" name="notpass" value=""
													placeholder="입력하세요"></td>

												<td><input type="text" name="note" value=""
													placeholder="입력하세요"></td>
											</tr>

										</tbody>
									</table>

								</div>

								<div class="right">
									<div class="right_chi">
										<input type="hidden" name="command" value="insert"> <input
											type="submit" value="확인">

										<button type="submit" name="command" value="insert"
											id="btn_report_confirm">확인</button>
									</div>
								</div>
							</form>
						</div>

					</div>


					<div class="div_button">
						<div class="div_none">
							<!-- 빈 공간 -->
						</div>
						<!-- 								<button type="button" id="btn_report_confirm"> -->
						<!-- 									<a class="btn_text_color" href="./TestQA_main_park.jsp">확인</a> -->
						<!-- 								</button> -->

						<div class="div_none">
							<!-- 빈 공간 -->
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

</body>

</html>