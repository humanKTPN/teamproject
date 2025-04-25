<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>작업 등록</title>
    <link rel="stylesheet" href="resources/css/workManage_add_kwak.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/workManage_add_kwak.js"></script>
    <style>
        /* 모바일 버전 구현(불량쪽 차트는 ....) */
    </style>
    <script>
        function updateLnNm() {
            var select = document.getElementById("ln_nm");
            var opt    = select.options[select.selectedIndex];
            var lnCd   = opt.getAttribute("data-ln-cd");
            document.getElementById("ln_cd").value   = lnCd;
            document.getElementById("h_ln_cd").value = lnCd;
        }
        function updateBomNm() {
            var sel = document.getElementById("item_nm"),
                opt = sel.options[sel.selectedIndex];
            document.getElementById("item_cd").value    = opt.getAttribute("data-item-cd");
            document.getElementById("h_item_cd").value  = opt.getAttribute("data-item-cd");
            document.getElementById("pln_cd").value     = opt.getAttribute("data-pln-cd");
            document.getElementById("h_pln_cd").value   = opt.getAttribute("data-pln-cd");
            document.getElementById("indc-qntt").value  = opt.getAttribute("data-indc-qntt");
            document.getElementById("bom-cd").value     = opt.getAttribute("data-bom-cd");
            document.getElementById("bom-desc").value   = opt.getAttribute("data-bom-desc");
            document.getElementById("rt-cd").value      = opt.getAttribute("data-rt-cd");
            document.getElementById("rt-desc").value    = opt.getAttribute("data-rt-desc");
        }
    </script>
</head>
<body>
  <div class="menuPage-con">
    <div class="border_line">
      <div class="pop">
        <div class="add-table">
          <form method="post" action="insertPr" name="insertPr">
            <div class="select-body">

              <div class="select-con">
                <div class="select-1">
                  생산코드
                  <input type="text" id="hoNo" placeholder="생산코드" disabled>

                  담당자명
                  <select name="mb_nm" id="mb_nm">
                    <c:forEach var="dtM" items="${mbMap}">
                      <option value="${dtM.MBR_NM}">
                        ${dtM.MBR_NM}
                      </option>
                    </c:forEach>
                  </select>

                  라인호기명
                  <select name="ln_nm" id="ln_nm" onclick="updateLnNm()">
                    <c:forEach var="dtL" items="${LineMap}">
                      <option value="${dtL.MT_MNG_NM}"
                              data-ln-cd="${dtL.MT_MNG_CD}">
                        ${dtL.MT_MNG_NM}
                      </option>
                    </c:forEach>
                  </select>
                </div>
              </div>

              <div class="select-con">
                <div class="select-1">
                  생산일정코드
                  <input type="text" name="pln_cd" id="pln_cd"
                         placeholder="생산일정코드" disabled>
                  <input type="hidden" name="h_pln_cd" id="h_pln_cd">

                  품목코드
                  <input type="text" name="item_cd" id="item_cd" disabled>
                  <input type="hidden" name="h_item_cd" id="h_item_cd">

                  품목명
                  <select name="item_nm" id="item_nm" onclick="updateBomNm()">
                    <c:forEach var="dt" items="${addMap}">
                      <option value="${dt.ITEM_NM}"
                              data-item-cd="${dt.ITEM_CD}"
                              data-pln-cd="${dt.PROD_PLN_CD}"
                              data-indc-qntt="${dt.TRG_PROD_CNT}"
                              data-bom-cd="${dt.BOM_CD}"
                              data-bom-desc="${dt.BOM_DESC}"
                              data-rt-cd="${dt.RT_CD}"
                              data-rt-desc="${dt.RT_DESC}">
                        ${dt.ITEM_NM}
                      </option>
                    </c:forEach>
                  </select>
                </div>
              </div>

              <div class="select-con">
                <div class="select-1">
                  지시수량
                  <input type="text" id="indc-qntt" name="indc_qntt"
                         placeholder="지시수량">

                  작업일자
                  <input type="date" name="prod_dt" placeholder="일자입력">

                  라인호기코드
                  <input type="text" id="ln_cd" name="ln_cd" placeholder="라인호기코드" disabled>
                  <input type="hidden" id="h_ln_cd" name="h_ln_cd">
                </div>
              </div>

            </div>

<!--             <div class="bompro-con"> -->
<!--               <div class="bom-con"> -->
<!--                 <h4>BOM : -->
                  <input type="hidden" id="bom-cd" name="bom_cd">
<!--                 </h4> -->
                <input type="hidden" id="bom-desc" name="bom_desc"
                       style="width:90%; height:90%">
                       
<!--               </div> -->
<!--               <div class="process"> -->
<!--                 <h4>공정 : -->
                  <input type="hidden" id="rt-cd" name="rt_cd">
<!--                 </h4> -->
                <input type="hidden" id="rt-desc" name="rt_desc"
                       style="width:90%; height:90%">
<!--               </div> -->
<!--             </div> -->

            <div class="confirm-con">
              <input class="confirm" type="submit" value="추가" name="command">
            </div>
          </form>
        </div>
      </div>
      <!-- html 들어갈 곳 -->
    </div>
  </div>
</body>
</html>
