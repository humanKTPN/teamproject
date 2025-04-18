window.addEventListener('load',init)

                
                
function init(){
    
    const tbnms = document.querySelectorAll('.tab-name')
    
	for(tbnm of tbnms){
        tbnm.addEventListener('click',function(e){
            console.log(e.target.textContent)
            if(e.target.textContent == '기준관리'){
                window.location.href = 'masterdataManage_main_kwak.jsp'
            } else if(e.target.textContent == 'BOM'){
                window.location.href = 'bom_main_kwak.jsp'
            } else if(e.target.textContent == '공정'){
                window.location.href = 'processDesc_main.jsp'
            }
        })
    }
    
    document.querySelector('.add').addEventListener('click',function(){
    	window.location.href="/ktpn/rtAddDetail"
    })


}


    
    



// }
