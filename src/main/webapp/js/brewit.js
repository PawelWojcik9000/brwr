console.log("zaladowano");
document.addEventListener("DOMContentLoaded", function() {

    var steps = document.getElementsByClassName("step");
    var okbtns = document.getElementsByClassName("okbtn");

    for (var i = 1; i < steps.length; i++) {
        console.log(steps[i].lastElementChild);
        steps[i].style.visibility = "hidden";
    }

    var row = 0;
    for(var i = 0; i < okbtns.length; i++) {
        okbtns[i].addEventListener("click", function() {
            
            if(steps[row].lastElementChild.lastElementChild.getAttribute("id") === "countdown") {
                countDown(steps[row].lastElementChild.lastElementChild);
            }
            console.log(steps[row].lastElementChild.lastElementChild.getAttribute("id"));
            
            steps[row].style.visibility = "visible";
            row++; 
        })
    }

    function countDown(button) {
    	button.innerText = "OK";
    	console.log(button.innerHTML);
    }

    

});