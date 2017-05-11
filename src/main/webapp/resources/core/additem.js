$(document).ready(function() {
    $('#save').click(function() {


        var date = $("#date").val();
        var tournamentId = $("#tournament option:selected").attr("id");
        var homeTeamId = $("#hometeam option:selected").attr("id");
        var awayTeamId = $("#awayteam option:selected").attr("id");
        var win1 = $("#win1").val();
        var draw = $("#draw").val();
        var win2 = $("#win2").val();

        console.log(date, tournamentId, homeTeamId, awayTeamId, win1, draw, win2);
            $.ajax({
                type: "POST",
                url: "/item",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify({date: date, tournamentId: tournamentId, homeTeamId: homeTeamId,
                    awayTeamId: awayTeamId, koefWin1: win1, koefDraw: draw, koefWin2: win2}),
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
    });
});
