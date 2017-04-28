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