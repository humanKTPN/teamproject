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
<link rel="stylesheet" href="resources/css/layOut_kwak.css">
<link rel="stylesheet" href="resources/css/Production reporting_tak.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="resources/js/layOut_kwak.js"></script>
<script src="resources/js/Production reporting_tak.js"></script>
<script src="resources/js/echarts.min_tak.js"></script>
<style>
/******************
            모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>


</head>

<body>
	<div class="menuPage-con">
		<!-- html 들어갈 곳 -->
		<div id="work4">
			<div class="pr_box1">
				<div class="date_box">
					<table class="date_box_manu">
						<tr>
							<td class="date_point date_ssManu1 date_ssList1 point2">일별
								생산량</td>
							<td class="date_point date_ssManu2 date_ssList2">주간별 생산량</td>
							<td class="date_point date_ssManu3 date_ssList3">월별생산량</td>
						</tr>
					</table>
					<div class="ssgraph" id="date_ssManu1">
						<div class="graph_wrap">
							<select class="line_graph_day" style="margin: 10px;">
								<option value="1">A라인</option>
								<option value="2">B라인</option>
								<option value="3">C라인</option>
							</select>
							<!-- 일별 A 라인 -->
							<div class="graph_box_day_a">
								<!--그래프 js-->
								<!-- 1단계: ECharts 설치하기 -->
								<!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
								<div style="font-weight: 600;">1호기</div>
								<div id="main1_day_a" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">2호기</div>
								<div id="main2_day_a" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">3호기</div>
								<div id="main3_day_a" style="width: 100%; height: 190px;"></div>
								<!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

							</div>
							<!-- 일별 B 라인 -->
							<div class="graph_box_day_b hide">
								<!--그래프 js-->
								<!-- 1단계: ECharts 설치하기 -->
								<!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
								<div style="font-weight: 600;">1호기</div>
								<div id="main1_day_b" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">2호기</div>
								<div id="main2_day_b" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">3호기</div>
								<div id="main3_day_b" style="width: 100%; height: 190px;"></div>
								<!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

							</div>
							<!-- 일별 C 라인 -->
							<div class="graph_box_day_c hide">
								<!--그래프 js-->
								<!-- 1단계: ECharts 설치하기 -->
								<!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
								<div style="font-weight: 600;">1호기</div>
								<div id="main1_day_c" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">2호기</div>
								<div id="main2_day_c" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">3호기</div>
								<div id="main3_day_c" style="width: 100%; height: 190px;"></div>
								<!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

							</div>
						</div>
					</div>
					<div class="ssgraph hide" id="date_ssManu2">
						<div class="graph_wrap">
							<select class="line_graph_week" style="margin: 10px;">
								<option value="1">A라인</option>
								<option value="2">B라인</option>
								<option value="3">C라인</option>
							</select>
							<!-- 주별 A 라인 -->
							<div class="graph_box_week_a">
								<!--그래프 js-->
								<!-- 1단계: ECharts 설치하기 -->
								<!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
								<div style="font-weight: 600;">1호기</div>
								<div id="main1_week_a" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">2호기</div>
								<div id="main2_week_a" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">3호기</div>
								<div id="main3_week_a" style="width: 100%; height: 190px;"></div>
								<!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

							</div>
							<!-- 주별 B 라인 -->
							<div class="graph_box_week_b hide">
								<!--그래프 js-->
								<!-- 1단계: ECharts 설치하기 -->
								<!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
								<div style="font-weight: 600;">1호기</div>
								<div id="main1_week_b" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">2호기</div>
								<div id="main2_week_b" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">3호기</div>
								<div id="main3_week_b" style="width: 100%; height: 190px;"></div>
								<!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

							</div>
							<!-- 주별 C 라인 -->
							<div class="graph_box_week_c hide">
								<!--그래프 js-->
								<!-- 1단계: ECharts 설치하기 -->
								<!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
								<div style="font-weight: 600;">1호기</div>
								<div id="main1_week_c" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">2호기</div>
								<div id="main2_week_c" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">3호기</div>
								<div id="main3_week_c" style="width: 100%; height: 190px;"></div>
								<!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

							</div>
						</div>
					</div>
					<div class="ssgraph hide" id="date_ssManu3">
						<div class="graph_wrap">
							<select class="line_graph_month" style="margin: 10px;">
								<option value="1">A라인</option>
								<option value="2">B라인</option>
								<option value="3">C라인</option>
							</select>
							<!-- 월별 A 라인 -->
							<div class="graph_box_month_a">
								<!--그래프 js-->
								<!-- 1단계: ECharts 설치하기 -->
								<!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
								<div style="font-weight: 600;">1호기</div>
								<div id="main1_month_a" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">2호기</div>
								<div id="main2_month_a" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">3호기</div>
								<div id="main3_month_a" style="width: 100%; height: 190px;"></div>
								<!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

							</div>
							<!-- 월별 B 라인 -->
							<div class="graph_box_month_b hide">
								<!--그래프 js-->
								<!-- 1단계: ECharts 설치하기 -->
								<!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
								<div style="font-weight: 600;">1호기</div>
								<div id="main1_month_b" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">2호기</div>
								<div id="main2_month_b" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">3호기</div>
								<div id="main3_month_b" style="width: 100%; height: 190px;"></div>
								<!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

							</div>
							<!-- 월별 C 라인 -->
							<div class="graph_box_month_c hide">
								<!--그래프 js-->
								<!-- 1단계: ECharts 설치하기 -->
								<!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
								<div style="font-weight: 600;">1호기</div>
								<div id="main1_month_c" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">2호기</div>
								<div id="main2_month_c" style="width: 100%; height: 190px;"></div>
								<div style="font-weight: 600;">3호기</div>
								<div id="main3_month_c" style="width: 100%; height: 190px;"></div>
								<!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

							</div>
						</div>
					</div>
				</div>



				<div class="totalBox">
					<div class="numberBox">
						<div class="pr_boxTit">호기별 생산량 조회</div>
						<hr>
						<div
							style="display: flex; justify-content: space-evenly; margin-bottom: 15px;">
							<div>라인 :</div>
							<select class="mu_box">
								<option value="1">A라인 1호기</option>
								<option value="2">A라인 2호기</option>
								<option value="3">A라인 3호기</option>
								<option value="4">B라인 1호기</option>
								<option value="5">B라인 2호기</option>
								<option value="6">B라인 3호기</option>
								<option value="7">C라인 1호기</option>
								<option value="8">C라인 2호기</option>
								<option value="9">C라인 3호기</option>
							</select>

						</div>
						<div class="ssTable">
							<table>
								<tr>
									<th class="es1">기간별</th>
									<th class="es2">생산량</th>
								</tr>
								<tr>
									<td class="es1">금일 생산량</td>
									<td class="es2" id="es_0">${LineA1.total_prod_qntt }</td>
								</tr>
								<tr>
									<td class="es1">금주 생산량</td>
									<td class="es2" id="es_1">${LineA1_week.total_prod_qntt }</td>
								</tr>
								<tr>
									<td class="es1">금월 생산량</td>
									<td class="es2" id="es_2">${LineA1_month.total_prod_qntt }</td>
								</tr>
								<tr>
									<td class="es1">금월 불량률</td>
									<td class="es2" id="es_3">${LineA1_month_DR.defect_rate }%(${LineA1_month_DR.total_dfc_rt })</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="pr_box2">
						<!-- 가동설비현황 박스 -->
						<div class="ingBox">
							<div class="pr_boxTit">가동 설비 현황</div>
							<hr>
							<div class="ssTable">
								<table>
									<tr>
										<th class="es1">설비명</th>
										<th class="es2">가동상태</th>
									</tr>
									<tr>
										<td class="es1 NY11">A라인1호기</td>
										<td class="es2 NY1">정지</td>
									</tr>
									<tr>
										<td class="es1 NY22">A라인2호기</td>
										<td class="es2 NY2">정지</td>
									</tr>
									<tr>
										<td class="es1 NY33">A라인3호기</td>
										<td class="es2 NY3">정지</td>
									</tr>
									<tr>
										<td class="es1 NY44">B라인1호기</td>
										<td class="es2 NY4">정지</td>
									</tr>
									<tr>
										<td class="es1 NY55">B라인2호기</td>
										<td class="es2 NY5">정지</td>
									</tr>
									<tr>
										<td class="es1 NY66">B라인3호기</td>
										<td class="es2 NY6">정지</td>
									</tr>

									<tr>
										<td class="es1 NY77">C라인1호기</td>
										<td class="es2 NY7">정지</td>
									</tr>
									<tr>
										<td class="es1 NY88">C라인2호기</td>
										<td class="es2 NY8">정지</td>
									</tr>
									<tr>
										<td class="es1 NY99">C라인3호기</td>
										<td class="es2 NY9">정지</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="main_date_pi">
			<div class="date_list">
				<!-- 일별,품목별 총생산량 박스 -->
				<div class="date_ssBox" id="date_ssList1">
					<div class="date_ssBox_tit">일별 생산량</div>
					<div class="date_ssTable">
						<table class="sticky">
							<tr>
								<th class="es3">설비명</th>
								<th class="es4">생산량</th>
								<th class="es5">설비명</th>
								<th class="es6">생산량</th>
								<th class="es7">설비명</th>
								<th class="es8">생산량</th>
							</tr>
							<tr>
								<td class="es3">A라인 1호기</td>
								<td class="es4">${LineA1.total_prod_qntt }</td>
								<td class="es5">B라인 1호기</td>
								<td class="es6">${LineB1.total_prod_qntt }</td>
								<td class="es7">C라인 1호기</td>
								<td class="es8">${LineC1.total_prod_qntt }</td>
							</tr>
							<tr>
								<td class="es3">A라인 2호기</td>
								<td class="es4">${LineA2.total_prod_qntt }</td>
								<td class="es5">B라인 2호기</td>
								<td class="es6">${LineB2.total_prod_qntt }</td>
								<td class="es7">C라인 2호기</td>
								<td class="es8">${LineC2.total_prod_qntt }</td>
							</tr>
							<tr>
								<td class="es3">A라인 3호기</td>
								<td class="es4">${LineA3.total_prod_qntt }</td>
								<td class="es5">B라인 3호기</td>
								<td class="es6">${LineB3.total_prod_qntt }</td>
								<td class="es7">C라인 3호기</td>
								<td class="es8">${LineC3.total_prod_qntt }</td>
							</tr>
						</table>
					</div>
					<div class="date_ssBox_tit">품목별 금일 총 생산량</div>
					<select class="pr_bay" style="margin-left: 20px;">
						<option value="1">싹싹지우개</option>
						<option value="2">하츄핑지우개</option>
					</select>
					<div class="ssTotal" id="ssTotal1">${selectSSG.total_prod_qntt_ssg}</div>
				</div>
				<!-- 주간별,품목별 총생산량 박스 -->
				<div class="date_ssBox hide" id="date_ssList2">
					<div class="date_ssBox_tit">주간별 생산량</div>
					<div class="date_ssTable">
						<table class="sticky">
							<tr>
								<th class="es3">설비명</th>
								<th class="es4">생산량</th>
								<th class="es5">설비명</th>
								<th class="es6">생산량</th>
								<th class="es7">설비명</th>
								<th class="es8">생산량</th>
							</tr>
							<tr>
								<td class="es3">A라인 1호기</td>
								<td class="es4">${LineA1_week.total_prod_qntt }</td>
								<td class="es5">B라인 1호기</td>
								<td class="es6">${LineB1_week.total_prod_qntt }</td>
								<td class="es7">C라인 1호기</td>
								<td class="es8">${LineC1_week.total_prod_qntt }</td>
							</tr>
							<tr>
								<td class="es3">A라인 2호기</td>
								<td class="es4">${LineA2_week.total_prod_qntt }</td>
								<td class="es5">B라인 2호기</td>
								<td class="es6">${LineB2_week.total_prod_qntt }</td>
								<td class="es7">C라인 2호기</td>
								<td class="es8">${LineC2_week.total_prod_qntt }</td>
							</tr>
							<tr>
								<td class="es3">A라인 3호기</td>
								<td class="es4">${LineA3_week.total_prod_qntt }</td>
								<td class="es5">B라인 3호기</td>
								<td class="es6">${LineB3_week.total_prod_qntt }</td>
								<td class="es7">C라인 3호기</td>
								<td class="es8">${LineC3_week.total_prod_qntt }</td>
							</tr>
						</table>
					</div>

					<div class="date_ssBox_tit">품목별 주간 총 생산량</div>
					<select class="pm_week" style="margin-left: 20px;">
						<option value="1">싹싹지우개</option>
						<option value="2">하츄핑지우개</option>
					</select>
					<div class="ssTotal" id="ssTotal2">${selectSSG_week.total_prod_qntt_ssg}</div>
				</div>
				<!-- 월별,품목별 총생산량 박스 -->
				<div class="date_ssBox hide" id="date_ssList3">
					<div class="date_ssBox_tit">월별 생산량</div>
					<div class="date_ssTable">
						<table class="sticky">
							<tr>
								<th class="es3">설비명</th>
								<th class="es4">생산량</th>
								<th class="es5">설비명</th>
								<th class="es6">생산량</th>
								<th class="es7">설비명</th>
								<th class="es8">생산량</th>
							</tr>
							<tr>
								<td class="es3">A라인 1호기</td>
								<td class="es4">${LineA1_month.total_prod_qntt }</td>
								<td class="es5">B라인 1호기</td>
								<td class="es6">${LineB1_month.total_prod_qntt }</td>
								<td class="es7">C라인 1호기</td>
								<td class="es8">${LineC1_month.total_prod_qntt }</td>
							</tr>
							<tr>
								<td class="es3">A라인 2호기</td>
								<td class="es4">${LineA2_month.total_prod_qntt }</td>
								<td class="es5">B라인 2호기</td>
								<td class="es6">${LineB2_month.total_prod_qntt }</td>
								<td class="es7">C라인 2호기</td>
								<td class="es8">${LineC2_month.total_prod_qntt }</td>
							</tr>
							<tr>
								<td class="es3">A라인 3호기</td>
								<td class="es4">${LineA3_month.total_prod_qntt }</td>
								<td class="es5">B라인 3호기</td>
								<td class="es6">${LineB3_month.total_prod_qntt }</td>
								<td class="es7">C라인 3호기</td>
								<td class="es8">${LineC3_month.total_prod_qntt }</td>
							</tr>
						</table>
					</div>
					<div class="date_ssBox_tit">품목별 월 총 생산량</div>
					<select class="pm_month" style="margin-left: 20px;">
						<option value="1">싹싹지우개</option>
						<option value="2">하츄핑지우개</option>
					</select>
					<div class="ssTotal" id="ssTotal3">${selectSSG_month.total_prod_qntt_ssg}</div>
				</div>
			</div>
			<div class="main_piBox">
				<!--그래프 js-->
				<!-- 1단계: ECharts 설치하기 -->
				<!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
				<div id="main_pi" style="width: 100%; height: 100%;"></div>
				<!-- 3단계: 초기화 및 차트 옵션 설정하기 -->


				</script>

			</div>
		</div>
	</div>
</body>
<script>

//가동 설비 현황
const selectNY = [
        <c:forEach var="item" items="${selectNY}" varStatus="i">
            {
                liun_nm: "${item.liun_nm}"
            }<c:if test="${!i.last}">,</c:if>
        </c:forEach>
    ];
console.log(selectNY);

    for(let j = 0; j < selectNY.length ; j++){
    	
    	let liun_nm = selectNY[j].liun_nm;  // 배열은 0부터 시작하므로, i-1로 접근
		for (let i = 1; i < 10; i++) {
    	// 템플릿 리터럴을 사용하여 .NYi 클래스를 선택
	
   		let NYII = document.querySelector('.NY'+i+''+i);
    	let NYI = document.querySelector('.NY'+i);
    	console.log(i, NYII )
    	console.log(i, NYI )
    	console.log(liun_nm )
    
   		 // 만약 NYII가 null이 아니면
    	if (NYII) {
        // 'selectNY[i].liun_nm'과 비교
//		let liun_nm = '${selectNY[0].liun_nm}';  // 배열은 0부터 시작하므로, i-1로 접근
            NYI.classList.remove('stop');
            if(NYI.textContent==='정지'){
            	
            	
      	 	 if (NYII.textContent === liun_nm) {
        	    // '가동중' 상태로 변경
            	NYI.textContent = '가동중';
            	NYI.classList.remove('stop');
      	 	 } else {
        	    // '정지' 상태로 변경
           	 NYI.textContent = '정지';
           	 NYI.classList.add('stop');
       	 } 
            	
       }
    }
    }
}



	//라인 호기별 셀렉별 표시변환
	let arr = new Array();
	let mu_box = document.querySelector('.mu_box')
	console.log("mu_box : ", mu_box)
	mu_box.addEventListener('click', function(evt) {
		let mu_boxs = evt.target.value
		console.log("mu_boxs : ", mu_boxs)
		for (let i = 0; i < 4; i++) {
			arr[i] = document.getElementById('es_' + i)
			console.log("요거요거요거요거" + arr[0])
		}
		//A라인 1호기
		if (mu_boxs == "1") {
			arr[0].innerHTML = `${LineA1.total_prod_qntt }`;
			arr[1].innerHTML = `${LineA1_week.total_prod_qntt }`;
			arr[2].innerHTML = `${LineA1_month.total_prod_qntt }`;
			arr[3].innerHTML = `${LineA1_month_DR.defect_rate }%(${LineA1_month_DR.total_dfc_rt })`;
		}
		//A라인 2호기
		else if (mu_boxs == "2") {
			arr[0].innerHTML = `${LineA2.total_prod_qntt }`;
			arr[1].innerHTML = `${LineA2_week.total_prod_qntt }`;
			arr[2].innerHTML = `${LineA2_month.total_prod_qntt }`;
			arr[3].innerHTML = `${LineA2_month_DR.defect_rate }%(${LineA2_month_DR.total_dfc_rt })`;
		}
		//A라인 3호기
		else if (mu_boxs == "3") {
			arr[0].innerHTML = `${LineA3.total_prod_qntt }`;
			arr[1].innerHTML = `${LineA3_week.total_prod_qntt }`;
			arr[2].innerHTML = `${LineA3_month.total_prod_qntt }`;
			arr[3].innerHTML = `${LineA3_month_DR.defect_rate }%(${LineA3_month_DR.total_dfc_rt })`;
		}
		//B라인 1호기
		else if (mu_boxs == "4") {
			arr[0].innerHTML = `${LineB1.total_prod_qntt }`;
			arr[1].innerHTML = `${LineB1_week.total_prod_qntt }`;
			arr[2].innerHTML = `${LineB1_month.total_prod_qntt }`;
			arr[3].innerHTML = `${LineB1_month_DR.defect_rate }%(${LineB1_month_DR.total_dfc_rt })`;
		}
		//B라인 2호기
		else if (mu_boxs == "5") {
			arr[0].innerHTML = `${LineB2.total_prod_qntt }`;
			arr[1].innerHTML = `${LineB2_week.total_prod_qntt }`;
			arr[2].innerHTML = `${LineB2_month.total_prod_qntt }`;
			arr[3].innerHTML = `${LineB2_month_DR.defect_rate }%(${LineB2_month_DR.total_dfc_rt })`;
		}
		//B라인 3호기
		else if (mu_boxs == "6") {
			arr[0].innerHTML = `${LineB3.total_prod_qntt }`;
			arr[1].innerHTML = `${LineB3_week.total_prod_qntt }`;
			arr[2].innerHTML = `${LineB3_month.total_prod_qntt }`;
			arr[3].innerHTML = `${LineB3_month_DR.defect_rate }%(${LineB3_month_DR.total_dfc_rt })`;
		}
		//C라인 1호기
		else if (mu_boxs == "7") {
			arr[0].innerHTML = `${LineC1.total_prod_qntt }`;
			arr[1].innerHTML = `${LineC1_week.total_prod_qntt }`;
			arr[2].innerHTML = `${LineC1_month.total_prod_qntt }`;
			arr[3].innerHTML = `${LineC1_month_DR.defect_rate }%(${LineC1_month_DR.total_dfc_rt })`;
		}
		//C라인 2호기
		else if (mu_boxs == "8") {
			arr[0].innerHTML = `${LineC2.total_prod_qntt }`;
			arr[1].innerHTML = `${LineC2_week.total_prod_qntt }`;
			arr[2].innerHTML = `${LineC2_month.total_prod_qntt }`;
			arr[3].innerHTML = `${LineC2_month_DR.defect_rate }%(${LineC2_month_DR.total_dfc_rt })`;
		}
		//C라인 3호기
		else if (mu_boxs == "9") {
			arr[0].innerHTML = `${LineC3.total_prod_qntt }`;
			arr[1].innerHTML = `${LineC3_week.total_prod_qntt }`;
			arr[2].innerHTML = `${LineC3_month.total_prod_qntt }`;
			arr[3].innerHTML = `${LineC3_month_DR.defect_rate }%(${LineC3_month_DR.total_dfc_rt })`;
		}

	})
	
	
	//원형 그래프
	let myChart_pi = echarts.init(document.getElementById('main_pi'))

        option = {
            title: {
                text: '월 통계 자료',
                subtext: '',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            series: [
                {
                    name: 'KTPN',
                    type: 'pie',
                    radius: '50%',
                    data: [
                        { value: ${selectSS_IQ.total_prod_qntt}, name: '월 목표량' },
                        { value: ${selectSS.total_prod_qntt}, name: '월 생산량' },
                        { value: ${selectSS_DR.total_dfc_rt}, name: '월 불량수량' },
                    ],
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myChart_pi.setOption(option)
        
        
  //품목별 생산량
  let pr_bay = document.querySelector('.pr_bay')
    console.log("pr_bay : ", pr_bay)
    pr_bay.addEventListener('change', function (evt) {
        let pr_bays = evt.target.value
        console.log("pr_bays : ", pr_bays)
        let ssTotal1 = document.querySelector('#ssTotal1')
        console.log("bbbbb", ssTotal1)

        if (pr_bays == "1") {
            ssTotal1.innerHTML = `${selectSSG.total_prod_qntt_ssg}`;
        } else if (pr_bays == "2") {
            ssTotal1.innerHTML = `${selectHH.total_prod_qntt_hh}`;
        } 
    })

    //품목별 주간별 총 생산량 셀렉별 표시변환
    let pm_week = document.querySelector('.pm_week')
    console.log("pm_week : ", pm_week)
    pm_week.addEventListener('change', function (evt) {
        let pm_weeks = evt.target.value
        console.log("pm_weeks : ", pm_weeks)
        let ssTotal2 = document.querySelector('#ssTotal2')
        console.log("bbbbb", ssTotal2)

        if (pm_weeks == "1") {
            ssTotal2.innerHTML = `${selectSSG_week.total_prod_qntt_ssg}`;
        } else if (pm_weeks == "2") {
            ssTotal2.innerHTML = `${selectHH_week.total_prod_qntt_hh}`;
        } 
    })

    //품목별 월별 총 생산량 셀렉별 표시변환
    let pm_month = document.querySelector('.pm_month')
    console.log("pm_month : ", pm_month)
    pm_month.addEventListener('change', function (evt) {
        let pm_months = evt.target.value
        console.log("pm_months : ", pm_months)
        let ssTotal3 = document.querySelector('#ssTotal3')
        console.log("bbbbb", ssTotal3)

        if (pm_months == "1") {
            ssTotal3.innerHTML = `${selectSSG_month.total_prod_qntt_ssg}`;
        } else if (pm_months == "2") {
            ssTotal3.innerHTML = `${selectHH_month.total_prod_qntt_hh}`;
        }
    })
</script>
</html>