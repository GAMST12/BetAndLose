$(document).ready(function() {

        $(".koef a").click(function () {
            $(".koef a").removeClass("selected");
            $(".koef a").addClass("nonselected");
            $(this).removeClass("nonselected");
            $(this).addClass("selected");
            console.log($(this).parent());
            console.log($(this).parent().parent().children("#item-date").html());
            console.log($(this).parent().parent().children("#sport").html());
            console.log($(this).parent().parent().children("#tournament").html());
            console.log($(this).parent().parent().children("#team1").html());
            console.log($(this).parent().parent().children("#team2").html());
            console.log($(this).parent().parent().children("#item-date").html());
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
