window.addEventListener('load', init)

function init() {
    
    setInterval(function () {
        let currentDate = new Date();
        const formattedDate = `${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${currentDate.getDate()} ${currentDate.getHours()}:${currentDate.getMinutes()}:${currentDate.getSeconds()}`;
        let newDate = document.querySelector('#newDate').value = formattedDate;
        
    }, 1000);
    // let currentDate = new Date();
    // const formattedDate = `${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${currentDate.getDate()} ${currentDate.getHours()}:${currentDate.getMinutes()}:${currentDate.getSeconds()}`;
    // let newDate = document.querySelector('#newDate').value = formattedDate
    
    
    let itemNm = document.querySelector('.itemNm');
    console.log("itemNm : ", itemNm);

    itemNm.addEventListener('change', function (evt) {  // 'click'을 'change'로 변경
        let itemNms = evt.target.value;  // 선택된 옵션의 값 가져오기
        console.log("itemNms : ", itemNms);

        let itemCd = document.querySelector('.itemCd');  // itemCd 요소 가져오기
        console.log("bbbbb", itemCd.value);  // 기존 itemCd 값 출력

        // itemCd 값을 업데이트
        if (itemNms == "싹싹지우개") {
            itemCd.value = "P0036";  // itemCd의 값을 'SS-01'로 변경
        } else if (itemNms == "하츄핑지우개") {
            itemCd.value = "P0033";  // itemCd의 값을 'HH-01'로 변경
        }
        console.log("Updated itemCd : ", itemCd.value);  // 변경된 itemCd 값 출력
    });
    
    //epdpspepwpe
    let itemCd = document.querySelector('.itemCd');
    console.log("itemCd : ", itemCd);

    itemCd.addEventListener('change', function (evt) {  // 'click'을 'change'로 변경
        let itemCds = evt.target.value;  // 선택된 옵션의 값 가져오기
        console.log("itemCds : ", itemCds);

        let itemNm = document.querySelector('.itemNm');  // itemCd 요소 가져오기
        console.log("bbbbb", itemCd.value);  // 기존 itemCd 값 출력

        // itemCd 값을 업데이트
        if (itemCds == "P0036") {
            itemNm.value = "싹싹지우개";  // itemCd의 값을 'SS-01'로 변경
        } else if (itemCds == "P0033") {
            itemNm.value = "하츄핑지우개";  // itemCd의 값을 'HH-01'로 변경
        }
        console.log("Updated itemNm : ", itemNm.value);  // 변경된 itemCd 값 출력
    });
    
    let pmBut = document.querySelector('.pm_correction_but_con')
    pmBut.addEventListener('click', function () {

        if (pmBut.value == 'insert') {
            let ttssText1 = document.querySelector('.ttssText1');
            let ttssText2 = document.querySelector('.ttssText2');
            let timeSet = document.querySelector('.timeSet')
            timeSet.innerHTML="생산시작시간";
            ttssText1.classList.remove('hide');
            ttssText2.classList.add('hide');
            
        }else if (pmBut.value == 'update'){
            let ttssText1 = document.querySelector('.ttssText1');
            let ttssText2 = document.querySelector('.ttssText2');
            let timeSet = document.querySelector('.timeSet')
            timeSet.innerHTML="생산수정시간";
            ttssText1.classList.remove('hide');
            ttssText2.classList.add('hide');
            
        }else if (pmBut.value == 'complete'){
            let ttssText1 = document.querySelector('.ttssText1');
            let ttssText2 = document.querySelector('.ttssText2');
            let timeSet = document.querySelector('.timeSet')
            timeSet.innerHTML="생산종료시간";
            ttssText1.classList.add('hide');
            ttssText2.classList.remove('hide');
            
        }
    })
    
    
    
   document.querySelector('.end').addEventListener('click', function () {
    setTimeout(function(){
        // 부모 창 새로고침
        if (window.opener && !window.opener.closed) {
            window.opener.location.reload();
        }

        // 팝업 닫기
        window.close();
    }, 300);
});
    
    
    

}
    