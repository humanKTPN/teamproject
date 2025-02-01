window.addEventListener("load", function () {
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
    }
})