// TestQA_main_park.html 

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