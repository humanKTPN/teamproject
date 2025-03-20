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
<link rel="stylesheet" href="layOut_kwak.css" type="text/css">
<link rel="stylesheet" href="TestMM_update_park.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="layOut_kwak.js"></script>
<script src="TestMM_update_park.js" defer></script>
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
			<div class="menu">재고관리</div>
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

			<div>
				<div class="menuPage-con">
					<!-- html 들어갈 곳 -->
					<!-- TestMM_update -->

					<div class="containerMM_update">
						<div class="content">

							<div class="margin">

								<div class="tab-name-con">
									<div class="tab-name">재고 수정</div>
								</div>

								<!-- <div class="div_none"></div> -->

								<div class="table_scroll">
									<table class="material-table">
										<thead>
											<tr>
												<th scope="col" class="material-th">원자재코드</th>
												<th scope="col" class="material-th">원자재명</th>
												<th scope="col" class="material-th">입력 수량</th>
												<th scope="col" class="material-th">입고/출고</th>
												<th scope="col" class="material-th">작업자</th>
												<th scope="col" class="material-th">위치</th>
												<th scope="col" class="material-th">입력일</th>
												<th scope="col" class="material-th">비고</th>

											</tr>
										</thead>

										<tbody>
											<!-- 											원자재테이블 조회한 값 = mList -->
											<tr>
												<form method="post" action="imcon">



													<td id="Mcode" class="material-td Mcode"><input
														type="text" name="mcode" value="${mList.mtrl_cd }"
														readonly="readonly">${mList.mtrl_cd }</td>

													<td id="Mname" class="material-td"><input type="text"
														name="mname" value="${mList.mtrl_nm }" readonly="readonly">
														${mList.mtrl_nm }
													</td>

													<td id="Mea" class="material-td"><input type="text"
														name="newea" value="" placeholder="수량(EA) 입력"></td>

													<td id="" class="material-td">
														<select name="inNout">
															<option value="i">입고</option>
															<option value="o">출고</option>
														</select>
													</td>
													
													<td id="" class="material-td">
														<select name="worker">
                                    						<c:forEach var = "member" items = "${memberList }">
                                    							<option value="${member.MBR_NM }">${member.MBR_NM }</option>
                                    						</c:forEach>
                                    					</select>
													</td>

													<td id="Mloc" class="material-td">
														<select name="warehouse">
                                    						<option value="warehouse1">M창고1</option>
                                    						<option value="warehouse2">M창고2</option>
                                    						<option value="warehouse3">M창고3</option>
                                    		
                                    					</select>
													</td>
													
													<td id="Mloc" class="material-td">
														<input class="item" id="date" name="date" type="date" />
													</td>
													
													<td id="Mloc" class="material-td">
														<input class="item note" type="text" name="note" value="" placeholder="입력" />
													</td>

													<td><input type="hidden" name="command" value="update">
														<input type="submit" value="확인">
													</td>

												</form>


											</tr>


										</tbody>

									</table>
								</div>

								<div class="div_none">
									<!-- 빈 공간 -->
								</div>

								<div class="div_button">
									<button type="button" id="btn_update_confirm">
										<a class="btn_text_color" href="./TestMM_main_park.html">확인</a>
									</button>
								</div>
							</div>


						</div>

					</div>



				</div>


				<div></div>
			</div>
		</div>
	</div>
</body>

</body>

</html>