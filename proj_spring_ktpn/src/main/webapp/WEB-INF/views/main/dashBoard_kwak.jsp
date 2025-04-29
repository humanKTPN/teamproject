<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="resources/css/dashBoard_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
<!--     <script src="resources/dashBoard_kwak.js"></script>     -->
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>
<body>

<!--             <div class="bome-con"> -->


                    <div class="menuPage-con">    
                        <div class="container">
                        <div class="border-1">
                            <div class="border-top">
                                <div class="title">작업관리<button type="button" class="mView" id="pr">더보기</button></div>
                                <div class="dayWork" media="screen">
                                    <div id = "dayWork-board" >
                                        <div id = "day-list">
                                            금일 작업 지시서
                                        </div>
                                        <div class="list-con">
                                            <table class="list-table">
											 <tbody>
											          <c:choose>
											            <c:when test="${not empty dayWorkList}">
											              <c:forEach var="work" items="${dayWorkList}" varStatus="st">
											                <tr>
											                  <td class="list-td">${st.count}</td>
											                  <td class="list-td"><a href="prDetail?prod_cd=${work.prod_cd}"><c:out value="${work.prod_cd}"/></a></td>
											                  <td class="list-td"><c:out value="${work.item_cd}"/> </td>
											                  <td class="list-td"><c:out value="${work.indc_qntt}"/>개 필요</td>
											                </tr>
											              </c:forEach>
											            </c:when>
											            <c:otherwise>
											              <tr>
											                <td class="list-td" colspan="4">오늘 등록된 작업 지시가 없습니다.</td>
											              </tr>
											            </c:otherwise>
											          </c:choose>
											        </tbody>
                                            </table>
                                        </div>
                                    </div>

                                </div>
                            </div>
                    </div>
                        <div class="border-2">
                            <div class="border">
                                <div class="title">재고현황<button type="button" class="mView" id="mr">더보기</button></div>
                                <div id="bad">
                                    <div id = "badChart">
                                        <canvas id = "bdChart"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="border2">
                                <div class="title">생산량 현황<button type="button" class="mView" id="prd">더보기</button></div>
                                <div id="tempHu">
                                    <div class="th2-con">
                                        <select value="제품명" id="productSelect">
                                            <option>싹싹지우개</option>
                                            <option>처음처럼지우개</option>
                                            <option>다지우개</option>
                                            <option selected>하츄핑지우개</option>
                                        </select>
                                        <div id = "thchart-con">
                                            <canvas id="thchart" style="width: 30vw; height: 230px; "></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 
                </div>
<!--             </div> -->
<script>
    let productionChart;

    window.addEventListener('load', () => {
      drawInventoryChart();
      drawProductionChart();
      document
        .getElementById('productSelect')
        .addEventListener('change', drawProductionChart);
    });

    function drawInventoryChart() {
      fetch(`${pageContext.request.contextPath}/inventory`)
        .then(res => {
          if (!res.ok) throw new Error(res.statusText);
          return res.json();
        })
        .then(list => {
          const labels = list.map(e => e.itemName);
          const data   = list.map(e => e.quantity);

          new Chart(
            document.getElementById("bdChart").getContext("2d"),
            {
              type: 'bar',
              data: {
                labels: labels,
                datasets: [{
                  label: "현재 재고",
                  data: data,
                  backgroundColor: "#3e95cd"
                }]
              },
              options: {
                indexAxis: 'y',
                plugins: {
//                   title: { display: true, text: '재고현황' },
                  legend: { display: false }
                },
                responsive: false,
                scales: {
//                   x: { title: { display: false, text: '수량' } },
//                   y: { title: { display: false, text: '항목명' } }
                }
              }
            }
          );
        })
        .catch(err => console.error("재고 데이터 로드 실패:", err));
    }

    function drawProductionChart() {
      const productName = document.getElementById('productSelect').value;
      const url = new URL(
        `${pageContext.request.contextPath}/production`,
        window.location.origin
      );
      if (productName) url.searchParams.append('productName', productName);

      fetch(url)
        .then(res => {
          if (!res.ok) throw new Error(res.statusText);
          return res.json();
        })
        .then(list => {
          const labels     = list.map(e => e.period);
          const targetData = list.map(e => e.targetQty);
          const actualData = list.map(e => e.actualQty);

          const ctx = document.getElementById("thchart").getContext("2d");
          if (productionChart) productionChart.destroy();
          productionChart = new Chart(ctx, {
            type: 'line',
            data: {
              labels: labels,
              datasets: [
                {
                  label: "목표량",
                  data: targetData,
                  borderColor: "#8e5ea2",
                  fill: false
                },
                {
                  label: "생산량",
                  data: actualData,
                  borderColor: "#3e95cd",
                  fill: false
                }
              ]
            },
            options: {
              plugins: { title: { display: false, text: '생산현황' } },
              scales: {
//                 x: { title: { display: true, text: '기간' } },
//                 y: { title: { display: true, text: '수량' } }
              },
              responsive: false,
              devicePixelRatio: 2
            }
          });
        })
        .catch(err => console.error("생산 데이터 로드 실패:", err));
    }
    
    document.querySelector('#pr').addEventListener('click',function(){
        window.location.href = '/ktpn/pr'
      })

      document.querySelector('#mr').addEventListener('click',function(){
        window.location.href = '/ktpn/mainmp'
      })
      document.querySelector('#prd').addEventListener('click',function(){
        window.location.href = '/ktpn/tb_pr_mt2'
      })
  </script>
</body>
</html>