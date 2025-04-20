window.addEventListener('load',init)

                
                
function init(){

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
    
    document.querySelector('.add').addEventListener('click',function(){
    	window.location.href="/ktpn/bmAddDetail"
    })
}
