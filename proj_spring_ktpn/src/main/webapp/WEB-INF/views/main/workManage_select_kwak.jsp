<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>작업 상세</title>
    <link rel="stylesheet" href="resources/css/workManage_select_kwak.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/workManage_select_kwak.js"></script>
</head>
<body>
  <c:if test="${not empty list}">
    <c:set var="dt" value="${list[0]}" />
  </c:if>
      <div class="menuPage-con">
        <div class="border_line">
<!--           <div class="pop"> -->
<!--             <div class="add-table"> -->
              <form method="post" action="prDel">
                <table class="detail-table">
                  <tr>
                    <th class="detail-th">생산코드</th>
                    <th class="detail-th">생산일정코드</th>
                    <th class="detail-th">라인호기코드</th>
                    <th class="detail-th">라인호기명</th>
                    <th class="detail-th">품목코드</th>
                    <th class="detail-th">담당자명</th>
                    <th class="detail-th">작업일자</th>
                    <th class="detail-th">지시수량</th>
                  </tr>
                  <tr>
                    <td class="detail-td"><c:out value="${dt.PROD_CD}"/></td>
                    <td class="detail-td"><c:out value="${dt.PROD_PLN_CD}"/></td>
                    <td class="detail-td"><c:out value="${dt.LIUN_CD}"/></td>
                    <td class="detail-td"><c:out value="${dt.LIUN_NM}"/></td>
                    <td class="detail-td"><c:out value="${dt.ITEM_CD}"/></td>
                    <td class="detail-td"><c:out value="${dt.MNGR_NM}"/></td>
                    <td class="detail-td"><c:out value="${dt.PROD_DT}"/></td>
                    <td class="detail-td"><c:out value="${dt.INDC_QNTT}"/></td>
                  </tr>
                </table>

                <div class="bompro-con">
                  <div class="bom-con">
                    <h4>BOM : <span id="bomId" data-bm="${dt.BOM_CD}">
							    <c:out value="${dt.BOM_CD}" />
							  </span></h4>
                    <div class="bom_table"></div>
<%--                     <div><c:out value="${dt.BOM_DESC}"/></div> --%>
                  </div>
                  <div class="process">
                    <h4>공정 : 
                    		<span id="rtId" data-rt="${dt.RT_CD}">
                    			<c:out value="${dt.RT_CD}"/>
                    		</span>
                    </h4>
                    <div class="rt_table">
<%--                     <c:out value="${dt.RT_DESC}"/> --%>
                    </div>
                  </div>
                </div>
                <div class="add-con">
                  <input type="hidden" name="prod_cd" value="${dt.PROD_CD}" />
                  <input type="submit" class="del" name="command" value="삭제" />
                </div>

              </form>
<!--             </div> -->
<!--           </div> -->
        </div>
      </div>
</body>
<script>
window.addEventListener('DOMContentLoaded', function(){
  // ==== BOM 테이블 로드 ====
  var bomElem = document.getElementById('bomId');
  var bomCd   = bomElem.getAttribute('data-bm');
  var bomUrl  = '/ktpn/bmDetail?bom_cd=' + encodeURIComponent(bomCd);

  fetch(bomUrl, {
    method: 'GET',
    headers: { 'Accept': 'text/html' }
  })
  .then(function(res){
    if (!res.ok) throw new Error(res.statusText);
    return res.text();
  })
  .then(function(html){
    var parser = new DOMParser();
    var doc    = parser.parseFromString(html, 'text/html');
    var table  = doc.querySelector('.mr_table');
    var container = document.querySelector('.bom_table');
    container.innerHTML = table
      ? table.outerHTML
      : '<p>테이블을 찾을 수 없습니다.</p>';
  })
  .catch(function(err){ console.error('BOM AJAX 오류:', err); });

  // ==== RT 테이블 로드 ====
  var rtElem = document.getElementById('rtId');
  var rtCd   = rtElem.getAttribute('data-rt');
  var rtUrl  = '/ktpn/rtDetail?rt_cd=' + encodeURIComponent(rtCd);

  fetch(rtUrl, {
    method: 'GET',
    headers: { 'Accept': 'text/html' }
  })
  .then(function(res){
    if (!res.ok) throw new Error(res.statusText);
    return res.text();
  })
  .then(function(html){
    var parser = new DOMParser();
    var doc    = parser.parseFromString(html, 'text/html');
    var rtTable   = doc.querySelector('.rt_table');
    var rtContainer = document.querySelector('.rt_table');
    rtContainer.innerHTML = rtTable
      ? rtTable.outerHTML
      : '<p>공정 테이블을 찾을 수 없습니다.</p>';
  })
  .catch(function(err){ console.error('RT AJAX 오류:', err); });
});
</script>
</html>
