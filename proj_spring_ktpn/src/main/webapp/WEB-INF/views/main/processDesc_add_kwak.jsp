<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>공정등록 (AJAX 전용)</title>
  <link rel="stylesheet" href="resources/css/processDesc_add_kwak.css"/>
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
  <script>
    // 1) 공정명 선택 시 rt_cd와 hidden h_rt_cd 업데이트
    function updateRtNm(){
      const sel = document.getElementById("rt_nm"),
            opt = sel.options[sel.selectedIndex],
            cd  = opt.getAttribute("data-rt-cd");
      document.getElementById("rt_cd").value   = cd;
      document.getElementById("h_rt_cd").value = cd;
    }
    window.addEventListener("load", updateRtNm);

    document.addEventListener("DOMContentLoaded", function(){
      const tbody  = document.getElementById("ingredients-body"),
            addBtn = document.getElementById("addBtn");

      // 2) 테이블 행 추가/삭제
      tbody.addEventListener("click", function(e){
        const btn = e.target;
        if(btn.classList.contains("lineAdd")){
          e.preventDefault();
          const row   = btn.closest("tr"),
                clone = row.cloneNode(true);
          clone.querySelectorAll('input[name="desc"]').forEach(i => i.value = "");
          row.after(clone);
        }
        if(btn.classList.contains("lineRemove")){
          e.preventDefault();
          if(tbody.querySelectorAll("tr").length > 1){
            btn.closest("tr").remove();
          }
        }
      });

      // 3) AJAX로 전송할 페이로드 생성 (rt_nm, item_cd 추가)
      function collectPayload(){
        const rtCd       = document.getElementById("h_rt_cd").value,
              rtNm       = document.getElementById("rt_nm").value,
              itemCd     = document.getElementById("item_cd").value,
              rows       = tbody.querySelectorAll("tr.line"),
              components = Array.from(rows).map(r => ({
                desc: r.querySelector('input[name="desc"]').value
              }));
        return { rtCd, rtNm, itemCd, components };
      }

      // 4) “추가” 버튼 클릭 시 AJAX 전송
      addBtn.addEventListener("click", function(e){
        e.preventDefault();
        const payload = collectPayload();
        fetch("/ktpn/bmAddRt", {
          method:  "POST",
          headers: { "Content-Type":"application/json" },
          body:    JSON.stringify(payload)
        })
        .then(res => {
          if (!res.ok) throw new Error("HTTP 오류 " + res.status);
          return res.text();  // 빈 문자열도 OK
        })
        .then(data => {
	    window.location.href = '/ktpn/rt';
	  })
        
      });
    });
  </script>
</head>
<body>
  <div class="menuPage-con">
    <div class="background">
      <!-- form은 레이아웃용, 실제 전송은 AJAX만 사용 -->
      <form id="rtForm" onsubmit="return false;">
        <div class="margin">
          <div class="tab-con">
            <div class="tab-name-div">
              <div class="tab-name switch-color">공정등록</div>
            </div>
          </div>
          <div class="dropBox"></div>

          <!-- 공정 코드/명/품목 입력 -->
          <div class="command-loc">
            <div class="command-div">
              <table class="command-table">
                <tr>
                  <th class="command-th">공정코드</th>
                  <th class="command-th">공정명</th>
                  <th class="command-th">품목코드</th>
                </tr>
                <tr>
                  <td class="command-td">
                    <input type="text" id="rt_cd" disabled/>
                    <input type="hidden" id="h_rt_cd" name="rt_cd"/>
                  </td>
                  <td class="command-td">
                    <select id="rt_nm" name="rt_nm" onchange="updateRtNm()">
                      <c:forEach var="dt" items="${list}">
                        <option data-rt-cd="${dt.MT_MNG_CD}">${dt.MT_MNG_NM}</option>
                      </c:forEach>
                    </select>
                  </td>
                  <td class="command-td">
                    <input type="text" id="item_cd" name="item_cd"/>
                  </td>
                </tr>
              </table>
            </div>
          </div>

          <!-- 설명 입력부 -->
          <div class="desc-con">
            <div class="tab-name-div">
              <div class="tab-name switch-color">설명입력</div>
            </div>
            <div class="desc">
              <table class="mr_table">
                <tbody id="ingredients-body">
                  <tr class="line">
                    <td>설명 : <input type="text" name="desc"/></td>
                    <td>
                      <button type="button" class="lineAdd">+</button>
                      <button type="button" class="lineRemove">–</button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
            <div class="add-con">
              <button type="button" id="addBtn" class="add">추가</button>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</body>
</html>
