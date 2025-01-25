window.addEventListener('load',workManage)

select = []
function workManage(menu, select){
    console.log('select',select)

    if(menu=='작업관리'){
        for(s of select){
            s.addEventListener('click',function(){
                console.log('ㅎㅇ')
                document.querySelector('.menuPage-con').innerHTML = `<div class="pop">
                <div class="add-table">
                 <img class="eraser-img" src="https://cdn.011st.com/11dims/resize/1000x1000/quality/75/11src/product/6297562089/B.jpg?506000000">
                 <table class="detail-table">
                                              <tr>
                                                  <th scope = "col">작업지시번호</th>
                                                  <th scope = "col">납품처명</th>
                                                  <th scope = "col">납기일자</th>
                                                  <th scope = "col">품목명</th>
                                                  <th scope = "col">담당자</th>
                                                  <th scope = "col">지시수량</th>
                                                  <th scope = "col">생산수량</th>
                                                  <th scope = "col">종결여부</th>
                                                  <th scope = "col">BOM</th>
                                                  <th scope = "col">공정</th>
                                              </tr>
                                              <tr>
                                                  <td>1호기</td>
                                                  <td>다이소</td>
                                                  <td>2025/01/22</td>
                                                  <td>싹싹지우개</td>
                                                  <td>김길동</td>
                                                  <td>4000</td>
                                                  <td>500</td>
                                                  <td>진행중</td>
                                                  <td>SS-01</td>
                                                  <td>A07</td>
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
        addBtn.addEventListener('click',function(){
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