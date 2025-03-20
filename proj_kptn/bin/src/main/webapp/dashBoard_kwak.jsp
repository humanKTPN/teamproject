<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 여기에 대시보드 css 파일옮기기 -->
    <link rel="stylesheet" href="dashBoard_kwak.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.7/dist/chart.umd.min.js"></script>
    <script src="dashBoard_kwak.js"></script>    
    <style>
        /******************
        모바일 버전 구현(불량쪽 차트는 ....)
        *******************/
    </style>
</head>
<body>
        <div class="menu-con work">
            <div>
                <div id ="title-name">
                    <div class="titleName">
                        <i id="ham" class=" main-menu fas fa-solid fa-bars fa-lg"></i>&nbsp;&nbsp;<div class="logo"><i class="fas fa-solid fa-infinity fa-lg"></i>&nbsp;Human MES solution</div>
                    </div>
                    <div class="icon-sub">
                        관리자님 환영합니다.
                        <!-- <i class="fas fa-solid fa-gear fa-lg" style="display: flex; width: 60px; justify-content: space-between;" > -->
                        <i class="fas fa-regular fa-arrow-right-from-bracket fa-md">
                            <span class="subBut">로그아웃</span>
                        </i>
                        <!-- </i> -->
                    </div>  
                </div>
            </div>
        <div class="main-menu-con">
            <!-- <div class="main-menu" id="main-menu">MENU 닫기</div> -->
            <div class="menu">기준관리</div>
            <div class="menu">작업관리</div>
            <div class="menu">생산관리</div>
            <div class="menu">생산리포팅</div>
            <div class="menu">자재관리</div>
            <div class="menu">품질관리</div>
        </div>
        </div>
        <div class="board">
            
            <div class="mainmenu" id="work1">
                <div class="menuBut">대시보드</div>
                <div class="menuBut">게시판</div>
                <div class="menuBut">공지사항</div>
                <!-- <div class="menuBut">기준관리</div> -->
            </div>
            <div class="bome-con">


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
            </div>
<script>
window.addEventListener('load',init)



function init(){

    //메뉴 열었다 닫았다 하기<시작>
    document.querySelector('#ham').addEventListener('click',function(){
        
        
        if(document.querySelector('.mainmenu').classList.length == 1){
            document.querySelector('.mainmenu').classList.add('hide')
            // document.querySelector('#main-menu').textContent = 'MENU 열기'
        } else if (document.querySelector('.mainmenu').classList.length == 2){
            document.querySelector('.mainmenu').classList.remove('hide')
            // document.querySelector('#main-menu').textContent = 'MENU 닫기'
        }

    }) //메뉴 열었다 닫았다 하기<끝>
    // 탑 버튼 내용나오게 하기 <시작>
    // console.log(document.querySelector('.mainmenu').classList.length)// 클래스 개수
    let menus = document.querySelectorAll('.menu')
    for (menu of menus){//탑 메뉴탭에 클릭이벤트 주기
        menu.addEventListener('click',function(e){

            // console.log(e.target.textContent) // 어떤 메뉴를 눌렀는지 확인
            dashBoard (e.target.textContent)
            if(e.target.textContent=='작업관리'){
                window.location.href="workManage_main_kwak.html"

              } else if (e.target.textContent=='생산관리'){
                window.location.href="Production management_tak.html"
                
              } else if (e.target.textContent=='생산리포팅'){
                window.location.href="Production reporting_tak.html"
                
              } else if (e.target.textContent=='자재관리'){
                window.location.href="TestMM_main_park.html"
                
              } else if (e.target.textContent=='품질관리'){
                window.location.href="TestQA_main_park.html"

            } else if (e.target.textContent=='기준관리'){
              window.location.href="masterdataManage_main_kwak.html"
          }
        })
    }// 탑 버튼 내용나오게 하기  <끝>


    // 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<시작>
    let buttons = document.querySelectorAll('.menuBut')
    for(button of buttons){
        button.addEventListener('click',function(e){

            // console.log(e.target.textContent) // 클릭한 요소 텍스트 나오는지 확인
           
            if(e.target.textContent=='대시보드'){
                window.location.href="dashBoard_kwak.html"
            } else if (e.target.textContent=='게시판'){
                window.location.href = "FreeBoard_Nam.html"
            } else if (e.target.textContent=='공지사항'){
                window.location.href = "noticeBoard_Nam.html"
            }  
        })
    }// 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<끝>
    
    // 로그아웃 버튼 
    document.querySelector('.subBut').addEventListener('click',function(){
      window.location.href = "loginpage_Nam.html"
    })

    // 로고버튼
    document.querySelector('.logo').addEventListener('click',function(){
      window.location.href = 'dashBoard_kwak.html'
    })

    document.querySelector('#dayWork-board').addEventListener('click',function(){
      window.location.href = 'workManage_main_kwak.html'
    })
    document.querySelector('#dayWork-board2').addEventListener('click',function(){
      window.location.href = 'Production management_tak.html'
    })
    document.querySelector('#bdChart').addEventListener('click',function(){
      window.location.href = 'TestMM_main_park.html'
    })
    document.querySelector('.th2-con').addEventListener('click',function(){
      window.location.href = 'Production reporting_tak.html'
    })

}

    
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