window.addEventListener('load', init)


function init() {
    let date_point = document.querySelectorAll('.date_point')
    for (let i = 0; i < date_point.length; i++) {
        date_point[i].addEventListener('click', function (evt) {
            console.log("1", evt.target)
            console.log("2", evt.target.parentNode.children)
            let date_points = evt.target.parentNode.children
            for (let j = 0; j < date_points.length; j++) {
                date_points[j].classList.remove('point2')
            }
            evt.target.classList.add('point2')

            console.log("111", evt.target.getAttribute('class'))
            let evtId = evt.target.getAttribute('class').split(' ')
            console.log("222", evtId[1])
            const date_ssManuId = document.querySelectorAll("[id^=date_ssManu]")
            console.log("333", date_ssManuId)

            for (let y = 0; y < date_ssManuId.length; y++) {
                date_ssManuId[y].classList.add('hide')
            }
            document.querySelector("#" + evtId[1]).classList.remove('hide')
            
            console.log("222", evtId[2])
            const date_ssListId = document.querySelectorAll("[id^=date_ssList]")
            console.log("333", date_ssListId)

            for (let y = 0; y < date_ssListId.length; y++) {
                date_ssListId[y].classList.add('hide')
            }
            document.querySelector("#" + evtId[2]).classList.remove('hide')
        })

    }
}