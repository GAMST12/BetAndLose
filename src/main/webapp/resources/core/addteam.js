$(document).ready(function() {
    $('#save').click(function() {

        var team = $("#team").val();
        var city = $("#city").val();
        var country = $("#country").val();
        var sex = $("#sex option:selected").text();
        var kindSport = $("#kind-sport option:selected").text();

        if (team != '' && city!= '' && country!= '' &&  kindSport!= '' && sex!= '') {
            console.log(team, city, country, sex, kindSport);
            $.ajax({
                type: "POST",
                url: "/tournament",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify({team: team, city: city, country: country, sex: sex, kindSport: kindSport}),
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