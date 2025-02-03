window.addEventListener('load',chart)

function chart(){
  console.log("again?")
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
