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
    <link rel="stylesheet" href="masterdataManage_main_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="masterdataManage_main_kwak.js"></script>    
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
                        <i id="ham" class="fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;<div class="logo"><i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES solution</div>
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
                                    <div class="tab-name switch-color">기준관리</div>
                                </div>
                                <div class = "tab-name-div">
                                    <div class="tab-name">BOM</div>
                                </div>
                                <div class = "tab-name-div">
                                    <div class="tab-name">공정</div>
                                </div>
                            </div>
                        <div class="dropBox">
                        <form action="#">
                            <select name="categories" id="cate">
                                <option value="전체">전체</option>
                                <option value="구분">구분</option>
                                <option value="설명">설명</option>
                            </select>
                            <input type="select" class="sel">
                            <input type="submit" class="search" value="검색" />
                            </form>
                        </div>
                        
                        <div class="command-loc">
                            <div class="command-div">
                                <table class="command-table">
                                    <tr>
                                        <th class="command-th" scope = "col">번호</th>
                                        <th class="command-th" scope = "col">기준관리코드</th>
                                        <th class="command-th" scope = "col">기준관리명</th>
                                        <th class="command-th" scope = "col">설명</th>                                        
                                    </tr>
                                    <%
                                    DAO_MD_main_Kwak dao = new DAO_MD_main_Kwak();
                                    List<DTO_MD_main_Kwak> dto = dao.getData();
                                    int i = 1;
                                    for(DTO_MD_main_Kwak dt : dto){
                                    	
//                                     List<DTO_MD_main_Kwak> imgList = dao.getData();
                                    %>
                                    <tr>
                                        <td class="command-td"><%=i %></td>
                                        <td class="command-td"><%=dt.getMT_MNG_CD() %></td>
                                        <td class="command-td"><a href="masterdataManage_select_kwak.jsp?MT_MNG_CD=<%=dt.getMT_MNG_CD() %>"><%=dt.getMT_MNG_NM() %></a></td>
                                        <td class="command-td"><%=dt.getMT_MNG_DESC() %></td>
                                    </tr>
                                    <%
                                    i++;
                                    }
                                    %>
                                </table>
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
    </body>
    
</body>
</html>