window.addEventListener('load',init)

                
                
function init(){
    if(window.innerWidth == 500){ // 새로고침일때만 적용됨 일단 보류
        document.querySelector('#main-menu').textContent = 'MENU'
    }
    


    //메뉴 열었다 닫았다 하기<시작>
    document.querySelector('#main-menu').addEventListener('click',function(){
        
        
        if(document.querySelector('.mainmenu').classList.length == 1){
            document.querySelector('.mainmenu').classList.add('hide')
            document.querySelector('#main-menu').textContent = 'MENU 열기'
        } else if (document.querySelector('.mainmenu').classList.length == 2){
            document.querySelector('.mainmenu').classList.remove('hide')
            document.querySelector('#main-menu').textContent = 'MENU 닫기'
        }

    }) //메뉴 열었다 닫았다 하기<끝>
    // 탑 버튼 내용나오게 하기 <시작>
    console.log(document.querySelector('.mainmenu').classList.length)// 클래스 개수
    let menus = document.querySelectorAll('.menu')
    for (menu of menus){//탑 메뉴탭에 클릭이벤트 주기
        menu.addEventListener('click',function(e){

            // console.log(e.target.textContent) // 어떤 메뉴를 눌렀는지 확인
            dashBoard (e.target.textContent)
            if(e.target.textContent=='작업관리'){
                document.querySelector('.menuPage-con').innerHTML = `작업관리내용`
            } else if (e.target.textContent=='생산관리'){
                document.querySelector('.menuPage-con').innerHTML = `생산관리내용`
            } else if (e.target.textContent=='생산리포팅'){
                document.querySelector('.menuPage-con').innerHTML = `생산리포팅`
            } else if (e.target.textContent=='자재관리'){
                document.querySelector('.menuPage-con').innerHTML = `자재관리`
            } else if (e.target.textContent=='품질관리'){
                document.querySelector('.menuPage-con').innerHTML = `품질관리`
            } 
        })
    }// 탑 버튼 내용나오게 하기  <끝>


    // 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<시작>
    let buttons = document.querySelectorAll('.menuBut')
    for(button of buttons){
        button.addEventListener('click',function(e){

            // console.log(e.target.textContent) // 클릭한 요소 텍스트 나오는지 확인
           
            if(e.target.textContent=='대시보드'){
                document.querySelector('.menuPage-con').innerHTML = `<div class="container">
        <div class="border-1">
            <div class="border-top">
                <div class="title">작업/생산관리</div>
                <div class="dayWork" media="screen">
                    <div id = "dayWork-board" >
                        <div id = "day-list">
                            금일 생산 지시 사항
                        </div>
                        <div class="list-con">
                            <table>
                                <tr>
                                    <td>1</td>
                                    <td>1호기</td>
                                    <td>생산</td>
                                    <td>...<i id="arrow-up" class="arrow fa-solid fa-arrow-up"></i></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>1호기</td>
                                    <td>생산</td>
                                    <td>...<i id="arrow-up" class="arrow fa-solid fa-arrow-up"></i></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>A제품</td>
                                    <td>생산</td>
                                    <td>...<i id="arrow-up" class="arrow fa-solid fa-arrow-up"></i></td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>B제품</td>
                                    <td>생산</td>
                                    <td>...<i id="arrow-up" class="arrow fa-solid fa-arrow-up"></i></td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td>C제품</td>
                                    <td>생산</td>
                                    <td>...<i id="arrow-up" class="arrow fa-solid fa-arrow-up"></i></td>
                                </tr>
                               

                            </table>
                        </div>
                    </div>
                    <!-- <div class = "dayWork-board-con"> -->
                        <div id = "dayWork-board2">
                            <!-- <div id = "day-list"> -->
                                <table class="command-table">
                                    <tr>
                                        <th colspan='2' class="th">작업지시번호</th>
                                        <th colspan='2' class="th">납기일자</th>
                                        <th colspan='2' class="th">담당자</th>
                                    </tr>
                                    <tbody>
                                        <tr>
                                            <td class="td">1호기</td>
                                            <td class="td">2호기</td>
                                            <td class="td">1호기</td>
                                            <td class="td">2호기</td>
                                            <td class="td">김기동</td>
                                        </tr>
                                        <tr>
                                            <td class="td">3호기</td>
                                            <td class="td">4호기</td>
                                            <td class="td">3호기</td>
                                            <td class="td">4호기</td>
                                            <td class="td">홍희야</td>
                                        </tr>
                                        <tr>
                                            <td class="td">5호기</td>
                                            <td class="td">6호기</td>
                                            <td class="td">5호기</td>
                                            <td class="td">6호기</td>
                                            <td class="td">김둘리</td>
                                        </tr>
                                    </tbody>
                                    
                                </table>
                            <!-- </div> -->
                         
                        </div>
                    <!-- </div> -->
                  
                </div>
                    
            </div>
        <!-- asdfasdfasdfasfsadfsaf -->
        <!-- dsafsdfasdfasdfsa -->
        <!-- </div> -->
    </div>
        <div class="border-2">
            <div class="border">
                <div class="title">재고현황</div>
                <div id="bad">
                    <div id = "badChart">
                        <canvas id = "bdChart2"></canvas>
                    </div>
                </div>
            </div>
            <div class="border2">
                <div class="title">불량률 현황</div>
                <div id="tempHu">
                    <div class="th2-con">
                        <table class="th2-table">
                            <tr>
                                <th class="th2">품목명</th>
                                <th class="th2">불량률</th>
                            </tr>
                            <!-- <tbody> -->
                                <tr>
                                    <td class="td">1호기</td>
                                    <td class="td">2호기</td>
                                </tr>
                                <tr>
                                    <td class="td">3호기</td>
                                    <td class="td">4호기</td>
                                </tr>
                                <tr>
                                    <td class="td">3호기</td>
                                    <td class="td">4호기</td>
                                </tr>
                            <!-- </tbody> -->
                        </table>
                        <div id = "thchart-con">
                            <canvas id="thchart2"></canvas>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div> 
</div> `
dashBoard(e.target.textContent)



            } else if (e.target.textContent=='게시판'){
                document.querySelector('.menuPage-con').innerHTML = `게시판`
            } else if (e.target.textContent=='공지사항'){
                document.querySelector('.menuPage-con').innerHTML = `공지사항`
            }
        })
    }// 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<끝>

}

    
    


window.addEventListener('load',chart)

function chart(){
  new Chart(document.getElementById("bdChart"), {
      type: 'bar',
      data: {
        labels: ["지우개본품재고", "종이포장지재고", "비닐포장지재고", "완제품재고", "현주문량"],
        datasets: [
          {
            backgroundColor: ["#3e95cd"],
            data: [2478,5267,734,784,433],
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
                data: [2478,5267,734,784,433],
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
