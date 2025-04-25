<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- 검색기능만들기 -->
<body>
	<form method="post" action="edit">
	<table border="1">
		<c:if test="${not empty dto}">
			<tr>
				<th>id</th>
				<td><input type="text" id = "id" name="id" value="${dto.id}" disabled > </td>
				<td><input type="hidden" name="id" value="${dto.id}"></td>
			<tr>
				<th>pw</th>
				<td><input type ="text" id = "pw" name = "pw"
				placeholder = "비밀번호를 입력해주세요" value = "${dto.pw}"> </td>
			</tr>
			<tr>
				<th>mbr_nm</th>
				<td><input type ="text" id = "mbr_nm" name = "mbr_nm"
				placeholder = "이름을 입력해주세요" value = "${dto.mbr_nm}"> </td>
			</tr>
			<tr>
				<th>mbr_senm</th>
				<td><input type ="text" id = "mbr_senm" name = "mbr_senm"
				placeholder = "등급을 입력해주세요" value = "${dto.mbr_senm}"> </td>
			</tr>
			<tr>
				<th>dlt_yn</th>
				<td><input type = "text" id = "ytn_yn" name = "ytn_yn"
				placeholder = "삭제여부를 입력해주세요" value = "${dto.ytn_yn}" disabled> </td>
				<td><input type="hidden" name="ytn_yn" value="${dto.ytn_yn}">  </td>
			</tr>
		</c:if>
	</table>
	<div class = 'buttons'>
		<input type='submit' class='button edit' value="수정form">
	</div>
</form>
</body>
</html>