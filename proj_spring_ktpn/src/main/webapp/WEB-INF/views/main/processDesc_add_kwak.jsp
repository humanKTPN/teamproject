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
    <link rel="stylesheet" href="processDesc_add_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="processDesc_add_kwak.js"></script>    
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>
<body>
               <div class="menuPage-con">    
                    <div class="background">
                        <div class="margin">
                            <div class="tab-con">
                                <div class = "tab-name-div">
                                    <div class="tab-name switch-color">공정등록</div>
                                </div>
                            </div>
                        <div class="dropBox">
                        </div>
                        
                        <div class="command-loc">
                            <div class="command-div">
                                <table class="command-table">
                                    <tr>
                                        <th class="command-th" scope = "col">공정코드</th>
                                        <th class="command-th" scope = "col">공정명</th>
                                        <th class="command-th" scope = "col">품목코드</th>
                                        <!-- <th class="command-th" scope = "col">설명</th> -->
                                    </tr>
                                    <form method="post" action="CNTRL_RT_Kwak">
                                    <tr>
                                        <td class="command-td">
										    <input type="text" id="rt_cd" disabled>	
										    <input type="hidden" id="h_rt_cd" name="rt_cd">								    
										</td>
										
                                        <td class="command-td">
									    <select name="rt_nm" id="rt_nm" onclick="updateRtNm()">
									        <c:forEach var="dt" items="${dtoList}">
									            <option value="${dt.RT_NM}" data-rt-cd="${dt.RT_CD}">${dt.RT_NM}</option>
									        </c:forEach>
									    </select>
									   
									</td>
									<script>
									function updateRtNm() {
									    var select = document.getElementById("rt_nm");
									    var selectedOption = select.options[select.selectedIndex];
									    var rtNm = selectedOption.getAttribute("data-rt-cd");
									    document.getElementById("rt_cd").value = rtNm;
									    document.getElementById("h_rt_cd").value = rtNm;
									}
									</script>
                                        <td class="command-td"><input type="text"></td>
                                    </tr>
                                  
                                    
                                </table>
                            
                            </div>
                            <div class="desc-con">
                                <div class = "tab-name-div">
                                    <div class="tab-name switch-color">설명입력</div>
                                </div>
                                  
                                <textarea class="desc" name="rt_desc"></textarea>
                                <div class="add-con">
                                    <input type="submit" class="add" value= "추가" name="command"></div>
                             </form> 
                          
                            </div>

                    </div>
                    
                </div>
             
                </div>
                
            </div>
    
</body>
</html>