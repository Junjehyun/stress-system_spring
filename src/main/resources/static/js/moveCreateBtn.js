//追加するボタンを押した時、新規作成画面に遷移する
$(document).ready(function() {
    $("#moveCreateBtn").click(function(){
        var companyCheckValue = $("#companyCheck").is(":checked") ? "true" : "false";
        var companyNameInputValue = $("#companyNameInput").val();
        var companyNameOutputValue = $("#companyNameOutput").val();

        window.location.href = "/doctor-create?hiddenCompanyCheck=" + companyCheckValue +
            "&hiddenCompanyNameInput=" + encodeURIComponent(companyNameInputValue) +
            "&hiddenCompanyNameOutput=" + encodeURIComponent(companyNameOutputValue);
    }); 
});