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
<link rel="stylesheet" href="FreeBoard_Nam.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="FreeBoard_Nam.js"></script>
<script src="oac(ktpn).js"></script>
<script>
// window.location.replace("boardcon");
</script>
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
				<div class='pageAll'>
					<div class='boardarea'>
						<div class="margin-con">
							<div class='pagecon'>
								<p id='pageinfo'>자유게시판</p>
							</div>
							<div class='middle_board'>
								<div class='searcharea'>
									<div class='selectbox'>
										<form>
											<select name='viewfilter' id='viewfilter'>
												<option value='allview'>모두</option>
												<option value='tilteview'>제목</option>
												<option value='contentview'>내용</option>
												<option value='writeuserview'>작성자</option>
											</select>
										</form>
									</div>
									<div class='fillvalue'>
										<input type='text' id='fillvalue' placeholder="검색어를 입력해주세요">
									</div>
									<div class='searchB'>
										<button type="button" id='search'>검색</button>
									</div>
								</div>
								<hr>
								<div>

									<table class='boardtable' border=1>
										<tr class='boardlist th' style="height: 30px;">
											<th class='num'>번호</td>
											<th class='writetitle'>제목</td>
											<th class='writeuser'>작성자</td>
											<th class='writedate'>작성일</td>
											<th class='viewcount'>조회수</td>
										</tr>
<!-- 										<table id="looler" name="fblist""> -->
											<c:forEach var="dto" items="${resultList}">
												<tr class='boardlist'>
													<td class="wnum">${dto.BRD_NO}</td>
													<td class="writetitle">${dto.TTL_NM}</td>
													<td class="writeuser">${dto.ID}</td>
													<td class='writedate'>${dto.REG_DTTM}</td>
													<td class='viewcount'>${dto.VW_CNT}</td>
												</tr>
											</c:forEach>
										</table>
										</div>
										<div class="page-num-con">
											<div class="page-num">
												<div class="page pre-page">< 이전</div>
												<div class="page">
													<span class="num bold">1</span> <span class="num">2</span>
													<span class="num">3</span> <span class="num">4</span> <span
														class="num">5</span>
												</div>
												<div class="page next-page">다음 ></div>
											</div>
											<div class="add-con">
												<div class="add">추가</div>
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

</body>

</html>