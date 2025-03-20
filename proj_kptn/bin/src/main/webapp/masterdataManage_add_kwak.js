window.addEventListener('load',init)

                
                
function init(){

    //메뉴 열었다 닫았다 하기<시작>
    document.querySelector('#ham').addEventListener('click',function(){
        
        
        if(document.querySelector('.mainmenu').classList.length ==1){
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
            if(e.target.textContent=='작업관리'){
                window.location.href="workManage_main_kwak.jsp"
            } else if (e.target.textContent == '생산관리') {
                // 생산관리 메인 
                window.location.href = "Production management_tak.jsp"
            } else if (e.target.textContent == '생산리포팅') {
                // 생산리포팅 메인 
                window.location.href = "Production reporting_tak.jsp"
            } else if (e.target.textContent == '자재관리') {
                // 자재관리 메인 
                window.location.href = "TestMM_main_park.jsp" 
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
            } else if (e.target.textContent == '게시판') {
                // 게시판 메인
                window.location.href = "FreeBoard_Nam.jsp"
            } else if (e.target.textContent == '공지사항') {
                // 공지사항 메인
                window.location.href = "noticeBoard_Nam.jsp"
            }  
        })
    }// 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<끝>

    
    document.querySelector('.add').addEventListener('click',function(){
        alert("추가되었습니다.")
        // window.location.href="masterdataManage_edit_kwak.jsp"
    })
      // 로그아웃 버튼 
      document.querySelector('.subBut').addEventListener('click',function(){
        window.location.href = "loginpage_Nam.jsp"
      })
  
      // 로고버튼
      document.querySelector('.logo').addEventListener('click',function(){
        window.location.href = 'dashBoard_kwak.jsp'
      })
         //페이지 표시
    const nums = document.querySelectorAll('.num')

    for(let i =0; i< nums.length; i++){
        nums[i].addEventListener('click',function(e){
            for(let j=0; j<nums.length; j++){
                nums[j].classList.remove('bold')
                e.target.classList.add('bold')
            }
        })
    }
    tbnms = document.querySelectorAll('.tab-name')

    for(tbnm of tbnms){
        tbnm.addEventListener('click',function(e){
            console.log(e.target.textContent)
            if(e.target.textContent == '기준관리'){
                window.location.href = 'masterdataManage_main_kwak.jsp'
            } else if(e.target.textContent == 'BOM'){
                window.location.href = 'bom_main_kwak.jsp'
            } else if(e.target.textContent == '공정'){
                window.location.href = 'processDesc_main.jsp'
            }
        })
    }


}


    
    



// }
