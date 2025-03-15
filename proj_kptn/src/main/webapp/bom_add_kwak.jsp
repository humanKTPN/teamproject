<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "tb_bm_1000mt.DAO_BM_Kwak" %>
<%@page import= "tb_bm_1000mt.DTO_BM_Kwak" %>
 <%@ page import="java.util.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="bom_add_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="bom_add_kwak.js"></script>    
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>
<body>
    <body>
        <div class="menu-con work">
            <div>
                <div id ="title-name">
                    <div class="titleName">
                        <i id="ham" class="fas fa-solid fa-bars fa-lg"></i><div class="logo"><i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES solution</div>
                    </div>
                    <div class="icon-sub">
                        관리자님 환영합니다.
                        <i class="fas fa-regular fa-arrow-right-from-bracket fa-md">
                            <span class="subBut">로그아웃</span>
                        </i>
                    </div>  
                </div>
            </div>
            <div class="main-menu-con">
                <!-- <div class="main-menu" id="main-menu">MENU 열기</div> -->
                <div class="menu">기준관리</div>
                <div class="menu">작업관리</div>
                <div class="menu">생산관리</div>
                <div class="menu">생산리포팅</div>
                <div class="menu">자재관리</div>
                <div class="menu">품질관리</div>
            </div>
        </div>
        <div class="board">
            
            <div class="mainmenu" id="work1">
                <div class="menuBut">대시보드</div>
                <div class="menuBut">게시판</div>
                <div class="menuBut">공지사항</div>
                <!-- <div class="menuBut">기준관리</div> -->
            </div>
            <div class="bome-con">


                <div class="menuPage-con">    
                    <div class="background">
                        <div class="margin">
                            <div class="tab-con">
                                <div class = "tab-name-div">
                                    <div class="tab-name switch-color">BOM등록</div>
                                </div>
                            </div>
                        <div class="dropBox">
                        </div>
                        
                        <div class="command-loc">
                            <div class="command-div">
                                <table class="command-table">
                                    <tr>
                                        <th class="command-th" scope = "col">BOM코드</th>
                                        <th class="command-th" scope = "col">BOM명</th>
                                        <th class="command-th" scope = "col">품목코드</th>
                                        <!-- <th class="command-th" scope = "col">설명</th> -->
                                    </tr>
                                    <tr>
                             <form method="post" action="CNTRL_BM_Kwak">
                                <%
						        DAO_BM_Kwak dao = new DAO_BM_Kwak();
						        List<DTO_BM_Kwak> dto = dao.getData();
						        request.setAttribute("dtoList", dto);
						        %>
									<td class="command-td">
									    <input type="text" id="bom_cd" disabled>	
									    <input type="hidden" id="h_bom_cd" name="bom_cd">								    
									</td>
									<td class="command-td">
									    <select name="bom_nm" id="bom_nm" onclick="updateBomNm()">
									        <c:forEach var="dt" items="${dtoList}">
									            <option value="${dt.bom_nm}" data-bom-cd="${dt.bom_cd}">${dt.bom_nm}</option>
									        </c:forEach>
									    </select>
									</td>
									
									<script>
									function updateBomNm() {
									    var select = document.getElementById("bom_nm");
									    var selectedOption = select.options[select.selectedIndex];
									    var bomNm = selectedOption.getAttribute("data-bom-cd");
									    document.getElementById("bom_cd").value = bomNm;
									    document.getElementById("h_bom_cd").value = bomNm;
									}
									</script>
                                        <td class="command-td">
                                        	<input type="text"  name= "item_cd">
                                       </td>
                                    </tr>
                                    
                                </table>
                            
                            </div>
                            <div class="desc-con">
                                <div class = "tab-name-div">
                                    <div class="tab-name switch-color">설명입력</div>
                                </div>
                                <textarea class="desc" name="bom_desc"></textarea>
                                <div class="add-con">
                                    <input type="submit" class="add" value= "추가" name="command"></div>
                                    
                                 </form>
                                </div> 
                            </div>

                    </div>
                    
                </div>
             
                </div>
                
            </div>
    </body>
    
</body>
</html>