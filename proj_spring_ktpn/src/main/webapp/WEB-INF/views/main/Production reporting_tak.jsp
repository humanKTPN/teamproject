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
    <link rel="stylesheet" href="resources/css/layOut_kwak.css">
    <link rel="stylesheet" href="resources/css/Production reporting_tak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="resources/js/layOut_kwak.js"></script>
    <script src="resources/js/Production reporting_tak.js"></script>
    <script src="resources/js/echarts.min_tak.js"></script>
    <style>
        /******************
            모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>


</head>

<body>
<div class="menuPage-con">
                <!-- html 들어갈 곳 -->
                <div id="work4">
                    <div class="pr_box1">
                        <div class="date_box">
                            <table class="date_box_manu">
                                <tr>
                                    <td class="date_point date_ssManu1 date_ssList1 point2">일별 생산량</td>
                                    <td class="date_point date_ssManu2 date_ssList2">주간별 생산량</td>
                                    <td class="date_point date_ssManu3 date_ssList3">월별생산량</td>
                                </tr>
                            </table>
                            <div class="ssgraph" id="date_ssManu1">
                                <div class="graph_wrap">
                                    <select class="line_graph_day" style="margin: 10px;">
                                        <option value="1">A라인</option>
                                        <option value="2">B라인</option>
                                        <option value="3">C라인</option>
                                    </select>
                                    <!-- 일별 A 라인 -->
                                    <div class="graph_box_day_a">
                                        <!--그래프 js-->
                                        <!-- 1단계: ECharts 설치하기 -->
                                        <!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
                                        <div style="font-weight: 600;">1호기</div>
                                        <div id="main1_day_a" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">2호기</div>
                                        <div id="main2_day_a" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">3호기</div>
                                        <div id="main3_day_a" style="width: 100%;height: 190px;"></div>
                                        <!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

                                    </div>
                                    <!-- 일별 B 라인 -->
                                    <div class="graph_box_day_b hide">
                                        <!--그래프 js-->
                                        <!-- 1단계: ECharts 설치하기 -->
                                        <!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
                                        <div style="font-weight: 600;">1호기</div>
                                        <div id="main1_day_b" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">2호기</div>
                                        <div id="main2_day_b" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">3호기</div>
                                        <div id="main3_day_b" style="width: 100%;height: 190px;"></div>
                                        <!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

                                    </div>
                                    <!-- 일별 C 라인 -->
                                    <div class="graph_box_day_c hide">
                                        <!--그래프 js-->
                                        <!-- 1단계: ECharts 설치하기 -->
                                        <!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
                                        <div style="font-weight: 600;">1호기</div>
                                        <div id="main1_day_c" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">2호기</div>
                                        <div id="main2_day_c" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">3호기</div>
                                        <div id="main3_day_c" style="width: 100%;height: 190px;"></div>
                                        <!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

                                    </div>
                                </div>
                            </div>
                            <div class="ssgraph hide" id="date_ssManu2">
                                <div class="graph_wrap">
                                    <select class="line_graph_week" style="margin: 10px;">
                                        <option value="1">A라인</option>
                                        <option value="2">B라인</option>
                                        <option value="3">C라인</option>
                                    </select>
                                    <!-- 주별 A 라인 -->
                                    <div class="graph_box_week_a">
                                        <!--그래프 js-->
                                        <!-- 1단계: ECharts 설치하기 -->
                                        <!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
                                        <div style="font-weight: 600;">1호기</div>
                                        <div id="main1_week_a" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">2호기</div>
                                        <div id="main2_week_a" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">3호기</div>
                                        <div id="main3_week_a" style="width: 100%;height: 190px;"></div>
                                        <!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

                                    </div>
                                    <!-- 주별 B 라인 -->
                                    <div class="graph_box_week_b hide">
                                        <!--그래프 js-->
                                        <!-- 1단계: ECharts 설치하기 -->
                                        <!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
                                        <div style="font-weight: 600;">1호기</div>
                                        <div id="main1_week_b" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">2호기</div>
                                        <div id="main2_week_b" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">3호기</div>
                                        <div id="main3_week_b" style="width: 100%;height: 190px;"></div>
                                        <!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

                                    </div>
                                    <!-- 주별 C 라인 -->
                                    <div class="graph_box_week_c hide">
                                        <!--그래프 js-->
                                        <!-- 1단계: ECharts 설치하기 -->
                                        <!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
                                        <div style="font-weight: 600;">1호기</div>
                                        <div id="main1_week_c" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">2호기</div>
                                        <div id="main2_week_c" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">3호기</div>
                                        <div id="main3_week_c" style="width: 100%;height: 190px;"></div>
                                        <!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

                                    </div>
                                </div>
                            </div>
                            <div class="ssgraph hide" id="date_ssManu3">
                                <div class="graph_wrap">
                                    <select class="line_graph_month" style="margin: 10px;">
                                        <option value="1">A라인</option>
                                        <option value="2">B라인</option>
                                        <option value="3">C라인</option>
                                    </select>
                                    <!-- 월별 A 라인 -->
                                    <div class="graph_box_month_a">
                                        <!--그래프 js-->
                                        <!-- 1단계: ECharts 설치하기 -->
                                        <!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
                                        <div style="font-weight: 600;">1호기</div>
                                        <div id="main1_month_a" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">2호기</div>
                                        <div id="main2_month_a" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">3호기</div>
                                        <div id="main3_month_a" style="width: 100%;height: 190px;"></div>
                                        <!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

                                    </div>
                                    <!-- 월별 B 라인 -->
                                    <div class="graph_box_month_b hide">
                                        <!--그래프 js-->
                                        <!-- 1단계: ECharts 설치하기 -->
                                        <!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
                                        <div style="font-weight: 600;">1호기</div>
                                        <div id="main1_month_b" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">2호기</div>
                                        <div id="main2_month_b" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">3호기</div>
                                        <div id="main3_month_b" style="width: 100%;height: 190px;"></div>
                                        <!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

                                    </div>
                                    <!-- 월별 C 라인 -->
                                    <div class="graph_box_month_c hide">
                                        <!--그래프 js-->
                                        <!-- 1단계: ECharts 설치하기 -->
                                        <!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
                                        <div style="font-weight: 600;">1호기</div>
                                        <div id="main1_month_c" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">2호기</div>
                                        <div id="main2_month_c" style="width: 100%;height: 190px;"></div>
                                        <div style="font-weight: 600;">3호기</div>
                                        <div id="main3_month_c" style="width: 100%;height: 190px;"></div>
                                        <!-- 3단계: 초기화 및 차트 옵션 설정하기 -->

                                    </div>
                                </div>
                            </div>
                        </div>



                        <div class="totalBox">
                            <div class="numberBox">
                                <div class="pr_boxTit">호기별 생산량 조회</div>
                                <hr>
                                <div style="display: flex; justify-content: space-evenly; margin-bottom: 15px;">
                                    <div>라인 :</div>
                                    <select class="mu_box">
                                        <option value="1">A라인 1호기</option>
                                        <option value="2">A라인 2호기</option>
                                        <option value="3">A라인 3호기</option>
                                        <option value="4">B라인 1호기</option>
                                        <option value="5">B라인 2호기</option>
                                        <option value="6">B라인 3호기</option>
                                        <option value="7">C라인 1호기</option>
                                        <option value="8">C라인 2호기</option>
                                        <option value="9">C라인 3호기</option>
                                    </select>

                                </div>
                                <div class="ssTable">
                                    <table>
                                        <tr>
                                            <th class="es1">기간별</th>
                                            <th class="es2">생산량</th>
                                        </tr>
                                        <tr>
                                            <td class="es1">금일 생산량</td>
                                            <td class="es2" id="es_0">${dto.liun_nm } ea</td>
                                        </tr>
                                        <tr>
                                            <td class="es1">금주 생산량</td>
                                            <td class="es2" id="es_1">125 ea</td>
                                        </tr>
                                        <tr>
                                            <td class="es1">금월 생산량</td>
                                            <td class="es2" id="es_2">521 ea</td>
                                        </tr>
                                        <tr>
                                            <td class="es1">금월 불량률</td>
                                            <td class="es2" id="es_3">2%</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="pr_box2">
                                <!-- 가동설비현황 박스 -->
                                <div class="ingBox">
                                    <div class="pr_boxTit">가동 설비 현황</div>
                                    <hr>
                                    <div class="ssTable">
                                        <table>
                                            <tr>
                                                <th class="es1">설비명</th>
                                                <th class="es2">가동상태</th>
                                            </tr>
                                            <tr>
                                                <td class="es1">A라인 1호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">A라인 2호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">A라인 3호기</td>
                                                <td class="es2 stop">정지(유휴시간)</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">A라인 4호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">A라인 5호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">A라인 6호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">B라인 1호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">B라인 2호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">B라인 3호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">B라인 4호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">C라인 1호기</td>
                                                <td class="es2 stop">정지(유휴시간)</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">C라인 2호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">C라인 3호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">C라인 4호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                            <tr>
                                                <td class="es1">A라인 1호기</td>
                                                <td class="es2">가동중</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="main_date_pi">
                    <div class="date_list">
                        <!-- 일별,품목별 총생산량 박스 -->
                        <div class="date_ssBox" id="date_ssList1">
                            <div class="date_ssBox_tit">일별 생산량</div>
                            <div class="date_ssTable">
                                <table>
                                    <tr>
                                        <th class="es3">설비명</th>
                                        <th class="es4">생산량</th>
                                        <th class="es5">설비명</th>
                                        <th class="es6">생산량</th>
                                        <th class="es7">설비명</th>
                                        <th class="es8">생산량</th>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 1호기</td>
                                        <td class="es4">15 ea</td>
                                        <td class="es5">B라인 1호기</td>
                                        <td class="es6">19 ea</td>
                                        <td class="es7">C라인 1호기</td>
                                        <td class="es8">17 ea</td>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 2호기</td>
                                        <td class="es4">12 ea</td>
                                        <td class="es5">B라인 2호기</td>
                                        <td class="es6">13 ea</td>
                                        <td class="es7">C라인 2호기</td>
                                        <td class="es8">11 ea</td>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 3호기</td>
                                        <td class="es4">15 ea</td>
                                        <td class="es5">B라인 3호기</td>
                                        <td class="es6">13 ea</td>
                                        <td class="es7">C라인 3호기</td>
                                        <td class="es8">11 ea</td>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 4호기</td>
                                        <td class="es4">13 ea</td>
                                        <td class="es5">B라인 4호기</td>
                                        <td class="es6">15 ea</td>
                                        <td class="es7">C라인 4호기</td>
                                        <td class="es8">10 ea</td>
                                    </tr>
                                </table>
                            </div>
                            <div class="date_ssBox_tit">품목별 금일 총 생산량
                            </div>
                            <select class="pr_bay" style="margin-left: 20px;">
                                <option value="1">싹싹지우개</option>
                                <option value="2">처음처럼지우개</option>
                                <option value="3">우유빛지우개</option>
                                <option value="4">뭐든지우개</option>
                                <option value="5">리셋지우개</option>
                            </select>
                            <div class="ssTotal" id="ssTotal1">24ea</div>
                        </div>
                        <!-- 주간별,품목별 총생산량 박스 -->
                        <div class="date_ssBox hide" id="date_ssList2">
                            <div class="date_ssBox_tit">주간별 생산량</div>
                            <div class="date_ssTable">
                                <table>
                                    <tr>
                                        <th class="es3">설비명</th>
                                        <th class="es4">생산량</th>
                                        <th class="es5">설비명</th>
                                        <th class="es6">생산량</th>
                                        <th class="es7">설비명</th>
                                        <th class="es8">생산량</th>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 1호기</td>
                                        <td class="es4">56 ea</td>
                                        <td class="es5">B라인 1호기</td>
                                        <td class="es6">67 ea</td>
                                        <td class="es7">C라인 1호기</td>
                                        <td class="es8">65 ea</td>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 2호기</td>
                                        <td class="es4">58 ea</td>
                                        <td class="es5">B라인 2호기</td>
                                        <td class="es6">64 ea</td>
                                        <td class="es7">C라인 2호기</td>
                                        <td class="es8">59 ea</td>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 3호기</td>
                                        <td class="es4">71 ea</td>
                                        <td class="es5">B라인 3호기</td>
                                        <td class="es6">68 ea</td>
                                        <td class="es7">C라인 3호기</td>
                                        <td class="es8">61 ea</td>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 4호기</td>
                                        <td class="es4">59 ea</td>
                                        <td class="es5">B라인 4호기</td>
                                        <td class="es6">67 ea</td>
                                        <td class="es7">C라인 4호기</td>
                                        <td class="es8">81 ea</td>
                                    </tr>
                                </table>
                            </div>

                            <div class="date_ssBox_tit">품목별 주간 총 생산량</div>
                            <select class="pm_week" style="margin-left: 20px;">
                                <option value="1">싹싹지우개</option>
                                <option value="2">처음처럼지우개</option>
                                <option value="3">우유빛지우개</option>
                                <option value="4">뭐든지우개</option>
                                <option value="5">리셋지우개</option>
                            </select>
                            <div class="ssTotal" id="ssTotal2">213ea</div>
                        </div>
                        <!-- 월별,품목별 총생산량 박스 -->
                        <div class="date_ssBox hide" id="date_ssList3">
                            <div class="date_ssBox_tit">월별 생산량</div>
                            <div class="date_ssTable">
                                <table>
                                    <tr>
                                        <th class="es3">설비명</th>
                                        <th class="es4">생산량</th>
                                        <th class="es5">설비명</th>
                                        <th class="es6">생산량</th>
                                        <th class="es7">설비명</th>
                                        <th class="es8">생산량</th>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 1호기</td>
                                        <td class="es4">246 ea</td>
                                        <td class="es5">B라인 1호기</td>
                                        <td class="es6">278 ea</td>
                                        <td class="es7">C라인 1호기</td>
                                        <td class="es8">263 ea</td>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 2호기</td>
                                        <td class="es4">269 ea</td>
                                        <td class="es5">B라인 2호기</td>
                                        <td class="es6">283 ea</td>
                                        <td class="es7">C라인 2호기</td>
                                        <td class="es8">258 ea</td>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 3호기</td>
                                        <td class="es4">304 ea</td>
                                        <td class="es5">B라인 3호기</td>
                                        <td class="es6">285 ea</td>
                                        <td class="es7">C라인 3호기</td>
                                        <td class="es8">294 ea</td>
                                    </tr>
                                    <tr>
                                        <td class="es3">A라인 4호기</td>
                                        <td class="es4">279 ea</td>
                                        <td class="es5">B라인 4호기</td>
                                        <td class="es6">286 ea</td>
                                        <td class="es7">C라인 4호기</td>
                                        <td class="es8">283 ea</td>
                                    </tr>
                                </table>
                            </div>
                            <div class="date_ssBox_tit">품목별 월 총 생산량</div>
                            <select class="pm_month" style="margin-left: 20px;">
                                <option value="1">싹싹지우개</option>
                                <option value="2">처음처럼지우개</option>
                                <option value="3">우유빛지우개</option>
                                <option value="4">뭐든지우개</option>
                                <option value="5">리셋지우개</option>
                            </select>
                            <div class="ssTotal" id="ssTotal3">935ea</div>
                        </div>
                    </div>
                    <div class="main_piBox">
                        <!--그래프 js-->
                        <!-- 1단계: ECharts 설치하기 -->
                        <script src="./echarts.min_tak.js"></script>
                        <!-- 2단계: DOM 컨테이너 준비하기: 너비(width), 높이(height) 설정하기 -->
                        <div id="main_pi" style="width: 100%;height: 100%;"></div>
                        <!-- 3단계: 초기화 및 차트 옵션 설정하기 -->
                        <!-- <script type="text/javascript">
                            // 3-1. 준비한 DOM 컨테이너에서 echarts 초기화하기
                            let myChart_pi = echarts.init(document.getElementById('main_pi'))

                            option = {
                                title: {
                                    text: '월 통계 자료',
                                    subtext: '',
                                    left: 'center'
                                },
                                tooltip: {
                                    trigger: 'item'
                                },
                                legend: {
                                    orient: 'vertical',
                                    left: 'left'
                                },
                                series: [
                                    {
                                        name: 'KTPN',
                                        type: 'pie',
                                        radius: '50%',
                                        data: [
                                            { value: 1048, name: '월 목표량' },
                                            { value: 735, name: '월 생산량' },
                                            { value: 735, name: '월 불량률' },
                                        ],
                                        emphasis: {
                                            itemStyle: {
                                                shadowBlur: 10,
                                                shadowOffsetX: 0,
                                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                                            }
                                        }
                                    }
                                ]
                            };
                            // 3-3. 차트 옵션 설정하기
                            myChart_pi.setOption(option)
                        </script> -->
                    </div>
                </div>
            </div>
</body>

</html>