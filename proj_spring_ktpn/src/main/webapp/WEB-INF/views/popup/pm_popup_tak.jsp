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
<!-- 여기에 css,js 파일옮기기 -->
<link rel="stylesheet"
	href="resources/css/Production management_tak.css">
<script src="resources/js/pm_popup_tak.js"></script>
<!-- <script src="Production management_tak.js"></script> -->

</head>

<body>
	<!-- 생산라인수정창 -->
	<div class="ssretouch_box1">
		<div class="pm_correction">
			<div class="boxTit">생산 관리</div>
			<div class="pm_ssmanu">
				<div>
					<!-- 							<form method="post" action="tb_pr_mt"> -->
					<div>
						<div class="pm_correction_con" style="margin: 10px 20px 5px 0;">
							<div style="margin-right: 60px;">라인 :</div>
							<div>
								<select id="select1" name="liunNm" onchange="change1()">
									<option value="선택">선택</option>
									<c:forEach var="dto" items="${md_1000mt_L }">
										<option mt_mng_cd="${dto.MT_MNG_CD }"
											value="${dto.MT_MNG_NM }">${dto.MT_MNG_NM }</option>
									</c:forEach>
								</select>
							</div>

						</div>



						<input type="hidden" id="mtMngCd" name="mtMngCd" value="">

						<div class="pm_correction_con" style="margin: 10px 20px 5px 0;">
							<div style="width: 80px;">생산 코드 :</div>
							<div>
								<!-- 같이 받을 데이터 변수에 넣어서 출력 -->
								<select id="select2" name="prodcd" onchange="change2()">
									<option value="선택">선택</option>
									<c:forEach var="dto" items="${pm_1000mt_N }">
										<option value="${dto.prod_cd }" indc_qntt1="${dto.indc_qntt }">
											${dto.prod_cd }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>

					<input type="hidden" id="indc_qntt" name="indcQntt"
						value="${dto.indc_qntt }">

					<div class="pm_correction_con">
						<div style="width: 100px;">품목코드:</div>
						<select class="itemCd" id="MT_MNG_CD" name="itemCd">
							<c:forEach var="dto" items="${md_1000mt_P }">
								<option value="${dto.MT_MNG_CD }">${dto.MT_MNG_CD }</option>
							</c:forEach>
						</select>
						<!-- <div class="itemCd" type="text" style="width: 50px;">SS-01</div> -->
					</div>
					<div class="pm_correction_con">
						<div class="timeSet" style="width: 100px;">생산시작시간:</div>
						<input id="newDate" type="text" style="color: gray;"
							name="PROD_STRT_TIME" value="현재 시간">
					</div>
					<div class="pm_correction_con">
						<div style="width: 100px;">생산자:</div>
						<select name=workNm id="mbr_nm">
							<c:forEach var="dto" items="${mb_1000mt }">
								<option value="${dto.mbr_nm }">${dto.mbr_nm }</option>
							</c:forEach>
						</select>
					</div>
					<div class="pm_correction_con">
						<div style="width: 100px;">품명:</div>
						<select class="itemNm" name="itemNm" id="MT_MNG_NM">
							<c:forEach var="dto" items="${md_1000mt_P }">
								<option value="${dto.MT_MNG_NM }">${dto.MT_MNG_NM }</option>
							</c:forEach>
						</select>
					</div>

					<div class="ttssText1">
						<div class="pm_correction_con" style="margin: 10px 20px 5px 0;">
							<div class="sstext" style="width: 100px;">생산수량 :</div>
							<input name="prodQntt" id="prodQntt" value="">
						</div>
					</div>
					<div class="ttssText2 hide">
						<div class="pm_correction_con" style="margin: 10px 20px 5px 0;">
							<div class="sstext" style="width: 100px;">불량수량 :</div>
							<input name="dfcRt" id="dfcRt" value="">
						</div>
					</div>
					<div class="pm_correction_but">
						<select class="pm_correction_but_con" id="crud" name="command">
							<option value="insert">시작</option>
							<option value="update">수정</option>
							<option value="complete">완료</option>
						</select> <input type="hidden" name="type" value="${type}">
						<div style="margin: 0;">
							<input class="pm_correction_but_con end" id="modify" type="button"
								value="등록">

							<!--<button type="submit" name="command", value="update">등록</button> -->
						</div>
					</div>
				</div>
				<!-- 							</form> -->
			</div>
			</dlv>
		</div>
		<script>
