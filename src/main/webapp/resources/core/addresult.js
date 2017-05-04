$(document).ready(function() {

    $('td#save').click(function() {
        var itemId;
        var score1;
        var score2;

        console.log($(this));
        console.log($(this).parent());
        itemId = $(this).parent().attr("id");
        score1 =  $(this).parent().children("#score1").children("input").val();
        score2 =  $(this).parent().children("#score2").children("input").val();
        if (itemId != '' && score1!= '' && score2!= '') {
            console.log(itemId);
            console.log(score1);
            console.log(score2);
            $.ajax({
                type: "POST",
                url: "/result",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify({itemId: itemId, homeScore: score1, awayScore: score2}),
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


    $("#logout").click(function () {
        console.log("logout");
        $.ajax({
            type: "POST",
            url: "/logout",
            success: function () {
                window.location.href = "/login";
            }
        });
    });

});
