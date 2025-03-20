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
                                        { product: '25.03.11', 목표량: 50.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.03.12', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.03.13', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.03.15', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.16', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.17', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.18', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
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
                                        { product: '25.03.11', 목표량: 90.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.03.12', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.03.13', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.03.15', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.16', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.17', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.18', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
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
                                { product: '25.03.11', 목표량: 1113.3, 생산량: 185.8, 불량률: 193.7 },
                                { product: '25.03.12', 목표량: 183.1, 생산량: 173.4, 불량률: 155.1 },
                                { product: '25.03.13', 목표량: 186.4, 생산량: 165.2, 불량률: 182.5 },
                                { product: '25.03.15', 목표량: 172.4, 생산량: 153.9, 불량률: 139.1 },
                                { product: '25.03.16', 목표량: 172.4, 생산량: 153.9, 불량률: 139.1 },
                                { product: '25.03.17', 목표량: 172.4, 생산량: 153.9, 불량률: 139.1 },
                                { product: '25.03.18', 목표량: 172.4, 생산량: 153.9, 불량률: 139.1 }
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
                                        { product: '25.03.11', 목표량: 43.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.03.12', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.03.13', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.03.15', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.16', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.17', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.18', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
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
                                        { product: '25.03.11', 목표량: 93.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.03.12', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.03.13', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.03.15', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.16', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.17', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.18', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
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
                                { product: '25.03.11', 목표량: 13.3, 생산량: 85.8, 불량률: 93.7 },
                                { product: '25.03.12', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                { product: '25.03.13', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                { product: '25.03.15', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.03.16', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.03.17', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.03.18', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
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
                                        { product: '25.03.11', 목표량: 43.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.03.12', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.03.13', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.03.15', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.16', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.17', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.18', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
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
                                        { product: '25.03.11', 목표량: 93.3, 생산량: 85.8, 불량률: 93.7 },
                                        { product: '25.03.12', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                        { product: '25.03.13', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                        { product: '25.03.15', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.16', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.17', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                        { product: '25.03.18', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
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

    //품목별 월별 총 생산량 셀렉별 표시변환
    let arr = new Array();
    let mu_box = document.querySelector('.mu_box')
    console.log("mu_box : ", mu_box)
    mu_box.addEventListener('click', function (evt) {
        let mu_boxs = evt.target.value
        console.log("mu_boxs : ", mu_boxs)
        for(let i=0; i<4; i++){
            arr[i] = document.getElementById('es_'+i)
            console.log("요거요거요거요거"+arr[0])
        }
        if (mu_boxs == "1") {
            arr[0].innerHTML = 10;
            arr[1].innerHTML = 20;
            arr[2].innerHTML = 30;
            arr[3].innerHTML = 40;
        } else if (mu_boxs == "2") {
            arr[0].innerHTML = 110;
            arr[1].innerHTML = 210;
            arr[2].innerHTML = 301;
            arr[3].innerHTML = 401;
        } else if (mu_boxs == "3") {
            arr[0].innerHTML = 1110;
            arr[1].innerHTML = 210;
            arr[2].innerHTML = 3110;
            arr[3].innerHTML = 4101;
        } else if (mu_boxs == "4") {
            arr[0].innerHTML = 110;
            arr[1].innerHTML = 20;
            arr[2].innerHTML = 130;
            arr[3].innerHTML = 410;
        } else if (mu_boxs == "5") {
            arr[0].innerHTML = 110;
            arr[1].innerHTML = 210;
            arr[2].innerHTML = 31110;
            arr[3].innerHTML = 40;
        } else if (mu_boxs == "6") {
            arr[0].innerHTML = 110;
            arr[1].innerHTML = 20;
            arr[2].innerHTML = 301;
            arr[3].innerHTML = 40;
        } else if (mu_boxs == "7") {
            arr[0].innerHTML = 101;
            arr[1].innerHTML = 20;
            arr[2].innerHTML = 30;
            arr[3].innerHTML = 4011;
        } else if (mu_boxs == "8") {
            arr[0].innerHTML = 110;
            arr[1].innerHTML = 210;
            arr[2].innerHTML = 30;
            arr[3].innerHTML = 410;
        } else if (mu_boxs == "9") {
            arr[0].innerHTML = 10111;
            arr[1].innerHTML = 210;
            arr[2].innerHTML = 30;
            arr[3].innerHTML = 40;
        }

    })



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
                        { product: '25.03.11', 목표량: 10.3, 생산량: 85.8, 불량률: 93.7 },
                        { product: '25.03.12', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                        { product: '25.03.13', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                        { product: '25.03.15', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                        { product: '25.03.16', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                        { product: '25.03.17', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                        { product: '25.03.18', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
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
                                { product: '25.03.11', 목표량: 50.3, 생산량: 85.8, 불량률: 93.7 },
                                { product: '25.03.12', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                { product: '25.03.13', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                { product: '25.03.15', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.03.16', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.03.17', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.03.18', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
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
                                { product: '25.03.11', 목표량: 90.3, 생산량: 85.8, 불량률: 93.7 },
                                { product: '25.03.12', 목표량: 83.1, 생산량: 73.4, 불량률: 55.1 },
                                { product: '25.03.13', 목표량: 86.4, 생산량: 65.2, 불량률: 82.5 },
                                { product: '25.03.15', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.03.16', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.03.17', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 },
                                { product: '25.03.18', 목표량: 72.4, 생산량: 53.9, 불량률: 39.1 }
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


        let myChart_pi = echarts.init(document.getElementById('main_pi'))

        option = {
            title: {
                text: '월 통계 자료',
                subtext: '',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            series: [
                {
                    name: 'KTPN',
                    type: 'pie',
                    radius: '50%',
                    data: [
                        { value: 1048, name: '월 목표량' },
                        { value: 735, name: '월 생산량' },
                        { value: 735, name: '월 불량률' },
                    ],
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myChart_pi.setOption(option)


    



}