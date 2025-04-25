// TestMm_main_park.html


// 추가 알림
const btn_main_add = document.getElementById('btn_main_add');

/*btn_main_add.addEventListener('click', function () {
    console.log("동작함");
    //alert("추가 페이지로 넘어갑니다.");
});


// 삭제 알림
const btn_main_delete = document.getElementById('btn_main_delete');

btn_main_delete.addEventListener('click', function () {
    console.log("동작함");
    //alert("삭제 페이지로 넘어갑니다.");
});


// 주문 알림
const btn_main_order = document.getElementsByClassName('btn_main_order');

btn_main_order[0].addEventListener('click', function () {
    console.log("동작함");
    //alert("주문정보 페이지로 넘어갑니다.");
});


// 수정 알림
const btn_main_update = document.getElementsByClassName('btn_main_update');

btn_main_update[0].addEventListener('click', function () {
    console.log("동작함");
    //alert("수정 페이지로 넘어갑니다.");
});


// 이전 페이지 알림
const a_before = document.getElementById('a_before');

a_before.addEventListener('click', function () {
    console.log("동작함");
    //alert("이전 페이지로 넘어갑니다");
});


// 다음 페이지 알림
const a_after = document.getElementById('a_after');

a_after.addEventListener('click', function () {
    console.log("동작함");
    //alert("다음 페이지로 넘어갑니다");
});


//페이지 표시
const nums = document.querySelectorAll('.num')

for(let i =0; i< nums.length; i++){
    nums[i].addEventListener('click',function(e){
        for(let j=0; j<nums.length; j++){
            nums[j].classList.remove('bold')
            e.target.classList.add('bold')
        }
    })
}*/


let select_table1 = document.querySelector('.select_table1');
const show_table2 = document.querySelector('#show_table2');
const show_table1 = document.querySelector('#show_table1');

select_table1.addEventListener('click', function(){
    console.log("동작함");
    show_table2.classList.add('hide');
    
    show_table1.classList.remove('hide');
})

let select_table2 = document.querySelector('.select_table2');
select_table2.addEventListener('click', function(){
	console.log("동작함");    
    show_table1.classList.add('hide');

    show_table2.classList.remove('hide');

   
})

// 현재 날짜가 바로 반영
document.getElementById('select_MM_today').value = new Date().toISOString().substring(0, 10);

// jquery
$(document).ready(function () {
    $('a_before').click(function () {
        console.log("동작함");
        //alert("이전 페이지로 넘어갑니다.");
    })

});