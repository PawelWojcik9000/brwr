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

    // adds new row in dynamic table
    function addNewTableRow(table) {
        var newRow = document.createElement("tr");
        newRow.innerHTML = table.children[0].innerHTML;
        table.appendChild(newRow);
    }
    
    // deletes last row in dynamic table
    function deleteTableRow(table) {
        if(table.childElementCount > 1) table.removeChild(table.lastChild);
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
        deleteTableRow(maltsTableBody);
    });
    deleteLastHopButton.addEventListener("click", function() {
        deleteTableRow(hopsTableBody);
    });
    deleteLastAdditionButton.addEventListener("click", function() {
        deleteTableRow(additionsTableBody);
    });
});