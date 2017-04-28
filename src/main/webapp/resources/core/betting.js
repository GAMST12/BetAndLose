$(document).ready(function() {

        $(".koef").click(function () {
            $(".koef").addClass("nonselected");
            $(this).addClass("selected");
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
