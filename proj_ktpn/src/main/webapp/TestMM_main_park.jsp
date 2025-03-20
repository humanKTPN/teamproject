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
<link rel="stylesheet" href="TestMM_main_park.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="TestMM_main_park.js" defer></script>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="layOut_kwak.js"></script>

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
					<!-- TestMM_main -->
					<div class="containerMM">
						<div class="content">

							<div class="margin">

								<div class="tab-name-con">
									<div class="tab-name">재고현황</div>
								</div>

								<!-- 원자재 테이블과 완제품 테이블 구분 -->
								<div class="select_table">
									<div class="select_table1">원자재</div>

									<div class="select_table2">완제품</div>
								</div>

								<div class="select_input_search-btn">

									<form action="#">

										<select name="select_MM" id="select_MM">
											<option value="all" selected="selected">전체</option>
											<option value="Mcode">자재코드</option>
											<option value="Mname">자재명</option>
											<option value="Morder">주문필요</option>
											<option value="Mloc">재고위치</option>
										</select> <input type="select" class="select">
										<!-- <input class="select_day" id="select_MM_eve" type="date" value=""
                                                max="2999-12-31" , min="1970-01-01"> -->
										<input class="select_day" id="select_MM_today" type="date"
											value="" max="2999-12-31" , min="1970-01-01"> <input
											type="submit" class="submit" value="검색">

									</form>
									
									<div class="div_form_order">
										<form method="post" action="dealcomp">
											<input type="hidden" name="command" value="order"> 
<!-- 											<input type="submit" value="거래처"> -->
										
											
											<button type="submit" class="btn_main_order btn_text_color">
												거래처
<!-- 												<a class="btn_text_color" href="./TestMM_order_park.jsp">거래처</a> -->
											</button>
										</form>
									</div>
									
									<div class="div_form_order">
										<form method="post" action="imcon">
<!-- 											<input type="hidden" name="command" value="mLog">  -->
<!-- 											<input type="submit" value="거래처"> -->
										
											
											<button name="command" value="mLog" type="submit" class="btn_main_order btn_text_color">
												원자재로그
 												
											</button>
										</form>
									</div>
									
									<div class="div_form_order">
										<form method="post" action="impcon">
											<input type="hidden" name="command" value="pLog"> 
<!-- 											<input type="submit" value="거래처"> -->
										
											
											<button type="submit" class="btn_main_order btn_text_color">
												완제품로그
 												
											</button>
										</form>
									</div>

								</div>

								<!-- 추후 추가 할 내용 
                                         원자재 테이블, 완제품 테이블을 만들어서
                                         메뉴에서 원자재, 완제품 버튼을 누르면 해당하는 테이블이 화면에 출력
                                         ex) 원자재(기본화면, 강조 표시)   완제품
                                             자재코드   자재명   수량 ... ... ...
                                             AA-dd-01 염화비닐  1000 ... ...

                                             원자재            완제품(클릭, 강조 표시)
                                             품목코드     품목명     수량 ... ... ... 
                                             aa-dd-cc   싹싹지우개   1000 ... ...  
                                    -->

								<div>
									<div id="show_table1">
										<table class="material-table">
											<thead>
												<tr>
<!-- 													<th scope="col" class="material-th">삭제체크</th> -->
													<th scope="col" class="material-th">원자재코드</th>
													<th scope="col" class="material-th">원자재명</th>
													<th scope="col" class="material-th">기준 수량</th>
													<th scope="col" class="material-th">현재 수량</th>
													<th scope="col" class="material-th">주문필요</th>
													<th scope="col" class="material-th">위치</th>
													<th scope="col" class="material-th">수정</th>
													
												</tr>
											</thead>
											<tbody>
												<c:forEach var="Mdata" items="${materialList }">

													<tr>
														<form method="post" action="imcon">
															<td><input type="checkbox" name="deleteCheck"
																value="Y"></td>
															
															<td id="Mcode" class="material-td Mcode">
																<input type="hidden" name="code" value="${Mdata.mtrl_cd }">
															${Mdata.mtrl_cd }
															</td>
															
															<td id="Mname" class="material-td">
															<input type="hidden" name="name" value="${Mdata.mtrl_nm }">
															${Mdata.mtrl_nm }</td>
															
															<td id="Msntea" class="material-td">
															<input type="hidden" name="sntea" value="${Mdata.stn_cnt }">
															${Mdata.stn_cnt }</td>
															
															<td id="Mcurea" class="material-td">
															<input type="hidden" name="ea" value="${Mdata.crnt_aftr_cnt }">
															${Mdata.crnt_aftr_cnt }</td>
															
															<td id="Morder" class="material-td">
															<input type="hidden" name="order" value="${Mdata.ordr_rqrd_yn }">
															${Mdata.ordr_rqrd_yn }</td>
															
															<td id="Mloc" class="material-td">
															<input type="hidden" name="loc" value="${Mdata.mtrl_loc_nm }">
															${Mdata.mtrl_loc_nm }</td>

															<td id="Mbutton" class="material-td">
<!-- 																<input type="hidden" name="command" value="update">  -->
<!-- 																<input type="submit" value="수정"> -->

