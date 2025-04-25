<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>loginPG</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<!--     <script src="session.js"></script> -->
<link rel="stylesheet" href="resources/css/loginpage_Nam.css"
	type="text/css">
<script src="resources/js/loginpage_Nam.js"></script>
<script src="oac(ktpn).js"></script>

</head>
<body>
	<div id='blank'>
		<!-- 정리를 위한 공간 -->
<!-- 		아이디 비번일치 프로세스 만들기 -->
	</div>
	<div class='login_area'>
		<div class='middle_login' style='height: 400px'>
			<p id='pageinfo'>
				<span id='text'><i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human
					MES solution</span>
			</p>
			<div class='send'>
				<!-- 아이디 입력창 -->
				<form method="post" action="ktpn/">
					<div class='idarea'>
						<input type='text' id='uid' name='id' placeholder="아이디 입력"
							style='height: 30px'>
						<!-- 아이디 저장체크여부(미코딩) -->
						<label id='uidchkre'> <input type='checkbox'> 아이디
							저장
						</label>
					</div>
					<br>
					<div class='pwarea'>
						<!-- 비밀번호 입력창 -->
						<input type='password' id='upw' name='pw' placeholder="비밀번호 입력"
							style='height: 30px'>
					</div>
				</form>
				<button type='submit' id='login' name="checking">로그인</button>
			</div>
			<%-- 			<c:forEach var="dto" items="${resultList }"> --%>
			<%-- 							${dto.id } --%>
			<%-- 							${dto.pw } --%>
			<%-- 				</c:forEach> --%>
			<!-- 로그인 버튼 -->
		</div>
		<br>
		<!-- 유저여부체크 -->
		<!--             <div id='uchkmessege'> 자바스크립트로 조건에 따라 추가할 예정 -->
		<!--                 ( 여기는 회원이 맞는지 확인하는 구간입니다! 추후 자동으로 삽입될 예정 ) -->
		<!--             </div> -->



		<!-- 주의사항메시지 -->
		<div id='lost_messege'>** 회원가입이 필요한 경우 관리자에게 문의하시기 바랍니다. **</div>
		<!-- 회원정보 찾기 메뉴 -->
		<div class='buttons'>
			<button type='button' id='idfind'>아이디찾기</button>
			<button type='button' id='pwfind'>비밀번호찾기</button>
		</div>
		<br>
	</div>
	<div id="blank">
		<!-- 정리를 위한 공간 -->
	</div>

	<br>

	<!-- 	<h2>세션 정보</h2> -->
	<!-- 	<p> -->
	<!-- 		<strong>세션 ID:</strong> <span id="sessionId">로드 중...</span> -->
	<!-- 	</p> -->
	<!-- 	<p> -->
	<!-- 		<strong>저장된 username:</strong> <span id="username">로드 중...</span> -->
	<!-- 	</p> -->
	<!-- 	<p> -->
	<!-- 		<strong>세션 유지 시간 (초):</strong> <span id="sessionTimeout">로드 -->
	<!-- 			중...</span> -->
	<!-- 	</p> -->
	<!-- 	<p> -->
	<!-- 		<strong>세션 남은 시간:</strong> <span id="timer">로드 중...</span> -->
	<!-- 	</p> -->

	<!-- 	<p> -->
	<!-- 		<strong>세션 만료 여부:</strong> <span id="sessionExpired">확인 중...</span> -->
	<!-- 	</p> -->
</body>
</html>
