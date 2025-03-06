// TestMM_delte_park.html

// 체크박스
const allCheck = document.querySelector('.allCheck');
const list = document.querySelectorAll('.check');

// 제일 위에 있는 체크박스를 선택하면 나머지도 선택
allCheck.addEventListener('click', function() {
    if(allCheck.checked) {
        for(let i=0; i<list.length; i++) {
            list[i].checked = true;
        }
    } else {
        for(let i=0; i<list.length; i++) {
            list[i].checked = false;
        }
    }

});

// 체크박스를 전부 다 선택하면 제일 위에 있는 체크박스도 체크
const checked = document.querySelectorAll('.check:checked');

// list.forEach((target) => target.addEventListener('click'), function(){
//     if(list.length == checked.length) {
//         allCheck.checked = true;
//     }
//     else {
//         allCheck.checked = false;
//     }
// });

// 선택된 체크박스의 목록을 삭제
const btn_delete_confirm = document.getElementById('btn_delete_confirm');

btn_delete_confirm.addEventListener('click', function() {
    for(let i=0; i<list.length; i++) {
        if(list[i].checked) {
            list[i].parentElement.remove();
        }
    }
    alert("삭제되었습니다.")
});

