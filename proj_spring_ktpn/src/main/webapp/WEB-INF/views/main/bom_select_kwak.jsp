<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="resources/css/bom_select_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/bom_select_kwak.js"></script>    
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>
<body>
    <div class="menuPage-con">
        <!-- html 들어갈 곳 -->
        <div class="border_line">
            <div class="pop">
                <div class="add-table">
                    <table class="detail-table">
                        <tr>
                            <th class="detail-th" scope="col">BOM코드</th>
                            <th class="detail-th" scope="col">BOM명</th>
                            <th class="detail-th" scope="col">품목코드</th>
                        </tr>
                        <!-- list의 첫번째 데이터를 dt 변수에 저장 -->
                        <c:set var="dt" value="${list[0]}" />
                        <tr>
                            <td class="detail-td">
                                <span class="spn-td">${dt.bom_cd}</span>
                            </td>
                            <td class="detail-td">
                                <span class="spn-td">${dt.bom_nm}</span>
                            </td>
                            <td class="detail-td">
                                <span class="spn-td">${dt.item_cd}</span>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="bompro-con">
                <div class="bom-con">
                    <h4>
                        품목코드 :<span class="spn-td">${dt.item_cd}</span>
                        <input type="text" class="mod-td hide" value="A80">
                    </h4>
                    <div class="bom-item-con">
                        <!-- BOM 설명이 필요한 경우 아래와 같이 줄바꿈 처리 가능 -->
<%--                         <c:if test="${not empty dt.bom_desc}"> --%>
                            <span class="spn-td">${dt.bom_desc}</span>
<%--                         </c:if> --%>
                        <input type="text" class="mod-td hide" value="${dt.bom_desc}" />
                    </div>
                </div>
            </div>
            <!-- 수정 및 삭제 폼 예시 (필요 시 주석 해제하여 사용) -->
         
            <div class="add-con">
                <div class="mode-con">
                    <form method="get" action="bmMod?bom_cd=${dt.bom_cd}">
                        <input type="submit" class="mod" value="수정">
<!--                         <input type="hidden" name="command" value="수정"> -->
                        <input type="hidden" name="bom_cd" value="${dt.bom_cd}">
                    </form>
                    <form method="post" action="bmDel?bom_cd=${dt.bom_cd}">
                        <input type="submit" class="del" value="삭제">
                        <input type="hidden" name="command" value="삭제">
                        <input type="hidden" name="bom_cd" value="${dt.bom_cd}">
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>