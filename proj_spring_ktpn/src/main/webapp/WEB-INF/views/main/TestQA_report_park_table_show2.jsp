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
						<div class="tab-name">제품 리포트</div>
					</div>

					<div class="div_report_parent">
						<div class="div_report_name"></div>


						<div class="t_con">
							<form method="get" action="mainqc">
								<div class="con_1">

									<table class="qtable">
										<thead>
											<tr class="qtable-tr1">
												<th class="">항목</th>
												<th class="">내용</th>

												<th class="">항목</th>
												<th class="">내용</th>
											</tr>
										</thead>

										<tbody>

											<!-- 													생산내용과 품질내용 합친 조인 테이블 - QcList -->


											<tr>
												<th class="qc-title">
													<p>1. 생산코드</p>
												</th>
												<td>${QcList[0].prod_cd }</td>

												<th class="qc-title">
													<p>9. 검수자</p>
												</th>
												<td>${QcList[0].chckr_nm }</td>
											</tr>

											<tr>
												<th class="qtable-th qc-title">
													<p>2. 품목코드</p>
												</th>
												<td class="qtable-td">${QcList[0].item_cd }</td>

												<th class="qc-title">
													<p>10. 검수일</p>
												</th>
												<td>${QcList[0].chckr_dttm }
												</td>
											</tr>

											<tr>
												<th class="qc-title">
													<p>3. 품목명</p>
												</th>
												<td>${QcList[0].item_nm }</td>

												<th class="qc-title">
													<p>11. 강도값</p>
												</th>
												<td>${QcList[0].strth_val }</td>
											</tr>

											<tr>
												<th class="qc-title">
													<p>4. 작업자</p>
												</th>
												<td>${QcList[0].work_nm }</td>

												<th class="qc-title">
													<p>12. 크기값</p>
												</th>
												<td>${QcList[0].sz_val }</td>
											</tr>

											<tr>
												<th class="qc-title">
													<p>5. 생산완료시간</p>
												</th>
												<td>${QcList[0].prod_end_time }</td>

												<th class="qc-title">
													<p>13. 색상값</p>
												</th>
												<td><div class="QA-td-color1" style="background-color: ${QcList[0].clrl_val }"></div>&nbsp;${QcList[0].clrl_val }</td>
											</tr>

											<tr>
												<th class="qc-title">
													<p>6. 지시수량</p>
												</th>
												<td>${QcList[0].indc_qntt }</td>

												<th class="qc-title">
													<p>14. 품질값</p>
												</th>
												<td>${QcList[0].qlty_val }</td>
											</tr>

											<tr>
												<th class="qc-title">
													<p>7. 생산수량</p>
												</th>
												<td>${QcList[0].prod_qntt }</td>

												<th class="qc-title">
													<p>15. 불합격사유</p>
												</th>
												<td>${QcList[0].fail_caus_desc }</td>
											</tr>

											<tr>
												<th class="qc-title">
													<p>8. 불량수량</p>
												</th>
												<td>${QcList[0].dfc_rt }</td>

												<th class="qc-title">
													<p>16. 비고</p>
												</th>
												<td>${QcList[0].rmrk }</td>
											</tr>

										</tbody>
									</table>

								</div>

								<div class="div_button">
									<div class="div_none">
										<!-- 빈 공간 -->
									</div>

									<button type="submit" id="btn_report_confirm" name="command"
										value="move_main_page">확인</button>

									<!-- 											<button type="button" id="btn_report_confirm"> -->
									<!-- 												<a class="btn_text_color" href="./TestQA_main_park.jsp">확인</a> -->
									<!-- 											</button> -->

									<div class="div_none">
										<!-- 빈 공간 -->
									</div>
								</div>

							</form>
						</div>

					</div>
				</div>
			</div>

		</div>

	</div>

</body>

</html>