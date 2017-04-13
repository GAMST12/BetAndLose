$(document).ready(function(){

    $("#logout").click(function () {
        console.log("logout");
        $.ajax({
            type: "POST",
            url: "/logout",
            success: function() {
                window.location.href="/login";
            }
        });

    });
});
