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
            console.log("이거이거이거이거이거" + evtId[1])


            if (evtId[1] == "date_ssManu1") {
                //일별 생산량 라인선택시 클릭이벤트
                let line_graph_day = document.querySelector('.line_graph_day')
                console.log("line_graph_day : ", line_graph_day)
                line_graph_day.addEventListener('click', function (evt) {
                    let line_graph_days = evt.target.value
                    console.log("line_graph_days : ", line_graph_days)
                    let graph_box_day_a = document.querySelector('.graph_box_day_a')
                    console.log("aaaaaaa", graph_box_day_a)
                    let graph_box_day_b = document.querySelector('.graph_box_day_b')
                    console.log("bbbbb", graph_box_day_b)
                    let graph_box_day_c = document.querySelector('.graph_box_day_c')
                    console.log("cccccc", graph_box_day_c)


                    if (line_graph_days == "1") {
                        graph_box_day_a.classList.remove('hide')
                        graph_box_day_b.classList.add('hide')
                        graph_box_day_c.classList.add('hide')

                    } else if (line_graph_days == "2") {

                        graph_box_day_a.classList.add('hide')
                        graph_box_day_b.classList.remove('hide')
                        // <!-- 일별 B라인 -->
                        for (let i = 1; i < 4; i++) {

                            let myChart_day_b = echarts.init(document.getElementById('main' + i + '_day_b'))

                            option = {
                                legend: {},
                                tooltip: {},
                                dataset: {
                                    dimensions: ['product', '목표량', '생산량', '불량률'],
                                    source: [
                                        { product: '25.04.29', 목표량: 50.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.04.28', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.04.27', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.04.26', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.04.25', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.04.24', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.04.23', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
                                    ]
                                },
                                xAxis: { type: 'category' },
                                yAxis: {},
                                series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
                            };
                            myChart_day_b.setOption(option)
                        }
                        graph_box_day_c.classList.add('hide')
                    } else if (line_graph_days == "3") {
                        graph_box_day_a.classList.add('hide')
                        graph_box_day_b.classList.add('hide')
                        graph_box_day_c.classList.remove('hide')
                        // <!-- 일별 C라인 -->
                        for (let i = 1; i < 4; i++) {

                            let myChart_day_c = echarts.init(document.getElementById('main' + i + '_day_c'))

                            option = {
                                legend: {},
                                tooltip: {},
                                dataset: {
                                    dimensions: ['product', '목표량', '생산량', '불량률'],
                                    source: [
                                        { product: '25.04.29', 목표량: 90.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.04.28', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.04.27', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.04.26', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.04.25', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.04.24', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.04.23', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
                                    ]
                                },
                                xAxis: { type: 'category' },
                                yAxis: {},
                                series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
                            };
                            myChart_day_c.setOption(option)
                        }
                    }
                })
            }


            if (evtId[1] == "date_ssManu2") {
                // <!-- 주별 A라인 -->
                for (let i = 1; i < 4; i++) {

                    let myChart_week_a = echarts.init(document.getElementById('main' + i + '_week_a'))

                    option = {
                        legend: {},
                        tooltip: {},
                        dataset: {
                            dimensions: ['product', '목표량', '생산량', '불량률'],
                            source: [
                                { product: '25.04.3주', 목표량: 1113.3, 생산량: 185.8, 불량률: 193.7 },
                                { product: '25.04.2주', 목표량: 183.1, 생산량: 173.4, 불량률: 155.1 },
                                { product: '25.04.1주', 목표량: 186.4, 생산량: 165.2, 불량률: 182.5 },
                                { product: '25.03.4주', 목표량: 172.4, 생산량: 153.9, 불량률: 139.1 },
                                { product: '25.03.3주', 목표량: 172.4, 생산량: 153.9, 불량률: 139.1 },
                                { product: '25.03.2주', 목표량: 172.4, 생산량: 153.9, 불량률: 139.1 },
                                { product: '25.03.1주', 목표량: 172.4, 생산량: 153.9, 불량률: 139.1 }
                            ]
                        },
                        xAxis: { type: 'category' },
                        yAxis: {},
                        series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
                    };
                    myChart_week_a.setOption(option)
                }

                //주별 생산량 라인선택시 클릭이벤트
                let line_graph_week = document.querySelector('.line_graph_week')
                console.log("line_graph_week : ", line_graph_week)
                line_graph_week.addEventListener('click', function (evt) {
                    let line_graph_weeks = evt.target.value
                    console.log("line_graph_weeks : ", line_graph_weeks)
                    let graph_box_week_a = document.querySelector('.graph_box_week_a')
                    console.log("aaaaaaa", graph_box_week_a)
                    let graph_box_week_b = document.querySelector('.graph_box_week_b')
                    console.log("bbbbb", graph_box_week_b)
                    let graph_box_week_c = document.querySelector('.graph_box_week_c')
                    console.log("cccccc", graph_box_week_c)



                    if (line_graph_weeks == "1") {
                        graph_box_week_a.classList.remove('hide')
                        graph_box_week_b.classList.add('hide')
                        graph_box_week_c.classList.add('hide')

                    } else if (line_graph_weeks == "2") {
                        graph_box_week_a.classList.add('hide')
                        graph_box_week_b.classList.remove('hide')
                        // <!-- 주별 B라인 -->
                        for (let i = 1; i < 4; i++) {

                            let myChart_week_b = echarts.init(document.getElementById('main' + i + '_week_b'))

                            option = {
                                legend: {},
                                tooltip: {},
                                dataset: {
                                    dimensions: ['product', '목표량', '생산량', '불량률'],
                                    source: [
                                        { product: '25.04.3주', 목표량: 43.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.04.2주', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.04.1주', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.03.4주', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.3주', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.2주', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.1주', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
                                    ]
                                },
                                xAxis: { type: 'category' },
                                yAxis: {},
                                // Declare several bar series, each will be mapped
                                // to a column of dataset.source by default.
                                series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
                            };
                            // 3-3. 차트 옵션 설정하기
                            myChart_week_b.setOption(option)
                        }
                        graph_box_week_c.classList.add('hide')
                    } else if (line_graph_weeks == "3") {
                        graph_box_week_a.classList.add('hide')
                        graph_box_week_b.classList.add('hide')
                        graph_box_week_c.classList.remove('hide')
                        // <!-- 주별 C라인 -->
                        // 3-1. 준비한 DOM 컨테이너에서 echarts 초기화하기
                        for (let i = 1; i < 4; i++) {

                            let myChart_week_c = echarts.init(document.getElementById('main' + i + '_week_c'))

                            option = {
                                legend: {},
                                tooltip: {},
                                dataset: {
                                    dimensions: ['product', '목표량', '생산량', '불량률'],
                                    source: [
                                        { product: '25.04.3주', 목표량: 93.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.04.2주', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.04.1주', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.03.4주', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.3주', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.2주', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.1주', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
                                    ]
                                },
                                xAxis: { type: 'category' },
                                yAxis: {},
                                // Declare several bar series, each will be mapped
                                // to a column of dataset.source by default.
                                series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
                            };
                            // 3-3. 차트 옵션 설정하기
                            myChart_week_c.setOption(option)
                        }
                    }

                })



            } else if (evtId[1] == "date_ssManu3") {
                // <!-- 월별 A라인 -->
                // 3-1. 준비한 DOM 컨테이너에서 echarts 초기화하기
                for (let i = 1; i < 4; i++) {

                    let myChart_month_a = echarts.init(document.getElementById('main' + i + '_month_a'))

                    option = {
                        legend: {},
                        tooltip: {},
                        dataset: {
                            dimensions: ['product', '목표량', '생산량', '불량률'],
                            source: [
                                { product: '25.04', 목표량: 13.3, 생산량: 85.8, 불량률: 93.7 },
                                { product: '25.03', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                { product: '25.02', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                { product: '25.01', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '24.12', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '24.11', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '24.10', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
                            ]
                        },
                        xAxis: { type: 'category' },
                        yAxis: {},
                        // Declare several bar series, each will be mapped
                        // to a column of dataset.source by default.
                        series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
                    };
                    // 3-3. 차트 옵션 설정하기
                    myChart_month_a.setOption(option)
                }
                //월별 생산량 라인선택시 클릭이벤트
                let line_graph_month = document.querySelector('.line_graph_month')
                console.log("line_graph_month : ", line_graph_month)
                line_graph_month.addEventListener('click', function (evt) {
                    let line_graph_months = evt.target.value
                    console.log("line_graph_months : ", line_graph_months)
                    let graph_box_month_a = document.querySelector('.graph_box_month_a')
                    console.log("aaaaaaa", graph_box_month_a)
                    let graph_box_month_b = document.querySelector('.graph_box_month_b')
                    console.log("bbbbb", graph_box_month_b)
                    let graph_box_month_c = document.querySelector('.graph_box_month_c')
                    console.log("cccccc", graph_box_month_c)


                    if (line_graph_months == "1") {
                        graph_box_month_a.classList.remove('hide')
                        graph_box_month_b.classList.add('hide')
                        graph_box_month_c.classList.add('hide')

                    } else if (line_graph_months == "2") {

                        graph_box_month_a.classList.add('hide')
                        graph_box_month_b.classList.remove('hide')
                        // <!-- 월별 B라인 -->
                        // 3-1. 준비한 DOM 컨테이너에서 echarts 초기화하기
                        for (let i = 1; i < 4; i++) {

                            let myChart_month_b = echarts.init(document.getElementById('main' + i + '_month_b'))

                            option = {
                                legend: {},
                                tooltip: {},
                                dataset: {
                                    dimensions: ['product', '목표량', '생산량', '불량률'],
                                    source: [
                                        { product: '25.04', 목표량: 43.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.03', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.02', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.01', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '24.12', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '24.11', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '24.10', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
                                    ]
                                },
                                xAxis: { type: 'category' },
                                yAxis: {},
                                // Declare several bar series, each will be mapped
                                // to a column of dataset.source by default.
                                series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
                            };
                            // 3-3. 차트 옵션 설정하기
                            myChart_month_b.setOption(option)
                        }
                        graph_box_month_c.classList.add('hide')
                    } else if (line_graph_months == "3") {
                        graph_box_month_a.classList.add('hide')
                        graph_box_month_b.classList.add('hide')
                        graph_box_month_c.classList.remove('hide')
                        // 월별 C라인
                        // 3-1. 준비한 DOM 컨테이너에서 echarts 초기화하기
                        for (let i = 1; i < 4; i++) {

                            let myChart_month_c = echarts.init(document.getElementById('main' + i + '_month_c'))

                            option = {
                                legend: {},
                                tooltip: {},
                                dataset: {
                                    dimensions: ['product', '목표량', '생산량', '불량률'],
                                    source: [
                                        { product: '25.04', 목표량: 93.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.03', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.02', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.01', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '24.12', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '24.11', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '24.10', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
                                    ]
                                },
                                xAxis: { type: 'category' },
                                yAxis: {},
                                // Declare several bar series, each will be mapped
                                // to a column of dataset.source by default.
                                series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
                            };
                            // 3-3. 차트 옵션 설정하기
                            myChart_month_c.setOption(option)
                        }
                    }
                })
            }


            console.log("222", evtId[2])
            const date_ssListId = document.querySelectorAll("[id^=date_ssList]")
            console.log("333", date_ssListId)

            for (let y = 0; y < date_ssListId.length; y++) {
                date_ssListId[y].classList.add('hide')
            }
            document.querySelector("#" + evtId[2]).classList.remove('hide')

        })

    }


    // <!-- 일별 A라인 -->

        // 3-1. 준비한 DOM 컨테이너에서 echarts 초기화하기
        for (let i = 1; i < 4; i++) {

            let myChart_day_a = echarts.init(document.getElementById('main' + i + '_day_a'))

            option = {
                legend: {},
                tooltip: {},
                dataset: {
                    dimensions: ['product', '목표량', '생산량', '불량률'],
                    source: [
                        { product: '25.04.29', 목표량: 10.3, 생산량: 85.8, 불량률: 93.7 },
                        { product: '25.04.28', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                        { product: '25.04.27', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                        { product: '25.04.26', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                        { product: '25.04.25', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                        { product: '25.04.24', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                        { product: '25.04.23', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
                    ]
                },
                xAxis: { type: 'category' },
                yAxis: {},
                // Declare several bar series, each will be mapped
                // to a column of dataset.source by default.
                series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
            };
            myChart_day_a.setOption(option)
        }
        let line_graph_day = document.querySelector('.line_graph_day')
        console.log("line_graph_day : ", line_graph_day)
        line_graph_day.addEventListener('click', function (evt) {
            let line_graph_days = evt.target.value
            console.log("line_graph_days : ", line_graph_days)
            let graph_box_day_a = document.querySelector('.graph_box_day_a')
            console.log("aaaaaaa", graph_box_day_a)
            let graph_box_day_b = document.querySelector('.graph_box_day_b')
            console.log("bbbbb", graph_box_day_b)
            let graph_box_day_c = document.querySelector('.graph_box_day_c')
            console.log("cccccc", graph_box_day_c)


            if (line_graph_days == "2") {

                graph_box_day_a.classList.add('hide')
                graph_box_day_b.classList.remove('hide')
                // <!-- 일별 B라인 -->
                for (let i = 1; i < 4; i++) {

                    let myChart_day_b = echarts.init(document.getElementById('main' + i + '_day_b'))

                    option = {
                        legend: {},
                        tooltip: {},
                        dataset: {
                            dimensions: ['product', '목표량', '생산량', '불량률'],
                            source: [
                                { product: '25.04.29', 목표량: 50.3, 생산량: 85.8, 불량률: 93.7 },
                                { product: '25.04.28', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                { product: '25.04.27', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                { product: '25.04.26', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.04.25', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.04.24', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.04.23', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
                            ]
                        },
                        xAxis: { type: 'category' },
                        yAxis: {},
                        series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
                    };
                    myChart_day_b.setOption(option)
                }
                graph_box_day_c.classList.add('hide')
            } else if (line_graph_days == "3") {
                graph_box_day_a.classList.add('hide')
                graph_box_day_b.classList.add('hide')
                graph_box_day_c.classList.remove('hide')
                // <!-- 일별 C라인 -->
                for (let i = 1; i < 4; i++) {

                    let myChart_day_c = echarts.init(document.getElementById('main' + i + '_day_c'))

                    option = {
                        legend: {},
                        tooltip: {},
                        dataset: {
                            dimensions: ['product', '목표량', '생산량', '불량률'],
                            source: [
                                { product: '25.04.29', 목표량: 90.3, 생산량: 85.8, 불량률: 93.7 },
                                { product: '25.04.28', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                { product: '25.04.27', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                { product: '25.04.26', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.04.25', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.04.24', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.04.23', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
                            ]
                        },
                        xAxis: { type: 'category' },
                        yAxis: {},
                        series: [{ type: 'bar' }, { type: 'bar' }, { type: 'bar' }]
                    };
                    myChart_day_c.setOption(option)
                }
            }

        })


        


    



}