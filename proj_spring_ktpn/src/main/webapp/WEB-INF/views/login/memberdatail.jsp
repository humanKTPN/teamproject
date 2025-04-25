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
	<table border="1">
		<c:if test="${not empty dto}">
			<tr>
				<th>id</th>
				<td>${dto.id} </td>
			<tr>
				<th>pw</th>
				<td>${dto.pw} </td>
			</tr>
			<tr>
				<th>mbr_nm</th>
				<td>${dto.mbr_nm} </td>
			</tr>
			<tr>
				<th>mbr_senm</th>
				<td>${dto.mbr_senm} </td>
			</tr>
			<tr>
				<th>reg_dttm</th>
				<td>${dto.reg_dttm} </td>
			</tr>
			<tr>
				<th>mod_dttm</th>
				<td>${dto.mod_dttm} </td>
			</tr>
			<tr>
				<th>dlt_yn</th>
				<td>${dto.ytn_yn} </td>  
			</tr>
		</c:if>
		<c:if test="${empty dto}">
			<p> (테스트용)list가 null이거나 비어 있습니다</p>
			<p> 조회된 결과가 없습니다.</p>
		</c:if>
	</table>
	<div class = 'buttons'>
		<a href = "edit?id=${dto.id}"><button type='button' id ="edit"> 수정form </button></a>
		<a href = "member"> <button type="button" id = 'remove'> 삭제</button></a>
	</div>
<!-- <form> -->
<!-- </form> -->
</body>
</html>