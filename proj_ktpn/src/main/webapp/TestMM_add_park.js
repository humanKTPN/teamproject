// TestMM_add_park.html

// 사이드 메뉴 유무에 따라 크기 조절
// document.querySelector('#main-menu').addEventListener('click',function(){
        
        
//     if(document.querySelector('.mainmenu').classList.length == 1){
//         document.querySelector('.mainmenu').classList.add('hide')
//         document.querySelector('#main-menu').textContent = 'MENU 열기'
//         document.querySelector('.flex_child').style.width = "1080px";
//     } else if (document.querySelector('.mainmenu').classList.length == 2){
//         document.querySelector('.mainmenu').classList.remove('hide')
//         document.querySelector('#main-menu').textContent = 'MENU 닫기'
//         document.querySelector('.flex_child').style.width = "1272px";
//     }

// }) //메뉴 열었다 닫았다 하기<끝>


// 입력추가 버튼을 누르면 동작하는 이벤트
const btn_input_add = document.getElementById('btn_input_add');

// 생성된 input의 개수
let input_cnt = 0;

btn_input_add.addEventListener('click', function () {
    console.log("동작함");

    // new_input 할 때마다 +1
    input_cnt += 1;

    const new_input = document.createElement("div");
    // new_input.className = 'flex_child';
    // new_input.className = 'child' + input_cnt;
    new_input.classList.add('flex_child', 'new_input');
    new_input.innerHTML = `
        
            <input class="item Mcode" type="text" value="" placeholder="자재코드 입력" />
            <input class="item Mname" type="text" value="" placeholder="자재명 입력" />
            <input class="item Mea" type="text" value="" placeholder="수량 입력" />
            <input class="item Mloc" type="text" value="" placeholder="재고위치 입력" />
        
    `;

    document.getElementById('input').appendChild(new_input);


    console.log(input_cnt);
});



// 확인 버튼을 누르면 입력한 값을 출력하는 이벤트
const btn_add_confirm = document.getElementById('btn_add_confirm');

btn_add_confirm.addEventListener('click', function () {
    console.log("동작함");
    alert("추가되었습니다.");
    // const add_input = document.querySelectorAll('.new_input');
    // let input_data;

    // const ad = document.querySelectorAll(".Mcode").value;
    

    for(let i=0; i<ad.length; i++){
        console.log(ad);
    }


    // for (let i = 0; i < add_input.length; i++) {

    //     // 추가한 input의 값 별로 배열에 저장하기

    //     if (add_input[i].querySelector(".Mea").value < 1000) {
    //         add_input[i].querySelector(".Morder").value = "Y";
    //     } else {
    //         add_input[i].querySelector(".Morder").value = "N";
    //     }

    //     input_data = [
    //         {
    //             Mcode: add_input[i].querySelector('.Mcode').value,
    //             Mname: add_input[i].querySelector(".Mname").value,
    //             Mea: add_input[i].querySelector(".Mea").value,
    //             Morder: add_input[i].querySelector(".Morder").value,
    //             Mloc: add_input[i].querySelector(".Mloc").value
    //         }
    //     ];
    //     //console.log(input_data[i].Mcode + " " + input_data[i].Mname + " " + input_data[i].Mea + " " + input_data[i].Morder + " " + input_data[i].Mloc + "가 추가되었습니다.");
    //     console.log(add_input[i].textContent);
        



    //     // if (document.querySelector(".Mea").value < 1000) {
    //     //     document.querySelector(".Morder").value = "Y";
    //     // } else {
    //     //     document.querySelector(".Morder").value = "N";
    //     // }

    //     // input_data = [
    //     //     {
    //     //         Mcode: document.querySelector(".Mcode").value,
    //     //         Mname: document.querySelector(".Mname").value,
    //     //         Mea: document.querySelector(".Mea").value,
    //     //         Morder: document.querySelector(".Morder").value,
    //     //         Mloc: document.querySelector(".Mloc").value
    //     //     }
    //     // ];

    
    // }




    // for (let i = 0; i < input_cnt; i++) {
    //     alert(input_data[i].Mcode + " " + input_data[i].Mname + " " + input_data[i].Mea + " " + input_data[i].Morder + " " + input_data[i].Mloc + "가 추가되었습니다.");
    // }
    // alert(Mcode + " " + Mname + " " + Mea + " " + Morder + " " + Mloc + "(이)가 추가되었습니다.");
});

// 현재 문제 - 여러개의 input 값을 입력했을 때 출력이 안됨
// 생각난 방법1. 새로 추가한 new_input 전체, 또는 부모 div-flex_child에 하나의 공통 클래스를 준다
//              new_input 할때마다 클래스 값이 증가한다. ex) flex_child1
//              for문으로 배열에 넣는다
//              for문으로 출력