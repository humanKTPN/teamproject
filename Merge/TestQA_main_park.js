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
        // alert("품질보고서 작성페이지로 넘어갑니다.");
    });
});


// 이전 페이지 알림
const a_before_page = document.getElementById('a_before_page');

a_before_page.addEventListener('click', function() {
    console.log("동작함");
    // alert("이전페이지로 넘어갑니다.");
});


// 다음 페이지 알림
const a_after_page = document.getElementById('a_after_page');

a_after_page.addEventListener('click', function() {
    console.log("동작함");
    // alert("다음페이지로 넘어갑니다.");
});


// 페이지 강조 표시
const nums = document.querySelectorAll('.num');

for(let i =0; i<nums.length; i++){
    nums[i].addEventListener('click', function(e) {
        for(let j=0; j<nums.length; j++) {
            nums[j].classList.remove('bold');
            e.target.classList.add('bold');
        }
    })
}


// 현재 날짜가 바로 반영
document.getElementById('select_QA_today').value = new Date().toISOString().substring(0, 10);
