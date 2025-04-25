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
<!-- <link rel="stylesheet" href="layOut_kwak.css" type="text/css"> -->
<link rel="stylesheet" href="resources/css/TestMM_add_park.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<!-- <script src="layOut_kwak.js"></script> -->
<script src="resources/js/TestMM_add_park.js" defer></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<body>
	<div class="menuPage-con">
				<!-- html 들어갈 곳 -->
				<!-- TestMM_add -->
				<div class="containerMM_add">

					<div class="content">

						<div class="margin">

							<div class="tab-name-con">
								<div class="tab-name">재고 추가</div>
								
							</div>

							<div class="div_add">

								<!-- <div class="div_none"></div> -->

								<div id="input">
									<form action="addm2" method="post">

										<div class="flex_child">

											<div class="item i_color">원자재코드</div>
											<div class="item i_color">원자재이름</div>
											<!--                                         <div class="item i_color">기준수량</div> -->
											<div class="item i_color">입력수량</div>
											<div class="item i_color">입고/출고</div>
										</div>


										<!-- 입력추가 버튼을 누르면 나오는 input 예시 -->
<!-- 										<div class="flex_child new_input"> -->

											<div class="flex_child">
												<div class="item">
													<!--                                     		원자재코드 선택하면 원자재명도 자동으로입력 
												이미 추가된 원자재코드가 있으면 그 코드로는 새로운 추가 불가능하게 하기-->
													<select id="select1" name="mtrl_cd" onchange="changeM()">
														<c:forEach var="code" items="${mcList }">
															<option value="${code.MT_MNG_CD }"
																auto_Mname="${code.MT_MNG_NM }">
																${code.MT_MNG_CD }</option>
														</c:forEach>
													</select>
												</div>

												<script>
													function changeM() {
														var select1 = document
																.getElementById('select1');
														var select1_option = select1.options[select1.selectedIndex];

														var auto_Mname = select1_option.getAttribute('auto_Mname');
														
														document.getElementById('Mname').value = auto_Mname;
													}
												</script>

												<div class="item">
													<input type="text" id="Mname" name="mtrl_nm" value=""
														readonly="readonly">

													<!-- 													<select name="name"> -->
													<%-- 														<c:forEach var="code" items="${codeList }"> --%>
													<%-- 															<option value="${code.MT_MNG_NM }">${code.MT_MNG_NM }</option> --%>
													<%-- 														</c:forEach> --%>
													<!-- 													</select> -->
												</div>

												<div class="item">
													<input class="item Mea" type="text" name="crnt_cnt" value=""
														placeholder="수량(EA) 입력" />

												</div>

												<div class="item">
													<select name="iob_se_cd">
														<option value="i">입고</option>
														<option value="o">출고</option>
													</select>
												</div>
											</div>

											<div class="flex_child">
												<div class="item i_color">작업자</div>
												<div class="item i_color">위치</div>
												<div class="item i_color">입력일</div>
												<div class="item i_color">비고</div>
												<!--                                         <div class="item i_color">변동후 수량</div> -->
												<!--                                         <div class="item i_color">변동일</div> -->
											</div>
											
											<div class="flex_child">
											<div class="item">
												<select name="work_nm">
													<c:forEach var="member" items="${mList }">
														<option value="${member.mbr_nm }">${member.mbr_nm }</option>
													</c:forEach>
												</select>
											</div>

											<div class="item">
												<select name="mtrl_cd_nm">
													<option value="M창고1">M창고1</option>
													<!-- 														<option value="warehouse2">M창고2</option> -->
													<!-- 														<option value="warehouse3">M창고3</option> -->

												</select>
											</div class="item">

											<div class="item">
												<input class="item" id="date" name="chng_dt" type="date" />
											</div>

											<div class="item">
												<input class="item note" type="text" name="rmrk" value=""
													placeholder="입력하세요" />
											</div>
										</div>






<!-- 										</div> -->
										<div>
											<input type="hidden" name="command" value="insert"> 
											<input class="btn" type="submit" value="추가">
										</div>

									</form>





								</div>




							</div>

<!-- 							<div class="div_btn"> -->

<!-- 								<div class="div_none"> -->
<!-- 									빈 공간 -->
<!-- 								</div> -->

<!-- 								추가 input을 만드는 버튼 -->
<!-- 								<div class="div_btn_input_add"> -->
<!-- 									<button type="button" id="btn_input_add" class="btn_input_add">입력추가</button> -->
<!-- 								</div> -->

<!-- 								<div class="div_none"> -->
<!-- 									빈 공간 -->
<!-- 								</div> -->

<!-- 								확인 버튼 -->
<!-- 								<div class="div_btn_add_confirm"> -->
<!-- 									<button type="button" id="btn_add_confirm"> -->
<!-- 										<a class="btn_text_color" href="./TestMM_main_park.html">확인</a> -->
<!-- 									</button> -->
<!-- 								</div> -->
<!-- 							</div> -->

						</div>
					</div>

				</div>
			</div>

</body>

</html>