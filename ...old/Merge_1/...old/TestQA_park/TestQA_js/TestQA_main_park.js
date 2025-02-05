// TestQA_main_park.html 


// 품질보고서 작성 알림
const enter_reportPage = document.querySelectorAll('.enter_reportPage');

// enter_reportPage[0].addEventListener('click', function() {
//     console.log("동작함");
//     alert("품질보고서 작성페이지로 넘어갑니다.");
// });

enter_reportPage.forEach((element) => {
    element.addEventListener("click", function() {
        console.log("동작함");
        alert("품질보고서 작성페이지로 넘어갑니다.");
    });
});


// 이전 페이지 알림
const a_before_page = document.getElementById('a_before_page');

a_before_page.addEventListener('click', function() {
    console.log("동작함");
    alert("이전페이지로 넘어갑니다.");
});


// 다음 페이지 알림
const a_after_page = document.getElementById('a_after_page');

a_after_page.addEventListener('click', function() {
    console.log("동작함");
    alert("다음페이지로 넘어갑니다.");
});