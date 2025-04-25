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
<link rel="stylesheet"
	href="resources/css/Production management_tak.css">
<script src="resources/js/pr_popup_tak.js"></script>
<!-- <script src="Production management_tak.js"></script> -->


</head>

<body>
	<div class="ssretouch_box2">
		<dlv class="pm_correction">
		<div class="boxTit">생산 관리</div>
		<div class="pr_ssmanu">
			<div class="ssTitle" style="margin: 15px 0 0;">생산 일정 관리</div>
			<div>


				<div class="pr_correction_con">
					<div style="width: 100px;">생산일정코드:</div>
					<span>자동생성</span>
				</div>

				<div class="pr_correction_con">
					<div style="width: 100px;">품명:</div>
					<select class="itemNm" name="itemNm" id="itemNm">
						<c:forEach var="dto" items="${md_1000mt_P }">
							<option value="${dto.MT_MNG_NM }">${dto.MT_MNG_NM }</option>
						</c:forEach>
					</select>
				</div>
				<div class="pr_correction_con">
					<div style="width: 100px;">품목 코드:</div>
					<select class="itemCd" id="itemCd" name="itemCd">
						<c:forEach var="dto" items="${md_1000mt_P }">
							<option value="${dto.MT_MNG_CD }">${dto.MT_MNG_CD }</option>
						</c:forEach>
					</select>
				</div>
				<div class="pr_correction_con " id="select2">
					<div style="width: 100px;">목표 수량:</div>
					<input type="text" style="height: 18px;" id="trgProdCnt"
						name="trgProdCnt" value="">
				</div>
				<div class="pr_correction_con">
					<div style="width: 150px;">기한설정:</div>
					<div class="pr_date">
						<input type="date" id="prodStrtDt" name="prodStrtDt" value=""
							style="height: 20px; width: 60%;">&nbsp;&nbsp;부터&nbsp;&nbsp;
						<input type="date" id="prodEndDt" name="prodEndDt" value=""
							style="height: 20px; width: 60%;">&nbsp;&nbsp;까지&nbsp;&nbsp;
					</div>
				</div>
				<div class="pm_correction_but">
					<select id="crud" class="pm_correction_but_con" name="command">
						<option value="insert">시작</option>
						<option value="update">수정</option>
						<option value="complete">완료</option>
					</select> <input type="hidden" name="type" value="${type}">
					<div class="end" style="margin: 0;">
						<input class="pm_correction_but_con" id="modify" type="button"
							value="등록">
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
			<script>
//데이터 가져올때 연관된 데이터 한번에 가져오는 코드 라인명에 맞는 라인코드

function change1() {
	const select = document.getElementById('select1');
	const selectedOption = select.options[select.selectedIndex];


	// 연관 속성 값 가져오기
	const trgProdCnt = selectedOption.getAttribute("trgProdCnt");
	const itemNm = selectedOption.getAttribute("itemNm");
	const itemCd = selectedOption.getAttribute("itemCd");
	const prodStrtDt = selectedOption.getAttribute("prodStrtDt");
	const prodEndDt = selectedOption.getAttribute("prodEndDt");

	console.log("선택된 생산코드 속성:", {
		itemNm,
		itemCd,
	});

	// 값 자동 세팅
	if (trgProdCnt) document.getElementById("trgProdCnt").value = trgProdCnt;
	if (itemNm) document.getElementById("itemNm").value = itemNm;
	if (itemCd) document.getElementById("itemCd").value = itemCd;
	if (prodStrtDt) document.getElementById("prodStrtDt").value = prodStrtDt;
	if (prodEndDt) document.getElementById("prodEndDt").value = prodEndDt;
}
</script>
</body>
<script>

