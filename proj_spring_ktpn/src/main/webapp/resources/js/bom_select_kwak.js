window.addEventListener('load',init)

                
                
function init(){

   
    document.querySelector('.del').addEventListener('click',function(){
        alert('삭제되었습니다.')
    })

    document.querySelector('.mod').addEventListener('click',function(){

        if(document.querySelector('.mod').textContent == '완료'){
            document.querySelector('.mod').textContent = '수정'
            window.location.href='bom_mod_kwak.jsp'
        } else {
            document.querySelector('.mod').textContent = '완료'
        }

        const cnms =  document.querySelectorAll('.spn-td')
        const mnms =  document.querySelectorAll('.mod-td')
        for(cnm of cnms){
            if(cnm.classList.length == 1){
                cnm.classList.add('hide')
            } else {
                cnm.classList.remove('hide')
            }
        }
        for(mnm of mnms){
            if(mnm.classList.length == 1){
                mnm.classList.add('hide')
            } else {
                mnm.classList.remove('hide')
            }
        }
    })
	const tbnms = document.querySelectorAll('.tab-name')
    
	for(tbnm of tbnms){
        tbnm.addEventListener('click',function(e){
            console.log(e.target.textContent)
            if(e.target.textContent == '기준관리'){
                window.location.href = '/ktpn/md'
            } else if(e.target.textContent == 'BOM'){
                window.location.href = '/ktpn/bm'
            } else if(e.target.textContent == '공정'){
                window.location.href = '/ktpn/rt'
            }
        })
    }
}

