window.addEventListener('load',init)

                
                
function init(){

   
    console.log('게시판에 들어옴')

    const search = document.querySelector("#search");
    search.addEventListener('click', filter)
    function filter() {
        const optionS = document.querySelector('#viewfilter')
        const optionT = document.querySelector('#fillvalue')
        console.log(optionS.value)
        console.log(optionT.value)

        // 필터링 후 표시(미구현)
    }

    const write = document.querySelector('.add');
    write.addEventListener('click', writeprocess)
    function writeprocess() {
        console.log("글쓰기 페이지 진입")
        window.location.href = "fwriteprocess_nam"
    }
    
  
    const nums = document.querySelectorAll('.pnum')        

 
    for(let i =0; i< nums.length; i++){
        nums[i].addEventListener('click',function(e){
            for(let j=0; j<nums.length; j++){
                nums[j].classList.remove('bold')
                e.target.classList.add('bold')
            }
        })
    }

}