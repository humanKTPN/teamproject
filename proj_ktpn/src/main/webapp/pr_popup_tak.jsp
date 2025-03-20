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
<link rel="stylesheet" href="Production management_tak.css">
<script src="pr_popup_tak.js"></script>
<!-- <script src="Production management_tak.js"></script> -->
</head>

<body>
	<div class="ssretouch_box">
		<dlv class="pm_correction">
		<div class="boxTit">생산 관리</div>
		<div class="pr_ssmanu">
			<div class="ssTitle" style="margin: 15px 0 0;">생산 일정 관리</div>
			<form method="post" action="tb_pr_mt">
				<!--<div class="pr_correction_con">
				 <div style="width: 100px;">생산일정코드:</div>
					<select name="PROD_PLN_CD">
						<c:forEach var="dto" items="${resultList }">
							<option value="${dto.prod_pln_cd }">${dto.prod_pln_cd }</option>
						</c:forEach>
					</select>
				</div> -->
				<div class="pr_correction_con">
					<div style="width: 100px;">품명:</div>
					<select class="itemNm" name="itemNm">
						<c:forEach var="dto" items="${StandardList }">
							<option value="${dto.mt_mng_nm }">${dto.mt_mng_nm }</option>
						</c:forEach>
					</select>
				</div>
				<div class="pr_correction_con">
					<div style="width: 100px;">품목 코드:</div>
					<select class="itemCd" name="itemCd">
						<c:forEach var="dto" items="${StandardList }">
							<option value="${dto.mt_mng_cd }">${dto.mt_mng_cd }</option>
						</c:forEach>
					</select>
				</div>
				<div class="pr_correction_con">
					<div style="width: 100px;">목표 수량:</div>
					<input type="text" style="height: 18px;" name="trgProdCnt" value="">
				</div>
				<div class="pr_correction_con">
					<div style="width: 150px;">기한설정:</div>
					<div class="pr_date">
						<input type="date" name="prodStrtDt" value=""
							style="height: 20px; width: 60%;">&nbsp;&nbsp;부터&nbsp;&nbsp;
						<input type="date" name="prodEndDt" value=""
							style="height: 20px; width: 60%;">&nbsp;&nbsp;까지&nbsp;&nbsp;
					</div>
				</div>
				<div class="pm_correction_but">
					<select class="pm_correction_but_con" name="command">
						<option value="insert">시작</option>
						<option value="update">수정</option>
						<option value="complete">완료</option>
					</select> <input type="hidden" name="type" value="${type}">
					<div class="end" style="margin: 0;">
						<input class="pm_correction_but_con" type="submit" value="등록">
					</div>
				</div>
			</form>
		</div>
	</div>
	</div>
</body>
<script>
	
</script>

</html>