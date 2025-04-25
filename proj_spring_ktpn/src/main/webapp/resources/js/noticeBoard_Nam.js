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
    console.log(document.querySelector('.mainmenu').classList.length)// 클래스 개수
    let menus = document.querySelectorAll('.menu')
    for (menu of menus) {//탑 메뉴탭에 클릭이벤트 주기
        menu.addEventListener('click', function (e) {

            // console.log(e.target.textContent) // 어떤 메뉴를 눌렀는지 확인
            // 클릭했을때 해당 페이지로 넘어가는 Java Script
            if (e.target.textContent == '작업관리') {
                // 작업관리 메인
                window.location.href = "workManage_main_kwak.jsp"
            } else if (e.target.textContent == '생산관리') {
                // 생산관리 메인 
                window.location.href = "Production management_tak.jsp"
            } else if (e.target.textContent == '생산리포팅') {
                // 생산리포팅 메인 
                window.location.href = "Production reporting_tak.jsp"
            } else if (e.target.textContent == '자재관리') {
                // 자재관리 메인 
                window.location.href = "TestMM_main_park.jsp"
            } else if (e.target.textContent == '품질관리') {
                // 품질관리 메인 
                window.location.href = "TestQA_main_park.jsp"
            } else if (e.target.textContent == '기준관리') {
                // 기준관리 메인
                window.location.href = "masterdataManage_main_kwak.jsp"
            }
        })
    }// 탑 버튼 내용나오게 하기  <끝>


    // 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<시작>
    let buttons = document.querySelectorAll('.menuBut')
    for (button of buttons) {
        button.addEventListener('click', function (e) {
            if (e.target.textContent == '대시보드') {
                // 대시보드 메인
                window.location.href = "dashBoard_kwak.jsp"
            } else if (e.target.textContent == '게시판') {
                // 게시판 메인
                window.location.href = "boardcon"
            } else if (e.target.textContent == '공지사항') {
                // 공지사항 메인
                window.location.href = "noticeBoard_Nam.jsp"
            } 
        })
    }// 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<끝

    console.log('게시판에 들어옴')

    const search = document.querySelector("#search");
    search.addEventListener('click', filter)
    function filter() {
        const optionS = document.querySelector('#viewfilter')
        const optionT = document.querySelector('#fillvalue')
        console.log(optionS.value)
        console.log(optionT.value)

        // 필터링 후 표시(미구현)
    }

    const write = document.querySelector('.add');
    write.addEventListener('click', writeprocess)
    function writeprocess() {
        console.log("글쓰기 페이지 진입")
        window.location.href = "writeprocess_nam"
    }
    
    // // 페이지표시부분 미구현
    // const page1 = document.querySelector('.pnum1')
    // page1.addEventListener('click', function () {
    //     const first = document.querySelector('.pum1')
    //     console.log('1페이지 진입')
    // })


    // const page2 = document.querySelector('.pnum2')
    // page2.addEventListener('click', function () {
    //     const second = document.querySelector('.pum2')
    //     console.log('2페이지 진입')
    // })

    // const page3 = document.querySelector('.pnum3')
    // page3.addEventListener('click', function () {
    //     const thrid = document.querySelector('.pum3')
    //     console.log('3페이지 진입')
    // })

    // const page4 = document.querySelector('.pnum4')
    // page4.addEventListener('click', function () {
    //     const fourth = document.querySelector('.pum4')
    //     console.log('4페이지 진입')
    // })

    // const page5 = document.querySelector('.pnum5')
    // page5.addEventListener('click', function () {
    //     const fifth = document.querySelector('.pum5')
    //     console.log('5페이지 진입')
    // })

    const nums = document.querySelectorAll('.pnum')        

    // for(let i =0; i< nums.length; i++){
    //     nums.forEach(num => { num.addEventListener('click',function(e){
    //         nums.forEach(nm => nm.classList.remove('bold'));
    //         e.target.classList.add('bold')
    //     })
    // });
    // }

    for(let i =0; i< nums.length; i++){
        nums[i].addEventListener('click',function(e){
            for(let j=0; j<nums.length; j++){
                nums[j].classList.remove('bold')
                e.target.classList.add('bold')
            }
        })
    }
       // 로그아웃 버튼 
       document.querySelector('.subBut').addEventListener('click',function(){
        window.location.href = "loginpage_Nam.jsp"
      })
  
      // 로고버튼
      document.querySelector('.logo').addEventListener('click',function(){
        window.location.href = 'dashBoard_kwak.jsp'
      })
      const list =  document.querySelectorAll('.boardlist')

      for(line of list){
        line.addEventListener('click',function(){
            window.location.href = 'dashBoard_kwak.jsp'
        })
      }
}