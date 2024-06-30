$(document).ready(function() {
    $(".moveUpdateBtn").click(function() {

        var userId = $(this).data("userid");

        var companyCheckValue = $("#companyCheck").is(":checked") ? "true" : "false";
        var soshikiCheckValue = $("#soshikiCheck").is(":checked") ? "true" : "false";
        var kengenCheckValue = $("#kengenCheck").is(":checked") ? "true" : "false";

        var companyNameInputValue = $("#companyNameInput").val();
        var soshikiNameInputValue = $("#soshikiNameInput").val();

        var companyNameOutputValue = $("#companyNameOutput").val();
        var soshikiNameOutputValue = $("#soshikiNameOutput").val();

        var kengenKubunValue = $("input[name='kengenKubun']:checked").val();

        window.location.href = "/doctor-edit/" + userId + "?hiddenCompanyCheck=" + companyCheckValue +
        "&hiddenSoshikiCheck=" + soshikiCheckValue +
        "&hiddenKengenCheck=" + kengenCheckValue +
        "&hiddenCompanyNameInput=" + encodeURIComponent(companyNameInputValue) +
        "&hiddenSoshikiNameInput=" + encodeURIComponent(soshikiNameInputValue) +
        "&hiddenCompanyNameOutput=" + encodeURIComponent(companyNameOutputValue) +
        "&hiddenSoshikiNameOutput=" + encodeURIComponent(soshikiNameOutputValue) +
        "&hiddenKengenKubun=" + encodeURIComponent(kengenKubunValue)
        ;
    });
});