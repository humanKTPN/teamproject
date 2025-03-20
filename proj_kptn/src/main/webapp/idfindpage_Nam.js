window.addEventListener('load', message)
function message() {
    console.log("아이디 찾기 페이지 접근중")

    document.querySelector('#result').addEventListener('click', idfinder)
    function idfinder() {
        let idfinder = document.querySelector('#result')
        console.log('아이디찾기 버튼 클릭')

        const name = document.querySelector('#name')
        console.log(name.value)
        const tel = document.querySelector('#tel')
        console.log(tel.value)
        const userfind = document.querySelector('.findres')

        if ((name.value == "admin" && tel.value == '0415611122')) {
            console.log('회원정보 찾음')
            // 회원정보(id)값을 불러와야함.(현재 넣은 아이디는 임의값임)
            userfind.textContent = '아이디는 adnin 입니다.'
            userfind.style.color = 'black'
        } else {
            console.log('회원정보 없음')
            userfind.textContent = '회원정보를 찾을 수 없습니다.'
            userfind.style.color = 'red'
        }

        if (name.value == '') {
            console.log('미입력된 항목이 있음')
            userfind.style.color = '#f00';
            userfind.textContent = '이름은 필수입니다!';
        } else if (tel.value == '') {
            console.log('미입력된 항목이 있음')
            userfind.style.color = '#f00';
            userfind.textContent = '전화번호는 필수입니다!';
        }
    }
    document.querySelector('#pwfindC').addEventListener('click', pwprocess)
    function pwprocess() {
        let pwfinder = document.querySelector('#pwfindC')
        console.log('비밀번호 찾기로 이동')
        location.href = "pwfindpage_Nam.jsp"
    }
    
}