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
    <link rel="stylesheet" href="resources/css/edit_Nam.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/edit_Nam.js"></script>
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>

<body>
	<div class="menuPage-con">
		<!-- html 들어갈 곳 -->
		<div class='pagecon'>
			<span id='pageinfo'> 글수정 </span>
		</div>
		<hr>
		<form method="post" action="edit_Nam">
			<div class="dom">
				<div class="editprocess">
					<div class='viewdom'>
							<p>게시판 번호 : ${dto.BRD_NO }<input type="number" name="BRD_NO" value="${dto.BRD_NO }" disabled></p>
						<table>
							<tr class='title-con'>
								<td><span class='text'>제목</span></td>
								<td><input type="text" id='title' name = "TTL_NM"
								placeholder="제목을 입력하시오"
									value="${dto.TTL_NM }"></td>
							</tr>
							<tr class='content-con'>
								<td><span class='text'>내용</span></td>
								<td><textarea id="content" name = "BRD_DESC"
								placeholder="내용을 입력하세요">${dto.BRD_DESC }</textarea></td>
							</tr>
						</table>
<!-- 						<div id='time'> -->
<!-- <!-- 							수정일자가 들어오는곳 날짜 형식 문제 --> -->
<%-- 							최초 작성일자 : "${dto.REG_DTTM }" <input type="hidden" name="REG_DTTM" --%>
<%-- 								value="<fmt:formatDate value="${dto.REG_DTTM }" pattern="yyyy-MM-dd HH:mm:ss" />"> --%>
<%-- 							수정일자 : "${dto.MOD_DTTM }" <input type="hidden" name="MOD_DTTM" --%>
<%-- 								value="<fmt:formatDate value="${dto.MOD_DTTM }" pattern="yyyy-MM-dd HH:mm:ss" />"> --%>
<!-- 						</div> -->
						<div id='user'>
<!-- 							작성자가 들어오는곳 -->
							작성자 : "${dto.ID }" <input type="hidden" name="ID" value="${dto.ID }">
						</div>
					</div>
					<div id='writemsg'>
						메시지
					</div>
<!-- 					<div class='screat'> -->
<!-- 						<div id='screat'> -->
<!-- <!-- 							글이 들어오는곳 --> -->
<%-- <%-- 							비밀글여부 : ${dto.BLND_YN } <input type= 'text' name = 'BLND_YN' value ='${dto.BLND_YN }'> --%> --%>
<!-- 						</div> -->
<!-- 					</div> -->
					<div class='buttons'>
						<input type='submit' class='button edit' value="수정form">
						<button type='button' class='button cancel'>취소</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>

</html>