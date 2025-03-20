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
    <link rel="stylesheet" href="idfindpage_Nam.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="idfindpage_Nam.js"></script>
</head>

<body>
    <div class='idfindp'>
        <div class='findarea'>
            <div class='area-con'>
                <div class='input-form'>
                    <div class='menu'>
                        <div id='idfindC'>
                            <span id=idfindT>아이디 찾기</span>
                        </div>
                        <div id='pwfindC'>
                            <span id=pwfindT>비밀번호 찾기</span>
                        </div>
                    </div>
                    <span id='text'><i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES solution</span>
                    <div class='idfindInfo'>
                        <div class='nameInfo'>
                            <span id='conid'> 이름 </span>
                            <input type='text' id='name' placeholder="이름">
                        </div>
                        <div class='telInfo'>
                            <span id='connum'> 휴대폰번호 </span>
                            <input type='tel' id='tel' placeholder="휴대폰번호">
                        </div>
                    </div>
                    <div class = 'processarea'>
                        <div id='idfindprocess'>
                            <button type='button' id='result'> 아이디찾기 </button>
                        </div>
                        <div class='findres'>
                            <!-- 아이디 찾기 결과 표시하는 곳 -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>