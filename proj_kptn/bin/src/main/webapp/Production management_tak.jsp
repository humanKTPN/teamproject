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
<link rel="stylesheet" href="layOut_tak.css">
<link rel="stylesheet" href="Production management_tak.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="layOut_tak.js"></script>
<script src="Production management_tak.js"></script>
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
					<i id="ham" class=" main-menu fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;
					<div class="logo">
						<i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES
						solution
					</div>
				</div>
				<div class="icon-sub">
					관리자님 환영합니다.
					<!-- <i class="fas fa-solid fa-gear fa-lg" style="display: flex; width: 60px; justify-content: space-between;" > -->
					<i class="fas fa-regular fa-arrow-right-from-bracket fa-md"> <span
						class="subBut">로그아웃</span>
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
					<div class="dayWork-T" id="work3">
						<div class="line_ssbox">
							<div class="boxTit">라인 별 생산 현황</div>
							<hr>
							<div class="table-con">
								<div class="line_manu">
									<table>
										<tr class="ssLine">
											<td class="ssLine0 point">전체라인</td>
											<td class="ssLine1">A라인</td>
											<td class="ssLine2">B라인</td>
											<td class="ssLine3">C라인</td>
										</tr>
									</table>
									<input class="pm_mm_but" type="button" value="관리">
								</div>

								<div class="ssTable" id="ssLine0">
									<table>
										<tr class="tableTop">
											<th class="cs1">설비</th>
											<th class="cs2">생산코드</th>
											<th class="cs3">품번코드</th>
											<th class="cs4">품명</th>
											<th class="cs5">생산시작시간</th>
											<th class="cs6">생산완료시간</th>
											<th class="cs7">생산자</th>
											<th class="cs8">설비상태</th>
										</tr>
									</table>
									<table class="pm_table">
										<tr>
											<td class="cs1">A-1호기</td>
											<td class="cs2">B25-0204-015</td>
											<td class="cs3">SSJ-02</td>
											<td class="cs4">싹싹지우개</td>
											<td class="cs5">2025.02.04<br>15:12:34
											</td>
											<td class="cs6">00:00:00</td>
											<td class="cs7">김기동</td>
											<td class="cs8">가동중</td>
										</tr>
										<tr>
											<td class="cs1">${liun_nm }</td>
											<td class="cs2">${prod_cd }</td>
											<td class="cs3">${item_cd }</td>
											<td class="cs4">${item_nm }</td>
											<td class="cs5">${prod_strt_time}</td>
											<td class="cs6">${prod_end_time}</td>
											<td class="cs7">${work_nm}</td>
											<td class="cs8">${eqpm_oprt_stts_val}</td>
										</tr>

									</table>
								</div>
								<div class="ssTable hide" id="ssLine1">
									<table>
										<tr class="tableTop">
											<th class="cs1">설비</th>
											<th class="cs2">생산코드</th>
											<th class="cs3">품번코드</th>
											<th class="cs4">품명</th>
											<th class="cs5">생산시작시간</th>
											<th class="cs6">생산완료시간</th>
											<th class="cs7">생산자</th>
											<th class="cs8">설비상태</th>
										</tr>
									</table>
									<table class="pm_table">
										<tr>
											<td class="cs1">A-1호기</td>
											<td class="cs2">B25-0204-015</td>
											<td class="cs3">SSJ-02</td>
											<td class="cs4">싹싹지우개</td>
											<td class="cs5">2025.02.04<br>15:12:34
											</td>
											<td class="cs6">00:00:00</td>
											<td class="cs7">김기동</td>
											<td class="cs8">가동중</td>
										</tr>
									</table>
								</div>
								<div class="ssTable hide" id="ssLine2">
									<table>
										<tr class="tableTop">
											<th class="cs1">설비</th>
											<th class="cs2">생산코드</th>
											<th class="cs3">품번코드</th>
											<th class="cs4">품명</th>
											<th class="cs5">생산시작시간</th>
											<th class="cs6">생산완료시간</th>
											<th class="cs7">생산자</th>
											<th class="cs8">설비상태</th>
										</tr>
									</table>
									<table class="pm_table">
										<tr>
											<td class="cs1">B-1호기</td>
											<td class="cs2">B25-0204-043</td>
											<td class="cs3">FTJ-05</td>
											<td class="cs4">처음처럼지우개</td>
											<td class="cs5">2025.02.04<br>15:58:30
											</td>
											<td class="cs6">00:00:00</td>
											<td class="cs7">홍희야</td>
											<td class="cs8">가동중</td>
										</tr>
									</table>
								</div>
								<div class="ssTable hide" id="ssLine3">
									<table>
										<tr class="tableTop">
											<th class="cs1">설비</th>
											<th class="cs2">제품코드</th>
											<th class="cs3">품번코드</th>
											<th class="cs4">품명</th>
											<th class="cs5">생산시작시간</th>
											<th class="cs6">생산완료시간</th>
											<th class="cs7">생산자</th>
											<th class="cs8">설비상태</th>
										</tr>
									</table>
									<table class="pm_table">
										<tr>
											<td class="cs1">C-1호기</td>
											<td class="cs2">B25-0204-028</td>
											<td class="cs3">UBJ-01</td>
											<td class="cs4">우유빛지우개</td>
											<td class="cs5">2025.02.04<br>15:44:12
											</td>
											<td class="cs6">2025.02.04<br>16:12:32
											</td>
											<td class="cs7">김둘리</td>
											<td class="cs8 stop">정지</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div>
							<div class="ss">
								<div class="schedule">
									<div class="ssDate_box">
										<div class="date_manu">
											<div class="boxTit">생산 일정</div>
											<div style="width: 50%;">
												<input type="date" style="height: 20px; width: 30%;">~
												<input type="date" style="height: 20px; width: 30%;">
												<input class="date_but" type="button" value="확인">
											</div>
											<input class="pr_mm_but" type="button" value="관리">
										</div>
										<hr>
										<div class="schedule_con">
											<table>
												<tr class="tableTop">
													<th class="schedule1">품번코드</th>
													<th class="schedule2">품명</th>
													<th class="schedule3">목표시작기한</th>
													<th class="schedule4">목표종료기한</th>
													<th class="schedule5">목표생산수량</th>
												</tr>
											</table>
											<table class="pr_table">
												<tr>
													<td class="schedule1">SSJ-02</td>
													<td class="schedule2">싹싹지우개</td>
													<td class="schedule3">2025.02.01</td>
													<td class="schedule4">2025.02.25</td>
													<td class="schedule5">1500ea</td>
												</tr>
												<tr>
													<td class="schedule1">${MT_MNG_CD}</td>
													<td class="schedule2">${ITEM_NM}</td>
													<td class="schedule3">${PROD_STRT_DT}</td>
													<td class="schedule4">${PROD_END_DT}</td>
													<td class="schedule5">${TRG_PROD_CNT}</td>
												</tr>
											</table>
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
