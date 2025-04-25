<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 대시보드용 CSS -->
    <link rel="stylesheet" href="resources/css/bom_select_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/bom_select_kwak.js"></script>
    <style>
        /* 모바일 버전 구현 등 추가 스타일 */
    </style>
    <script>
        function updateBomNm() {
            var select = document.getElementById("bom_nm");
            var selectedOption = select.options[select.selectedIndex];
            var bomCd = selectedOption.getAttribute("data-bom-cd");
            document.getElementById("bom_cd").value = bomCd;
            document.getElementById("h_bom_cd").value = bomCd;
        }
    </script>
</head>
<body>

            <div class="menuPage-con">    
                <div class="border_line">
			       <form method="post" action="/ktpn/bmMod">
                    <div class="pop">
                        <div class="add-table">
                            <table class="detail-table">
                                <tr>
                                    <th class="detail-th" scope="col">BOM코드</th>
                                    <th class="detail-th" scope="col">BOM명</th>
                                    <th class="detail-th" scope="col">품목코드</th>
                                </tr>
                                <!-- 컨트롤러에서 "bmDetail" 속성으로 전달된 DTO_BM_Kwak 객체를 dt 변수에 저장 -->
                                <c:set var="dt" value="${dt[0]}" />
                                <tr>
                                    <!-- 폼 태그는 여기서 시작하여 전체 입력 항목을 감쌉니다 -->
                                        <td class="detail-td">
                                            <span class="spn-td">
                                                <input type="text" value="${dt.bom_cd}" name="bom_cd" disabled>
                                            </span>
                                        </td>
                                        <td class="detail-td">
                                            <span class="spn-td">
                                                <input type="text" value="${dt.bom_nm}" name="bom_nm" disabled>
                                            </span>
                                        </td>
                                        <td class="detail-td">
                                            <span class="spn-td">
                                                <input type="text" value="${dt.item_cd}" name="item_cd" disabled>
                                            </span>
                                        </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="bompro-con">
                        <div class="bom-con">
                            <h4>
                                품목코드 :
                                <span class="spn-td">
                                    <input type="text" value="${dt.item_cd}" disabled>
                                </span>
                            </h4>
                            <div class="bom-item-con">
<!--                                 <span class="spn-td"> -->
                                    <!-- textarea의 내부 텍스트로 bom_desc를 출력 -->
<%--                                     <textarea name="bom_desc" style="width:300px; height:300px;">${dt.bom_desc}</textarea> --%>
									 <table class="add-table">
									    <tbody id="ingredients-body">
									    <c:forEach var="mr" items="${sessionScope.mrlist}">
<%-- 									      <c:forEach var="mr" items="${mrlist}" > --%>
<%-- 									      <c:set var="selectedMr" value="${sessionScope.mr_nm}" /> --%>
									        <tr>
									          <td>
										       <input type="hidden" name="sn" value="${mr.sn}">
									          	<select name="alpha1">
<%-- 										          	<c:set var="mr_nm" value="${param.mr_nm}" scope="session"/> --%>
										          	<c:forEach var="m" items="${mrl}" >
										          			<option value="${m.MT_MNG_NM}" <c:if test="${m.MT_MNG_NM eq mr.mr_nm}">selected</c:if>>${m.MT_MNG_NM}</option>							          	
										          	</c:forEach>
									          	</select>
									          </td>       <!-- 재료명 -->
									          <td><input type="number" value="${mr.amnt_qunt}" name="amount1"></td>   <!-- 수량 -->
									          <td>${mr.unt_nm}</td>      <!-- 단위 -->
									          <td> <button type="button" class="addItem">추가</button></td>
									          <td> <button type="button" data-sn="${mr.sn}" id="snn" class="delItem">삭제</button></td>
									        </tr>
									      </c:forEach>
									    </tbody>
									  </table>
<!--                                 </span> -->
                            </div>
                        </div>
                    </div>
                    <div class="add-con">
                        <div class="mode-con">
                            <input type="submit" class="mod" id="submit" value="완료">
                            <input type="hidden" name="command" value="완료">
                            <input type="hidden" name="bom_cd" id="bom_cd" value="${dt.bom_cd}">
                            <input type="hidden" name="h_mr_nm" value="${mr.mr_nm}">
                        </div>
                        </form>
                    </div> 
                </div>
            </div>
</body>
<script type="text/javascript">

document.addEventListener('DOMContentLoaded', function() {
	  // .desc 내부의 첫 번째 테이블을 선택
	  const table = document.querySelector('.bom-item-con table');

	  table.addEventListener('click', function(event) {
	    const btn = event.target;

	    // "+" 버튼 클릭 시: 행 복제해서 아래에 삽입
	    if (btn.classList.contains('addItem')) {
	      event.preventDefault();
	      const currentRow = btn.closest('tr');
	      const newRow = currentRow.cloneNode(true);

	      // 복제된 행의 input/select 값 초기화
	      newRow.querySelectorAll('input').forEach(input => {
	        input.value = '';
	      });
	      newRow.querySelectorAll('select').forEach(select => {
	        select.selectedIndex = 0;
	      });
	      
	      const snHidden = newRow.querySelector('#sn');
	      if (snHidden) snHidden.value = '0';

	      // 현재 행 바로 아래에 삽입
	      currentRow.parentNode.insertBefore(newRow, currentRow.nextSibling);
	    }

	    
	    if (btn.classList.contains('delItem')) {
	    	event.preventDefault()
	     	const sn = btn.dataset.sn;
	    	console.log(sn)
	     	const bomCd  = document.getElementById('bom_cd').value
	     	
		 	const payload = { sn, bomCd };
	     	
// 	     	const values = Array.from(document.querySelectorAll('select[name="alpha1"]'))
//             .map(s => s.value);
// 			sessionStorage.setItem('alpha1Values', JSON.stringify(values));
		 	
		 	
	    	fetch('/ktpn/bmDel', {
			    method: 'DELETE',
			    headers: { 'Content-Type': 'application/json' },
			    body: JSON.stringify(payload)
			  }).then(res => {
			      if (!res.ok) throw new Error(res.statusText);
			      // 성공했으면 페이지 새로고침
// 			      location.reload();
			      window.location.href = '/ktpn/bmMod?bom_cd='+bomCd
			    })
	    	
	    	
	    	
	    	
	      event.preventDefault();
	      const row = btn.closest('tr');
	      row.remove();
	      


		  
		  
	    }
	  });
	});



</script>
</html>
