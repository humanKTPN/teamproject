<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MD Detail</title>
    <!-- CSS 및 JS 파일 -->
    <link rel="stylesheet" href="resources/processDesc_select.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/processDesc_select.js"></script>
    <style>
        /* 모바일 버전 구현 등 추가 스타일 */
    </style>
</head>
<body>
            <div class="menuPage-con">
                <div class="border_line">
                    <div class="pop">
                        <div class="add-table">
                            <!-- 컨트롤러에서 전달한 "list"가 비어있는지 체크 -->
                            <c:if test="${not empty list}">
                                <!-- 리스트의 첫 번째 요소를 dt로 설정 -->
                                <c:set var="dt" value="${list[0]}" />
                                <!-- 이미지 처리 : IMG_PATH_ADR 값이 없는 경우 대체 -->
                                <c:choose>
                                    <c:when test="${empty dt.IMG_PATH_ADR}">
                                        <!-- 이미지가 없을 경우 (필요한 대체 콘텐츠 삽입 가능) -->
                                    </c:when>
                                    <c:otherwise>
                                        <!-- c:url을 사용해 URL 파라미터 인코딩 -->
                                        <c:url var="downloadUrl" value="download.do">
                                            <c:param name="filename" value="${dt.IMG_PATH_ADR}" />
                                        </c:url>
                                        <img border="0" class="eraser-img" src="${downloadUrl}" />
                                    </c:otherwise>
                                </c:choose>
                                <table class="detail-table">
                                    <tr>
                                        <th class="detail-th" scope="col">기준관리코드</th>
                                        <th class="detail-th" scope="col">기준관리명</th>
                                    </tr>
                                    <tr>
                                        <td class="detail-td">
                                            <span class="spn-td">${dt.MT_MNG_CD}</span>
                                            <input type="text" class="mod-td hide" value="${dt.MT_MNG_CD}" />
                                        </td>
                                        <td class="detail-td">
                                            <span class="spn-td">${dt.MT_MNG_NM}</span>
                                            <input type="text" class="mod-td hide" value="${dt.MT_MNG_NM}" />
                                        </td>
                                    </tr>
                                </table>
                            </c:if>
                            <c:if test="${empty list}">
                                <p>조회된 데이터가 없습니다.</p>
                            </c:if>
                        </div>
                    </div>
                    <div class="bompro-con">
                        <div class="bom-con">
                            <c:if test="${not empty list}">
                                <c:set var="dt" value="${list[0]}" />
                                <h4>
                                    항목명 :
                                    <span class="spn-td">${dt.MT_MNG_NM}</span>
                                    <input type="text" class="mod-td hide" value="${dt.MT_MNG_NM}" />
                                </h4>
                                <table>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <span class="spn-td">${dt.MT_MNG_DESC}</span>
                                            <input type="text" style="width: 500px; height: 100px;" class="mod-td hide" value="${dt.MT_MNG_DESC}" />
                                        </td>
                                    </tr>
                                </table>
                            </c:if>
                        </div>
                    </div>
                    <div class="add-con">
                        <div class="mode-con">
                            <form method="post" action="masterDataManagement_kwak_cotroller">
                                <input type="submit" class="mod" value="수정" />
                                <input type="hidden" name="command" value="수정" />
                                <c:if test="${not empty list}">
                                    <input type="hidden" name="MT_MNG_CD" value="${list[0].MT_MNG_CD}" />
                                </c:if>
                            </form>
                            <form method="post" action="masterDataManagement_kwak_cotroller">
                                <input type="submit" class="del" value="삭제" />
                                <input type="hidden" name="command" value="삭제" />
                                <c:if test="${not empty list}">
                                    <input type="hidden" name="MT_MNG_CD" value="${list[0].MT_MNG_CD}" />
                                    <input type="hidden" name="MT_MNG_NM" value="${list[0].MT_MNG_NM}" />
                                    <input type="hidden" name="MT_MNG_DESC" value="${list[0].MT_MNG_DESC}" />
                                </c:if>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>
