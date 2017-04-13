$(document).ready(function() {
    $('#save').click(function() {
        var login = $("#login").val();
        var password = $("#inputPassword").val();
        var confirmPassword = $("#confirmPassword").val();
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var email = $("#inputEmail").val();

        console.log(login, password);

        if (login!= '' && (confirmPassword === password) && password!='') {
            $.ajax({
                type: "POST",
                url: "/register",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify({
                    login: login, password: password, email: email,
                    firstName: firstName, lastName: lastName
                }),
                success: function (data) {
                    console.log("OK");
                    console.log(data);
                    if (data.status === "OK") {
                        window.location.href = "/login";
                    } else {
                        window.location.href = "/login";
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
