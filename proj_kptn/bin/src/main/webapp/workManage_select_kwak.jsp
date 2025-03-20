<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@page import= "tb_pr_1000mt.DAO_PR_Kwak" %>
 <%@page import= "tb_pr_1000mt.DTO_PR_Kwak_main" %>     
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="workManage_select_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="workManage_select_kwak.js"></script>    
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
<!--                          <img class="eraser-img" src="https://cdn.011st.com/11dims/resize/1000x1000/quality/75/11src/product/6297562089/B.jpg?506000000"> -->
                         <!-- <div class="detail-con"> -->
                            <table class="detail-table">
                                <tr>
                                    <th class="detail-th" scope = "col">생산코드</th>
                                    <th class="detail-th" scope = "col">생산일정코드</th>
                                    <th class="detail-th" scope = "col">라인호기코드</th>
                                    <th class="detail-th" scope = "col">라인호기명</th>
                                    <th class="detail-th" scope = "col">품목코드</th>
                                    <th class="detail-th" scope = "col">담당자명</th>
                                    <th class="detail-th" scope = "col">작업일자</th>
                                    <th class="detail-th" scope = "col">지시수량</th>
                                </tr>
                                
                                <%
                                
                                DAO_PR_Kwak dao = new DAO_PR_Kwak();
                                List<DTO_PR_Kwak_main> dto = dao.getDataInfo(request.getParameter("prod_cd"));
                                
                                DTO_PR_Kwak_main dt = dto.get(0);
                                
                                %>
                                <form method=post action="CNTRL_PR_Kwak">
                                <tr>
                                    <td class="detail-td"><%=dt.getPROD_CD() %></td>
                                    <td class="detail-td"><%=dt.getPROD_PLN_CD() %></td>
                                    <td class="detail-td"><%=dt.getLIUN_CD() %></td>
                                    <td class="detail-td"><%=dt.getLIUN_NM() %></td>
                                    <td class="detail-td"><%=dt.getITEM_CD() %></td>
                                    <td class="detail-td"><%=dt.getMNGR_NM() %></td>
                                    <td class="detail-td"><%=dt.getPROD_DT() %></td>
                                    <td class="detail-td"><%=dt.getINDC_QNTT() %></td>
                                </tr>
                                
                            </table>
                         <!-- </div> -->
                        </div>
                        </div>
                        <div class="bompro-con">
                            <div class="bom-con">
                                <h4>BOM : <%= dt.getBOM_CD() %></h4>
                                <div>
                                	<%=dt.getBOM_DESC() %>
                                </div>
                            </div>
                            <div class="process">
                                <h4>공정 : <%=dt.getRT_CD() %></h4>
                                <div>
                                	<%=dt.getRT_DESC() %>
                                </div>
                            </div>
                        </div>
                        <div class="add-con">
                            <input type=submit class="del" value="삭제" name="command">
                            <input type="hidden" name="prod_cd" value="<%=dt.getPROD_CD() %>" >
                        </div> 
                        </form>
                    </div>
                </div>
                    
                    </div> 
                </div>
            <!-- </div> -->
    <!-- </body> -->
    
</body>
</html>