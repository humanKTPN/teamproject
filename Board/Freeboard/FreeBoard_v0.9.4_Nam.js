///////////////////////////////////////////////////////////////////////////
////////////////////////////////대시보드////////////////////////////////////
///////////////////////////////////////////////////////////////////////////
window.addEventListener('load', chart)

function chart() {
    console.log("again?")
    new Chart(document.getElementById("bdChart"), {
        type: 'bar',
        data: {
            labels: ["지우개본품재고", "종이포장지재고", "비닐포장지재고", "완제품재고", "현주문량"],
            datasets: [
                {
                    backgroundColor: ["#3e95cd"],
                    data: [2478, 5267, 734, 784, 433],
                    label: "수주 및 현재고",
                }
            ]
        },
        options: {
            plugins: {
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
            labels: [1500, 1600, 1700],

            datasets: [{
                data: [1402, 3700, 5267],
                label: "목표량",
                borderColor: "#8e5ea2",
                fill: true
            }, {
                data: [221, 783, 2478],
                label: "생산량",
                borderColor: "#3e95cd",
                fill: true
            }, {
                data: [547, 675, 734],
                label: "불량",
                borderColor: "#3cba9f",
                fill: true
            }
            ]
        },
        options: {
            plugins: {
                legend: { display: true },
            },
            // title: {
            //   display: true,
            //   text: 'World population per region (in millions)'
            // }
        }
    });
}

function dashBoard(dashCheck) {
    if (dashCheck == '대시보드') {
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
                        data: [2478, 5267, 734, 784, 433],
                        label: "수주 및 현재고",
                    }
                ]
            },
            options: {
                plugins: {
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
                labels: [1500, 1600, 1700],

                datasets: [{
                    data: [1402, 3700, 5267],
                    label: "목표량",
                    borderColor: "#8e5ea2",
                    fill: true
                }, {
                    data: [221, 783, 2478],
                    label: "생산량",
                    borderColor: "#3e95cd",
                    fill: true
                }, {
                    data: [547, 675, 734],
                    label: "불량",
                    borderColor: "#3cba9f",
                    fill: true
                }
                ]
            },
            options: {
                plugins: {
                    legend: { display: true },
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
///////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////작업관리//////////////////////////
///////////////////////////////////////////////////////////////////////////
select = []
function workManage(menu, select) {
    console.log('select', select)

    if (menu == '작업관리') {
        for (s of select) {
            s.addEventListener('click', function () {
                console.log('ㅎㅇ')
                document.querySelector('.menuPage-con').innerHTML = `<div class="pop">
                <div class="add-table">
                 <img class="eraser-img" src="https://cdn.011st.com/11dims/resize/1000x1000/quality/75/11src/product/6297562089/B.jpg?506000000">
                 <table class="detail-table">
                                              <tr>
                                                  <th class="detail-th" scope = "col">작업지시번호</th>
                                                  <th class="detail-th" scope = "col">납품처명</th>
                                                  <th class="detail-th" scope = "col">납기일자</th>
                                                  <th class="detail-th" scope = "col">품목명</th>
                                                  <th class="detail-th" scope = "col">담당자</th>
                                                  <th class="detail-th" scope = "col">지시수량</th>
                                                  <th class="detail-th" scope = "col">생산수량</th>
                                                  <th class="detail-th" scope = "col">종결여부</th>
                                                  <th class="detail-th" scope = "col">BOM</th>
                                                  <th class="detail-th" scope = "col">공정</th>
                                              </tr>
                                              <tr>
                                                  <td class="detail-td">1호기</td>
                                                  <td class="detail-td">다이소</td>
                                                  <td class="detail-td">2025/01/22</td>
                                                  <td class="detail-td">싹싹지우개</td>
                                                  <td class="detail-td">김길동</td>
                                                  <td class="detail-td">4000</td>
                                                  <td class="detail-td">500</td>
                                                  <td class="detail-td">진행중</td>
                                                  <td class="detail-td">SS-01</td>
                                                  <td class="detail-td">A07</td>
                                              </tr>
                                              
                                          </table>
                </div>
                </div>
                <div class="bompro-con">
                    <div class="bom-con">
                        <h4>BOM : SS-01</h4>
                        고무로 접착된 식물성 기름 5%<br>
                        고운 속돌가루 59%<br>
                        황 5%<br>
                        염화비닐 30%<br>
                        프탈레이트계 가소제1%<br>
                        color-red 1%<br>
                        탄산칼슘 10%
                    </div>
                    <div class="process">
                        <h4>공정 : A07</h4>
                        <pre>
1. 재료의 배합
플라스틱 원료와 가소제(可塑剤)등을 계량하여 교반기(혼합 기계)에 넣는다.

2. 섞는다
교반기에 넣은 재료를 잘 혼합한다.
여기서의 열의 강도와 시간조절에 의해 지우개의 단단함을 조정할 수 있다.
색이나 향기를 추가하는 것도 보통 이 과정에서 시행한다.

3. 지우개의 모양을 만든다 => 지우개의 모양을 만드는 방법은 3가지가 있다.
*압출성형(押出成型):스크루식 압출기로 가늘고 긴 형태의 지우개를 만든다.
*압축성형(壓縮成型):네모진 형태의 핫 프레스기에 섞은 재료를 흘려 넣어 굳은 후 얇은 판 모양의 지우개가 만들어진다.
*사출성형(射出成型):사출성형기를 사용하여 각 크기와 형태의 모양에 흘려 넣어 굳으면 각기 다른 모양의 지우개가 만들어진다.

4. 절단한다.
압출이나 압축성형 된 지우개는 재단기를 사용하여 자른다.

5. 완성
케이스에 넣거나 세로판 포장을 해 상자에 넣으면 완성이다.
                        </p>

                        
                    </div>
                </div>`
            })
        }
        let addBtn = document.querySelector('.add')
        addBtn.addEventListener('click', function () {
            // console.log('ㅎㅇ')
            document.querySelector('.menuPage-con').innerHTML = `<div class="pop">
                                                                    <div class="add-table">
                                                                     <img class="eraser-img">
                                                                     
                                                                     <div class="select-body">
                                                                        <div class="select-con">
                                                                            <div class="select-1">
                                                                            담당자<input type="text" placeholder="담당자입력">
                                                                            납기일자<input type="text" placeholder="일자입력">
                                                                            수량<input type="text" placeholder="수량입력">
                                                                            </div>
                                                                        </div>

                                                                        <div class="select-con">
                                                                            <div class="select-1">
                                                                            품목명<input type="text" placeholder="풍목명입력">
                                                                            일자<input type="text" placeholder="일자입력">
                                                                            납품처<input type="text" placeholder="납품처입력">
                                                                            </div>
                                                                        </div>

                                                                        <div class="select-con">
                                                                            <div class="select-1">
                                                                            BOM<input type="text" placeholder="BOM입력">
                                                                            공정<input type="text" placeholder="공정입력">
                                                                            품목코드<input type="text" placeholder="품목코드">
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                     
                                                                     </div>

                                                                    </div>
                                                                    </div>
                                                                    <div class="bompro-con">
                                                                        <div class="bom-con">
                                                                            <h4>BOM : </h4>
                                                                        </div>
                                                                        <div class="process">
                                                                            <h4>공정 : </h4>
                                                                        </div>
                                                                    </div>`
        })
    }
}

window.addEventListener('load', init)



function init() {
    if (window.innerWidth == 500) { // 새로고침일때만 적용됨 일단 보류
        document.querySelector('#main-menu').textContent = 'MENU'
    }



    //메뉴 열었다 닫았다 하기<시작>
    document.querySelector('#main-menu').addEventListener('click', function () {


        if (document.querySelector('.mainmenu').classList.length == 1) {
            document.querySelector('.mainmenu').classList.add('hide')
            document.querySelector('#main-menu').textContent = 'MENU 열기'
        } else if (document.querySelector('.mainmenu').classList.length == 2) {
            document.querySelector('.mainmenu').classList.remove('hide')
            document.querySelector('#main-menu').textContent = 'MENU 닫기'
        }

    }) //메뉴 열었다 닫았다 하기<끝>
    // 탑 버튼 내용나오게 하기 <시작>
    console.log(document.querySelector('.mainmenu').classList.length)// 클래스 개수
    let menus = document.querySelectorAll('.menu')
    for (menu of menus) {//탑 메뉴탭에 클릭이벤트 주기
        menu.addEventListener('click', function (e) {

            // console.log(e.target.textContent) // 어떤 메뉴를 눌렀는지 확인
            dashBoard(e.target.textContent)
            if (e.target.textContent == '작업관리') {
                document.querySelector('.menuPage-con').innerHTML = `<div class="background">
                                                                                        <div class = "tab-name-div">
                                                                                            <div class="tab-name">작업지시서 조회</div>
                                                                                        </div>
                                                                                        <div class="dropBox">
                                                                                        <form action="#">
                                                                                            <select name="categories" id="cote">
                                                                                                <option value="전체">전체</option>
                                                                                                <option value="품목명">품목명</option>
                                                                                                <option value="담당자명">담당자명</option>
                                                                                                <option value="호기">호기</option>
                                                                                                <option value="종결여부">종결여부</option>
                                                                                            </select>
                                                                                            <input type="select">
                                                                                            <input type="submit" value="검색" />
                                                                                            </form>
                                                                                        </div>
                                                                                        
                                                                                        <div class="command-loc">
                                                                                            <div class="command-div">
                                                                                                <table class="command-table">
                                                                                                    <tr>
                                                                                                        <th class="command-th" scope = "col">작업지시번호</th>
                                                                                                        <th class="command-th" scope = "col">납품처명</th>
                                                                                                        <th class="command-th" scope = "col">납기일자</th>
                                                                                                        <th class="command-th" scope = "col">품목명</th>
                                                                                                        <th class="command-th" scope = "col">담당자</th>
                                                                                                        <th class="command-th" scope = "col">지시수량</th>
                                                                                                        <th class="command-th" scope = "col">생산수량</th>
                                                                                                        <th class="command-th" scope = "col">종결여부</th>
                                                                                                        <th class="command-th" scope = "col">BOM</th>
                                                                                                        <th class="command-th" scope = "col">공정</th>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td class="command-td">1호기</td>
                                                                                                        <td class="command-td">다이소</td>
                                                                                                        <td class="command-td">2025/01/22</td>
                                                                                                        <td class="command-td">싹싹지우개</td>
                                                                                                        <td class="command-td">김길동</td>
                                                                                                        <td class="command-td">4000</td>
                                                                                                        <td class="command-td">500</td>
                                                                                                        <td class="command-td">진행중</td>
                                                                                                        <td class="command-td">SS-01</td>
                                                                                                        <td class="command-td">A07</td>
                                                                                                    </tr>
                                                                                                    
                                                                                                </table>
                                                                                            </div>
                                                                                        </div>
                                                                                            <div class="page-num-con">
                                                                                                <div class="page-num">
                                                                                                    <div class="page">
                                                                                                        < 이전페이지
                                                                                                    </div>
                                                                                                    <div class="page">
                                                                                                        <span>1 2 3 4 5</span>
                                                                                                    </div>
                                                                                                    <div class = "page">
                                                                                                        다음페이지 >
                                                                                                    </div>
                                                                                                </div>
                                                                                                <div class="add-con">
                                                                                                    <div class="add">
                                                                                                        추가
                                                                                                    </div>
                                                                                                </div> 
                                                                                            </div>   
                                                                                        </div>
                                                                                    </div>`
                workManage(e.target.textContent, document.querySelectorAll('td'))
            } else if (e.target.textContent == '생산관리') {
                document.querySelector('.menuPage-con').innerHTML = `생산관리내용`
            } else if (e.target.textContent == '생산리포팅') {
                document.querySelector('.menuPage-con').innerHTML = `생산리포팅`
            } else if (e.target.textContent == '자재관리') {
                document.querySelector('.menuPage-con').innerHTML = `자재관리`
            } else if (e.target.textContent == '품질관리') {
                document.querySelector('.menuPage-con').innerHTML = `품질관리`
            }
        })
    }// 탑 버튼 내용나오게 하기  <끝>


    // 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<시작>
    let buttons = document.querySelectorAll('.menuBut')
    for (button of buttons) {
        button.addEventListener('click', function (e) {

            // console.log(e.target.textContent) // 클릭한 요소 텍스트 나오는지 확인

            if (e.target.textContent == '대시보드') {
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
                                        <canvas id = "bdChart2" style="width: 100%; height: 100%;"></canvas>
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



            } else if (e.target.textContent == '게시판') {
                document.querySelector('.menuPage-con').innerHTML = `<div>
<div>
<p id='pageinfo'>
자유게시판
</p>
<hr>
<div class='boardarea'>
<div class='middle_board'>
    <div class='searcharea'>
        <div class='selectbox'>
            <form>
                <select name='viewfilter' id='viewfilter'>
                    <option value='allview'>모두</option>
                    <option value='tilteview'>제목</option>
                    <option value='contentview'>내용</option>
                    <option value='writeuserview'>작성자</option>
                </select>
            </form>
        </div>
        <div class='fillvalue'>
            <input type='text' id ='fillvalue' placeholder="검색어를 입력해주세요">
        </div>
        <div class='searchB'>
            <button type="button" id='search'>검색</button>
        </div>
    </div>
    <hr>
    <div>
    <table class='boardtable'>
        <tr class='boardlist' style="height: 30px; border: 1px solid black;">
            <td class='num'> 번호 </td>
            <td class='writetitle'> 제목 </td>
            <td class='writeuser'> 작성자 </td>
            <td class='writedate'> 작성일 </td>
            <td class='viewcount'> 조회수 </td>
        </tr>
    </table>
    <table class='boardcontents'>
        
    </table>
</div>
    <div class='pageline'>
        <div class='pagemanger'>
            <button type="button" class='prevp'> 이전페이지 </button>
        </div>
        <div class='pnum'>
            <span class='pnum1'> 1 </span>
            <span class='pnum2'> 2 </span>
            <span class='pnum3'> 3 </span>
            <span class='pnum4'> 4 </span>
            <span class='pnum5'> 5 </span>
        </div>
        <div>
            <button type="button" class='nextp'> 다음페이지 </button>
        </div>
        <div>
            <button type="button" class='write'> 글쓰기 </button>
        </div>
    </div>
</div>
</div>
</div>
</div>`

                const search = document.querySelector("#search");
                search.addEventListener('click', filter)
                function filter() {
                    const optionS = document.querySelector('#viewfilter')
                    const optionT = document.querySelector('#fillvalue')
                    console.log(optionS.value)
                    console.log(optionT.value)

                }

                const write = document.querySelector('.write');
                write.addEventListener('click', writeprocess)
                function writeprocess() {
                    const writeprocess = document.querySelector('.boardcontents')
                    writeprocess.innerHTML += `<tr class='boardcontent' style="height: 30px; border: 1px solid black;">
    <td class='num'> 번호 </td>
<td class='writetitle'> 제목 </td>
<td class='writeuser'> 작성자 </td>
<td class='writedate'> 작성일 </td>
<td class='viewcount'> 조회수 </td>
</tr>`
                }
            } else if (e.target.textContent == '공지사항') {
                document.querySelector('.menuPage-con').innerHTML = `공지사항`
            }
        })
    }// 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<끝>

}




