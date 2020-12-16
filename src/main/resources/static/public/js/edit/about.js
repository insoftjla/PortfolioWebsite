$(document).ready(() =>{

    const edit = () => {
        $(".aboutData").hide()
        $(".editor").show(300)
    }

    const aboutBlock = $("#aboutBlock")

    aboutBlock.dblclick(() => {
        edit();
    })


})