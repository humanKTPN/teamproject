<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="tb_md_1000mt.DAO_MD_main_Kwak" %>
   <%@ page import="tb_md_1000mt.DTO_MD_main_Kwak" %>
   <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="processDesc_select.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="processDesc_select.js"></script>    
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>
<body>
    <!-- <body> -->
        <div class="menu-con work">
            <div>
                <div id ="title-name">
                    <div class="titleName">
                        <i id="ham" class=" main-menu fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;<div class="logo"><i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES solution</div>
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
                       <!-- html 들어갈 곳 -->
                        <div class="border_line">
                       <div class="pop">
                        <div class="add-table">
 								<%
                                    DAO_MD_main_Kwak dao = new DAO_MD_main_Kwak();
                                    List<DTO_MD_main_Kwak> dto = dao.getDataInfo(request.getParameter("cd"));
                                    DTO_MD_main_Kwak dt = dto.get(0);
                                    	

                                       if(dt.getIMG_PATH_ADR() == null){
				                        
                                    %>
                                        
			                         <div class="eraser-img"></div>
			                         <%
											} else {
			                         %>
			                        	<img border="0" class="eraser-img" src="download.do?filename=<%= dt.getIMG_PATH_ADR()  %>">
			                         <%
											}
			                         %>
<!--                          <img class="eraser-img" src="https://image.made-in-china.com/202f0j00bkIWOGfPbNqz/White-Colour-Chloride-PVC-Raw-Material-Virgin-and-Recycle-PVC-Resin.webp"> -->
                            <table class="detail-table">
                                <tr>
<!--                                     <th class="detail-th" scope = "col">번호</th> -->
                                    <th class="detail-th" scope = "col">기준관리코드</th>
                                    <th class="detail-th" scope = "col">기준관리명</th>
                                    <!-- <th class="detail-th" scope = "col">설명</th> -->
                                </tr>
                                <tr>
                            <form method="post" action="masterDataManagement_kwak_cotroller">
<!--                                     <td class="detail-td"><span >1</span></td> -->
                                    <td class="detail-td"><span class="spn-td"><input type='text' class="mod-td" value="<%=dt.getMT_MNG_CD() %>" name="MT_MNG_CD" disabled></span></td>
                                    <td class="detail-td"><span class="spn-td"><input type='text' class="mod-td" value="<%=dt.getMT_MNG_NM() %>" name="MT_MNG_NM"></span></td>
                                    <!-- <td class="detail-td"><span class="spn-td">검사</span><input type='text' class="mod-td hide" value="검사"></td> -->
                                </tr>
                                
                            </table>
                        </div>
                        </div>
                        <div class="bompro-con">
                            <div class="bom-con">
                                <h4>항목명 :<span class="spn-td"> <input type='text' class="mod-td" value="<%=dt.getMT_MNG_NM() %>" disabled></span></h4>
                                <table>
                                    <tr>
                                       <td>
                                       
<!--                                         <img class="eraser-img bom-item" src="https://image.made-in-china.com/202f0j00bkIWOGfPbNqz/White-Colour-Chloride-PVC-Raw-Material-Virgin-and-Recycle-PVC-Resin.webp"> -->
                                       </td> 
                                       <td>
                                           <span class="spn-td"><input type='text' class="mod-td" value="<%=dt.getMT_MNG_DESC() %>" name="MT_MNG_DESC"></span>
                                       </td>
                                
                                    </tr>
                                 
                                </table>
                                
                                
                            </div>
                        </div>
                        <div class="add-con">
                            <div class="mode-con">
                                <input type="submit" class="mod" value="완료">
                                <input type="hidden" value="완료" name="command">
                                <input type="hidden" value="<%=dt.getMT_MNG_CD() %>" name="MT_MNG_CD">

                             </form>
                            </div>
                        </div> 
                    </div>
                </div>
                    
                    </div> 
                </div>
            <!-- </div> -->
    <!-- </body> -->
    
</body>
</html>