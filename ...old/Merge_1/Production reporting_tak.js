window.addEventListener('load', init)


function init() {
    //기간별 탭 포인트,표시페이지 변환
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

    //품목별 금일 총 생산량 셀렉별 표시변환
    let pr_bay = document.querySelector('.pr_bay')
    console.log("pr_bay : ", pr_bay)
    pr_bay.addEventListener('click', function (evt) {
        let pr_bays = evt.target.value
        console.log("pr_bays : ", pr_bays)
        let ssTotal1 = document.querySelector('#ssTotal1')
        console.log("bbbbb", ssTotal1)

        if (pr_bays == "1") {
            ssTotal1.innerHTML = "24ea";
        } else if (pr_bays == "2") {
            ssTotal1.innerHTML = "19ea";
        } else if (pr_bays == "3") {
            ssTotal1.innerHTML = "21ea";
        } else if (pr_bays == "4") {
            ssTotal1.innerHTML = "23ea";
        } else if (pr_bays == "5") {
            ssTotal1.innerHTML = "27ea";
        }
    })
    
    //품목별 주간별 총 생산량 셀렉별 표시변환
    let pm_week = document.querySelector('.pm_week')
    console.log("pm_week : ", pm_week)
    pm_week.addEventListener('click', function (evt) {
        let pm_weeks = evt.target.value
        console.log("pm_weeks : ", pm_weeks)
        let ssTotal2 = document.querySelector('#ssTotal2')
        console.log("bbbbb", ssTotal2)

        if (pm_weeks == "1") {
            ssTotal2.innerHTML = "213ea";
        } else if (pm_weeks == "2") {
            ssTotal2.innerHTML = "227ea";
        } else if (pm_weeks == "3") {
            ssTotal2.innerHTML = "208ea";
        } else if (pm_weeks == "4") {
            ssTotal2.innerHTML = "198ea";
        } else if (pm_weeks == "5") {
            ssTotal2.innerHTML = "231ea";
        }
    })

    //품목별 월별 총 생산량 셀렉별 표시변환
    let pm_month = document.querySelector('.pm_month')
    console.log("pm_month : ", pm_month)
    pm_month.addEventListener('click', function (evt) {
        let pm_months = evt.target.value
        console.log("pm_months : ", pm_months)
        let ssTotal3 = document.querySelector('#ssTotal3')
        console.log("bbbbb", ssTotal3)

        if (pm_months == "1") {
            ssTotal3.innerHTML = "935ea";
        } else if (pm_months == "2") {
            ssTotal3.innerHTML = "892ea";
        } else if (pm_months == "3") {
            ssTotal3.innerHTML = "914ea";
        } else if (pm_months == "4") {
            ssTotal3.innerHTML = "951ea";
        } else if (pm_months == "5") {
            ssTotal3.innerHTML = "962ea";
        }
    })

    //품목별 월별 총 판매량 셀렉별 표시변환
    let pm_month_sel = document.querySelector('.pm_month_sel')
    console.log("pm_month_sel : ", pm_month_sel)
    pm_month_sel.addEventListener('click', function (evt) {
        let pm_month_sels = evt.target.value
        console.log("pm_month_sels : ", pm_month_sels)
        let ssTotal4 = document.querySelector('#ssTotal4')
        console.log("bbbbb", ssTotal4)

        if (pm_month_sels == "1") {
            ssTotal4.innerHTML = "1500ea";
        } else if (pm_month_sels == "2") {
            ssTotal4.innerHTML = "1250ea";
        } else if (pm_month_sels == "3") {
            ssTotal4.innerHTML = "1000ea";
        } else if (pm_month_sels == "4") {
            ssTotal4.innerHTML = "750ea";
        } else if (pm_month_sels == "5") {
            ssTotal4.innerHTML = "1100ea";
        }
    })
}