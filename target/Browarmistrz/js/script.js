console.log("zaladowano");
document.addEventListener("DOMContentLoaded", function() {
    var newMaltButton = document.getElementById("oneMoreMaltBtn");
    var newHopButton = document.getElementById("oneMoreHopBtn");
    var newAdditionButton = document.getElementById("oneMoreAdditionBtn");
    var deleteLastMaltButton = document.getElementById("deleteLastMaltBtn");
    var deleteLastHopButton = document.getElementById("deleteLastHopBtn");
    var deleteLastAdditionButton = document.getElementById("deleteLastAdditionBtn");
    var maltsTableBody = document.getElementById("malts").getElementsByTagName("tbody")[0];
    var hopsTableBody = document.getElementById("hops").getElementsByTagName("tbody")[0];
    var additionsTableBody = document.getElementById("additions").getElementsByTagName("tbody")[0];
    var maltsRows = 0;  var hopsRows = 0;  var additionsRows = 0;

    // adds new row in dynamic table
    function addNewTableRow(table) {
        var newRow = document.createElement("tr");
        newRow.innerHTML = table.children[0].innerHTML;
        
        if(newRow.children[0].children[1].getAttribute("name") === "malts[0].maltName") {
            maltsRows++;
            newRow.children[0].children[1].setAttribute("id", "malts"+maltsRows+".maltName");
            newRow.children[0].children[1].setAttribute("name", "malts["+maltsRows+"].maltName");
            newRow.children[0].children[1].setAttribute("value", "");
            newRow.children[1].children[1].setAttribute("id", "malts"+maltsRows+".maltWeight");
            newRow.children[1].children[1].setAttribute("name", "malts["+maltsRows+"].maltWeight");
            newRow.children[1].children[1].setAttribute("value", "");
            
            console.log(newRow.innerHTML);
        }

        if(newRow.children[0].children[1].getAttribute("name") === "hops[0].hopName") {
            hopsRows++;
            newRow.children[0].children[1].setAttribute("id", "hops"+hopsRows+".hopName");
            newRow.children[0].children[1].setAttribute("name", "hops["+hopsRows+"].hopName");
            newRow.children[0].children[1].setAttribute("value", "");
            newRow.children[1].children[1].setAttribute("id", "hops"+hopsRows+".hopWeight");
            newRow.children[1].children[1].setAttribute("name", "hops["+hopsRows+"].hopWeight");
            newRow.children[1].children[1].setAttribute("value", "");
            newRow.children[2].children[1].setAttribute("id", "hops"+hopsRows+".hopBoilTime");
            newRow.children[2].children[1].setAttribute("name", "hops["+hopsRows+"].hopBoilTime");
            newRow.children[2].children[1].setAttribute("value", "");
            console.log(newRow.innerHTML);
        }

        if(newRow.children[0].children[1].getAttribute("name") === "additions[0].additionName") {
            additionsRows++;
            newRow.children[0].children[1].setAttribute("id", "additions"+additionsRows+".additionName");
            newRow.children[0].children[1].setAttribute("name", "additions["+additionsRows+"].additionName");
            newRow.children[0].children[1].setAttribute("value", "");
            newRow.children[1].children[1].setAttribute("id", "additions"+additionsRows+".additionTime");
            newRow.children[1].children[1].setAttribute("name", "additions["+additionsRows+"].additionTime");
            newRow.children[1].children[1].setAttribute("value", "");
            newRow.children[2].children[0].setAttribute("id", "additions"+additionsRows+".additionUse");
            newRow.children[2].children[0].setAttribute("name", "additions["+additionsRows+"].additionUse");
            newRow.children[2].children[0].setAttribute("value", "");
            console.log(newRow.innerHTML);
        }
        table.appendChild(newRow);
    }
    
    // deletes last row in dynamic table
    function deleteTableRow(table) {
        if(table.childElementCount > 1) table.removeChild(table.children[1]);
    }

    // adding new row buttons
    newMaltButton.addEventListener("click", function() {
        addNewTableRow(maltsTableBody);
    });
    newHopButton.addEventListener("click", function() {
        addNewTableRow(hopsTableBody);
    });
    newAdditionButton.addEventListener("click", function() {
        addNewTableRow(additionsTableBody);
    });

    // delete last row buttons
    deleteLastMaltButton.addEventListener("click", function() {
        if(maltsRows > 0) maltsRows--;
        deleteTableRow(maltsTableBody);
    });
    deleteLastHopButton.addEventListener("click", function() {
        if(hopsRows > 0) hopsRows--;
        deleteTableRow(hopsTableBody);
    });
    deleteLastAdditionButton.addEventListener("click", function() {
        if(additionsRows > 0) additionsRows--;
        deleteTableRow(additionsTableBody);
    });
});