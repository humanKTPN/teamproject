window.addEventListener('load',init)

                
                
function init(){

    //메뉴 열었다 닫았다 하기<시작>
    document.querySelector('#ham').addEventListener('click',function(){
        
        
        if(document.querySelector('.mainmenu').classList.length == 1){
            document.querySelector('.mainmenu').classList.add('hide')
            // document.querySelector('#main-menu').textContent = 'MENU 닫기'
        } else if (document.querySelector('.mainmenu').classList.length == 2){
            document.querySelector('.mainmenu').classList.remove('hide')
            // document.querySelector('#main-menu').textContent = 'MENU 열기'
        }

    }) //메뉴 열었다 닫았다 하기<끝>
    // 탑 버튼 내용나오게 하기 <시작>
    console.log(document.querySelector('.mainmenu').classList.length)// 클래스 개수
    let menus = document.querySelectorAll('.menu')
    for (menu of menus){//탑 메뉴탭에 클릭이벤트 주기
        menu.addEventListener('click',function(e){

            // console.log(e.target.textContent) // 어떤 메뉴를 눌렀는지 확인
            // 클릭했을때 해당 페이지로 넘어가는 Java Script
            if(e.target.textContent=='작업관리'){
                // 작업관리 메인
                window.location.href="workManage_main_kwak.html"
            } else if (e.target.textContent == '생산관리') {
                // 생산관리 메인 
                window.location.href = "Production management_tak.html"
            } else if (e.target.textContent == '생산리포팅') {
                // 생산리포팅 메인 
                window.location.href = "Production reporting_tak.html"
            } else if (e.target.textContent == '자재관리') {
                // 자재관리 메인 
                window.location.href = "TestMM_main_park.html"
            } else if (e.target.textContent == '품질관리') {
                // 품질관리 메인 
                window.location.href = "TestQA_main_park.html"
            } else if (e.target.textContent=='기준관리'){
                // 기준관리 메인
               window.location.href="masterdataManage_main_kwak.html"
           }
        })
    }// 탑 버튼 내용나오게 하기  <끝>


    // 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<시작>
    let buttons = document.querySelectorAll('.menuBut')
    for(button of buttons){
        button.addEventListener('click',function(e){
            if(e.target.textContent=='대시보드'){
                 // 대시보드 메인
                window.location.href="dashBoard_kwak.html"
            } else if (e.target.textContent == '게시판') {
                // 게시판 메인
                window.location.href = "FreeBoard_Nam.html"
            } else if (e.target.textContent == '공지사항') {
                // 공지사항 메인
                window.location.href = "noticeBoard_Nam.html"
            }  
        })
    }// 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<끝>

    document.querySelector('.confirm').addEventListener('click',function(){
        alert('저장되었습니다.')
    })
    document.querySelector('#item').addEventListener('change',function(e){
        console.log(e.target.value)
        // document.querySelector('#bom').value += 'A-NY-80'
        // document.querySelector('#prc').value += 'NY-80'
        document.querySelector('#pcd').value = 'A80'

        document.querySelector(".bomTitle").innerHTML = 'A-NY-80'
        document.querySelector('#bomDesc').innerHTML = `고무로 접착된 식물성 기름 5g<br>
                                                        고운 속돌가루 54g<br>
                                                        황 10g<br>
                                                        염화비닐 30g<br>
                                                        프탈레이트계 가소제1g<br>
                                                        color-blue 1g<br>
                                                        탄산칼슘 10g`
        document.querySelector(".prcTitle").innerHTML = 'NY-80'
        document.querySelector('#prcDesc').innerHTML = `1. 지우개 재료를 혼합기에 넣고 반죽을 만든다<br>
                                                            2. 지우개 반죽을 롤러에 넣는다<br>
                                                            3. 롤러에 다른 재료를 넣는다<br>
                                                            4. 롤러에 넣은 지우개 반죽을 빼서 잘 말아놓는다<br>
                                                            5. 말아놓은 반죽을 펴서 상온에 12시간 냅둔다<br>
                                                            6. 반죽을 압출기로 큰 사각형모양으로 찍는다<br>
                                                            7. 찍어낸 사각형 반죽을 압출-스팀기에 20분간 넣어서 열(163도)과 압력을 가한다<br>
                                                            8. 스팀기에서 나온 반죽의 가장자리를 자르고 찬물에 넣는다<br>
                                                            9. 반죽을 일정한 길이(직사각형)로 자른다<br>
                                                            10. 반죽을 일정한 길이로 잘라서 통에 담는다(일반적인 판매용 지우개 크기)<br>
                                                            11. 완제품 지우개에 탈크를 넣고 3-5시간 섞어준다 (탈크는 서로 붙지않게하는 용도)<br>
                                                            12. 완제품에 회사로고를 찍는다<br>
                                                            13. 포장한다`

        document.querySelector('img').src='https://contents.kyobobook.co.kr/sih/fit-in/400x0/gift/pdt/1720/hot1680745213388.jpg'
        console.log(document.querySelector('#ordcnt'))
        document.querySelector('#ordcnt').value = `4000`
        document.querySelector('#hoNo').value = `1호기`
        document.querySelector('#line').value = `A라인`


    })
     // 로그아웃 버튼 
     document.querySelector('.subBut').addEventListener('click',function(){
        window.location.href = "loginpage_Nam.html"
      })
  
      // 로고버튼
      document.querySelector('.logo').addEventListener('click',function(){
        window.location.href = 'dashBoard_kwak.html'
      })
}

