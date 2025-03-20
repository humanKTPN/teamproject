// TestQA_report_park.html

// 확인 알림
const btn_report_confirm = document.getElementById('btn_report_confirm');

btn_report_confirm.addEventListener('click', function() {
    console.log("동작함");
    //alert("메인페이지로 넘어갑니다.");
});

// 현재 날짜가 바로 반영
document.getElementById('QA_day').value = new Date().toISOString().substring(0, 10);

// 확인 버튼을 누르면 TestQA_report의 최종결과 값이 넘어가서 TestQA_main의 최종결과 값이 된다.


//
document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);