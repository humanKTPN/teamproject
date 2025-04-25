<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>공정 상세</title>
  <!-- CSS / JS -->
  <link rel="stylesheet" href="resources/css/processDesc_select.css">
  <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
  <script src="resources/js/processDesc_select.js"></script>
  <style>
    /* 모바일 버전 구현(불량쪽 차트는 ....) */
  </style>
</head>
<c:set var="dto" value="${list[0]}" />
<body>
      <div class="menuPage-con">
        <div class="border_line">
          <div class="pop">
            <div class="add-table">
              <table class="detail-table">
                <tr>
                  <th class="detail-th">공정코드</th>
                  <th class="detail-th">공정명</th>
                  <th class="detail-th">품목코드</th>
                </tr>
                <tr>
                  <td class="detail-td">
                    <span class="spn-td">
                      <c:out value="${dto.rt_cd}" />
                    </span>
                  </td>
                  <td class="detail-td">
                    <span class="spn-td">
                      <c:out value="${dto.rt_nm}" />
                    </span>
                  </td>
                  <td class="detail-td"> 
                    <span class="spn-td">
                      <c:out value="${dto.item_cd}" />
                    </span>
                  </td>
                </tr>
              </table>
            </div>
          </div>

          <div class="bompro-con">
            <div class="bom-con">
              <h4>
                공정코드 :
                <span class="spn-td">
                  <c:out value="${dto.rt_cd}" />
                </span>
              </h4>
              <table style="width: 70%;">
                <tr>
                  <td>
                     <table style="width: 100%;
										  border: 1px solid grey;
										  text-align: center;" class="detail-table rt_table">
<!-- 							    <thead> -->
<!-- 							      <tr> -->
<!-- 							        <th class="detail-th">재료명</th> -->
<!-- 							        <th class="detail-th">수량</th> -->
<!-- 							        <th class="detail-th">단위</th> -->
<!-- 							      </tr> -->
<!-- 							    </thead> -->
							    <tbody>
							      <c:forEach var="rt" items="${dc}">
							        <tr>
							          <td class="detail-td">${rt.rt_desc}</td>  <!-- 설명 -->
							        </tr>
							      </c:forEach>
							    </tbody>
							  </table>
                </tr>
              </table>
            </div>
          </div>

          <div class="add-con">
            <div class="mode-con">
              <form method="get" action="rtMod">
<!--                 <input type="hidden" name="command" value="수정" /> -->
                <input type="hidden" name="rt_cd" value="${dto.rt_cd}" />
                <input type="submit" class="mod" value="수정" />
              </form>
            </div>
          </div>

        </div>
      </div>

</body>
</html>
