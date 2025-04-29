window.addEventListener('load',init)

                
                
function init(){

   
    const write = document.querySelector('.add');
    write.addEventListener('click', writeprocess)
    function writeprocess(e) {
        console.log("글쓰기 페이지 진입")
        console.log("viewpage.innerText", viewpage.innerText)
        if(viewpage.innerText == '공지사항'){
        	window.location.href = "nwriteprocess_nam"
        } else {
        	window.location.href = "fwriteprocess_nam"
        }
    }
    
   

    const nums = document.querySelectorAll('.pnum')        

    // for(let i =0; i< nums.length; i++){
    //     nums.forEach(num => { num.addEventListener('click',function(e){
    //         nums.forEach(nm => nm.classList.remove('bold'));
    //         e.target.classList.add('bold')
    //     })
    // });
    // }

    for(let i =0; i< nums.length; i++){
        nums[i].addEventListener('click',function(e){
            for(let j=0; j<nums.length; j++){
                nums[j].classList.remove('bold')
                e.target.classList.add('bold')
            }
        })
    }

  
}