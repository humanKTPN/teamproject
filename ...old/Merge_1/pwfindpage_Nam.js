window.addEventListener('load', message)
function message() {
    console.log("비밀번호 찾기 페이지 접근중")

    document.querySelector('#result').addEventListener('click', pwfinder)
    function pwfinder() {
        let idfinder = document.querySelector('#result')
        console.log('비밀번호 찾기 버튼 클릭')

        const id = document.querySelector('#id')
        console.log(id.value)
        const tel = document.querySelector('#tel')
        console.log(tel.value)
        const userfind = document.querySelector('.findres')

        if ((id.value == "admin" && tel.value == '0415611122')) {
            console.log('회원정보 찾음')
            // 비밀번호를 임시비밀번호를 줄지 알려줄지 고민됨
            userfind.textContent = '비밀번호는  입니다.'
            userfind.style.color = 'black'
        } else {
            console.log('회원정보 없음')
            userfind.textContent = '회원정보를 찾을 수 없습니다.'
            userfind.style.color = 'red'
        }

        if (id.value == '') {
            console.log('미입력된 항목이 있음')
            userfind.style.color = '#f00';
            userfind.textContent = '아이디는 필수입니다!';
        } else if (tel.value == '') {
            console.log('미입력된 항목이 있음')
            userfind.style.color = '#f00';
            userfind.textContent = '전화번호는 필수입니다!';
        }
    }

    document.querySelector('#idfindC').addEventListener('click', pwprocess)
    function pwprocess() {
        let pwfinder = document.querySelector('#idfindC')
        console.log('아이디 찾기로 이동')
        location.href = "idfindpage_Nam.html"
    }
}