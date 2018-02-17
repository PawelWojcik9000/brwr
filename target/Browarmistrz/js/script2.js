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


    // adding new row buttons
    newMaltButton.addEventListener("click", function() {
        maltsRows++;
        var newRow = document.createElement("tr");
        newRow.innerHTML = '<td><label>Nazwa: </label> <form:input type="text" path="malts['+maltsRows+'].maltName" />'
                        +'<form:errors path="malts['+maltsRows+'].maltName" cssClass="error" /></td>'
                        +'<td><label>Ilość(kg): </label> <form:input type="text" path="malts['+maltsRows+'].maltWeight" />'
                        +'<form:errors path="malts['+maltsRows+'].maltWeight" cssClass="error" /></td>'
        maltsTableBody.appendChild(newRow);
    });
    newHopButton.addEventListener("click", function() {
        
    });
    newAdditionButton.addEventListener("click", function() {
        
    });

    // deletes last row in dynamic table
    function deleteTableRow(table) {
        if(table.childElementCount > 1) table.removeChild(table.lastChild);
    }

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