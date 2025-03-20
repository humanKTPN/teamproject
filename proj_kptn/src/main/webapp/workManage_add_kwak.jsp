<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@page import= "tb_pr_1000mt.DAO_PR_Kwak" %>
 <%@page import= "tb_pr_1000mt.DTO_PR_Kwak" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="workManage_add_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="workManage_add_kwak.js"></script>        
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
                        <i id="ham" class="main-menu fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;<div class="logo"><i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES solution</div>
                    </div>
                    <div class="icon-sub">
                        관리자님 환영합니다.
                        <!-- <i class="fas fa-solid fa-gear fa-lg" style="display: flex; width: 60px; justify-content: space-between;" > -->
                        <i class="fas fa-regular fa-arrow-right-from-bracket fa-md">
                            <span class="subBut">로그아웃</span>
                        </i>
                        <!-- </i> -->
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
                        <div class="border_line">

                        
                       <!-- html 들어갈 곳 -->
                       <div class="pop">
                        <div class="add-table">
                        
                        <%
					        DAO_PR_Kwak dao = new DAO_PR_Kwak();
					        List<DTO_PR_Kwak> dto = dao.getData();
					        request.setAttribute("dtoList", dto);
					        
					        List<DTO_PR_Kwak> dtoMb = dao.getMember();
					        request.setAttribute("dtoListMb", dtoMb);
					        
					        List<DTO_PR_Kwak> dtoLine = dao.getLine();
					        request.setAttribute("dtoLine", dtoLine);
					        
						%>
                         <form method = "post" action="CNTRL_PR_Kwak">
                         <div class="select-body">
                            <div class="select-con">
                                <div class="select-1">
		                       생산코드<input type="text" id = "hoNo" placeholder="생산코드" disabled>
		                       
                               담당자명<select name="mb_nm" id="mb_nm" onclick="updateMbNm()">
									        <c:forEach var="dtM" items="${dtoListMb}">
									            <option value="${dtM.PR_MB_NM}">${dtM.PR_MB_NM}</option>
									        </c:forEach>
								</select>
								<script>
									function updateMbNm() {
									    var select = document.getElementById("mb_nm");
									    var selectedOption = select.options[select.selectedIndex];
// 									    var bomNm = selectedOption.getAttribute("data-item-cd");
// 									    document.getElementById("item_cd").value = bomNm;
									}
								</script>
                                

                                라인호기코드<select name="ln_cd" id="ln_cd" onclick="updateLnNm()">
								        <c:forEach var="dtL" items="${dtoLine}">
								            <option value="${dtL.LINE_CD}" data-ln-nm="${dtL.LINE_NM}">${dtL.LINE_CD}</option>
								        </c:forEach>
								</select>
								
									<script>
									function updateLnNm() {
									    var select = document.getElementById("ln_cd");
									    var selectedOption = select.options[select.selectedIndex];
									    var lnNm = selectedOption.getAttribute("data-ln-nm");
									    document.getElementById("ln_nm").value = lnNm;
									    document.getElementById("h_ln_nm").value = lnNm;
									    console.log(lnNm)
									}
								</script>
                              
                                
                                
                                </div>
                            </div>

                            <div class="select-con">
                                <div class="select-1">
                                <!-- 품목명<input type="text" placeholder="품목명입력"> -->
                                생산일정코드<input type="text" name="pln_cd" id="pln_cd" placeholder="생산일정코드" disabled>
                                		<input type="hidden" name="h_pln_cd" id="h_pln_cd">
                                품목코드<input type="text" name="item_cd" id="item_cd" disabled >	
                                	 <input type="hidden" name="h_item_cd" id="h_item_cd">
                                	 
                                
                                품목명<select name="item_nm" id="item_nm" onclick="updateBomNm()">
									        <c:forEach var="dt" items="${dtoList}">
									            <option value="${dt.ITEM_NM}" 
									            		data-item-cd="${dt.ITEM_CD}"
									            		data-pln-cd="${dt.PROD_PLN_CD}"
									            		data-indc-qntt="${dt.INDC_QNTT}"
									            		data-bom-cd="${dt.BOM_CD2}"
									            		data-bom-desc="${dt.BOM_DESC}"
									            		
									            		data-rt-cd="${dt.RT_CD2}"
									            		data-rt-desc="${dt.RT_DESC}"
									            		
									            		
									            		>${dt.ITEM_NM}</option>
									        </c:forEach>
									     
								</select>
								<script>
									function updateBomNm() {
									    var select = document.getElementById("item_nm");
									    var selectedOption = select.options[select.selectedIndex];
									    var bomNm = selectedOption.getAttribute("data-item-cd");
									    document.getElementById("item_cd").value = bomNm;
									    document.getElementById("h_item_cd").value = bomNm;
									    var bompln = selectedOption.getAttribute("data-pln-cd");
									    document.getElementById("pln_cd").value = bompln;
									    document.getElementById("h_pln_cd").value = bompln;
									    var bomcnt = selectedOption.getAttribute("data-indc-qntt");
									    document.getElementById("indc-qntt").value = bomcnt;
									    var bomcd = selectedOption.getAttribute("data-bom-cd");
									    document.getElementById("bom-cd").value = bomcd;
									    var bomDesc = selectedOption.getAttribute("data-bom-desc");
									    document.getElementById("bom-desc").value = bomDesc;
									    var rtDesc = selectedOption.getAttribute("data-rt-desc");
									    document.getElementById("rt-desc").value = rtDesc;
									    var rtcd = selectedOption.getAttribute("data-rt-cd");
									    document.getElementById("rt-cd").value = rtcd;
									}
								</script>
                               
                                
                                <!-- 납품처<input type="text" placeholder="납품처입력"> -->
                                
                                </div>
                            </div>
                            

                            <div class="select-con">
                                <div class="select-1">
                                지시수량<input type="text" id="indc-qntt" name="indc_qntt" placeholder="생산라인">
                                작업일자<input type="date" name="prod_dt" placeholder="일자입력">
                                라인호기명<input type="text" id = "ln_nm" placeholder="라인호기명" disabled>
                                	   <input type="hidden" id = "h_ln_nm" name="h_ln_nm">

                               
                                </div>
                            </div>
                        </div>
                         
                         </div>

                        </div>
                        <div class="bompro-con">
                            <div class="bom-con">
                                <h4>BOM : <input type="text" id="bom-cd" name="bom_cd"> </h4>
                 
                                <input type="text" name="bom-desc" id="bom-desc" style= "width: 90%; height: 90%">
                       
                            </div>
                            <div class="process">
                                  <h4>공정 : <input type="text" id="rt-cd" name="rt_cd"> </h4>
                                  
                 
                                <input type="text" name="rt-desc" id="rt-desc" style= "width: 90%; height: 90%">
                       
                            </div>
                        </div>
                        
                        <div class="confirm-con">
                        <input class="confirm" type="submit" value = "추가" name="command">
                        </form>
<!--                             <div class="confirm">저장</div> -->
                        </div>
                       <!-- html 들어갈 곳 -->
                    </div>
                </div>
                    </div> 
                </div>
            </div>
    </body>
    
</body>
</html>