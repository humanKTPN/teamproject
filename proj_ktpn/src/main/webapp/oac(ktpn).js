function getCookie(name) { // 가져올때
    let cookies = document.cookie.split('; ');
    console.log("cookies : ", cookies);

    for (let cookie of cookies) {
        let [key, value] = cookie.split('=');
        console.log("현재 쿠키 : ", key, value);

        if (key === name) return value;
    }
    return null;
}

window.onload = function () {
    document.querySelector("#ham").addEventListener("click", function () {
        let popupClosed1 = getCookie("oac1");
        console.log("getCookie(oac1) : ", getCookie("oac1"))
        console.log("popupClosed1 : ", popupClosed1);

        if (popupClosed1 == "2") {
            /// 팝업창 유지
            // document.cookie = "oac1=false";
            console.log("메뉴을 띄운다.")
            document.querySelector("#work1").style.display = "block"
        } else if (popupClosed1 == "1") {
            // document.cookie = "oac1=true";
            console.log("메뉴을 지운다.")
            document.querySelector("#work1").style.display = "none"
        }
    })
    closePopup()
}


function closePopup() {
    let popupClosed1 = getCookie("oac1");

    if (popupClosed1 === "2") {
        console.log("메뉴을 띄운다.")
        console.log("popupClosed1 : 1", popupClosed1);
        document.getElementById("work1").style.display = "block";
        document.cookie = "oac1=1";
    } else if (popupClosed1 === "1") {
        console.log("메뉴을 지운다.")
        console.log("popupClosed1 : 2", popupClosed1);
        document.getElementById("work1").style.display = "none";
        document.cookie = "oac1=2";
    }
}

// 1. 햄버거 메뉴 버튼을 누르면 세션쿠키의 값이 바뀐다
// document.cookie = "oac1=true";
// document.cookie = "oac1=false";

// 2. 바뀐 세션 값에 따라 사이드메뉴가 보이고 안보인다.
// document.getElementById("popup").style.display = "none";
// document.getElementById("popup").style.display = "block";	

