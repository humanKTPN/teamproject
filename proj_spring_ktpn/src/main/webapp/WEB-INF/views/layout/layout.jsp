<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Human MES Solution</title>
<link rel="icon" href="	https://cdn-icons-png.flaticon.com/512/262/262047.png" type="image/x-icon">
<link rel="stylesheet" href="resources/css/layOut_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/layOut_kwak.js"></script>   

</head>
<body>
	<!-- header -->
	<div>
<!-- 		header -->
		<div class="menu-con work">
            <div>
                <div id="title-name">
                    <div class="titleName">
                        <i id="ham" class=" main-menu fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;<i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES solution
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
                <div class="menu">기준관리</div>
                <!-- <div class="main-menu" id="main-menu">MENU 닫기</div> -->
                <div class="menu">작업관리</div>
                <div class="menu">생산관리</div>
                <div class="menu">생산리포팅</div>
                <div class="menu">재고관리</div>
                <div class="menu">품질관리</div>
            </div>
        </div>
	</div>
	<!-- main -->
	<div>
		<!-- side -->
		<div class="side">
<!-- 			side menu -->
				<div class="board">
		            <div class="mainmenu" id="work1">
		                <div class="menuBut">대시보드</div>
		                <div class="menuBut">게시판</div>
		                <div class="menuBut">공지사항</div>
		                
		            </div>
		       <div class="menuPage-con">    
                      <!-- content -->
					<div class="content" style="width: 100%;display: flex;justify-content: center; height: 100%;align-items: center;">
						<tiles:insertAttribute name="content" />
					</div>
           	  </div>
      		</div>
		</div>
		
	</div>

</body>
</html>