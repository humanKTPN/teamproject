// TestMm_main_park.html


// 추가 알림
const btn_main_add = document.getElementById('btn_main_add');

btn_main_add.addEventListener('click', function () {
    console.log("동작함");
    alert("추가 페이지로 넘어갑니다.");
});


// 삭제 알림
const btn_main_delete = document.getElementById('btn_main_delete');

btn_main_delete.addEventListener('click', function () {
    console.log("동작함");
    alert("삭제 페이지로 넘어갑니다.");
});


// 주문 알림
const btn_main_order = document.getElementsByClassName('btn_main_order');

btn_main_order[0].addEventListener('click', function () {
    console.log("동작함");
    alert("주문 페이지로 넘어갑니다.");
});


// 수정 알림
const btn_main_update = document.getElementsByClassName('btn_main_update');

btn_main_update[0].addEventListener('click', function () {
    console.log("동작함");
    alert("수정 페이지로 넘어갑니다.");
});


// 이전 페이지 알림
const a_before = document.getElementById('a_before');

a_before.addEventListener('click', function () {
    console.log("동작함");
    alert("이전 페이지로 넘어갑니다");
});


// 다음 페이지 알림
const a_after = document.getElementById('a_after');

a_after.addEventListener('click', function () {
    console.log("동작함");
    alert("다음 페이지로 넘어갑니다");
});

// jquery
$(document).ready(function () {
    $('a_before').click(function () {
        console.log("동작함");
        alert("이전 페이지로 넘어갑니다.");
    })

});