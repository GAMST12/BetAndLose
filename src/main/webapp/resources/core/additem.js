$(document).ready(function() {
    $('#save').click(function() {


        var date = $("#date").val();
        var tournament = $("#tournament option:selected").text();
        var hometeam = $("#hometeam option:selected").text();
        var awayteam = $("#awayteam option:selected").text();
        var win1 = $("#win1").val();
        var draw = $("#draw").val();
        var win2 = $("#win2").val();

        console.log(date, tournament, hometeam, awayteam, win1, draw, win2);

        if (date != '' && tournament!= '' && hometeam!= '' &&  awayteam!= ''
                && win1!= '' && draw!= '' && win2!= '') {
            console.log(date, tournament, hometeam, awayteam, win1, draw, win2);
            $.ajax({
                type: "POST",
                url: "/item",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify({date: date, tournament: tournament, homeTeam: hometeam,
                    awayTeam: awayteam, koefWin1: win1, koefDraw: draw, koefWin2: win2}),
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
