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
<link rel="stylesheet" href="resources/css/freeBoard_Nam.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<script src="resources/js/freeBoard_Nam.js"></script>
<style>
/******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
</style>
</head>

<body>
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
							<table class='boardtable'>
								<tr class='boardlist th' style="height: 30px;">
									<th class='num'>번호</th>
									<th class='writetitle'>제목</th>
									<th class='writeuser'>작성자</th>
									<th class='writedate'>작성일</th>
									<th class='viewcount'>조회수</th>
								</tr>
								<c:forEach var="dto" items="${list}">
									<tr class='boardlist' style="height: 30px;">
										<td class="wnum">${dto.BRD_NO}</td>
										<td class="writetitle"><a href="writeview_Nam?BRD_NO=${dto.BRD_NO}">${dto.TTL_NM}</a></td>
										<td class="writeuser">${dto.ID}</td>
										<td class='writedate'>${dto.REG_DTTM}</td>
										<td class='viewcount'>${dto.VW_CNT}</td>
									</tr>
								</c:forEach>
								<c:if test="${empty list}">
									<p> (테스트용)list가 null이거나 비어 있습니다</p>
									<p> 조회된 결과가 없습니다.</p>
								</c:if>
			
							</table>
						</div>
						<div class="page-num-con">
							<div class="page-num">
							
								<c:if test="${currentPage > 1}">
								    <a href="notice?page=${currentPage - 1}" class="page pre-page">< 이전</a>
								</c:if>
									<c:forEach var="i" begin="1" end="${totalPages}">
								        <c:choose>
									        <c:when test="${i == currentPage}">
									            <a href="notice?page=${i}" style="font-weight:bold;">${i}</a>
									        </c:when>
									        <c:otherwise>
									            <a href="notice?page=${i}">${i}</a>
									        </c:otherwise>
									    </c:choose>
								    </c:forEach>
								<c:if test="${currentPage < totalPages}">
								    <a href="notice?page=${currentPage + 1}" class="page next-page">다음 ></a>
								</c:if>
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

</body>

</html>