<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="masterdataManage_add_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="masterdataManage_add_kwak.js"></script>    
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
                                    <div class="tab-name switch-color">기준관리등록</div>
                                </div>
                            </div>
                        <div class="dropBox">
                        </div>
                        
                        <div class="command-loc">
                            <div class="command-div">
                                <table class="command-table">
                                    <tr>
                                        <th class="command-th" scope = "col">이미지업로드</th>
                                        <th class="command-th" scope = "col">기준관리코드</th>
                                        <th class="command-th" scope = "col">기준관리명</th>
                                        <th class="command-th" scope = "col">기준관리유형</th>
                                        <!-- <th class="command-th" scope = "col">설명</th> -->
                                    </tr>
                                    <tr>
                                    <form method="post" action="masterDataManagement_kwak_cotroller" enctype="multipart/form-data">
                                        <td class="command-td"><input type="file" name="file1" value="img"></td>
                                        <td class="command-td"><input type="text" name="MT_MNG_CD" disabled></td>
                                        <td class="command-td"><input type="text" name="MT_MNG_NM"></td>
                                        <td class="command-td" >
                                            <select name="TP_CLS_VAL">
                                                <option value="원자재">원자재</option>
                                                <option value="완제품">완제품</option>
                                                <option value="라인호기">라인호기</option>
                                                <option value="BOM">BOM</option>
                                                <option value="공정">공정</option>
                                                <option value="거래처">거래처</option>
                                            </select></td>
                                        <!-- <td class="command-td"><input type="text"></td> -->
                                    
                                    </tr>
                                    
                                </table>
                            
                            </div>
                            <div class="desc-con">
                                <div class = "tab-name-div">
                                    <div class="tab-name switch-color">설명입력</div>
                                </div>
                                <textarea class="desc" name="MT_MNG_DESC"></textarea>
                               		
                                <div class="add-con">
                                    <input type="submit" class="add" name="command" value="추가">
                                </div> 
                                </form>
                            </div>

                    </div>
                    
                </div>
             
                </div>
                
            </div>
    </body>
    
</body>
</html>