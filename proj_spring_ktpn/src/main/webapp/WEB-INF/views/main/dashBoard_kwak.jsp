<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="resources/dashBoard_kwak.css">
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
                                <div class="title">작업/생산관리</div>
                                <div class="dayWork" media="screen">
                                    <div id = "dayWork-board" >
                                        <div id = "day-list">
                                            금일 작업 지시서
                                        </div>
                                        <div class="list-con">
                                            <table class="list-table">
                                                <tr>
                                                    <td class="list-td">1</td>
                                                    <td class="list-td">싹싹지우개</td>
                                                    <td class="list-td">4,000개 필요</td>
                                                    <td class="list-td">생산중</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                        <div id = "dayWork-board2">
                                            <div class="command-table-con">
                                                <table class="command-table">
                                                    <tr>
                                                        <th colspan='2' class="th">A라인</th>
                                                        <th colspan='2' class="th">B라인</th>
                                                        <th colspan='2' class="th">C라인</th>
                                                    </tr>
                                                        <tr>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">2호기</td>
                                                            <td class="td">가동중</td>
                                                            <td class="td">1호기</td>
                                                            <td class="td">가동중</td>
                                                        </tr>
                                                       
                                                </table>
                                            </div>
                                        </div>                                  
                                </div>
                            </div>
                    </div>
                        <div class="border-2">
                            <div class="border">
                                <div class="title">재고현황</div>
                                <div id="bad">
                                    <div id = "badChart">
                                        <canvas id = "bdChart"></canvas>
                                    </div>
                                </div>
                            </div>
                            <div class="border2">
                                <div class="title">불량률 현황</div>
                                <div id="tempHu">
                                    <div class="th2-con">
                                        <select value="제품명">
                                            <option>싹싹지우개</option>
                                            <option>처음처럼지우개</option>
                                            <option>다지우개</option>
                                            <option>하츄핑지우개</option>
                                        </select>
                                        <div id = "thchart-con">
                                            <canvas id="thchart" style="width: 60%; height: auto; "></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 
                </div>
<!--             </div> -->
<script>

    
<%
	int a=200;
%>


window.addEventListener('load',chart)

function chart(){
  new Chart(document.getElementById("bdChart"), {
      type: 'bar',
      data: {
        labels: ["지우개본품재고", "종이포장지재고", "비닐포장지재고", "완제품재고", "현주문량"],
        datasets: [
          {
            backgroundColor: ["#3e95cd"],
            data: [<%=a%>,5267,734,784,433],
            label: "수주 및 현재고",
          }
        ]
      },
      options: {
          plugins:{
              legend: { display: true },
              
          },
          indexAxis: 'y',
        title: {
          display: true,
          text: 'Predicted world population (millions) in 2050'
        }
      }
  });
  new Chart(document.getElementById("thchart"), {
    type: 'line',
    data: {
      labels: [1800,1900,2000],
      
      datasets: [{ 
          data: [1402,3700,5267],
          label: "목표량",
          borderColor: "#8e5ea2",
          fill: true
        },{ 
          data: [221,783,2478],
          label: "생산량",
          borderColor: "#3e95cd",
          fill: true
        },  { 
          data: [547,675,734],
          label: "불량",
          borderColor: "#3cba9f",
          fill: true
        }
      ]
    },
    options: {
         plugins:{
              legend: { display:  true},
          },
      // title: {
      //   display: true,
      //   text: 'World population per region (in millions)'
      // }
    }
  });
}

function dashBoard (dashCheck){
  if(dashCheck=='대시보드'){
  //   if (Chart.getChart('bdChart')) { // 'bdChart' ID를 가진 차트가 존재하는 경우
  //     console.log("?")
  //     Chart.getChart('bdChart').destroy(); // 차트 파괴
  //     Chart.getChart('thchart').destroy(); // 차트 파괴
  //     console.log("again?")
      new Chart(document.getElementById("bdChart2"), {
          type: 'bar',
          data: {
            labels: ["지우개본품재고", "종이포장지재고", "비닐포장지재고", "완제품재고", "현주문량"],
            datasets: [
              {
                backgroundColor: ["#3e95cd"],
                data: [<%=a%>,5267,734,784,433],
                label: "수주 및 현재고",
              }
            ]
          },
          options: {
              plugins:{
                  legend: { display: true },
                  
              },
              indexAxis: 'y',
            title: {
              display: true,
              text: 'Predicted world population (millions) in 2050'
            }
          }
      });
      new Chart(document.getElementById("thchart2"), {
        type: 'line',
        data: {
          labels: [1500,1600,1700],
          
          datasets: [{ 
              data: [1402,3700,5267],
              label: "목표량",
              borderColor: "#8e5ea2",
              fill: true
            },{ 
              data: [221,783,2478],
              label: "생산량",
              borderColor: "#3e95cd",
              fill: true
            },  { 
              data: [547,675,734],
              label: "불량",
              borderColor: "#3cba9f",
              fill: true
            }
          ]
        },
        options: {
             plugins:{
                  legend: { display:  true},
              },
          // title: {
          //   display: true,
          //   text: 'World population per region (in millions)'
          // }
        }
      });
    }
  }

// }

</script>
</body>
</html>