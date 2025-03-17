document.addEventListener("DOMContentLoaded", function () {
    fetchSessionData(); // 페이지 로드 시 세션 정보 가져오기
});

function fetchSessionData() {
    fetch('session')  // 서버에서 세션 정보 가져오기
        .then(response => {
            if (!response.ok) {
                throw new Error("서버 응답 오류: " + response.status);
            }
            return response.json();  // JSON 변환
        })
        .then(data => {
            document.getElementById('sessionId').innerText = data.sessionId || "없음";
            document.getElementById('username').innerText = data.username || "admin";
            document.getElementById('sessionTimeout').innerText = data.sessionTimeout || "알 수 없음";
            document.getElementById('sessionExpired').innerText = data.sessionExpired ? "만료됨" : "유효함";

            // 타이머 업데이트
            updateTimer(data.remainingTime);
        })
        .catch(error => {
            console.error("세션 정보를 가져오는 중 오류 발생:", error);
            document.getElementById('sessionExpired').innerText = "오류 발생";
        });
}

function updateTimer(remainingTime) {
    if (window.timerInterval) {
        clearInterval(window.timerInterval);
    }

    function countdown() {
        if (remainingTime > 0) {
            document.getElementById('timer').innerText = remainingTime + " 초";
            remainingTime--;
        } else {
            document.getElementById('timer').innerText = "세션이 만료되었습니다.";
            alert("세션이 만료되었습니다. 다시 로그인해주세요.");
            clearInterval(window.timerInterval);

            markSessionAsExpired();
        }
    }
    countdown();
    window.timerInterval = setInterval(countdown, 1000);
}


// 팝업이 닫힐 때 세션 만료 요청 보내기
function markSessionAsExpired() {
    fetch('/session-expire', { method: 'POST' }) // 서버에 세션 만료 요청
        .then(response => response.json())
        .then(data => {
            console.log("서버 응답:", data);
            document.getElementById('sessionExpired').innerText = "만료됨"; // 화면 업데이트
        })
        .catch(error => console.error("세션 만료 요청 중 오류 발생:", error));
}



// (자바 톰캣 서버 버전)
//  var remainingTime = 0; // 초기값

// // 서버에서 세션 남은 시간 가져오기
// function fetchRemainingTime() {
//     fetch('session')
//         .then(response => response.json())
//         .then(data => {
//             remainingTime = data.remainingTime;
//             startTimer(); // 타이머 시작
//         })
//         .catch(error => console.error("세션 정보를 가져오는 중 오류 발생: ", error));
// }

// // 타이머 업데이트 함수
// function startTimer() {
//     if (window.timerInterval) clearInterval(window.timerInterval); // 기존 타이머 중지

//     window.timerInterval = setInterval(function () {
//         if (remainingTime > 0) {
//             document.getElementById('timer').innerText = remainingTime + " 초";
//             remainingTime--;
//         } else {
//             alert("세션 시간이 만료되었습니다. 시간을 초기화합니다.");
//             document.getElementById('timer').innerText = '세션이 만료되었습니다. 로그인페이지로 돌아갑니다.';
//             fetchRemainingTime(); // 서버에서 최신 세션 시간 가져와 다시 시작
//             clearInterval(timerInterval); // 반복 중지
//              }
//     }, 1000);
// }
// // var timerInterval = setInterval(updateTimer, 1000);

// // 3분마다 세션 유지 요청 보내기
// setInterval(function () {
//     fetch('/session')
//         .then(response => response.json())
//         .then(data => console.log("세션 유지됨:", data.message))
//         .catch(error => console.error("세션 유지 중 오류 발생:", error));
// }, 180000); // 3분마다 실행

// // 페이지 로드 시 세션 시간 가져오기
// window.onload = fetchRemainingTime;