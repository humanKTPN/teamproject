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
                window.location.href="workManage_main_kwak.jsp"

              } else if (e.target.textContent=='생산관리'){
                window.location.href="Production management_tak.jsp"
                
              } else if (e.target.textContent=='생산리포팅'){
                window.location.href="Production reporting_tak.jsp"
                
              } else if (e.target.textContent=='자재관리'){
                window.location.href="TestMM_main_park.jsp"
                
              } else if (e.target.textContent=='품질관리'){
                window.location.href="TestQA_main_park.jsp"

            } else if (e.target.textContent=='기준관리'){
              window.location.href="masterdataManage_main_kwak.jsp"
          }
        })
    }// 탑 버튼 내용나오게 하기  <끝>


    // 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<시작>
    let buttons = document.querySelectorAll('.menuBut')
    for(button of buttons){
        button.addEventListener('click',function(e){

            // console.log(e.target.textContent) // 클릭한 요소 텍스트 나오는지 확인
           
            if(e.target.textContent=='대시보드'){
                window.location.href="dashBoard_kwak.jsp"
            } else if (e.target.textContent=='게시판'){
                window.location.href = "FreeBoard_Nam.jsp"
            } else if (e.target.textContent=='공지사항'){
                window.location.href = "noticeBoard_Nam.jsp"
            }  
        })
    }// 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<끝>
    
    // 로그아웃 버튼 
    document.querySelector('.subBut').addEventListener('click',function(){
      window.location.href = "loginpage_Nam.jsp"
    })

    // 로고버튼
    document.querySelector('.logo').addEventListener('click',function(){
      window.location.href = 'dashBoard_kwak.jsp'
    })

    document.querySelector('#dayWork-board').addEventListener('click',function(){
      window.location.href = 'workManage_main_kwak.jsp'
    })
    document.querySelector('#dayWork-board2').addEventListener('click',function(){
      window.location.href = 'Production management_tak.jsp'
    })
    document.querySelector('#bdChart').addEventListener('click',function(){
      window.location.href = 'TestMM_main_park.jsp'
    })
    document.querySelector('.th2-con').addEventListener('click',function(){
      window.location.href = 'Production reporting_tak.jsp'
    })

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
