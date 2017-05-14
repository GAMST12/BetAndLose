$(document).ready(function() {

    var switcher = function (name) {
        $(".body").addClass("hidden");
        $("#" + name + "-panel").removeClass("hidden");

        $("ul.navbar-nav li").removeClass("active");
        $("#" + name + "-tab").parent().addClass("active");
    };

    $("#home-tab").click(function () {
        switcher("home");
    });

    $("#history-tab").click(function () {
        switcher("history");
    });

    $("#deposit-tab").click(function () {
        switcher("deposit");
    });

    $("#withdrawal-tab").click(function () {
        switcher("withdrawal");
    });

    $('#deposit-save').click(function() {
        var sum = $("#deposit-sum").val();
        console.log(sum);

        $.ajax({
            type: "POST",
            url: "/deposit",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify({sum: sum}),
            success: function (data) {
                console.log(data);
                if (data.status === "OK") {
                    alert("Successfully deposited");
                    window.location.href = "/profile";
                } else {
                    alert("Depositing failed");
                    window.location.href = "/profile";
                }
            },
            error: function(){
                alert("ERROR!");
            }
        });
        return false;

    });

    $('#withdrawal-save').click(function() {
        var sum = $("#withdrawal-sum").val();
        console.log(sum);

        $.ajax({
            type: "POST",
            url: "/withdraw",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify({sum: sum}),
            success: function (data) {
                console.log(data);
                if (data.status === "OK") {
                    alert("Successfully withdrawaled");
                    window.location.href = "/profile";
                } else {
                    alert("Withdrawing failed");
                    window.location.href = "/profile";
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