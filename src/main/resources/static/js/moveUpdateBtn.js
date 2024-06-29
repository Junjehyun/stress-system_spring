$(document).ready(function() {
    $(".moveUpdateBtn").click(function() {
        var userId = $(this).data("userid");

        window.location.href = "/doctor-edit/" + userId;
    });
});