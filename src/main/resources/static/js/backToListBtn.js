$(document).ready(function() {
    $("#backToListBtn").click(function() {
        var hiddenCompanyCheckValue = $("input[name='hiddenCompanyCheck']").val();
        var hiddenCompanyNameInputValue = $("input[name='hiddenCompanyNameInput']").val();
        var hiddenCompanyNameOutputValue = $("input[name='hiddenCompanyNameOutput']").val();

        $("#companyNameOutput").val(hiddenCompanyNameOutputValue);

        window.location.href = "/doctor-list?companyCheck=" + hiddenCompanyCheckValue + 
        "&companyNameInput=" + encodeURIComponent(hiddenCompanyNameInputValue) +
        "&companyNameOutput=" + encodeURIComponent(hiddenCompanyNameOutputValue);

    });
});