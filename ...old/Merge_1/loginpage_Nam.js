window.addEventListener('load', function () {
    console.log('접근중....')

    document.querySelector('#login').addEventListener('click', login)
    function login() {
        let login = document.querySelector('#login')
        console.log('로그인 버튼 클릭')

        const id = document.querySelector('#uid')
        const pw = document.querySelector('#upw')
        const userchk = document.querySelector('#uchkmessege')
        id.value == pw.value
        console.log(id, id.value)
        console.log(pw, pw.value)

        if ((id.value == "admin" && pw.value == 1234) || (id.value == "user" && pw.value == 5678)) {
            console.log('로그인 성공')
            userchk.textContent = ''
            location.href = "dashBoard_kwak.html"
        } else {
            console.log('회원정보 없음')
            userchk.textContent = '회원정보가 일치하지 않습니다.'
            userchk.style.color = 'red'
        }

        if (id.value == '') {
            console.log('미입력된 항목이 있음')
            userchk.style.color = '#f00';
            userchk.textContent = '아이디는 필수입니다!';
        } else if (pw.value == '') {
            console.log('미입력된 항목이 있음')
            userchk.style.color = '#f00';
            userchk.textContent = '비밀번호는 필수입니다!';
        }
    }

    document.querySelector('#idfind').addEventListener('click', idfindprocess)
    function idfindprocess() {
        let idfinder = document.querySelector('#idfind')
        console.log('아이디 찾기 버튼 클릭')
        location.href = "idfindpage_Nam.html"
    }

    document.querySelector('#pwfind').addEventListener('click', pwfindprocess)
    function pwfindprocess() {
        let pwfinder = document.querySelector('#pwfind')
        console.log('비밀번호 찾기 버튼 클릭')
        location.href = "pwfindpage_Nam.html"
    }
})