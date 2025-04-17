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
                                        <input type="text" id="bom_cd" disabled>	
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
                        <textarea class="desc" name="bom_desc"></textarea>
                        <div class="add-con">
                            <input type="submit" class="add" value="추가" name="command">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
