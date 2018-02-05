console.log("brewit.js loaded");
document.addEventListener("DOMContentLoaded", function() {

    var tableRow = document.getElementsByTagName("tr");
    var okBtns = document.getElementsByClassName("okbtn");

    for (var i = 1; i < tableRow.length; i++) {
        tableRow[i].style.visibility = "hidden";
    }

    var row = 0;
    for(var i = 0; i < okBtns.length; i++) {
        okBtns[i].addEventListener("click", function() {
            row++; 
            var buttonArea = tableRow[row].lastElementChild.lastElementChild;
            if(buttonArea.getAttribute("id") === "countdown") {
                countDown(buttonArea);
            }

            var hopsAddTime = document.getElementsByClassName("hopAddTime");
            var additionsAddTime = document.getElementsByClassName("additionAddTime");
            if(i === 6) {
                for (let i = 0; i < hopsAddTime.length; i++) {
                    countDown(hopsAddTime[i]);
                }
                for (let i = 0; i < additionsAddTime.length; i++) {
                    countDown(additionsAddTime[i]);
                }
            }
            
            tableRow[row].style.visibility = "visible";
            tableRow[row-1].lastElementChild.lastElementChild.setAttribute("disabled", true);
        })
    }

    function countDown(button) {

        button.setAttribute("disabled", true);
        var minutes = button.innerHTML - 1;
        var seconds = 59;
        button.innerHTML = minutes + 1 + ":00";
    	var interval = setInterval(function() {
            
            if(seconds < 10 && minutes < 10) {
                button.innerHTML = "0" + minutes + ":0" +seconds;
            } else if(seconds < 10) {
                button.innerHTML = minutes + ":0" +seconds;
            } else if(minutes < 10) {
                button.innerHTML = "0" + minutes + ":" +seconds;
            } else {
                button.innerHTML = minutes + ":" +seconds;
            }

            if(seconds <= 0) {
                minutes--;
                seconds = 60;
            }
            seconds--;

            if(minutes <= 0 && seconds <= 0) {
                button.removeAttribute("disabled");
                button.innerHTML = "OK";
                clearInterval(interval);
            }

        }, 20);
    }

});