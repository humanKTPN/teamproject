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
    <link rel="stylesheet" href="resources/css/processDesc_select.css">
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
                    <!-- 이미지 처리: modDto 객체의 IMG_PATH_ADR 값이 없으면 빈 div, 있으면 <img> 출력 -->
                    <c:choose>
                        <c:when test="${empty modDto.IMG_PATH_ADR}">
                            <div class="eraser-img"></div>
                        </c:when>
                        <c:otherwise>
                            <img border="0" class="eraser-img" src="download.do?filename=${modDto.IMG_PATH_ADR}" />
                        </c:otherwise>
                    </c:choose>
                    <table class="detail-table">
                        <tr>
                            <th class="detail-th" scope="col">기준관리코드</th>
                            <th class="detail-th" scope="col">기준관리명</th>
                        </tr>
                        <tr>
                            
                            <form method="post" action="${pageContext.request.contextPath}/mdMod">
                                <td class="detail-td">
                                    <span class="spn-td">
                                        <input type="text" class="mod-td" value="${modDto.MT_MNG_CD}" name="MT_MNG_CD" disabled />
                                    </span>
                                </td>
                                <td class="detail-td">
                                    <span class="spn-td">
                                        <input type="text" class="mod-td" value="${modDto.MT_MNG_NM}" name="MT_MNG_NM" />
                                    </span>
                                </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="bompro-con">
                <div class="bom-con">
                    <h4>
                        항목명 :
                        <span class="spn-td">
                            <input type="text" class="mod-td" value="${modDto.MT_MNG_NM}" disabled />
                        </span>
                    </h4>
                    <table>
                        <tr>
                            <td></td> 
                            <td>
                                <span class="spn-td">
                                    <input type="text" class="mod-td" value="${modDto.MT_MNG_DESC}" name="MT_MNG_DESC" />
                                </span>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="add-con">
                <div class="mode-con">
                    <input type="submit" class="mod" value="완료" />
                    <input type="hidden" value="완료" name="command" />
                    <input type="hidden" value="${modDto.MT_MNG_CD}" name="MT_MNG_CD" />
                    </form>
                </div>
            </div> 
        </div>
    </div>
</body>
</html>
