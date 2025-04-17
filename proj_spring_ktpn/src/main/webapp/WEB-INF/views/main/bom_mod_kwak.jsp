<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 대시보드용 CSS -->
    <link rel="stylesheet" href="resources/css/bom_select_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/bom_select_kwak.js"></script>
    <style>
        /* 모바일 버전 구현 등 추가 스타일 */
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
                <div class="border_line">
                    <div class="pop">
                        <div class="add-table">
                            <table class="detail-table">
                                <tr>
                                    <th class="detail-th" scope="col">BOM코드</th>
                                    <th class="detail-th" scope="col">BOM명</th>
                                    <th class="detail-th" scope="col">품목코드</th>
                                </tr>
                                <!-- 컨트롤러에서 "bmDetail" 속성으로 전달된 DTO_BM_Kwak 객체를 dt 변수에 저장 -->
                                <c:set var="dt" value="${dt[0]}" />
                                <tr>
                                    <!-- 폼 태그는 여기서 시작하여 전체 입력 항목을 감쌉니다 -->
                                    <form method="post" action="/ktpn/bmMod">
                                        <td class="detail-td">
                                            <span class="spn-td">
                                                <input type="text" value="${dt.bom_cd}" name="bom_cd" disabled>
                                            </span>
                                        </td>
                                        <td class="detail-td">
                                            <span class="spn-td">
                                                <input type="text" value="${dt.bom_nm}" name="bom_nm" disabled>
                                            </span>
                                        </td>
                                        <td class="detail-td">
                                            <span class="spn-td">
                                                <input type="text" value="${dt.item_cd}" name="item_cd" disabled>
                                            </span>
                                        </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="bompro-con">
                        <div class="bom-con">
                            <h4>
                                품목코드 :
                                <span class="spn-td">
                                    <input type="text" value="${dt.item_cd}" disabled>
                                </span>
                            </h4>
                            <div class="bom-item-con">
                                <span class="spn-td">
                                    <!-- textarea의 내부 텍스트로 bom_desc를 출력 -->
                                    <textarea name="bom_desc" style="width:300px; height:300px;">${dt.bom_desc}</textarea>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="add-con">
                        <div class="mode-con">
                            <input type="submit" class="mod" value="완료">
                            <input type="hidden" name="command" value="완료">
                            <input type="hidden" name="bom_cd" value="${dt.bom_cd}">
                        </div>
                        </form>
                    </div> 
                </div>
            </div>
</body>
</html>