//데이터 가져올때 연관된 데이터 한번에 가져오는 코드 라인명에 맞는 라인코드
function change1() {

	var select = document.getElementById('select1');
	var select_option = select.options[select.selectedIndex];

	var mt_mng_cd = select_option.getAttribute("MT_MNG_CD");
	console.log("MT_MNG_CD : ", mt_mng_cd);
	document.getElementById('mtMngCd').value = mt_mng_cd;
}

function change2() {
	const select = document.getElementById('select2');
	const selectedOption = select.options[select.selectedIndex];

	if (!selectedOption || selectedOption.value === "선택") return;

	// 연관 속성 값 가져오기
	const mtMngCd = selectedOption.getAttribute("mtMngCd");
	const liunNm = selectedOption.getAttribute("liunNm");
	const itemNm = selectedOption.getAttribute("itemNm");
	const itemCd = selectedOption.getAttribute("itemCd");
	const mbrNm = selectedOption.getAttribute("mbrNm");
	const prodQntt = selectedOption.getAttribute("prodQntt");
	const indc_qntt = selectedOption.getAttribute("indc_qntt1");

	console.log("선택된 생산코드 속성:", {
		mtMngCd,
		liunNm,
		itemNm,
		itemCd,
		mbrNm,
		prodQntt,
		indc_qntt
	});

	// 값 자동 세팅
	if (mtMngCd) document.getElementById("mtMngCd").value = mtMngCd;
	if (liunNm) document.getElementById("select1").value = liunNm;
	if (itemNm) document.getElementById("MT_MNG_NM").value = itemNm;
	if (itemCd) document.getElementById("MT_MNG_CD").value = itemCd;
	if (mbrNm) document.getElementById("mbr_nm").value = mbrNm;
	if (prodQntt) document.getElementById("prodQntt").value = prodQntt;
	if (indc_qntt) document.getElementById("indc_qntt").value = indc_qntt;
}
</script>
</body>

<script>
let pmBut = document.querySelector('.pm_correction_but_con')
pmBut.addEventListener('change', function (evt) {

    if (pmBut.value == 'insert') {
      //작업전 생산코드 표출
        var select_N = document.querySelector('#select2');
        select_N.innerHTML=`
		<option value="선택">선택</option>
						<c:forEach var="dto" items="${pm_1000mt_N }">
							<option value="${dto.prod_cd }" indc_qntt1="${dto.indc_qntt }">
								${dto.prod_cd }</option>
						</c:forEach>
	`;
        
    }else if (pmBut.value == 'update'){

      //작업전중생산코드 표출
        var select_Y = document.querySelector('#select2');
        select_Y.innerHTML=`
		<option value="선택">선택</option>
						<c:forEach var="dto" items="${pm_1100mt_Y }">
							<option value="${dto.prod_cd }" indc_qntt1="${dto.indc_qntt }"
								mtMngCd="${dto.mt_mng_cd }"
								liunNm="${dto.liun_nm}"
								itemNm="${dto.item_nm}"
								itemCd="${dto.item_cd}"
								mbrNm="${dto.work_nm}"
								prodQntt="${dto.prod_qntt}">
								${dto.prod_cd }</option>
						</c:forEach>
	`;
	
	
	
    }else if (pmBut.value == 'complete'){
		
//작업전중생산코드 표출
        var select_Y = document.querySelector('#select2');
        select_Y.innerHTML=`
		<option value="선택">선택</option>
						<c:forEach var="dto" items="${pm_1100mt_Y }">
							<option value="${dto.prod_cd }" indc_qntt1="${dto.indc_qntt }"
									mtMngCd="${dto.mt_mng_cd }"	
									liunNm="${dto.liun_nm}"
									itemNm="${dto.item_nm}"
									itemCd="${dto.item_cd}"
									mbrNm="${dto.work_nm}"
									prodQntt="${dto.prod_qntt}">
								${dto.prod_cd }</option>
						</c:forEach>
	`;
	
    }
})


