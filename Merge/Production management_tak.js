window.addEventListener('load',init)


function init(){
    //라인별 메뉴 클릭시 색변경 코드
    let ssLine = document.querySelector('.ssLine')
    ssLine.addEventListener('click', function (evt) {
        console.log("1", evt.target)
        console.log("2", evt.target.parentNode.children)
        let ssLines = evt.target.parentNode.children
        for (let i = 0; i < ssLines.length; i++) {
            ssLines[i].classList.remove('point')
        }
        evt.target.classList.add('point')
        console.log(evt.target.getAttribute('class'))
        let evtId = evt.target.getAttribute('class').split(' ')
        console.log(evtId[0])
        const ssLineId = document.querySelectorAll("[id^=ssLine]")
        console.log(ssLineId)

        for (let j = 0; j < ssLineId.length; j++) {
            ssLineId[j].classList.add('hide')
        }
        document.querySelector("#" + evtId[0]).classList.remove('hide')
    })
}