//생산일정코드 시작,수정,완료에따라 변환
let pmBut = document.querySelector('.pm_correction_but_con')
pmBut.addEventListener('change', function (evt) {

    if (pmBut.value == 'insert') {
        let pr_correction_con = document.querySelector('.pr_correction_con');
        pr_correction_con.innerHTML=`
        	<div style="width: 100px;">생산일정코드:</div>
			<span>자동생성</span>
        `;
      
        
    }else if (pmBut.value == 'update'){
        console.log("수정");
        let pr_correction_con = document.querySelector('.pr_correction_con');
        pr_correction_con.innerHTML=`
        	<div style="width: 100px;">생산일정코드:</div>
        	<select class="prodPlnCd" name="prodPlnCd" id="select1" onchange="change1()">
			<c:forEach var="dto" items="${pr_1110mt }">
				<option value="${dto.prod_pln_cd }" 
						trgProdCnt="${dto.trg_prod_cnt }"
						itemNm="${dto.item_nm}"
						itemCd="${dto.item_cd}"
						prodStrtDt="${dto.prod_strt_dt}"
						prodEndDt="${dto.prod_end_dt}"
						>${dto.prod_pln_cd }</option>
			</c:forEach>
		</select>
`;

        
    }else if (pmBut.value == 'complete'){
		
    	console.log("완료");
        let pr_correction_con = document.querySelector('.pr_correction_con');
        pr_correction_con.innerHTML=`
        	<div style="width: 100px;">생산일정코드:</div>
        	<select class="prodPlnCd" name="prodPlnCd" id="select1" onchange="change1()">
			<c:forEach var="dto" items="${pr_1110mt }">
				<option value="${dto.prod_pln_cd }" 
					trgProdCnt="${dto.trg_prod_cnt }"
						itemNm="${dto.item_nm}"
						itemCd="${dto.item_cd}"
						prodStrtDt="${dto.prod_strt_dt}"
						prodEndDt="${dto.prod_end_dt}"
						>${dto.prod_pln_cd }</option>
			</c:forEach>
		</select>
`;

	
    }
})

//업데이트 
document.querySelector("#modify").addEventListener("click",
			function(event) {
				event.preventDefault();
				// 		document.querySelector("#form").submit()
	
	const item_nm = document.querySelector('#itemNm').value 
	const trg_prod_cnt = document.querySelector('#trgProdCnt').value 
	const prod_strt_dt = document.querySelector('#prodStrtDt').value 
	const prod_end_dt = document.querySelector('#prodEndDt').value 
	const item_cd = document.querySelector('#itemCd').value 
// 	const prod_pln_cd = document.querySelector('#select1').value 
	const crud = document.getElementById("crud").value
				
	
console.log("item_nm : "+ item_nm )
console.log("trg_prod_cnt : "+ trg_prod_cnt )
console.log("prod_strt_dt : "+ prod_strt_dt )
console.log("prod_end_dt : "+ prod_end_dt )
console.log("item_cd : "+ item_cd )
// console.log("prod_pln_cd : "+ prod_pln_cd )
console.log("crud : "+ crud )
// 					let param = {
// 						item_nm : item_nm,
// 						trg_prod_cnt : trg_prod_cnt,
// 						prod_strt_dt : prod_strt_dt,
// 						prod_end_dt : prod_end_dt,
// 						item_cd : item_cd,
// 						prod_pln_cd : prod_pln_cd
// 					};
				
// 					let param2 = {
// 							prod_pln_cd : prod_pln_cd
// 						};
					let param3 = {
							item_nm : item_nm,
							trg_prod_cnt : trg_prod_cnt,
							prod_strt_dt : prod_strt_dt,
							prod_end_dt : prod_end_dt,
							item_cd : item_cd,
						};
				if (crud == "update") {

					const prod_pln_cd = document.querySelector('#select1').value 
					
					let param = {
						item_nm : item_nm,
						trg_prod_cnt : trg_prod_cnt,
						prod_strt_dt : prod_strt_dt,
						prod_end_dt : prod_end_dt,
						item_cd : item_cd,
						prod_pln_cd : prod_pln_cd
					};
					
					// ajax
					const xhr = new XMLHttpRequest()
					xhr.open('put', 'pr_popup')
					xhr.setRequestHeader('Content-Type', 'application/json')
					xhr.send(JSON.stringify(param))
					console.log("param : ", param )
					xhr.onload = function() {
						if (xhr.responseText == '1') {
							alert('수정 완료')
							location.href = 'pr_popup'
						} else {
							alert('수정 실패')
						}
					}

				}else if(crud == "complete"){
					
					const prod_pln_cd = document.querySelector('#select1').value
					let param2 = {
							prod_pln_cd : prod_pln_cd
						};
					
					// ajax
					const xhr = new XMLHttpRequest()
					xhr.open('put', 'pr_popup_complete')
					xhr.setRequestHeader('Content-Type', 'application/json')
					xhr.send(JSON.stringify(param2))
					console.log("param2 : ", param2 )
					xhr.onload = function() {
						if (xhr.responseText == '1') {
							alert('수정 완료')
							location.href = 'pr_popup'
						} else {
							alert('수정 실패')
						}
					}
				}else if(crud == "insert"){
					// ajax
					const xhr = new XMLHttpRequest()
					xhr.open('put', 'pr_popup_insert')
					xhr.setRequestHeader('Content-Type', 'application/json')
					xhr.send(JSON.stringify(param3))
					console.log("param3 : ", param3 )
					xhr.onload = function() {
						if (xhr.responseText == '1') {
							alert('등록 완료')
							location.href = 'pr_popup'
						} else {
							alert('등록 실패')
						}
					}
				}
			})

</script>

</html>