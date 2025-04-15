<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>기준관리 등록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS 파일 -->
    <link rel="stylesheet" href="resources/masterdataManage_add_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- JavaScript 파일 -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/masterdataManage_add_kwak.js"></script>
    <style>
        /* 모바일 버전 및 추가 스타일을 여기에 작성하세요 */
    </style>
</head>
<body>
              <div class="menuPage-con">
                <div class="background">
                    <div class="margin">
                        <!-- 탭 영역 -->
                        <div class="tab-con">
                            <div class="tab-name-div">
                                <div class="tab-name switch-color">기준관리등록</div>
                            </div>
                        </div>
                        <div class="dropBox">
                            <!-- 필요시 추가 콘텐츠 삽입 -->
                        </div>
                        
                        <!-- 추가(등록) 폼 영역 -->
                        <div class="command-loc">
                            <form method="post" action="${pageContext.request.contextPath}/mdadd" enctype="multipart/form-data">
                                <div class="command-div">
                                    <table class="command-table">
                                        <tr>
                                            <th class="command-th" scope="col">이미지업로드</th>
                                            <th class="command-th" scope="col">기준관리코드</th>
                                            <th class="command-th" scope="col">기준관리명</th>
                                            <th class="command-th" scope="col">기준관리유형</th>
                                        </tr>
                                        <tr>
                                            <td class="command-td">
                                                <input type="file" name="file1" value="img">
                                            </td>
                                            <td class="command-td">
                                                <!-- 코드 자동 생성 시 디폴트 값을 전달받거나 사용자 입력 없이 disabled 처리 -->
                                                <input type="text" name="MT_MNG_CD" disabled>
                                            </td>
                                            <td class="command-td">
                                                <input type="text" name="MT_MNG_NM">
                                            </td>
                                            <td class="command-td">
                                                <select name="TP_CLS_VAL">
                                                    <option value="원자재">원자재</option>
                                                    <option value="완제품">완제품</option>
                                                    <option value="라인호기">라인호기</option>
                                                    <option value="BOM">BOM</option>
                                                    <option value="공정">공정</option>
                                                    <option value="거래처">거래처</option>
                                                </select>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                
                                <div class="desc-con">
                                    <div class="tab-name-div">
                                        <div class="tab-name switch-color">설명입력</div>
                                    </div>
                                    <textarea class="desc" name="MT_MNG_DESC"></textarea>
                                    <div class="add-con">
                                        <input type="submit" class="add" name="command" value="추가">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- // 추가(등록) 폼 영역 -->
                    </div>
                </div>
            </div>
</body>
</html>
