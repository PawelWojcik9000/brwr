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
            
            if(this.getAttribute("id") === "finishbrewing") {
                document.getElementsByTagName("body")[0].lastElementChild.style.display = "block";
                var buttonArea = this;
            } else {
                row++; 
                var buttonArea = tableRow[row].lastElementChild.lastElementChild;
            }
            
            if(buttonArea.getAttribute("id") === "countdown") {
                countDown(buttonArea, "Gotowe");
            }

            var hopsAddTime = document.getElementsByClassName("hopAddTime");
            var additionsAddTime = document.getElementsByClassName("additionAddTime");
            if(row === 6) {
                for (var i = 0; i < hopsAddTime.length; i++) {
                    countDown(hopsAddTime[i], "Chmiel dodany");
                }
                for (var i = 0; i < additionsAddTime.length; i++) {
                    countDown(additionsAddTime[i], "Dodano");
                }
            }

            tableRow[row].style.visibility = "visible";
            this.setAttribute("disabled", true);
  
        })
    }

    function countDown(counterArea, afterCountText) {

        counterArea.setAttribute("disabled", true);
        var minutes = counterArea.innerHTML - 1;
        var seconds = 59;
        counterArea.innerHTML = minutes + 1 + ":00";
    	var interval = setInterval(function() {
            
            if(seconds < 10 && minutes < 10) {
                counterArea.innerHTML = "0" + minutes + ":0" +seconds;
            } else if(seconds < 10) {
                counterArea.innerHTML = minutes + ":0" +seconds;
            } else if(minutes < 10) {
                counterArea.innerHTML = "0" + minutes + ":" +seconds;
            } else {
                counterArea.innerHTML = minutes + ":" +seconds;
            }

            if(seconds <= 0) {
                minutes--;
                seconds = 60;
            }
            seconds--;

            if(minutes <= 0 && seconds <= 0) {
                counterArea.removeAttribute("disabled");
                counterArea.innerHTML = afterCountText;
                clearInterval(interval);
            }

        }, 10);
    }

});