//등록 클릭시 해당 데이터 보냄
	document.querySelector("#modify").addEventListener("click",
			function(event) {
				event.preventDefault();
				// 		document.querySelector("#form").submit()
	
				
	const mt_mng_nm_l = document.querySelector('#select1').value 
	const mt_mng_cd_l = document.querySelector('#mtMngCd').value 
	const prod_cd = document.querySelector('#select2').value 
	const indc_qntt = document.querySelector('#indc_qntt').value 
	const mt_mng_nm_p = document.querySelector('#MT_MNG_NM').value 
	const mt_mng_cd_p = document.querySelector('#MT_MNG_CD').value 
	const mbr_nm = document.querySelector('#mbr_nm').value 
	const prodQntt = document.querySelector('#prodQntt').value 
	const dfcRt = document.querySelector('#dfcRt').value 
	const crud = document.getElementById("crud").value 
console.log("mt_mng_nm_l : "+ mt_mng_nm_l )
console.log("mt_mng_cd_l : "+ mt_mng_cd_l )
console.log("prod_cd : "+ prod_cd )
console.log("indc_qntt : "+ indc_qntt )
console.log("mt_mng_nm_p : "+ mt_mng_nm_p )
console.log("mt_mng_cd_p : "+ mt_mng_cd_p )
console.log("mbr_nm : "+ mbr_nm )
console.log("prodQntt : "+ prodQntt )
console.log("dfcRt : "+ dfcRt )
console.log("crud : "+ crud )
					let param = {
						mt_mng_cd : mt_mng_cd_l,
						liun_nm : mt_mng_nm_l,
						item_nm : mt_mng_nm_p,
						item_cd : mt_mng_cd_p,
						indc_qntt : indc_qntt,
						prod_qntt : prodQntt,
						work_nm : mbr_nm,
						dfc_rt : dfcRt,
						prod_cd : prod_cd
					};
				
					let param2 = {
							dfc_rt : dfcRt,
							prod_cd : prod_cd
						};
				if (crud == "update") {

					// ajax
					const xhr = new XMLHttpRequest()
					xhr.open('put', 'pm_popup')
					xhr.setRequestHeader('Content-Type', 'application/json')
					xhr.send(JSON.stringify(param))
					console.log("param : ", param )
					xhr.onload = function() {
						if (xhr.responseText == '1') {
							alert('수정 완료')
							location.href = 'pm_popup'
						} else {
							alert('수정 실패')
						}
					}

				}else if(crud == "complete"){
					// ajax
					const xhr = new XMLHttpRequest()
					xhr.open('put', 'pm_popup_complete')
					xhr.setRequestHeader('Content-Type', 'application/json')
					xhr.send(JSON.stringify(param2))
					console.log("param2 : ", param2 )
					xhr.onload = function() {
						if (xhr.responseText == '1') {
							alert('수정 완료')
							location.href = 'pm_popup'
						} else {
							alert('수정 실패')
						}
					}
				}else if(crud == "insert"){
					// ajax
					const xhr = new XMLHttpRequest()
					xhr.open('put', 'pm_popup_insert')
					xhr.setRequestHeader('Content-Type', 'application/json')
					xhr.send(JSON.stringify(param))
					console.log("param : ", param )
					xhr.onload = function() {
						if (xhr.responseText == '1') {
							alert('등록 완료')
							location.href = 'pm_popup'
						} else {
							alert('등록 실패')
						}
					}
				}
			})
			
</script>

</html>
