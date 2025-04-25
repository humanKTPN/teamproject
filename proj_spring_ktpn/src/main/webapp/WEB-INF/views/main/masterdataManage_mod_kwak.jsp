<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>기준관리 수정</title>
    <!-- CSS 파일 -->
    <link rel="stylesheet" href="resources/css/marsterManage_mod.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- JavaScript 파일 -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/processDesc_select.js"></script>    
</head>
<body>
    <c:if test="${not empty dt}">
        <c:set var="modDto" value="${dt[0]}" />
    </c:if>

    <div class="menuPage-con">    
        <div class="border_line">
            <div class="pop">
                <div class="add-table">

                    <!-- form 시작: multipart/form-data 추가 -->
                    <form method="post"
                          action="${pageContext.request.contextPath}/mdMod"
                          enctype="multipart/form-data">
                      
                      <!-- 이미지 영역 -->
                      <c:choose>
                        <c:when test="${empty modDto.IMG_PATH_ADR}">
                          <div class="eraser-img">이미지 없음</div>
                        </c:when>
                        <c:otherwise>
                          <img border="0"
                               class="eraser-img"
                               src="temp/upload/${modDto.IMG_PATH_ADR}"
                               alt="${modDto.MT_MNG_NM}" />
                        </c:otherwise>
                      </c:choose>

                      <!-- 기존 이미지명 히든으로 전달 -->
                      <input type="hidden"
                             name="oldImg"
                             value="${modDto.IMG_PATH_ADR}" />

                      <!-- 새 이미지 선택 -->
                      <div style="margin:10px 0;">
                        <label for="file1">새 이미지 선택:</label>
                        <input type="file" name="file1" id="file1" />
                      </div>

                      <table class="detail-table">
                        <tr>
                          <th class="detail-th" scope="col">기준관리코드</th>
                          <th class="detail-th" scope="col">기준관리명</th>
                        </tr>
                        <tr>
                          <td class="detail-td">
                            <input type="text"
                                   class="mod-td"
                                   name="MT_MNG_CD"
                                   value="${modDto.MT_MNG_CD}"
                                   disabled />
                          </td>
                          <td class="detail-td">
                            <input type="text"
                                   class="mod-td"
                                   name="MT_MNG_NM"
                                   value="${modDto.MT_MNG_NM}" />
                          </td>
                        </tr>
                      </table>
                </div>
            </div>

            <div class="bompro-con">
              <div class="bom-con">
                <h4>
                  항목명 :
                  <input type="text"
                         class="mod-td"
                         value="${modDto.MT_MNG_NM}"
                         disabled />
                </h4>
                <table>
                  <tr>
                    <td></td>
                    <td>
                      <textarea name="MT_MNG_DESC"
                                class="mod-td"
                                style="width:500px; height:100px;">${modDto.MT_MNG_DESC}</textarea>
                    </td>
                  </tr>
                </table>
              </div>
            </div>

            <div class="add-con">
              <div class="mode-con">
                <input type="hidden"
                       name="command"
                       value="수정" />
                <input type="submit"
                       class="mod"
                       value="완료" />
                <input type="hidden" value="${modDto.MT_MNG_CD}" name="MT_MNG_CD" />
              </div>
            </div>

			</form>
                    <!-- form 끝 -->

        </div>
    </div>
</body>
</html>
