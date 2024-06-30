$(document).ready(function() {

    $("#backToListBtn").click(function() {
        var hiddenCompanyCheckValue = $("input[name='hiddenCompanyCheck']").val();
        var hiddenSoshikiCheckValue = $("input[name='hiddenSoshikiCheck']").val();
        var hiddenKengenCheckValue = $("input[name='hiddenKengenCheck']").val();
        var hiddenCompanyNameInputValue = $("input[name='hiddenCompanyNameInput']").val();
        var hiddenSoshikiNameInputValue = $("input[name='hiddenSoshikiNameInput']").val();
        var hiddenCompanyNameOutputValue = $("input[name='hiddenCompanyNameOutput']").val();
        var hiddenSoshikiNameOutputValue = $("input[name='hiddenSoshikiNameOutput']").val();
        var hiddenKengenKubunValue = $("input[name='hiddenKengenKubun']").val();

        window.location.href = "/doctor-list?companyCheck=" + hiddenCompanyCheckValue + 
        "&soshikiCheck=" + hiddenSoshikiCheckValue +
        "&kengenCheck=" + hiddenKengenCheckValue +
        "&companyNameInput=" + encodeURIComponent(hiddenCompanyNameInputValue) +
        "&soshikiNameInput=" + encodeURIComponent(hiddenSoshikiNameInputValue) +
        "&companyNameOutput=" + encodeURIComponent(hiddenCompanyNameOutputValue) +
        "&soshikiNameOutput=" + encodeURIComponent(hiddenSoshikiNameOutputValue) +
        "&kengenKubun=" + encodeURIComponent(hiddenKengenKubunValue);

    });
});