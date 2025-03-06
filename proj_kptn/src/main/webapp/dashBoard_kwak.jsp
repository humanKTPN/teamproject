<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="dashBoard_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="dashBoard_kwak.js"></script>    
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
                        <i id="ham" class=" main-menu fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;<div class="logo"><i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES solution</div>
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
            </div>
            <div class="bome-con">


                    <div class="menuPage-con">    
                        <div class="container">
                        <div class="border-1">
                            <div class="border-top">
                                <div class="title">작업/생산관리</div>
                                <div class="dayWork" media="screen">
                                    <div id = "dayWork-board" >
                                        <div id = "day-list">
                                            금일 작업 지시서
                                        </div>
                                        <div class="list-con">
                                            <table class="list-table">
                                                <tr>
                                                    <td class="list-td">1</td>
                                                    <td class="list-td">싹싹지우개</td>
                                                    <td class="list-td">4,000개 필요</td>
                                                    <td class="list-td">생산중</td>
                                                </tr>
                                                <tr>
                                                    <td class="list-td">2</td>
                                                    <td class="list-td">처음처럼지우개</td>
                                                    <td class="list-td">100개 필요</td>
                                                    <td class="list-td">생산중</td>
                                                </tr>
                                                <tr>
                                                    <td class="list-td">3</td>
                                                    <td class="list-td">다지우개</td>
                                                    <td class="list-td">1,000개 필요</td>
                                                    <td class="list-td">생산중</td>
                                                </tr>
                                                <tr>
                                                    <td class="list-td">4</td>
                                                    <td class="list-td">하츄핑지우개</td>
                                                    <td class="list-td">5,000개 필요</td>
                                                    <td class="list-td">생산중</td>
                                                </tr>
                                                <tr>
                                                    <td class="list-td">4</td>
                                                    <td class="list-td">하츄핑지우개</td>
                                                    <td class="list-td">5,000개 필요</td>
                                                    <td class="list-td">생산중</td>
                                                </tr>
                                                <tr>
                                                    <td class="list-td">4</td>
                                                    <td class="list-td">하츄핑지우개</td>
                                                    <td class="list-td">5,000개 필요</td>
                                                    <td class="list-td">생산중</td>
                                                </tr>
                                                <tr>
                                                    <td class="list-td">4</td>
                                                    <td class="list-td">하츄핑지우개</td>
                                                    <td class="list-td">5,000개 필요</td>
                                                    <td class="list-td">생산중</td>
                                                </tr>
                                                <tr>
                                                    <td class="list-td">4</td>
                                                    <td class="list-td">하츄핑지우개</td>
                                                    <td class="list-td">5,000개 필요</td>
                                                    <td class="list-td">생산중</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                        <div id = "dayWork-board2">
                                            <div class="command-table-con">
                                                <table class="command-table">
                                                    <tr>
                                                        <th colspan='2' class="th">A라인</th>
                                                        <th colspan='2' class="th">B라인</th>
                                                        <th colspan='2' class="th">C라인</th>
                                                    </tr>
                                                        <tr>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">2호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">2호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">2호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">2호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">2호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">2호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                        </tr>
                                                       
                                                </table>
                                            </div>
                                        </div>                                  
                                </div>
                            </div>
                    </div>
                        <div class="border-2">
                            <div class="border">
                                <div class="title">재고현황</div>
                                <div id="bad">
                                    <div id = "badChart">
                                        <canvas id = "bdChart"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="border2">
                                <div class="title">불량률 현황</div>
                                <div id="tempHu">
                                    <div class="th2-con">
                                        <select value="제품명">
                                            <option>싹싹지우개</option>
                                            <option>처음처럼지우개</option>
                                            <option>다지우개</option>
                                            <option>하츄핑지우개</option>
                                        </select>
                                        <div id = "thchart-con">
                                            <canvas id="thchart" style="width: 60%; height: auto; "></canvas>
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