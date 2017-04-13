$(document).ready(function() {
    $('#save').click(function() {
        var kindSport = $("#kind-sport").val();


        if (kindSport!= '') {
            $.ajax({
                type: "POST",
                url: "/kindSport",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify({
                    sport: kindSport
                }),
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
