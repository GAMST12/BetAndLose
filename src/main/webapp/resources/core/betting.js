$(document).ready(function() {

    var itemId;

        $(".koef a").click(function () {
            $(".koef a").removeClass("selected");
            $(".koef a").addClass("nonselected");
            $(this).removeClass("nonselected");
            $(this).addClass("selected");
            console.log($(this).parent());
            console.log($(this).parent().parent().attr("id"));
            itemId = $(this).parent().parent().attr("id");
        });

    $('#save').click(function() {
        var event;
        var koef;
        console.log($("#"+itemId));
        if ($("#"+itemId).children("#win1").children("a").hasClass("selected")) {
            event = "WIN1";
            koef = ($("#"+itemId).children("#win1").children("a").html());
        }
        if ($("#"+itemId).children("#draw").children("a").hasClass("selected")) {
            event = "DRAW";
            koef = ($("#"+itemId).children("#draw").children("a").html());
        }
        if ($("#"+itemId).children("#win2").children("a").hasClass("selected")) {
            event = "WIN2";
            koef = ($("#"+itemId).children("#win2").children("a").html());
        }
        var sum = $("#bet-sum").val();
        console.log(itemId, " ", event," ", koef," ", sum);

                    $.ajax({
                        type: "POST",
                        url: "/bet",
                        contentType: "application/json; charset=utf-8",
                        dataType: "json",
                        data: JSON.stringify({itemId: itemId, event: event, koef: koef, sum: sum}),
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
