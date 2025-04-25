<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8"/>
  <title>공정 수정</title>
  <link rel="stylesheet" href="resources/css/processDesc_mod.css"/>
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
</head>
<body>
  <div class="menuPage-con">
    <div class="border_line">
      <div class="pop">
        <div class="add-table">
          <form method="post" action="rtMod" class="postCon">
            <c:set var="dt" value="${dt[0]}"/>
            <table class="detail-table">
              <tr>
                <th class="detail-th">공정코드</th>
                <th class="detail-th">공정명</th>
                <th class="detail-th">품목코드</th>
              </tr>
              <tr>
                <td class="detail-td">
                  <input type="text" name="rt_cd" value="${dt.rt_cd}" disabled/>
                  <input type="hidden" name="rt_cd" value="${dt.rt_cd}"/>
                </td>
                <td class="detail-td">
                  <input type="text" name="rt_nm" value="${dt.rt_nm}" disabled/>
                </td>
                <td class="detail-td">
                  <input type="text" name="item_cd" value="${dt.item_cd}" disabled/>
                </td>
              </tr>
            </table>

            <div class="bompro-con">
              <div class="bom-con">
                <h4>공정코드 : <input type="text" value="${dt.rt_cd}" disabled/></h4>
                <table class="detail-table mr_table" style="width:100%; border:1px solid grey; text-align:center;">
                  <tbody>
                    <c:choose>
                      <c:when test="${not empty dc}">
                        <c:forEach var="rt" items="${dc}">
                          <tr class="line">
                            <td class="detail-td">
                              <!-- 리스트 바인딩용 name 속성 -->
                              설명 :
                              <input type="text"
                                     name="rt_descList"
                                     value="${rt.rt_desc}"/>
                              <button type="button" class="addItem">추가</button>
                              <button type="button"
                                      class="delItem"
                                      data-sn="${rt.sn}">삭제</button>
                              <input type="hidden"
                                     name="snList"
                                     value="${rt.sn}"/>
                            </td>
                          </tr>
                        </c:forEach>
                      </c:when>
                      <c:otherwise>
                        <tr class="line">
                          <td class="detail-td">
                            설명 :
                            <input type="text" name="rt_descList" value=""/>
                            <button type="button" class="addItem">추가</button>
                            <button type="button" class="delItem">삭제</button>
                            <input type="hidden" name="snList" value=""/>
                          </td>
                        </tr>
                      </c:otherwise>
                    </c:choose>
                  </tbody>
                </table>
              </div>
            </div>

            <div class="add-con">
              <div class="mode-con">
                <input type="submit" class="mod" value="완료"/>
                <input type="hidden" name="command" value="완료"/>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

  <script>
    document.addEventListener('DOMContentLoaded', function(){
      const table = document.querySelector('.mr_table');
      if (!table) return;

      table.addEventListener('click', function(event){
        const btn = event.target;
        const row = btn.closest('tr');
        if (!row) return;

        // 추가
        if (btn.classList.contains('addItem')) {
          event.preventDefault();
          const clone = row.cloneNode(true);
          clone.classList.add('line');
          // 새 행 초기화
          clone.querySelectorAll('input[name="rt_descList"]')
               .forEach(i => i.value = '');
          clone.querySelectorAll('input[name="snList"]')
               .forEach(i => i.value = '');
          clone.querySelectorAll('.delItem')
               .forEach(d => d.removeAttribute('data-sn'));
          row.after(clone);
          return;
        }

        // 삭제
        if (btn.classList.contains('delItem')) {
          event.preventDefault();
          const sn = btn.getAttribute('data-sn');
          const rtCd = document.querySelector('input[name="rt_cd"]').value;
          if (sn) {
            fetch('/ktpn/rtDel', {
              method: 'DELETE',
              headers: {'Content-Type':'application/json'},
              body: JSON.stringify({ rtCd: rtCd, sn: sn })
            })
            .then(res => {
              if (!res.ok) throw new Error(res.statusText);
              window.location.href = '/ktpn/rtMod?rt_cd=' + encodeURIComponent(rtCd);
            })
            .catch(console.error);
          }
          row.remove();
        }
      });
    });
  </script>
</body>
</html>
