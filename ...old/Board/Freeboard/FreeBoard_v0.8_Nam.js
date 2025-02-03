    // document.querySelector('.prevp').addEventListener('click', prev)
        // function prev() {
        //     let pageline = document.querySelector('.pnum')
        //     console.log(.pnum)
        //     for (prev of pageline) {
        //         console.log(`pageline`)
        //     }
        // }

        window.addEventListener("load", function () {
            console.log('들어옴')
        })
        const search = document.querySelector("#search");
        search.addEventListener('click', filter)
        function filter() {
            const optionS = document.querySelector('#viewfilter')
            const optionT = document.querySelector('#fillvalue')
            console.log(optionS.value)
            console.log(optionT.value)
        }