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
    <link rel="stylesheet" href="resources/css/writeprocess_nam.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/writeprocess_nam.js"></script>
    <script src="oac(ktpn).js"></script>
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
             <span id='pageinfo'> 글쓰기 </span>
         </div>
         <hr>
         
         <div class="dom">
             <div class="writeprocess">
                 <div class='viewdom'>
                     <form action="writeprocess_nam" method="post" id="summit">
<!--                      로그인세션 -->
<%--                      작성자 : "${dto.ID }" <input type="hidden" name="ID" value="${dto.ID }"> --%>
                     	<table>
                         <tr class = 'title-con'>
                             <td><span class='text'>제목</span></td>
                             <td><input type="text" id='title' name = "TTL_NM" placeholder="제목을 입력하시오"
									value="${dto.TTL_NM }"></td>
                         </tr>
                         <tr class = 'content-con'>
                             <td><span class='text'>내용</span></td>
                             <td><textarea id="content" name = "BRD_DESC" placeholder="내용을 입력하세요">${dto.BRD_DESC }</textarea></td>
                         </tr>
                         </table>
                     <div id='writemsg'>
                         
                     </div>
                     <div class='writebutton'>
                         <button type='submit' id='button'>글쓰기</button>
                     </div>
                     </form>
                 </div>
             </div>
         </div>
     </div>
</body>

</html>