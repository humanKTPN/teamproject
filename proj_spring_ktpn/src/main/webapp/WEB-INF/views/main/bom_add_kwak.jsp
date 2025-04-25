<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="resources/css/bom_add_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/bom_add_kwak.js"></script>    
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
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
        <div class="background">
            <div class="margin">
                <div class="tab-con">
                    <div class="tab-name-div">
                        <div class="tab-name switch-color">BOM등록</div>
                    </div>
                </div>
                <div class="dropBox">
                </div>
                
                <form method="post" action="/ktpn/bmAdd">
                    <div class="command-loc">
                        <div class="command-div">
                            <table class="command-table">
                                <tr>
                                    <th class="command-th" scope="col">BOM코드</th>
                                    <th class="command-th" scope="col">BOM명</th>
                                    <th class="command-th" scope="col">품목코드</th>
                                    <!-- <th class="command-th" scope="col">설명</th> -->
                                </tr>
                                <tr>
                                    <td class="command-td">
                                        <input type="text" id="bom_cd" value="${dt.MT_MNG_CD}" disabled>	
                                        <input type="hidden" id="h_bom_cd" name="bom_cd">								    
                                    </td>
                                    <td class="command-td">
                                        <select name="bom_nm" id="bom_nm" onclick="updateBomNm()">
                                            <c:forEach var="dt" items="${list}">
                                                <option value="${dt.MT_MNG_NM}" data-bom-cd="${dt.MT_MNG_CD}">${dt.MT_MNG_NM}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td class="command-td">
                                        <input type="text" name="item_cd">
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    
                    
                    <div class="desc-con">
                        <div class="tab-name-div">
                            <div class="tab-name switch-color">설명입력</div>
                        </div>
                        <div type="text" class="desc">
                        	<table>
                        		<tbody id="ingredients-body">
                        	  <tr class="line">
                        		<td>
		                        	재료명 : <select name="alpha">
		                        				<c:forEach var="mrl" items="${mrlist}">
				                       				<option value="${mrl.MT_MNG_NM}">${mrl.MT_MNG_NM}</option>
		                		          		</c:forEach>
		                		            </select>
		                		</td>
		                		<td>
		                        	수량 : <input type="number" name="amount">		                		
		                		</td>
		                		<td>
		                        	단위 : <select name="gram">
				                       		<option value="g">g</option>
		                		          </select>
		                		</td>
		                		<td>
		                			<button type ="button" class="lineAdd">+</button>
		                			<button type="button" class="lineRemove">–</button>
		                		</td>
		                		
                        	</tr>
                        	</tbody>
                        	</table>
                        </div>
                        <div class="add-con">
                            <button type="button" id="saveBtn" class="add">설명저장</button>
                            <input type="submit" class="add" value="추가" name="command">
                        </div>
                    </div>
                 </form>
            </div>
        </div>
    </div>
   
</body>
<script>
document.addEventListener('DOMContentLoaded', function() {
	  // .desc 내부의 첫 번째 테이블을 선택
	  const table = document.querySelector('.desc table');

	  table.addEventListener('click', function(event) {
	    const btn = event.target;

	    // "+" 버튼 클릭 시: 행 복제해서 아래에 삽입
	    if (btn.classList.contains('lineAdd')) {
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

	      // 현재 행 바로 아래에 삽입
	      currentRow.parentNode.insertBefore(newRow, currentRow.nextSibling);
	    }

	    // "–" 버튼 클릭 시: 해당 행 삭제
	    if (btn.classList.contains('lineRemove')) {
	      event.preventDefault();
	      const row = btn.closest('tr');
	      // 최소 한 행은 남기고 싶으면 아래 조건문 추가
	      // if (table.querySelectorAll('tr').length > 1) {
	      //   row.remove();
	      // }
	      row.remove();
	    }
	  });
	});
	

document.getElementById('saveBtn').addEventListener('click', function() {
	
	this.disabled = true;
	
	
	const tbody = document.getElementById('ingredients-body');
	
    const items = Array.from(tbody.querySelectorAll('tr.line')).map(tr => ({
      alpha:  tr.querySelector('select[name="alpha"]').value,
      amount: tr.querySelector('input[name="amount"]').value,
      gram:   tr.querySelector('select[name="gram"]').value
    }));

    const bomCd  = document.getElementById('h_bom_cd').value;
//     const bomNm  = document.getElementById('bom_nm').value;
//     const itemCd  = document.getElementById('item_cd').value;
    
    const payload = { bomCd, components: items };

    fetch('/ktpn/bmAddMr', {
    	  method: 'POST',
    	  headers: { 'Content-Type': 'application/json' },
    	  body: JSON.stringify(payload)
    	})
    
    

  });
</script>
</html>
