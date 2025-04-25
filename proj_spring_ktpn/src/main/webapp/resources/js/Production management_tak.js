window.addEventListener('load', init)


function init() {
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
        //라인메뉴 눌렀을때 라인별 현황판 다르게 표시
        console.log("111", evt.target.getAttribute('class'))
        let evtId = evt.target.getAttribute('class').split(' ')
        console.log("222", evtId[0])
        const ssLineId = document.querySelectorAll("[id^=ssLine]")
        console.log("333", ssLineId)


        for (let j = 0; j < ssLineId.length; j++) {
            ssLineId[j].classList.add('hide')
        }
        document.querySelector("#" + evtId[0]).classList.remove('hide')
    })

    // 라인별 생산관리 관련 
    // 라인별 목록에 줄클릭시 point 클래스 add하기위해 querySelectorAll 사용 후 for문 돌리기
    let pm_table = document.querySelectorAll('.pm_table')
    console.log(pm_table)
    for (let i = 0; i < pm_table.length; i++) {
        pm_table[i].addEventListener('click', function (evt) {

            //생산현황판 눌렀을때 생산일정 point 제거하는 js
            let pr_table = document.querySelectorAll('.pr_table')
            console.log("aaaaaaaaaa", pr_table)
            for (let y = 0; y < pr_table.length; y++) {
                console.log("kkkkkkkkkk", pr_table[y].querySelectorAll('tr'))
                let pr_table_tr = pr_table[y].querySelectorAll('tr')
                for (let j = 0; j < pr_table_tr.length; j++) {
                    pr_table_tr[j].classList.remove('point')
                }
            }

            // //생산 관리 관련 수정창 클릭시 표시
            // document.querySelector('.pr_correction').classList.add('hide')
            // document.querySelector('.pm_correction').classList.remove('hide')

            // // 라인별 목록에 줄클릭시 point 클래스 add하는 js 
            let pm_tables = evt.target.parentNode.parentNode.children
            console.log(pm_tables)
            for (let j = 0; j < pm_tables.length; j++) {
                pm_tables[j].classList.remove('point')
            }
            evt.target.parentNode.classList.add('point')
        })
    }


    let pr_table = document.querySelector('.pr_table')
    pr_table.addEventListener('click', function (evt) {

        //생산일정판 눌렀을때 생산현황 point 제거하는 js
        let pm_table = document.querySelectorAll('.pm_table')
        console.log("gggggggggggg", pm_table)
        for (let y = 0; y < pm_table.length; y++) {
            console.log("aaaaaaaaaa", pm_table[y].querySelectorAll('tr'))
            let pm_table_tr = pm_table[y].querySelectorAll('tr')
            for (let j = 0; j < pm_table_tr.length; j++) {
                pm_table_tr[j].classList.remove('point')
            }
        }

        // for(let y = 0; y < pm_table_tr.length; y++){
        //     pm_table_tr[y].classList.remove('point')
        // }

        //생산 관리 관련 수정창 클릭시 표시
        // document.querySelector('.pm_correction').classList.add('hide')
        // document.querySelector('.pr_correction').classList.remove('hide')
        // 라인별 목록에 줄클릭시 point 클래스 add하는 js 
        let pr_tables = evt.target.parentNode.parentNode.children
        console.log(pr_tables)
        for (let i = 0; i < pr_tables.length; i++) {
            pr_tables[i].classList.remove('point')
        }
        evt.target.parentNode.classList.add('point')
    })

    // let complete = document.querySelectorAll('.complete')
    // for (let i = 0; i < complete.length; i++) {
    //     complete[i].addEventListener('click', function () {
    //         alert("완료되었습니다.")
    //     })
    // }
    // let add = document.querySelectorAll('.add')
    // for (let i = 0; i < add.length; i++) {
    //     add[i].addEventListener('click', function () {
    //         alert("추가되었습니다.")
    //     })
    // }
    // let retouch = document.querySelectorAll('.retouch')
    // for (let i = 0; i < retouch.length; i++) {
    //     retouch[i].addEventListener('click', function () {
    //         alert("수정되었습니다.")
    //     })
    // }
    // let deletes = document.querySelectorAll('.delete')
    // for (let i = 0; i < deletes.length; i++) {
    //     deletes[i].addEventListener('click', function () {
    //         alert("삭제되었습니다.")
    //     })
    // }

    // 생산관리버튼 팝업창 기능
    document.querySelector('.pm_mm_but').addEventListener('click', function () {
        window.open("/ktpn/pm_popup", "a", "width=398, height=390, left=100, top=50");
    })

    // 생산일정버튼 팝업창 기능
    document.querySelector('.pr_mm_but').addEventListener('click', function () {
        window.open("/ktpn/pr_popup", "a", "width=398, height=410, left=100, top=50");
    })
    
    

}
