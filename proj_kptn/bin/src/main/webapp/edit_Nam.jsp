<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="edit_Nam.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="edit_Nam.js"></script>
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
                <div id="title-name">
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
                    <!-- html 들어갈 곳 -->
                    <div class='pagecon'>
                        <span id='pageinfo'>
                            글수정
                        </span>
                    </div>
                    <hr>
                    <div class="dom">
                        <div class="editprocess">
                            <div class='viewdom'>
                                <!-- <form action="writeview_Nam.html" method="get" id="summit"> -->
                                    <div class = 'title-con'>
                                        <span class='text'>제목</span>
                                        <input type="text" id='title' placeholder="제목을 입력하시오" value="신규직원 오리엔테이션 안내">
                                    </div>
                                    <div class = 'content-con'>
                                        <span class='text'>내용</span>
                                        <textarea type="text" id="content" placeholder="내용을 입력하세요">
신규직원들은 2025.2.20 14:30까지 테스트관으로 와주시기 바랍니다.

장소 : 본 회사 테스트관
시간 : 2025.2.20 14:30
준비물 : 필기구, 신분증, 반명함사진 1매</textarea>
                                    </div>
                                <!-- </form> -->
                        </div>
                        <div id='writemsg'>
                            <!-- 메시지 -->
                        </div>
                        <div class='buttons'>
                            <button type='submit' class = 'button edit'>수정</button>
                            <button type='submit' class = 'button cancel'>취소</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</body>

</html>