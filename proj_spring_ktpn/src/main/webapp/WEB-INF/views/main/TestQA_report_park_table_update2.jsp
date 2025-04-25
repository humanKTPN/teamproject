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
<link rel="stylesheet" href="resources/css/layOut_kwak.css"
	type="text/css">
<link rel="stylesheet" href="resources/css/TestQA_main_park.css"
	type="text/css">
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
						<div class="tab-name">품질 테스트 수정</div>
					</div>

					<div class="div_report_parent">
						<div class="div_report_name"></div>


						<div class="t_con">
							<form method="post" action="updateqc1">
								<div class="con_1">

									<div>
										<table class="QA-table">
											<tbody>
												<tr class="QA-tr">
													<th class="QA-th1">생산코드</th>
													<th class="QA-th1">품목코드</th>
													<th class="QA-th1">품목명</th>
													<th class="QA-th1">검수자</th>
													<th class="QA-th1">검수일</th>

												</tr>

												<tr>
													<td class="QA-td">
													<input id="pcode" type="hidden" name="prod_cd"
												value="${dto.prod_cd }">${dto.prod_cd }</td>
													<td class="QA-td">
													<input id="icode" type="hidden" name="item_cd"
												value="${dto.item_cd }">${dto.item_cd }</td>
													<td class="QA-td">
													<input id="iname" type="hidden" name="item_nm"
												value="${dto.item_nm }">
													${dto.item_nm }</td>
													<td class="QA-td"><select name="chckr_nm"
														required="required">
															<c:forEach var="worker" items="${mList }">
																<option value="${worker.mbr_nm }">${worker.mbr_nm }</option>
															</c:forEach>
													</select></td>
													<td class="QA-td"><input type="date" name="chckr_dttm" id="currentDate"
														required="required"></td>

												</tr>
											</tbody>
										</table>
									</div>

									<div>
										<table class="QA-table">
											<tbody>
												<tr class="QA-tr">
													<th class="QA-th1">강도값</th>
													<th class="QA-th1">크기값</th>
													<th class="QA-th1">색상값</th>
													<th class="QA-th1">품질값</th>
													<th class="QA-th1">불합격사유</th>
													<th class="QA-th1" colspan="1">비고</th>
												</tr>

												<tr>


													<td class="QA-td"><select name="strth_val"
														required="required">
															<option value="${dto.strth_val }" selected>${dto.strth_val }</option>
															<!-- <option value="fiber_select">선택</option> -->
															<option value="1">1</option>
															<option value="2">2</option>
															<option value="3">3</option>
															<option value="4">4</option>
															<option value="5">5</option>
															<option value="6">6</option>
															<option value="7">7</option>
															<option value="8">8</option>
															<option value="9">9</option>
															<option value="10">10</option>
													</select></td>

													<td class="QA-td"><select name="sz_val"
														required="required">
															<option value="${dto.sz_val }" selected>${dto.sz_val }</option>
															<!-- <option value="size_select">선택</option> -->
															<option value="1">1</option>
															<option value="2">2</option>
															<option value="3">3</option>
															<option value="4">4</option>
															<option value="5">5</option>
															<option value="6">6</option>
															<option value="7">7</option>
															<option value="8">8</option>
															<option value="9">9</option>
															<option value="10">10</option>
													</select></td>

													<td class="QA-td"><input name="clrl_val" type="color"
														value="${dto.clrl_val }"></td>

													<td class="QA-td"><select name="qlty_val"
														required="required">
															<option value=${dto.qlty_val } selected>${dto.qlty_val }</option>
															<!-- <option value="erase_select">선택</option> -->
															<option value="1">1</option>
															<option value="2">2</option>
															<option value="3">3</option>
															<option value="4">4</option>
															<option value="5">5</option>
															<option value="6">6</option>
															<option value="7">7</option>
															<option value="8">8</option>
															<option value="9">9</option>
															<option value="10">10</option>
													</select></td>

													<td class="QA-td" colspan="1"><select name="fail_caus_desc"
														required="required">
															<c:choose>
																	
																<c:when test="${dto.fail_caus_desc eq '선택'}">
																	<option value="${dto.fail_caus_desc }" selected>${dto.fail_caus_desc }</option>
																	<option value="외관불량">외관불량</option>
																	<option value="강도불량">강도불량</option>
																	<option value="색상불량">색상불량</option>
																	<option value="잘안지워짐">잘안지워짐</option>
																	<option value="옵션없음(비고에 입력)">옵션없음(비고에 입력)</option>
																</c:when>

																<c:when test="${dto.fail_caus_desc eq '외관불량'}">
																	<option value="선택">선택</option>
																	<option value="${dto.fail_caus_desc }" selected>${dto.fail_caus_desc }</option>
																	<option value="강도불량">강도불량</option>
																	<option value="색상불량">색상불량</option>
																	<option value="잘안지워짐">잘안지워짐</option>
																	<option value="옵션없음(비고에 입력)">옵션없음(비고에 입력)</option>
																</c:when>

																<c:when test="${dto.fail_caus_desc eq '강도불량'}">
																	<option value="선택">선택</option>
																	<option value="외관불량">외관불량</option>
																	<option value="${dto.fail_caus_desc }" selected>${dto.fail_caus_desc }</option>
																	<option value="색상불량">색상불량</option>
																	<option value="잘안지워짐">잘안지워짐</option>
																	<option value="옵션없음(비고에 입력)">옵션없음(비고에 입력)</option>
																</c:when>

																<c:when test="${dto.fail_caus_desc eq '색상불량'}">
																	<option value="선택">선택</option>
																	<option value="외관불량">외관불량</option>
																	<option value="강도불량">강도불량</option>
																	<option value="${dto.fail_caus_desc }" selected>${dto.fail_caus_desc }</option>
																	<option value="잘안지워짐">잘안지워짐</option>
																	<option value="옵션없음(비고에 입력)">옵션없음(비고에 입력)</option>
																</c:when>

																<c:when test="${dto.fail_caus_desc eq '잘안지워짐'}">
																	<option value="선택">선택</option>
																	<option value="외관불량">외관불량</option>
																	<option value="강도불량">강도불량</option>
																	<option value="색상불량">색상불량</option>
																	<option value="${dto.fail_caus_desc }" selected>${dto.fail_caus_desc }</option>
																	<option value="옵션없음(비고에 입력)">옵션없음(비고에 입력)</option>
																</c:when>

																<c:when test="${dto.fail_caus_desc eq '옵션없음(비고에 입력)'}">
																	<option value="선택">선택</option>
																	<option value="외관불량">외관불량</option>
																	<option value="강도불량">강도불량</option>
																	<option value="색상불량">색상불량</option>
																	<option value="잘안지워짐">잘안지워짐</option>
																	<option value="${dto.fail_caus_desc }" selected>${dto.fail_caus_desc }</option>
																</c:when>
																
																<c:otherwise>
																	<option value="선택" selected>선택</option>
																	<option value="외관불량">외관불량</option>
																	<option value="강도불량">강도불량</option>
																	<option value="색상불량">색상불량</option>
																	<option value="잘안지워짐">잘안지워짐</option>
																	<option value="옵션없음(비고에 입력)">옵션없음(비고에 입력)</option>
																</c:otherwise>
											
															</c:choose>
													</select></td>
													<td class="QA-td" colspan="1"><input type="text"
														name="rmrk" value="${dto.rmrk }" placeholder="입력하세요"></td>
												</tr>
											</tbody>
										</table>
									</div>

									<div>
<!-- 										<input type="hidden" value="update" name="command"> <input -->
<!-- 											type="submit" value="수정하기"> -->

										<button class="btn" type="submit" name="command" value="update">수정하기</button>
									</div>

								</div>
							</form>

							<div class="con_2"></div>




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
<!-- 			<button type="button" id="btn_report_confirm"> -->
<!-- 				<a class="btn_text_color" href="./TestQA_main_park2.html">확인</a> -->
<!-- 			</button> -->

			<div class="div_none">
				<!-- 빈 공간 -->
			</div>
		</div>
	</div>
</body>

</html>