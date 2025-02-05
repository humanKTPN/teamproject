window.addEventListener('load', init)


function init() {
    let date_ssManu = document.querySelectorAll('.date_ssManu')
    for (let i = 0; i < date_ssManu.length; i++) {
        date_ssManu[i].addEventListener('click', function (evt) {
            console.log("1", evt.target)
            console.log("2", evt.target.parentNode.children)
            let date_ssManus = evt.target.parentNode.children
            for (let j = 0; j < date_ssManus.length; j++) {
                date_ssManus[j].classList.remove('point')
            }
            evt.target.classList.add('point')
        })
    }
}