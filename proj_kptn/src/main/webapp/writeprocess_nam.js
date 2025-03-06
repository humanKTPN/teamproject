window.addEventListener('load', init)



function init() {

    //메뉴 열었다 닫았다 하기<시작>
    document.querySelector('#ham').addEventListener('click', function () {


        if (document.querySelector('.mainmenu').classList.length == 1) {
            document.querySelector('.mainmenu').classList.add('hide')
            // document.querySelector('#main-menu').textContent = 'MENU 열기'
        } else if (document.querySelector('.mainmenu').classList.length == 2) {
            document.querySelector('.mainmenu').classList.remove('hide')
            // document.querySelector('#main-menu').textContent = 'MENU 닫기'
        }

    }) ///메뉴 열었다 닫았다 하기<끝>
    // 탑 버튼 내용나오게 하기 <시작>
    console.log(document.querySelector('.mainmenu').classList.length)// 클래스 개수
    let menus = document.querySelectorAll('.menu')
    for (menu of menus) {//탑 메뉴탭에 클릭이벤트 주기
        menu.addEventListener('click', function (e) {

            // console.log(e.target.textContent) // 어떤 메뉴를 눌렀는지 확인
            // 클릭했을때 해당 페이지로 넘어가는 Java Script
            if (e.target.textContent == '작업관리') {
                // 작업관리 메인
                window.location.href = "workManage_main_kwak.html"
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
            }
        })
    }// 탑 버튼 내용나오게 하기  <끝>


    // 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<시작>
    let buttons = document.querySelectorAll('.menuBut')
    for (button of buttons) {
        button.addEventListener('click', function (e) {
            if (e.target.textContent == '대시보드') {
                // 대시보드 메인
                window.location.href = "dashBoard_kwak.html"
            } else if (e.target.textContent == '게시판') {
                // 게시판 메인
                window.location.href = "FreeBoard_Nam.html"
            } else if (e.target.textContent == '공지사항') {
                // 공지사항 메인
                window.location.href = "noticeBoard_Nam.html"
            } else if (e.target.textContent == '기준관리') {
                // 기준관리 메인
                window.location.href = "masterdataManage_main_kwak.html"
            }
        })
    }// 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<끝>

    console.log('글쓰기 페이지에 들어옴')

    const button2 = document.querySelector('#button')
    button2.addEventListener('click', write)

    function write() {
        const title = document.querySelector('#title')
        const content = document.querySelector('#content')
        console.log(title.value)
        console.log(content.value)

        // 값 가지고 작성된 글을 보내야됨.
        // 표시해주는 페이지가 있어야됨.
        
        if( title.value == '' ){
            console.log('id 안썼음')
            document.querySelector('#writemsg').style.color = '#f00';
            document.querySelector('#writemsg').textContent = '제목은 필수입니다';
        } else if( content.value == '' ){
            document.querySelector('#writemsg').style.color = '#f00';
            document.querySelector('#writemsg').textContent = '내용은 필수입니다';
        } else {
            document.querySelector('#writemsg').textContent = '';
            console.log('작성완료')
            window.location.href = "writeview_Nam.html"
        }
    }
       // 로그아웃 버튼 
       document.querySelector('.subBut').addEventListener('click',function(){
        window.location.href = "loginpage_Nam.html"
      })
  
      // 로고버튼
      document.querySelector('.logo').addEventListener('click',function(){
        window.location.href = 'dashBoard_kwak.html'
      })
}