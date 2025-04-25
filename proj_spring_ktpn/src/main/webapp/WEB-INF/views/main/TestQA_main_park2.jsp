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
<link rel="stylesheet" href="resources/css/TestQA_main_park.css"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="resources/js/layOut_kwak.js"></script>
<script src="resources/js/TestQA_main_park.js" defer></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<body>
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
					<!-- 								<form action="qccon" method="post"> -->

					<!-- 					<div class="right_chi"> -->


					<!-- 						<button class="btn" type="button" value="move_add_page" -->
					<!-- 							name="command">추가 - 버튼을 누르면 입력하는 창이 생김</button> -->

					<!-- 																<form action="qccon" method="post"> -->

					<!-- 																</form> -->

					<!-- 					</div> -->

					<details>
						<summary> 추가 </summary>



						<!-- <div class="div_none0"></div> -->
						<div>

							<!-- 									<form method="post" action="qccon"> -->


							<!-- 									</form> -->



							<form action="addqc" method="post">
								<div>
									<!-- 									<div class="div_none1"> -->
									<!-- 																					안보임 -->
									<!-- 									</div> -->
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
													<td class="QA-td"><select id="select1" name="prod_cd"
														onchange="changeP()">
															<option value="">선택</option>
															<c:forEach var="pcode" items="${pList }">
																<option value="${pcode.prod_cd }"
																	auto_icode="${pcode.item_cd }"
																	auto_iname="${pcode.item_nm }">${pcode.prod_cd }</option>
															</c:forEach>
													</select></td>

													<script>
														// 셀렉트 박스에서 선택한 옵션값 가져오기
														function changeP() {
															var select1 = document
																	.getElementById('select1');
															var select1_option = select1.options[select1.selectedIndex];

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

													<td class="QA-td"><input type="text" id="icode"
														name="item_cd" value="" readonly="readonly"></td>

													<td class="QA-td"><input type="text" id="iname"
														name="item_nm" value="" readonly="readonly"></td>

													<td class="QA-td"><select name="chckr_nm"
														required="required">
															<c:forEach var="worker" items="${mList }">
																<option value="${worker.mbr_nm }">${worker.mbr_nm }</option>
															</c:forEach>
													</select></td>


													<td class="QA-td"><input type="date" name="chckr_dttm"
														id="currentDate" required="required"></td>
												</tr>

											</tbody>
										</table>
									</div>

									<div class="div_none2"></div>

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
															<option value="10" selected>10</option>
													</select></td>

													<td class="QA-td"><select name="sz_val"
														required="required">
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
															<option value="10" selected>10</option>
													</select></td>

													<td class="QA-td"><input name="clrl_val" type="color"
														value="" placeholder="입력하세요"></td>

													<td class="QA-td"><select name="qlty_val"
														required="required">
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
															<option value="10" selected>10</option>
													</select></td>

													<td class="QA-td" colspan="1"><select
														name="fail_caus_desc" required="required">
															<option value="선택" selected>선택</option>
															<option value="외관불량">외관불량</option>
															<option value="강도불량">강도불량</option>
															<option value="색상불량">색상불량</option>
															<option value="잘안지워짐">잘안지워짐</option>
															<option value="옵션없음(비고에 입력)">옵션없음(비고에 입력)</option>
													</select> <!-- 														<input type="text" name="notpass" value="" placeholder="입력하세요"> -->
													</td>

													<td class="QA-td" colspan="1"><input type="text"
														name="rmrk" value="" placeholder="입력하세요"></td>
											</tbody>

										</table>
									</div>

									<button class="btn" type="submit" name="command" value="insert">
										추가하기</button>

								</div>
							</form>
						</div>
					</details>

					<div class="select_input_search-btn">

						<form action="searchqc" method="get">

							<select name="type" id="select_QA">
								<option value="all" selected="selected">전체</option>
								<option value="Pcode">생산코드</option>
								<option value="Fcode">품목코드</option>
								<option value="Fname">품목명</option>
								<!-- 											<option value="QA_code4">최종결과</option> -->
							</select> <input type="select" class="select" name="keyword"
								value="${dto.keyword }">
							<!-- <input class="select_day" id="select_QA_eve" type="date" value=""
                                                max="2999-12-31" , min="1970-01-01"> -->
							<!-- 						<input class="select_day" id="select_QA_today" type="date" -->
							<!-- 							value="" max="2999-12-31" , min="1970-01-01">  -->
							<input type="submit" class="submit" value="검색">


						</form>

					</div>

<!-- 					<div> -->
<!-- 						스피너 테스트 -->
<!-- 						<button id="loadingButton" onclick="simulateLoading()">로딩 -->
<!-- 							시작</button> -->
<!-- 						<div class="layerPopup layerPopup-js" style="display: none"> -->
<!-- 							<div class="spinner"></div> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<script>
// 						function simulateLoading() {
// 							var loadingSpinner = document
// 									.querySelector(".layerPopup-js");
// 							var loadingMessage = document
// 									.getElementById("loadingMessage");

// 							// 로딩 시작
// 							loadingSpinner.style.display = "flex";
// 							loadingMessage.textContent = "로딩 중...";

// 							// 1초 뒤에 로딩 완료
// 							setTimeout(function() {
// 								loadingSpinner.style.display = "none";
// 								loadingMessage.textContent = "로딩 완료";
// 							}, 1000);
// 						}
					</script>


					<%
					// 페이지 파라미터 처리
					int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
					int pageSize = 10;
					int startRow = (currentPage - 1) * pageSize;
					int endRow = startRow + pageSize;

					List<?> fullList = (List<?>) request.getAttribute("list");
					int totalCount = fullList != null ? fullList.size() : 0;
					int totalPage = (int) Math.ceil((double) totalCount / pageSize);

					List<?> pagedList = fullList != null
							? fullList.subList(Math.min(startRow, totalCount), Math.min(endRow, totalCount))
							: null;

					request.setAttribute("pagedList", pagedList);
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("totalPage", totalPage);
					%>


					<!-- 						<form action="deleteqc" method="post"> -->
					<div>
						<table class="QA-table">
							<thead>
								<tr>

									<th scope="col"
										style="border: 1px solid darkgrey; background-color: #2f373a; color: white;">✔</th>
									<th scope="col" class="QA-th">생산코드</th>
									<th scope="col" class="QA-th">품목코드</th>
									<th scope="col" class="QA-th">품목명</th>
									<th scope="col" class="QA-th">강도값</th>
									<th scope="col" class="QA-th">크기값</th>
									<th scope="col" class="QA-th">색상값</th>
									<th scope="col" class="QA-th">품질값</th>
									<th scope="col" class="QA-th">검수자</th>
									<th scope="col" class="QA-th">수정</th>
								</tr>
							</thead>

							<tbody class="">
								<c:if test="${not empty pagedList }">


									<c:forEach var="QCdata" items="${pagedList }">

										<tr>


											<td style="border: 1px solid darkgrey;"><input
												type="checkbox" class="checkboxx"
												id="updatecode_${QCdata.prod_cd }" name="delcode"
												value="${QCdata.prod_cd }"></td>

											<!-- 													<form method="post" action="qccon"> -->

											<td class="QA-td"><input id="pcode" type="hidden"
												name="pcode" value="${QCdata.prod_cd }"> <a
												class="enter_reportPage"
												href="showjoin?pcode=${QCdata.prod_cd }"
												data-value="${QCdata.prod_cd }"> ${QCdata.prod_cd } </a></td>

											<td class="QA-td"><input id="icode" type="hidden"
												name="icode" value="${QCdata.item_cd }">
												${QCdata.item_cd }</td>

											<td class="QA-td"><input id="iname" type="hidden"
												name="iname" value="${QCdata.item_nm }">
												${QCdata.item_nm }</td>

											<td class="QA-td"><input id="fiber" type="hidden"
												name="fiber" value="${QCdata.strth_val }">
												${QCdata.strth_val }</td>

											<td class="QA-td"><input id="size" type="hidden"
												name="size" value="${QCdata.sz_val }">
												${QCdata.sz_val }</td>

											<td class="QA-td"><input id="color" type="hidden"
												name="color" value="${QCdata.clrl_val }">
												<div class="QA-td-color"
													style="background-color: ${QCdata.clrl_val }"></div>

												${QCdata.clrl_val }</td>

											<td class="QA-td"><input id="erase" type="hidden"
												name="erase" value="${QCdata.qlty_val }">
												${QCdata.qlty_val }</td>

											<td class="QA-td"><input id="tester" type="hidden"
												name="tester" value="${QCdata.chckr_nm }">
												${QCdata.chckr_nm }</td>

											<td class="QA-td">
												<!-- 											<input type="hidden" name="command" value="update"> -->
												<!-- 												<input type="submit" value="수정"> -->
												<form action="updateqc" method="post">
													<button class="update_btn btn" type="submit"
														name="updateCode" value="${QCdata.prod_cd }">수정</button>
												</form>

											</td>

											<!--                                                 	</form> -->
										</tr>


									</c:forEach>

								</c:if>

								<c:if test="${empty pagedList }">
									<tr>
										<td colspan="10">조회 결과가 없습니다</td>
									</tr>
								</c:if>
							</tbody>
						</table>
					</div>

					<div>
						<button class="btn" id="btn_del" type="button" name="command"
							value="delete">삭제</button>
					</div>
					<!-- 					</form> -->
					<!-- 						<div> -->
					<!-- 							<button id="btnbb" type="button" name="command" value="update"> -->
					<!-- 								수정2 -->
					<!-- 							</button> -->
					<!-- 						</div> -->
					<script>
						// 수정페이지로 이동하는 js
						// 문제 - icode, iname의 값을 못 가져온다 
						// 문제 - param을 전송 못함
						// 수정버튼 여러개 중 하나만 작동
						//  -> 수정버튼을 하나로 만들고 체크박스로 체크한 데이터받기

						// 테이블 밖에 있는 수정 버튼
						/*const btnbb = document.querySelector('#btnbb');
						btnbb.addEventListener('click', function() {
							
						// 							let checkbox = document.querySelector('[id^=updatecode_]');
							let checkboxes = document.querySelectorAll('.checkboxx');
							let updateCode;
							for(let i = 0; i<checkboxes.length; i++) {
								if(checkboxes[i].checked) {
								
									updateCode = checkboxes[i].value;
									console.log("updateCode : ", updateCode);
								}
							}
							
							
							const xhr = new XMLHttpRequest();
							xhr.open('post', 'updateqc');
							xhr.send(updateCode);
							console.log("데이터 보냄");
							
							xhr.onload = function() {
								console.log("xhr.responseText", xhr.responseText);
								location.href=xhr.responseText;
							}
						})*/

						// 테이블에 있는 수정 버튼
						/*const update_btn = document.querySelector('.update_btn');
						console.log("update_btn.value : " , update_btn.value);
						
						update_btn.addEventListener('click', function() {
							
							let param = {
									prod_cd : document.querySelector('#pcode').value,
									item_cd : document.querySelector('#icode').value,
									item_nm : document.querySelector('#iname').value,
									strth_val : document.querySelector('#fiber').value,
									sz_val : document.querySelector('#size').value,
									clrl_val : document.querySelector('#color').value,
									qlty_val : document.querySelector('#erase').value,
									chckr_nm : document.querySelector('#tester').value
							}
							
							console.log("param : ", param);
							
							const xhr = new XMLHttpRequest();
							xhr.open('post', 'updateqc');
						// 							xhr.setRequestHeader('Content-Type', 'application/json')
							xhr.send(paramData);
						//							xhr.send(JSON.stringify(paramData));
							console.log("데이터 보냄");
						// 							xhr.onload = function() {
						// 								if(xhr.responseText == '1'){
						// 									alert('수정 성공');
						// 									location.href='allEmp';
						// 								} else {
						// 									alert('수정 실패');
						// 								}
						// 							}
						})*/

						// ajax로 데이터 삭제하기
						const btn_del = document.querySelector('#btn_del');

						btn_del.addEventListener('click', function() {

							let checkboxes = document
									.querySelectorAll('.checkboxx');
							let delcode = new Array();
							for (let i = 0; i < checkboxes.length; i++) {
								if (checkboxes[i].checked) {

									delcode[i] = checkboxes[i].value;
									//console.log("delcode : ", delCode);
								}
							}
							console.log("delcode : ", delcode);

							const xhr = new XMLHttpRequest();
							xhr.open('post', 'deleteqc');
							xhr.setRequestHeader('Content-Type',
									'application/json')
							//xhr.send(delcode);
							xhr.send(JSON.stringify(delcode));
							console.log("데이터 보냄");

							xhr.onload = function() {
								if (xhr.responseText != 0) {
									alert('삭제 성공');
									location.href = 'mainqc';
								} else {
									alert('삭제 실패');
								}
							}
						})
					</script>



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
									<a
										href="?type=${dto.type }&keyword=${dto.keyword }&page=${currentPage - 1}"
										class="page pre-page">이전</a>
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
									<a
										href="?type=${dto.type }&keyword=${dto.keyword }&page=${currentPage + 1}"
										class="page next-page">다음</a>
								</c:when>
								<c:otherwise>
									<span class="page next-page disabled">다음</span>
								</c:otherwise>
							</c:choose>


						</div>


					</div>
				</div>
				<!-- 								</form> -->


				<!-- 					<div class="div_none"> -->
				<!-- 						빈 공간 -->
				<!-- 					</div> -->




				<!-- 페이지 번호 -->
				<!-- 					<div class="flex_page"> -->

				<!-- 						<div class="item_page pre_page"> -->
				<!-- 							<a id="a_before_page" href=""> < 이전 </a> -->
				<!-- 						</div> -->

				<!-- 						<div class="item_page"> -->
				<!-- 							<a class="num bold" href="">1</a> <a class="num" href="">2</a> <a -->
				<!-- 								class="num" href="">3</a> <a class="num" href="">4</a> <a -->
				<!-- 								class="num" href="">5</a> -->
				<!-- 						</div> -->

				<!-- 						<div class="item_page next_page"> -->
				<!-- 							<a id="a_after_page" href=""> 다음 > </a> -->
				<!-- 						</div> -->
				<!-- 					</div> -->



			</div>

		</div>
	</div>

</body>

</html>