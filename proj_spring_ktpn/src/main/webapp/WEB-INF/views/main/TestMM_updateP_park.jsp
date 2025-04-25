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
<link rel="stylesheet" href="resources/css/TestMM_update_park.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="resources/js/layOut_kwak.js"></script>
<script src="resources/js/TestMM_update_park.js" defer></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<body>
	<div class="menuPage-con">
		<!-- html 들어갈 곳 -->
		<!-- TestMM_update -->

		<div class="containerMM_update">
			<div class="content">

				<div class="margin">

					<div class="tab-name-con">
						<div class="tab-name">재고 수정</div>
					</div>

					<!-- <div class="div_none"></div> -->
					<form method="post" action="updatep2">
						<div class="table_scroll">
							<table class="material-table">
								<thead>
									<tr>
										<th scope="col" class="material-th">생산코드</th>
										<th scope="col" class="material-th">완제품코드</th>
										<th scope="col" class="material-th">완제품명</th>
										<th scope="col" class="material-th">입력 수량</th>
										<th scope="col" class="material-th">입고/출고</th>
										<th scope="col" class="material-th">작업자</th>
										<th scope="col" class="material-th">위치</th>
										<th scope="col" class="material-th">입력일</th>
										<th scope="col" class="material-th">비고</th>



									</tr>
								</thead>

								<tbody>
									<!-- 											완제품 테이블 값 pList -->

									<tr>
										<td class="material-td Mcode">
											<select id="select" name="prod_cd" onchange="changeEA()">
												<option value="default" selected="selected">선택</option>
												<c:forEach var="pcode" items="${pList }">
													<option value="${pcode.prod_cd }"
														auto_iea="${pcode.prod_qntt }">${pcode.prod_cd }</option>
												</c:forEach>
											</select>
										</td>
										
										<script>
											// 생산코드를 선택하면 수량도 자동으로 입력
											function changeEA() {
												var select = document.querySelector('#select');
												var select_option = select.options[select.selectedIndex];
										
												var auto_iea = select_option.getAttribute('auto_iea');
												document.querySelector('#fpea').value = auto_iea;
											}
											
										</script>

										<td id="Mcode" class="material-td Mcode"><input
											type="text" name="fnsh_code" value="${dto.fnsh_code }" readonly="readonly">
										</td>

										<td id="Mname" class="material-td"><input type="text"
											name="fnshd_item_nm" value="${dto.fnsh_nm }" readonly="readonly">
										</td>

										<td id="Mea" class="material-td"><input id="fpea" type="text"
											name="crnt_cnt" value="" readonly="readonly"></td>

										<td id="" class="material-td"><select name="iob_se_cd">
												<option value="i">입고</option>
												<option value="o">출고</option>
										</select></td>

										<td id="" class="material-td"><select name="work_nm">
												<c:forEach var="member" items="${mList }">
													<option value="${member.mbr_nm }">${member.mbr_nm }</option>
												</c:forEach>
										</select></td>

										<td id="Mloc" class="material-td"><select
											name="fnshl_loc_nm">
												<option value="P창고1">P창고1</option>
												<!--                                     						<option value="warehouse2">P창고2</option> -->
												<!--                                     						<option value="warehouse3">P창고3</option> -->

										</select></td>

										<td id="Mloc" class="material-td"><input class="item"
											id="date" name="chng_dt" type="date" /></td>

										<td id="Mloc" class="material-td"><input
											class="item note" type="text" name="rmrk" value=""
											placeholder="입력" /></td>

									</tr>
								</tbody>
							</table>
						</div>
						<div>
							<input type="hidden" name="command" value="update"> 
							<input class="btn" type="submit" value="확인">
						</div>
					</form>

					<!-- 								원자재와 완제품의 입고와 출고 
									
									원자재 추가 => 최초 1회, 목록에 없을 때 목록에 추가- 입고만 가능
									원자재 수정 => 목록에 있으면 입고, 출고 가능
									
									완제품 추가 => 최초 1회, 목록에 없을 때 목록에 추가- 입고만 가능
									완제품 수정 => 목록에 있으면 입고, 출고 가능 - 
													생산코드를 선택하면 완제품코드와 완제품명 수량이 같이 적용
 -->

<!-- 					<div class="div_none"> -->
<!-- 						빈 공간 -->
<!-- 					</div> -->

<!-- 					<div class="div_button"> -->
<!-- 						<button type="button" id="btn_update_confirm"> -->
<!-- 							<a class="btn_text_color" href="./TestMM_main_park.html">확인</a> -->
<!-- 						</button> -->
<!-- 					</div> -->
				</div>

			</div>

		</div>

	</div>

</body>

</html>