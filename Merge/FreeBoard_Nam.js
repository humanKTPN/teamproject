window.addEventListener("load", function () {
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

    const write = document.querySelector('.write');
    write.addEventListener('click', writeprocess)
    function writeprocess() {
        window.location.href = "writeprocess_nam.html"
        console.log("글쓰기 페이지 진입")



        //         const writeprocess = document.querySelector('.boardcontents')
        //         writeprocess.innerHTML += `<tr class='boardcontents' style="height: 30px; border: 1px solid black;">
        //     <td class='num'> 번호 </td>
        // <td class='writetitle'> 제목 </td>
        // <td class='writeuser'> 작성자 </td>
        // <td class='writedate'> 작성일 </td>
        // <td class='viewcount'> 조회수 </td>
        // </tr>`
    }
    // 페이지표시부분 미구현
    const page1 = document.querySelector('.pnum1')
    page1.addEventListener('click', function () {
        const first = document.querySelector('.pum1')
        console.log('1페이지 진입')
    })


    const page2 = document.querySelector('.pnum2')
    page2.addEventListener('click', function () {
        const second = document.querySelector('.pum2')
        console.log('2페이지 진입')
    })

    const page3 = document.querySelector('.pnum3')
    page3.addEventListener('click', function () {
        const thrid = document.querySelector('.pum3')
        console.log('3페이지 진입')
    })

    const page4 = document.querySelector('.pnum4')
    page4.addEventListener('click', function () {
        const fourth = document.querySelector('.pum4')
        console.log('4페이지 진입')
    })

    const page5 = document.querySelector('.pnum5')
    page5.addEventListener('click', function () {
        const fifth = document.querySelector('.pum5')
        console.log('5페이지 진입')
    })

})
