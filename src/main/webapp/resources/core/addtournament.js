$(document).ready(function() {
    $('#save').click(function() {

        var tournament = $("#tournament").val();
        var kindSport = $("#kind-sport option:selected").text();

        if (tournament != '' && kindSport!= '') {
            console.log(tournament, kindSport);
            $.ajax({
                type: "POST",
                url: "/tournament",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify({tournament: tournament, kindSport: kindSport}),
                success: function (data) {
                    console.log(data);
                    if (data.status === "OK") {
                        alert("Successfully added");
                    } else {
                        alert("Adding failed");
                    }
                },
                error: function(){
                    alert("ERROR!");
                }
            });
            return false;
        } else {
            console.log("WRONG!");
        }
    });
});