<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@page import= "tb_pr_1000mt.DAO_PR_Kwak" %>
 <%@page import= "tb_pr_1000mt.DTO_PR_Kwak" %>       
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
    <link rel="stylesheet" href="workManage_main_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="workManage_main_kwak.js"></script>    
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>
<body>
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
                            <!-- </i> -->
                        </div>  
                    </div>
                </div>
            <div class="main-menu-con">
                <!-- <div class="main-menu" id="main-menu">MENU 닫기</div> -->
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

                <!-- <div class="sub-menu">
                    <div class="subBut"><i class="fas fa-regular fa-arrow-right-from-bracket fa-lg"></i>&nbsp;로그아웃</div>
                </div> -->

            </div>
            <div class="bome-con">


                    <div class="menuPage-con">    
                       <!-- html 들어갈 곳 -->
                       <div class="background">
                        <div class="content-con">

                        
                        <div class = "tab-name-div">
                            <div class="tab-name">작업지시서 조회</div>
                        </div>
                        <div class="dropBox">
                        <form method="post" action="CNTRL_PR_Kwak">
                            <select name="cate" id="cate">
                                <option value="전체">전체</option>
                                <option value="품목코드">품목코드</option>
                                <option value="담당자명">담당자명</option>
                                <option value="호기">호기</option>
                            </select>
                            <input type="text" class="select" name="search_desc">
                            <input type="submit" class="submit" value="검색" name="command"/>
                            <input type="date" name="str_dt"> ~ <input type="date" name="end_dt">
                        </form>
                        </div>
                        
                        <div class="command-loc">
                            <div class="command-div">
                                <table class="command-table">
                                    <tr>
                                        <th class="command-th" scope = "col">생산코드</th>
                                        <th class="command-th" scope = "col">생산일정코드</th>
                                        <th class="command-th" scope = "col">라인호기코드</th>
                                        <th class="command-th" scope = "col">라인호기명</th>
                                        <th class="command-th" scope = "col">품목코드</th>
                                        <th class="command-th" scope = "col">담당자명</th>
                                        <th class="command-th" scope = "col">작업일자</th>
                                        <th class="command-th" scope = "col">지시수량</th>
                                        
                                    </tr>
                                    
                                    <%
                                    DTO_PR_Kwak_main dto = new DTO_PR_Kwak_main();
                                    dto.setCate(request.getParameter("cate"));
                                    
                                    dto.setSch(request.getParameter("search_desc"));
                                    
                                    DAO_PR_Kwak dao = new DAO_PR_Kwak(); 
                                    List<DTO_PR_Kwak_main> list = dao.schData(dto);
                                    
                                    

                                    for(DTO_PR_Kwak_main dt : list){
                                    %>
                                    
                                    <tr>
                                        <td class="command-td"><a href="workManage_select_kwak.jsp?prod_cd=<%=dt.getPROD_CD() %>"><%=dt.getPROD_CD() %></a></td>
                                        <td class="command-td"><%=dt.getPROD_PLN_CD() %></td>
                                        <td class="command-td"><%=dt.getLIUN_CD() %></td>
                                        <td class="command-td"><%=dt.getLIUN_NM() %></td>
                                        <td class="command-td"><%=dt.getITEM_CD() %></td>
                                        <td class="command-td"><%=dt.getMNGR_NM() %></td>
                                        <td class="command-td"><%=dt.getPROD_DT() %></td>
                                        <td class="command-td"><%=dt.getINDC_QNTT() %></td>
                                    </tr>
                         			<%
                                    }
                         			%>
                                  
                                    
                                </table>
                            </div>
                            <div class="page-num-con">
                                <div class="page-num">
                                    <div class="page pre-page">
                                        < 이전
                                    </div>
                                    <div class="page">
                                        <span class="num bold">1</span>
                                        <span class="num">2</span>
                                        <span class="num">3</span>
                                        <span class="num">4</span>
                                        <span class="num">5</span>
                                    </div>
                                    <div class = "page next-page">
                                        다음 >
                                    </div>
                                </div>
                                <div class="add-con">
                                    <div class="add">
                                        추가
                                    </div>
                                </div> 
                            </div>   
                        </div>
                        </div>
                    </div>
                </div>
            </div>
             
                    </div> 
                </div>
            </div>
    
</body>
</html>