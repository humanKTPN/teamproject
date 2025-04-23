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
		<thead>
			<tr>
				<th>No.</th>
				<th>id</th>
				<th>mbr_nm</th>
				<th>mbr_senm</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="dto" items="${list}" varStatus = "loop">
			<tr>
				<td> ${loop.count} </td>
				<td> <a href="memberdatail?id=${dto.id}">${dto.id}</a> </td>
				<td> ${dto.mbr_nm} </td>
				<td> ${dto.mbr_senm} </td>
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<p> list가 null이거나 비어 있습니다</p>
		</c:if>
	</tbody>
	</table>

</body>
</html>