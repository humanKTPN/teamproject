window.addEventListener('load',workManage_select)

function workManage_select(){
    console.log('ㅎㅇ')
    select_td= document.querySelectorAll('.command-td')
    for(sel of select_td){
        sel.addEventListener('click',function(){
            window.location.href="workManage_select_v0.4_kwak.html"
        })
    }
    document.querySelector('.add').addEventListener('click',function(){
        window.location.href="workManage_add_v0.4_kwak.html"
    })
}