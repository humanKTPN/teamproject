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
    <link rel="stylesheet" href="resources/css/writeview_Nam.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/writeview_Nam.js"></script>
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
         <span id='pageinfo'>
             글조회
         </span>
     </div>
     <hr>
    <div id='area'>
        <div class='viewarea'>
        
                <div id='fn'>
                    <!-- 게시판정보가 들어오는곳 -->
                    ${dto.BOARDFN}
                </div>
                <div id='brdnums'>
                    <!-- 게시글번호가 들어오는곳 -->
                    ${dto.BRD_NO}
                </div>
            <div class='titlemenu'>
                <div id='title'>
                    <!-- 제목이 들어오는곳 -->
                    ${dto.TTL_NM }
                </div>
                <div id='user'>
                    <!-- 작성자가 들어오는곳 -->
                    ${dto.ID }
                </div>
<!--                 <div id='time'> -->
<!--                     작성일자가 들어오는곳 -->
<%--                     작성일자 : <fmt:formatDate value="${dto.REG_DTTM }" pattern="yyyy-MM-dd HH:mm:ss" /> <br> --%>
<%--                     수정일자 : <fmt:formatDate value="${dto.MOD_DTTM }" pattern="yyyy-MM-dd HH:mm:ss" /> --%>
<!--                 </div> -->
            </div>
            <div class='contentmenu'>
                <div id='content'>
                    <!-- 글이 들어오는곳 -->
                    ${dto.BRD_DESC }
                </div>
            </div>
<!--             <div class='screat'> -->
<!--                 <div id='screat'> -->
<!--                     글이 들어오는곳 -->
<%--                     비밀글여부 : ${dto.BLND_YN } --%>
<!--                 </div> -->
<!--             </div> -->
            <div class = 'button'>
                <button type="button" id="remove">삭제</button>
                <a href = "fedit_Nam?BRD_NO=${dto.BRD_NO}"> <button type="button" id = 'edit'> 수정</button></a>
                <a href = ""><button type="button" id = 'list'> 목록</button></a>
            </div>
        </div>
    </div>
    </div>
</body>

</html>