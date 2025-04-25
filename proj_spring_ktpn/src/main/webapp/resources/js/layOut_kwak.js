window.addEventListener('load',init)

                
                
function init(){
    // 쿠키 설정 함수
    function setCookie(name, value, days) {
        const date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        const expires = "expires=" + date.toUTCString();
        document.cookie = name + "=" + value + ";" + expires + ";path=/";
    }
	console.log(document.cookie)
    // 쿠키 가져오기 함수
    function getCookie(name) {
        const nameEQ = name + "=";
        const ca = document.cookie.split(';');
        for (let i = 0; i < ca.length; i++) {
            let c = ca[i];
            while (c.charAt(0) === ' ') c = c.substring(1, c.length);
            if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length, c.length);
        }
        return null;
    }

    // 메뉴 열었다 닫았다 하기
    document.querySelector('#ham').addEventListener('click', function() {
        const mainMenu = document.querySelector('.mainmenu');
        
        if (mainMenu.classList.contains('hide')) {
            mainMenu.classList.remove('hide');
            setCookie('menuState', 'open', 7); // 쿠키에 상태 저장 (7일 동안 유지)
        } else {
            mainMenu.classList.add('hide');
            setCookie('menuState', 'closed', 7); // 쿠키에 상태 저장 (7일 동안 유지)
        }
    });

    // 페이지 로드 시 쿠키 값 확인 및 메뉴 상태 설정
    const menuState = getCookie('menuState');
    const mainMenu = document.querySelector('.mainmenu');

    if (menuState === 'closed') {
        mainMenu.classList.add('hide');
    } else if (menuState === 'open') {
        mainMenu.classList.remove('hide');
    }
 //메뉴 열었다 닫았다 하기<끝>
    

    
    // 탑 버튼 내용나오게 하기 <시작>
    console.log(document.querySelector('.mainmenu').classList.length)// 클래스 개수
    let menus = document.querySelectorAll('.menu')
    for (menu of menus){//탑 메뉴탭에 클릭이벤트 주기
        menu.addEventListener('click',function(e){

            // console.log(e.target.textContent) // 어떤 메뉴를 눌렀는지 확인
            // 클릭했을때 해당 페이지로 넘어가는 Java Script
            if(e.target.textContent=='작업관리'){
                // 작업관리 메인
                window.location.href="/ktpn/pr"
            } else if (e.target.textContent=='생산관리'){
                // 생산관리 메인 
                window.location.href="#"
            } else if (e.target.textContent=='생산리포팅'){
                // 생산리포팅 메인 
                window.location.href="#"
            } else if (e.target.textContent=='재고관리'){
                // 재고관리 메인 
                window.location.href="#"
            } else if (e.target.textContent=='품질관리'){
                // 품질관리 메인 
                window.location.href="#"
            }  else if (e.target.textContent=='기준관리'){
                window.location.href="/ktpn/md" 
            } 
        })
    }// 탑 버튼 내용나오게 하기  <끝>


    // 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<시작>
    let buttons = document.querySelectorAll('.menuBut')
    for(button of buttons){
        button.addEventListener('click',function(e){
            if(e.target.textContent=='대시보드'){
                 // 대시보드 메인
                window.location.href="/ktpn/"
            } else if (e.target.textContent=='게시판'){
                 // 게시판 메인
                window.location.href="#"
            } else if (e.target.textContent=='공지사항'){
                 // 공지사항 메인
                window.location.href="#"
            } 
        })
    }// 메뉴 버튼 눌렀을때 해당 내용 나오게 하기<끝>
    
    // 로그아웃 버튼 
      document.querySelector('.subBut').addEventListener('click',function(){
        window.location.href = "loginpage_Nam.jsp"
      })
  
      // 로고버튼
      document.querySelector('.logo').addEventListener('click',function(){
        window.location.href = '/ktpn/'
      })


}