<!-- 																<button type="button" class="btn_main_update"> -->
<!-- 																	<a class="btn_text_color" -->
<!-- 																		href="./TestMM_update_park.jsp">수정</a> -->
<!-- 																</button> -->
																
																<button name="command" value="move_update_Page" type="submit" class="btn_main_update">
																	수정
																</button>
															</td>
														</form>
													</tr>
												</c:forEach>


											</tbody>

										</table>

										<div class="div_none">
										<!-- 빈 공간 -->
										</div>

										<div class="div_form_order">
										<form method="post" action="imcon">
											<input type="hidden" name="command" value="undo"> 
<!-- 											<input type="submit" value="거래처"> -->
										
											
											<button type="submit" class="btn_main_order btn_text_color">
												입력취소(undo)
 												
											</button>
										</form>
										</div>
										
										
										<div class="div_button">
										<form method="post" action="imcon">
											<button name="command" value="move_add_Page" type="submit" id="btn_main_add">
												추가
											</button>
										</form>
										
										
										
<!-- 										<button type="button" id="btn_main_add"> -->
<!-- 											<a class="btn_text_color" href="TestMM_add_park.jsp">추가</a> -->
<!-- 										</button> -->
				
<!-- 										<button type="button" id="btn_main_delete"> -->
												
<!-- 											<a class="btn_text_color" href="TestMM_delete_park.jsp">삭제</a> -->
<!-- 										</button> -->
								
										</div>

									</div>

									<div id="show_table2" class="hide">
										<table class="material-table product-table">
											<thead>
												<tr>
<!-- 													<th scope="col" class="material-th product-th">삭제체크</th> -->
													<th scope="col" class="material-th product-th">완제품코드</th>
													<th scope="col" class="material-th product-th">완제품명</th>
													<th scope="col" class="material-th product-th">수량</th>
													<th scope="col" class="material-th product-th">재고위치</th>
													<th scope="col" class="material-th product-th">수정</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="Pdata" items="${productList }">

													<tr>
													
														<form method="post" action="impcon">
														
														
															<td><input type="checkbox" name="deleteCheck"
																value="Y"></td>
															
															<td id="Pcode" class="material-td Mcode product-td">
																<input type="hidden" name="code" value="${Pdata.fnsh_code }">
																${Pdata.fnsh_code }
															</td>
														
															<td id="Pname" class="material-td product-td">
																<input type="hidden" name="code" value="${Pdata.fnsh_nm }">
																${Pdata.fnsh_nm }
															</td>
														
															<td id="Pcurea" class="material-td product-td">
																<input type="hidden" name="code" value="${Pdata.crnt_aftr_cnt }">
																${Pdata.crnt_aftr_cnt }
															</td>
														
															<td id="Ploc" class="material-td product-td">
																<input type="hidden" name="code" value="${Pdata.fnsh_loc_nm }">
																${Pdata.fnsh_loc_nm }
															</td>

															<td id="Mbutton" class="material-td product-td">
																<input type="hidden" name="command" value="move_updateP_Page">
																<input type="submit" value="수정">

<!-- 															<button type="button" class="btn_main_update"> -->
<!-- 																<a class="btn_text_color" -->
<!-- 																	href="./TestMM_update_park.jsp">수정</a> -->
<!-- 															</button> -->
															</td>
														
														</form>
													</tr>
												</c:forEach>


											</tbody>

										</table>
										
										<div class="div_none">
										<!-- 빈 공간 -->
										</div>
										
										<div class="div_form_order">
		
											<form method="post" action="impcon">
												<input type="hidden" name="command" value="undo"> 
<!-- 												<input type="submit" value="거래처"> -->
										
											
												<button type="submit" class="btn_main_order btn_text_color">
													입력취소(undo)
 												
												</button>
											</form>
										</div>
										
										
										<div class="div_button">
										
										<form method="post" action="impcon">
											<button name="command" value="move_addP_Page" type="submit" id="btn_main_add">
												추가
											</button>
										</form>
										
<!-- 										<button type="button" id="btn_main_add"> -->
<!-- 											<a class="btn_text_color" href="TestMM_add_park.jsp">추가</a> -->
<!-- 										</button> -->
				
<!-- 										<button type="button" id="btn_main_delete"> -->
												
<!-- 											<a class="btn_text_color" href="TestMM_delete_park.jsp">삭제</a> -->
<!-- 										</button> -->
								
										</div>

									</div>

									<div class="div_none">
										<!-- 빈 공간 -->
									</div>


									<!-- 자재코드 입력하면 자재명이 자동으로 입력
                                        수량은 기존에 있는것과 연동
                                        주문 필요도 입력창에선 없고 결과창에만 표시 -->

									<!-- 히스토리 항목 추가 -->

									<!-- 페이지 번호 -->
									<div class="flex_page">
										<div class="item_page pre_page">
											<a id="a_before" href=""> < 이전 </a>
										</div>

										<div class="item_page">
											<a class="num bold" href="">1</a> <a class="num" href="">2</a>
											<a class="num" href="">3</a> <a class="num" href="">4</a> <a
												class="num" href="">5</a>
										</div>

										<div class="item_page next_page">
											<a id="a_after" href=""> 다음 > </a>
										</div>
									</div>

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